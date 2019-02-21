$(function() {
	// to solve active menu bar problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Items':
		$('#listItems').addClass('active');
		break;
	case 'Manage Items':
		$('#manageItems').addClass('active');
		break;

	default:
		if (menu == "Home")
			break;
		$('#listItems').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

	//to tackle the csrf token
	var token=$('meta[name="_csrf"]').attr('content');
var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {	
		// set the token header for the ajax request	
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});
		
	}
		
	
	// code for jquery dataTable

	var $table = $('#itemListTable');

	// execute the below code only where we have this table
	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/items';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/items';
		}

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';

								}
							},

							{
								data : 'name'
							},
							{
								data : 'foodType'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}

							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/item" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
									if (row.quantiy < 1) {
										str += '<a href="javascript:void(0)" class="btn btn-warning disabled" role="button" aria-disabled="true"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										return str;
									} else {

										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/item" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
										return str;
									}
								}
							},

					]

				});

	}

	// dismissing the alert after 3secs
	var $alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeout('slow');
		}, 3000)

	}

	// ---------------------------------

	// data table for admin

	// --------------------

	var $adminItemsTable = $('#adminItemsTable');

	// execute the below code only where we have this table
	if ($adminItemsTable.length) {
		// console.log('Inside the table!');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/items';

		$adminItemsTable
				.DataTable({

					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [

							{
								data : 'id'
							},

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';

								}
							},

							{
								data : 'name'
							},
							{
								data : 'foodType'
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}

									return data;

								}
							},

							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}

							},

							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<label class="switch">';
									if (data) {

										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '"/>';
									} else {

										str += '<input type="checkbox" value="'
												+ row.id + '"/>';
									}

									str += '<div class="slider round"></div></label>';
									return str;

								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="' + window.contextRoot
											+ '/manage/' + data
											+ '/item" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';
									return str;

								}

							}

					],

					initComplete : function() {

						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the item?'
													: 'You want to deactivate the item?';
											var value = checkbox.prop('value');

											bootbox
													.confirm({
														size : 'small',
														title : 'Item Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {

															if (confirmed) {

																console
																		.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/item/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {

																					bootbox
																							.alert({
																								size : 'small',
																								title : 'Information',
																								message : data
																							});

																				});

															} else {

																checkbox
																		.prop(
																				'checked',
																				!checked);
															}

														}

													});

										});

					}

				});

	}

	// --------------------

	// validate code for category
	
	//-------------------------------------------------------
	var $categoryForm = $('#categoryForm');

	if ($categoryForm.length) {

		$categoryForm.validate({
			rules : {
				name : {
					required : true,
					minlength : 3
				},
				description : {
					required : true,
					minlength : 3
				}
			},
			messages : {
				name : {
					required : 'Please enter category name!',
					minlength : 'Please enter atleast three characters'
				},
				description : {
					required : 'Please enter category description!',
					minlength : 'Please enter atleast three characters'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
		});

	}

	//-----------------------------------------------------------------
	
	
	// --------------------

	// validate code for login form
	
	//-------------------------------------------------------
	var $loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({
			rules : {
				username : {
					required : true,
					email : true,
				},
				password : {
					required : true,
					minlength : 3
				}
			},
			messages : {
				username : {
					required : 'Please enter the email address!',
					email : 'Please enter the valid email address'
				},
				password : {
					required : 'Please enter the password!',
					minlength : 'Please enter atleast three characters'
				}
			},
			errorElement : "em",
			errorPlacement : function(error, element) {
				//add the class of help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
			}
		});

	}

	//-----------------------------------------------------------------
	
	
});
