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




			<h6>Qty. Available:${item.quantity}</h6>



			<a href="${contextRoot}/cart/add/${item.id}/item"
				class="btn btn-success"> <span
				class="glyphicon glyphicon-shopping-cart"></span> Add to Cart
			</a> 
			<a href="${contextRoot}/show/all/items" class="btn btn-primary">
				Back</a>

		</div>


	</div>

</div>