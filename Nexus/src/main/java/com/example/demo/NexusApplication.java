package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nexus.dao.FornecedorDAO;
import com.nexus.dao.NFEDAO;
import com.nexus.dao.ProdutoDAO;
import com.nexus.dao.UsuarioDAO;
import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Fornecedor;
import com.nexus.pojo.NFE;
import com.nexus.pojo.Produto;
import com.nexus.pojo.Usuario;
import com.nexus.utils.Data;
import com.nexus.utils.Utils;

@SpringBootApplication(scanBasePackages = { "com.nexus.controller"} )
public class NexusApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexusApplication.class, args);
//		try {
//			run();
//		} catch (UsuarioException e) {
//			e.printStackTrace();
//		}
	
	}
	
	public static void run() throws UsuarioException {
		try {
			FileReader arq = new FileReader("C:\\Users\\Hall\\Documents\\xml\\nfe.xml");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.lines().collect(Collectors.joining());
			Document doc = Jsoup.parse(linha);

			// Fazer parse
			Fornecedor fornecedor = parseFornecedor(doc);
			NFE nfe = parserNFE(doc, fornecedor);
			parseProduto(doc, nfe, fornecedor);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static NFE parserNFE(Document doc, Fornecedor fornecedor) throws UsuarioException {
		// TODO : Rever usuario
		Usuario usuario = new UsuarioDAO().obter(1);

		String numero = doc.select("refNFe").text();
		NFE nfe = NFEDAO.obter(numero);
		if (nfe == null) {
			nfe = new NFE();
			nfe.setFornecedor(fornecedor);
			nfe.setUsuario(usuario);
			nfe.setNumero(numero);
			nfe.setData_emissao(Data.DataBD(doc.select("dhEmi").text()));
			nfe.setData_emissao(new Date());
			nfe = new NFEDAO().salvar(nfe);
		}
		return nfe;
	}

	private static Fornecedor parseFornecedor(Document doc) throws UsuarioException {
		// TODO : Rever usuario
		Usuario usuario = new UsuarioDAO().obter(1);
		
		String cnpj = doc.select("emit").select("CNPJ").text();
		Fornecedor fornecedor = new FornecedorDAO().obter(cnpj);
		if (fornecedor == null) {
			fornecedor = new Fornecedor();
			fornecedor.setNome(doc.select("emit").select("xNome").text());
			fornecedor.setCnpj(cnpj);
			fornecedor.setEmail(doc.select("infRespTec").select("email").text());
			fornecedor.setFone(doc.select("infRespTec").select("fone").text());
			fornecedor.setUsuario(usuario);
			fornecedor = new FornecedorDAO().salvar(fornecedor);
		}
		return fornecedor;
	}

	private static void parseProduto(Document doc, NFE nfe, Fornecedor fornecedor) {
		Elements elsProduto = doc.select("det");
	      List<Produto> lsProtuto = new ArrayList<Produto>();
	      for(Element elProduto : elsProduto) {
	    	  Produto produto = new Produto();
	    	  produto.setDescricao(elProduto.select("xProd").text());
	    	  produto.setCodigoDeBarras(elProduto.select("cEAN").text());
	    	  produto.setQuantidade(Utils.extractValor(elProduto.select("qTrib").text()));
	    	  produto.setPrecoCompra(Utils.getDouble(elProduto.select("vUnTrib").text()));
	    	  produto.setNfe(nfe);
	    	  produto.setFornecedor(fornecedor);
	    	  produto = new ProdutoDAO().salvar(produto);
	    	  lsProtuto.add(produto);
	      }
	}

}
