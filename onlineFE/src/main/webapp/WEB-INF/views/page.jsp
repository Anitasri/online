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
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

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

	 <!-- for loading gif -->
	<div class="se-pre-con"></div>
	
	<!-- to avoid footer prblm wrap the whole body in class called wrapper -->
	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./common/navbar.jsp"%>

		<!-- Page Content -->
		<!-- to avoid footer prblm wrap the page content in class called content -->
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
			<c:if test="${userClickShowItem == true}">
				<%@include file="singleItem.jsp"%>
			</c:if>

			<!-- Load only when user clicks manage items -->
			<c:if test="${userClickManageItems == true}">
				<%@include file="manageItems.jsp"%>
			</c:if>

			<!-- Load only when user clicks show cart -->
			<c:if test="${userClickShowCart == true}">
				<%@include file="cart.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./common/footer.jsp"%>

		<!--JQuery and Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/bootstrap.min.js"></script>

		<!-- Datatable plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- Bootbox js -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>
