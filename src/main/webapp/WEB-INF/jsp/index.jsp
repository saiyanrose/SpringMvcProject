<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/jquery/3.6.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/webjars/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/5.3.2/css/bootstrap.min.css">

<title>${pageTitle}</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Site-Logo</a>
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
      <ul class="navbar-nav">        
        <li class="nav-item dropdown">
        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown">          		
          			${pageContext.request.userPrincipal.name}				
        	</a>
       		<div class="dropdown-menu">
          		<a class="dropdown-item" href="<%=request.getContextPath()%>/update-profile">Update Profile</a>
          		<button class="dropdown-item" id="logout-link" value="Logout">Logout</button>          		
        	</div>
      	</li>       	               
      </ul>  
          
    </div>
    
  </div>
</nav>
	<form id="logout-form" action="<%=request.getContextPath()%>/logout" method="post"></form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/logout.js"></script>
</html>