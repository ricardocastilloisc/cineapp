<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Error | Login</title>
		
		<spring:url value="/resources" var="urlPublic" />

		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">

	</head>

	<body>

		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">My CineSite</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Inicio</a></li>
						<li><a href="#">Acerca</a></li>
						<li><a href="#">Login</a></li>            
					</ul>
				</div><!--/.nav-collapse -->
			</div>
		</nav>

		<div class="container theme-showcase" role="main">
			<hr class="featurette-divider">
			<img src="${urlPublic}/images/login.png" width="136" height="136" class="center">
			<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
			
         <form class="form-signin" action="j_security_check" method="post">   
				<h4 class="form-signin-heading" style="color:red">Acceso denegado</h4>
				<h3 class="form-signin-heading">CineSite | Administracion</h3>        
				<label for="j_username" class="sr-only">Usuario</label>
				<input type="text" id="j_username" name="j_username" class="form-control" placeholder="Usuario" required autofocus>
				<label for="j_password" class="sr-only">Contraseña</label>
				<input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			</form>

		</div> <!-- /container -->
		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" ></script>
	</body>
</html>
