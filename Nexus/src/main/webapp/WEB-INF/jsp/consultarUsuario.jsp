<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Usuário</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<jsp:include page="css.jsp" />
</head>
<body>
	<jsp:include page="cabecalho.jsp" />
	<jsp:include page="menu.jsp" />
	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> Cadastro Usuário
			</h3>
			<!-- BASIC FORM VALIDATION -->
			<div class="row mt">
				<div class="col-lg-12">
					<div class="content-panel">
						<table class="table table-hover">
							<hr>
							<thead>
								<tr>
									<th>Id</th>
									<th>Nome</th>
									<th>Email</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="usuario" items="${lsUsuario}" varStatus="count">
									<tr>
										<td>${usuario.id}</td>
										<td>${usuario.nome}</td>
										<td>${usuario.email}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /form-panel -->
				</div>
				<!-- /col-lg-12 -->
			</div>
		</section>
		<!-- /wrapper -->
	</section>
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="lib/jquery.dcjqaccordion.2.7.js"></script>
	<script src="lib/jquery.scrollTo.min.js"></script>
	<script src="lib/jquery.nicescroll.js" type="text/javascript"></script>
	<!--common script for all pages-->
	<script src="lib/common-scripts.js"></script>
	<!--script for this page-->
	<script src="lib/form-validation-script.js"></script>

</body>
</html>