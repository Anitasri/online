<!-- Angular Script -->
<script src="${js}/angular.js"></script>

<!-- Item controller Script -->
<script src="${js}/itemsController.js"></script>

<div class="container" data-ng-app="ShoppingApp"
	data-ng-controller="ItemController as iCtrl">

	<div class="row" data-ng-init="iCtrl.fetchItems()">

		<div class="col-lg-3">
			<!-- SideBar of 3 categories -->
			<%@include file="./common/sidebar.jsp"%>
		</div>

		<div class="col-md-9">

			<div class="row carousel-holder">

				<div class="col-md-12">

					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						</ol>
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block img-fluid" src="${images}/CSlider1.jpg"
									alt="First slide" width="900" height="350">
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="${images}/CSlider2.jpg"
									alt="Second slide" width="900" height="350">
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="${images}/CSlider3.jpg"
									alt="Third slide" width="900" height="350">
							</div>
							<div class="carousel-item">
								<img class="d-block img-fluid" src="${images}/CSlider4.jpg"
									alt="Fourth slide" width="900" height="350">
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
			</div>
			
			<div class="row">
                	<div class="col-xs-12">
                		<h3>Our Most Viewed Items</h3>
                		<hr/>
                	</div>
                </div>

                <div class="row is-table-row">
                	
                    <div class="col-sm-4" data-ng-repeat="item in iCtrl.mvItems">                    	
                        <div class="thumbnail">
                            <img data-ng-src="${images}/{{item.code}}.jpg" alt="{{item.name}}" class="landingImg">
                            <h5>{{item.name}}</h5>
                            <hr/>
                            <div class="caption">
                                <h4 class="pull-right">&#8377; {{item.unitPrice}}</h4>
                                <p>{{item.description}}</p>
                                <a data-ng-href="${contextRoot}/show/{{item.id}}/item" class="btn btn-primary pull-right">View</a>
                            </div>
                        </div>
                        
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4>Checkout more items!</h4>
                        <hr/>
                        <a class="btn btn-primary" href="${contextRoot}/show/all/items">More Items</a>
                    </div>

                </div>
				
				<div class="row">
                	<div class="col-xs-12">
                		<h3>Our Most Purchased Items</h3>
                		<hr/>
                	</div>
                </div>
               <div class="row is-table-row">
                	
                    <div class="col-sm-4" data-ng-repeat="item in iCtrl.mpItems">                    	
                        <div class="thumbnail">
                            <img data-ng-src="${images}/{{item.code}}.jpg" alt="{{item.name}}" class="landingImg">
                            <h5>{{item.name}}</h5>
                            <hr/>
                            <div class="caption">
                                <h4 class="pull-right">&#8377;{{item.unitPrice}}</h4>
                                <p>{{item.description}}</p>
                                <a data-ng-href="${contextRoot}/show/{{item.id}}/item" class="btn btn-primary pull-right">View</a>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 col-lg-4 col-md-4">
                        <h4>Checkout more items!</h4>
                        <hr/>
                        <a class="btn btn-primary" href="${contextRoot}/show/all/items">More Items</a>
                    </div>

                </div>

		</div>

	</div>

</div>