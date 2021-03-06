<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>Login</title>
<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">
<!-- Bootstrap core CSS -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--external css-->
<link href="lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet">
<jsp:include page="css.jsp" />
</head>
<body>
	<div id="login-page">
		<div class="container">
			<form class="form-login" action="inicial" method="post">
				<h2 class="form-login-heading">LOGIN</h2>
				<div class="login-wrap">
					<input type="text" class="form-control"  name="email"  placeholder="Email" autofocus> 
						<br> 
						<input name="senha" class="form-control" placeholder="Senha">
						<span style="color:red">${erroAologar}</span>
						<span><p><label class="checkbox"> <input type="checkbox" value="remember-me"> Lembre-me </span>
						<span class="pull-right"><a data-toggle="modal"> Esqueceu a senha?</a></span>
					</label>
					<button class="btn btn-theme btn-block" type="submit">
						<i class="fa fa-lock"></i> ENTRAR
					</button>
					<hr>
					<div class="registration">
						Ainda n�o tem conta?<br /> <a class=""
						href="cadastroUsuarioExterno"  target="popup" 
						onclick="window.open('cadastroUsuarioExterno','popup','width=600,height=600'); return false;">
   						 Criar conta
					</a>
					</div>
				</div>
				<!-- Modal -->
				<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
					tabindex="-1" id="myModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title">Esqueceu a senha?</h4>
							</div>
							<div class="modal-body">
								<p>Enter your e-mail address below to reset your password.</p>
								<input type="text"  placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
								<button class="btn btn-theme" type="button">Submit</button>
							</div>
						</div>
					</div>
				</div>
				<!-- modal -->
			</form>
		</div>
	</div>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script type="text/javascript" src="lib/jquery.backstretch.min.js"></script>
	<script>
		$.backstretch("img/login-bg.jpg", {
			speed : 500
		});
	</script>
</body>
</html>