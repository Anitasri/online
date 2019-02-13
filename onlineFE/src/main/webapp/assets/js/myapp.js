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

	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'You want to activate the item?'
								: 'You want to deactivate the item?';
						var value = checkbox.prop(value);

						bootbox
								.confirm({
									size : 'medium',
									title : 'Item Activation & Deactivation',
									message : dMsg,
									callback : function(confirmed) {

										if (confirmed) {

											console.log(value);
											bootbox
													.alert({
														size : 'medium',
														title : 'Information',
														message : 'You are going to perform operation on item'
																+ value,
													});
										} else {

											checkbox.prop('checked', !checked);
										}

									}

								});

					});

});
