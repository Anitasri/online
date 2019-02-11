<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">




		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Item Management</h4>

				</div>

				<div class="panel-body">

					<!-- Form elements -->
					<form class="form-horizontal">

						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Item Name:</label>

							<div class="col-md-8">

								<input type="text" name="name" id="name" placeholder="Item Name"
									class="form-control" /> <em class="help-block"> Please
									Enter Item Name</em>


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="foodType">Enter
								Food Type:</label>

							<div class="col-md-8">

								<input type="text" name="foodType" id="foodType" placeholder="Food Type"
									class="form-control" /> <em class="help-block"> Please
									Enter Food Type</em>


							</div>

						</div>


						<div class="form-group">


							<div class="col-md-offset-4 col-md-8">

								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

							</div>

						</div>





					</form>

				</div>

			</div>
		</div>
	</div>
</div>