<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">

	<div class="row">

		<c:if test="${not empty message}">

			<div class="col-xs-12">

				<div class="alert alert-success alert-dismissiable">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${message}

				</div>

			</div>

		</c:if>

		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Item Management</h4>

				</div>

				<div class="panel-body">

					<!-- Form elements -->
					<sf:form class="form-horizontal" modelAttribute="item"
						action="${contextRoot}/manage/items" method="POST"
						enctype="multipart/form-data">



						<div class="form-group">

							<label class="control-label col-md-4" for="name">Enter
								Item Name:</label>

							<div class="col-md-8">

								<sf:input type="text" path="name" id="name"
									placeholder="Item Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />


							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="foodType">Enter
								Food Type:</label>

							<div class="col-md-8">

								<sf:input type="text" path="foodType" id="foodType"
									placeholder="Food Type" class="form-control" />
								<sf:errors path="foodType" cssClass="help-block" element="em" />


							</div>

						</div>


						<div class="form-group">

							<label class="control-label col-md-4" for="description">Item
								Description:</label>

							<div class="col-md-8">

								<sf:textarea path="description" id="description" rows="4"
									placeholder="Write a description" class="form-control" />
								<sf:errors path="description" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price</label>

							<div class="col-md-8">

								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Unit Price" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />

							</div>

						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity</label>

							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity"
									placeholder="Quantity" class="form-control" />
							</div>

						</div>

						<!-- File element for image -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select
								an image</label>

							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control" />
							</div>

						</div>

						<div class="form-group">

							<label class="control-label col-md-4" for="categoryId">Select
								Category:</label>

							<div class="col-md-8">

								<sf:select class="form-control" path="categoryId"
									id="categoryId" items="${categories}" itemLabel="name"
									itemValue="id" />

							</div>

						</div>

						<div class="form-group">

							<div class="col-md-offset-4 col-md-8">

								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />

								<!-- Hidden fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />



							</div>

						</div>





					</sf:form>

				</div>

			</div>
		</div>
	</div>
</div>