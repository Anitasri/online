<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<div class="container">

	<div class="row">

		<!-- Would be to display sidebar -->
		<div class="col-md-3">

			<%@include file="./common/sidebar.jsp"%>

		</div>

		<!-- to display the actual products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">

					<c:if test="${userClickAllItems == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Items</li>

						</ol>

					</c:if>

					<c:if test="${userClickCategoryItems == true}">

						<script>
							window.categoryId = '${category.id}';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>

				</div>

			</div>

			<div class="row">

				<div class="col-xs-12">

					<div class="container-fluid">
						<div class="table-responsive">
						
											<table id="itemListTable" class="table table-striped table-borderd"
						class="display">

						<thead>

							<tr>

								<th></th>
								<th>Name</th>
								<th>FoodType</th>
								<th>Price</th>
								<th>Qty Available</th>
								<th></th>

							</tr>

						</thead>

						<tbody>
						</tbody>

						<tfoot>

							<tr>

								<th></th>
								<th>Name</th>
								<th>FoodType</th>
								<th>Price</th>
								<th>Qty Available</th>
								<th></th>

							</tr>

						</tfoot>

					</table>
						
						</div>
					</div>
					
				</div>

			</div>

		</div>

	</div>

</div>