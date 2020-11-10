<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nexus</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<jsp:include page="css.jsp" />
</head>
<body>
	<section id="container">

	<!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">
					<p class="centered">
						<h5 class="centered">${usuarioLogado.nome}</h5>
					</p>
					<li class="mt"><a class="active" href="index.html">  <i class="fa fa-dashboard"></i> <span>Gráficos</span></a></li>
					<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-desktop"></i> <span>Cadastro</span> </a>
						<ul class="sub">
							<li><a  class="fa fa-user" href="/cadastroUsuario">  Usuário</a></li>
						</ul>
					</li>
					<li class="sub-menu"><a href="javascript:;"> <i class="fa fa-search"></i> <span>Consulta</span> </a>
						<ul class="sub">
							<li><a class="fa fa-user" href="/consultaUsuario">  Usuário</a></li>
						</ul>
					</li>
				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
	</section>
		
		<!--sidebar end-->
</body>
</html>