

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`grupo` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `parametros` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `grupo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `grupo_id` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `mydb`.`grupo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`cumpomfiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cumpomfiscal` (
  `id` INT NOT NULL,
  `data` VARCHAR(45) NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `forma_pagamento` VARCHAR(45) NULL DEFAULT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `usuario_id` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `cumpomfiscal_ibfk_1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`fones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fones` (
  `id` INT NOT NULL,
  `numero` VARCHAR(11) NULL DEFAULT NULL,
  `relacao` VARCHAR(45) NULL DEFAULT NULL,
  `id_relacao` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`fornecedor` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(11) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fornecedor_ibfk_1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`nfe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nfe` (
  `id` INT NOT NULL,
  `numero` VARCHAR(45) NULL,
  `fornecedor_id` INT NOT NULL,
  `usuario_id` INT NOT NULL,
  `data_emissao` DATE NULL,
  `data_cadastro` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_nfe_fornecedor1_idx` (`fornecedor_id` ASC) VISIBLE,
  INDEX `fk_nfe_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_nfe_fornecedor1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `mydb`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nfe_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`produto` (
  `id` INT NOT NULL,
  `descricao` VARCHAR(45) NULL DEFAULT NULL,
  `codigo_de_barras` VARCHAR(45) NULL DEFAULT NULL,
  `quantidade` INT NOT NULL,
  `preco_compra` DOUBLE NULL DEFAULT NULL,
  `valor_venda` DOUBLE NULL DEFAULT NULL,
  `margem_lucro` DOUBLE NULL DEFAULT NULL,
  `fornecedor_id` INT NOT NULL,
  `nfe_id` INT ,
  PRIMARY KEY (`id`),
  INDEX `fornecedor_id` (`fornecedor_id` ASC) VISIBLE,
  INDEX `fk_produto_nfe1_idx` (`nfe_id` ASC) VISIBLE,
  CONSTRAINT `produto_ibfk_1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `mydb`.`fornecedor` (`id`),
  CONSTRAINT `fk_produto_nfe1`
    FOREIGN KEY (`nfe_id`)
    REFERENCES `mydb`.`nfe` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`restricao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`restricao` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `tela` VARCHAR(45) NOT NULL,
  `consultar` TINYINT NULL DEFAULT NULL,
  `cadastrar` TINYINT NULL DEFAULT NULL,
  `alterar` TINYINT NULL DEFAULT NULL,
  `excluir` TINYINT NULL DEFAULT NULL,
  `grupo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `grupo_id` (`grupo_id` ASC) VISIBLE,
  CONSTRAINT `restricao_ibfk_1`
    FOREIGN KEY (`grupo_id`)
    REFERENCES `mydb`.`grupo` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`venda` (
  `id` VARCHAR(45) NOT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  `produto_id` INT NOT NULL,
  `cumpomfiscal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `cumpomfiscal_id` (`cumpomfiscal_id` ASC) VISIBLE,
  INDEX `fk_venda_produto1` (`produto_id` ASC) VISIBLE,
  CONSTRAINT `fk_venda_produto1`
    FOREIGN KEY (`produto_id`)
    REFERENCES `mydb`.`produto` (`id`),
  CONSTRAINT `venda_ibfk_1`
    FOREIGN KEY (`cumpomfiscal_id`)
    REFERENCES `mydb`.`cumpomfiscal` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



use mydb;
INSERT INTO `mydb`.`grupo` (`id`, `nome`, `parametros`) VALUES ('1', 'Administrador', '');
INSERT INTO `mydb`.`grupo` (`id`, `nome`, `parametros`) VALUES ('2', 'Vendas', '');


INSERT INTO `mydb`.`restricao` (`id`, `nome`, `tela`, `consultar`, `cadastrar`, `alterar`, `excluir` , `grupo_id`) VALUES ('1', 'Vendas - Cadastrar Usuário', 'usuario/cadastroUsuario', true, true, true, false,  2);
INSERT INTO `mydb`.`restricao` (`id`, `nome`, `tela`, `consultar`, `cadastrar`, `alterar`, `excluir`, `grupo_id`) VALUES ('2', 'Vendas - Cadastrar Fornecedor', 'fornecedor/cadastroFornecedor', true, true, true, false, 2);


INSERT INTO `mydb`.`usuario` (`id`, `nome`, `email`, `senha`, `telefone`, `grupo_id`) VALUES ('999', 'Administrador', 'administrador@nexus.com', 'teste', '4199999999', '1');
INSERT INTO `mydb`.`usuario` (`id`, `nome`, `email`, `senha`, `telefone`, `grupo_id`) VALUES ('1', 'Vendedor', 'vendas@nexus.com', 'teste', '4199999999', '2');

INSERT INTO `mydb`.`fornecedor` (`id`, `nome`, `telefone`, `email`, `usuario_id`, `cnpj`) VALUES ('1', 'Fornecedor Teste', '41999999999', 'fornecedorteste@gmail.com', '1', '31565104009476');

INSERT INTO `mydb`.`produto` (`id`, `descricao`, `quantidade`, `codigo_de_barras`, `preco_compra`, `valor_venda`, `fornecedor_id`) VALUES ('1', 'Protuto Teste', '10', '123456789', '1.00', '1.50', '1');
INSERT INTO `mydb`.`produto` (`id`, `descricao`, `quantidade`, `codigo_de_barras`, `preco_compra`, `valor_venda`, `fornecedor_id`) VALUES ('2', 'Protuto 2', '50', '1234567890', '2.30', '4.50', '1');





