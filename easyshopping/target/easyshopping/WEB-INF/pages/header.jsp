<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="${pageContext.servletContext.contextPath }/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
	<!-- Angular Js -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<!-- Custom Theme files -->

<!--theme-style-->
<link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" media="all" >	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Wedding Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<script src="<c:url value="/resources/js/simpleCart.min.js"/>"> </script>
<!-- start menu -->
<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" >
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
	</head>
	<body>
<nav class="navbar navbar-default">
<div class="container-fluid">
<ul class="nav navbar-nav">
   <li> <a href="home">Home</a> </li>
   <li><a href="aboutUs">About Us</a></li>
   <c:url var="url" value="/admin/product/productform"></c:url>

<c:if test="${pageContext.request.userPrincipal.name !=null }">
   <!-- http://localhost:8080/project1/admin/product/productform -->
   
   <security:authorize access="hasRole('ROLE_ADMIN')">
   <li><a href="${url }">Add New Product</a></li>
   </security:authorize>
   
   <c:url var="allProducts" value="/all/product/getAllProducts"></c:url>
   
   <li><a href="${allProducts}">Browse all products</a></li>
   
 <li class="dropdown">
			<a href="" class="dropdown-toggle" data-toggle="dropdown">
                     Select by Category<b class="caret"></b></a>
			<ul class="dropdown-menu">
			<c:forEach var="c" items="${categories }">
			<li>
<a href="<c:url value="/all/product/productsByCategory?searchCondition=${c.categoryDetails }"></c:url>" >
  ${c.categoryDetails }</a></li>
			</c:forEach>
			</ul>
			</li>
			
			<li><a href="">welcome ${pageContext.request.userPrincipal.name }</a></li>
</c:if>			
			<c:if test="${pageContext.request.userPrincipal.name ==null }">
			<li><a href="<c:url value="/login"></c:url>">Login</a></li>
			<li> <a href="<c:url value="/all/registrationForm"></c:url>">Register</a></li>
			</c:if>
			
			<c:if test="${pageContext.request.userPrincipal.name !=null }">
			<li><a href="<c:url value="/j_spring_security_logout"></c:url>">logout</a></li>
			</c:if>
			
			
</ul>



</div>

</nav>

</body>
</html>
      