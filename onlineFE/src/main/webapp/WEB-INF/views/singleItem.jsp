<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="container">

	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">


			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/items">Items</a></li>
				<li class="active">${item.name}</li>

			</ol>


		</div>


	</div>


	<div class="row">

		<!-- Display the item image -->
		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${item.code}.jpg" class="img img-responsive" />

			</div>

		</div>


		<!-- Display the image description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${item.name}</h3>
			<hr />

			<p>${item.description}</p>
			<hr />

			<h4>
				Price: <strong> &#8377; ${item.unitPrice} /-</strong>
			</h4>
			<hr />

			<c:choose>

				<c:when test="${item.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">Out of Stock!</span>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Qty. Available: ${item.quantity}</h6>

				</c:otherwise>

			</c:choose>



			<c:choose>

				<c:when test="${item.quantity < 1}">

					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
							<span class="glyphicon glyphicon-shopping-cart"></span> Add to
							Cart
					</strike></a>

				</c:when>
				<c:otherwise>

					<a href="${contextRoot}/cart/add/${item.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
					</a>




				</c:otherwise>

			</c:choose>

		</div>


	</div>

</div>