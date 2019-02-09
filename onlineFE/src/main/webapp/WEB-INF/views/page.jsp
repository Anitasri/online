<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Order online food site using Spring MVC and Hibernate">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<link rel="stylesheet" type="text/css"
	href="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.18/css/dataTables.bootstrap.min.css" />

<script type="text/javascript"
	src="https://maxcdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://maxcdn.datatables.net/1.10.18/js/dataTables.bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.18/jquery.min.js"></script>


<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="//https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>

<title>Online Order for Eatables-${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>



<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstarp sketchy theme -->
<link href="${css}/bootstrap-theme.css" rel="stylesheet">

<!-- Bootstarp Datatables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">



<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>

<!-- Custom styles for this template -->

<link href="${css}/myapp.css" rel="stylesheet">

</head>



<body>

	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./common/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">

			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- Load only when user clicks list itmes -->
			<c:if
				test="${userClickAllItems == true or userClickCategoryItems==true }">
				<%@include file="listItems.jsp"%>
			</c:if>

			<!-- Load only when user clicks show items -->
			<c:if
				test="${userClickShowItem == true}">
				<%@include file="singleItem.jsp"%>
			</c:if>


		</div>

		<!-- Footer -->
		<%@include file="./common/footer.jsp"%>

		<!--JQuery and Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Datatable plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>



		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>


	</div>

</body>

</html>
