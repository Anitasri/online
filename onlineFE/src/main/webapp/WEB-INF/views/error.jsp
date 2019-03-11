<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstarp sketchy theme -->
<link href="${css}/template-theme-cyborg.css" rel="stylesheet">

<!-- Bootstrap DataTable jQuery -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="se-pre-con"></div><!-- for loading gif -->

	<div class="wrapper"> <!-- to avoid footer prblm wrap the whole body in class called wrapper -->

        <!-- Navigation -->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${contextRoot}/home">Home</a>
	            </div>
			</div>
		</nav>
			
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
				
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">				
								${errorDescription}
							</blockquote>						
						
						</div>
											
					</div>					
				
				</div>
			
			</div>
							
		</div>

		<%@include file="./common/footer.jsp" %>
		
		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- datatables -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- datatables bootstrap js -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		
		<!-- Self coded JavaScript File -->
		<script src="${js}/myapp.js"></script>
		<!-- used for active menu -->

	</div>
	
</body>

</html>