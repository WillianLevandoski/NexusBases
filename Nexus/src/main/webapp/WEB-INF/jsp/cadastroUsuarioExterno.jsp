<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Usuário</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<jsp:include page="css.jsp" />
</head>
<body>
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-cirlce "></i> Criar conta
				</h3>
				<!-- BASIC FORM VALIDATION -->
				<div class="row mt">
					<div class="col-lg-12">
						<div class="form-panel">
							<form role="form" class="form-horizontal style-form"  action="cadastrarUsuarioExterno" method="post">
								<div class="form-group">
									<label class="col-lg-2 control-label">Nome</label>
									<div class="col-lg-10">
										<input type="text" placeholder="" id="f-name" name="nome" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="control-label col-lg-2">Senha</label>
									<div class="col-lg-10">
										<input class="form-control " id="password" name="senha" type="password" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-2 control-label">Email</label>
									<div class="col-lg-10">
										<input type="email" placeholder="" id="email2" name="email" class="form-control">
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<button class="btn btn-theme" type="submit">Cadastrar</button>
									</div>
								</div>
							</form>
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