
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nexus</title>
</head>
<body>

	Bem-Vindo ${usuarioLogado.nome} !
	
	

	<h2>Login</h2>
	<form action="usuario/login" method="post">
	
		<table>
		
		<tr>
		    <td>Nome:</td>
		    <td><input name="nome" size="30" required="required" /></td>
		</tr>
		
		<tr>
		    <td>Senha:</td>
		    <td><input type="senha" name="senha" size="30" required="required"/></td>
		</tr>
		
		<tr>
		    <td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
				
		</table>

	</form>


</body>
</html>

