<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Order online food site using Spring MVC and Hibernate">

<title>Online Order for Eatables-${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->

<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstarp sketchy theme -->
<link href="${css}/template-theme-cyborg.css" rel="stylesheet">

<!-- Bootstarp Datatables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	
	<!-- to avoid footer prblm wrap the whole body in class called wrapper -->
	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="flows-navbar.jsp"%>

		<!-- Page Content -->
        
        <!-- to avoid footer prblm wrap the page content in class called content -->
		<div class="content">
