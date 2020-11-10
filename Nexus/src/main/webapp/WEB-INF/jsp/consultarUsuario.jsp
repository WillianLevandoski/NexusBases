<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Usuário</title>
<jsp:include page="css.jsp" />
</head>
<body>
<jsp:include page="cabecalho.jsp" />
<jsp:include page="menu.jsp" />
<section id="main-content">
      <section class="wrapper">
        <div class="row">
          <div class="col-md-12">  
          <!-- /col-md-12 -->
          <div class="col-md-12 mt">
            <div class="content-panel">
              <table class="table table-hover">
                <h4><i class="fa fa-angle-right"></i> Consultar Usuário</h4>
                <hr>
                <thead>
                  <tr>
                    <th>Iopa</th>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Email</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${lsUsuario}" var="usuario" varStatus="count">
    		<tr>
			   <td>${count}</td>
       		   <td>${usuario.id}</td>
     		   <td>${usuario.nome}</td>
     		   <td>${usuario.email}</td>
    		</tr>
		</c:forEach>
                
               
                </tbody>
              </table>
            </div>
          </div>
          <!-- /col-md-12 -->
        </div>
        <!-- row -->
        <div class="row mt">
          <div class="col-md-12">
          </div>
          <!-- /col-md-12 -->
        </div>
        <!-- /row -->
      </section>
    </section>
</body>
</html>