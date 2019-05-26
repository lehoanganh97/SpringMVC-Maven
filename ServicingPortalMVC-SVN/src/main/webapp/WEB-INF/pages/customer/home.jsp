<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
<meta charset="UTF-8">
<title>Servicing Portal | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.4 -->
<link href="partner/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="partner/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
<link href="partner/dist/css/skins/skin-blue.min.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!--
  BODY TAG OPTIONS:
  =================
  Apply one or more of the following classes to get the
  desired effect
  |---------------------------------------------------------|
  | SKINS         | skin-blue                               |
  |               | skin-black                              |
  |               | skin-purple                             |
  |               | skin-yellow                             |
  |               | skin-red                                |
  |               | skin-green                              |
  |---------------------------------------------------------|
  |LAYOUT OPTIONS | fixed                                   |
  |               | layout-boxed                            |
  |               | layout-top-nav                          |
  |               | sidebar-collapse                        |
  |               | sidebar-mini                            |
  |---------------------------------------------------------|
  -->
<body class="skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<header class="main-header">

			<!-- Logo -->
			<a href="index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>CUS</b></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>Customer</b>Management</span>
			</a>

			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Messages: style can be found in dropdown.less-->
						<li class="dropdown messages-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
								class="label label-success">4</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">Bạn có 4 thông tin mới</li>
								<li>
									<!-- inner menu: contains the messages -->
									<ul class="menu">
										<li>
											<!-- start message --> <a href="#">
												<div class="pull-left">
													<!-- User Image -->
													<img src="../partner/dist/img/user2-160x160.jpg"
														class="img-circle" alt="User Image" />
												</div> <!-- Message title and timestamp -->
												<h4>
													Trần Văn B <small><i class="fa fa-clock-o"></i> 5
														mins</small>
												</h4> <!-- The message -->
												<p>Sản phẩm bạn cung cấp chất lượng không?</p>
										</a>
										</li>
										<!-- end message -->
									</ul> <!-- /.menu -->
								</li>
								<li class="footer"><a href="#">Xem tất cả tin nhắn</a></li>
							</ul>
						</li>
						<!-- /.messages-menu -->

						<!-- Notifications Menu -->
						<li class="dropdown notifications-menu">
							<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
								class="label label-warning">10</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">Bạn có 10 thông báo</li>
								<li>
									<!-- Inner Menu: contains the notifications -->
									<ul class="menu">
										<li>
											<!-- start notification --> <a href="#"> <i
												class="fa fa-users text-aqua"></i> Có 5 khách hàng mới theo
												dõi bạn
										</a>
										</li>
										<!-- end notification -->
										<li>
											<!-- start notification --> <a href="#"> <i
												class="fa fa-users text-aqua"></i> Đơn hàng 12345 cần xác
												nhận
										</a>
										</li>
										<!-- end notification -->
									</ul>
								</li>
								<li class="footer"><a href="#">Xem tất cả</a></li>
							</ul>
						</li>

						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <!-- The user image in the navbar-->
								<img src="partner/dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image" /> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">${cusProfile.getCustomerFullName()}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img
									src="partner/dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image" />
									<p>
										${cusProfile.getCustomerFullName()} <small>Thành viên từ
											11/2012</small>
									</p></li>
								<!-- Menu Body -->

								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul>
						</li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">

			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">

				<!-- Sidebar user panel (optional) -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="partner/dist/img/user2-160x160.jpg" class="img-circle"
							alt="User Image" />
					</div>
					<div class="pull-left info">
						<p>${cusProfile.getCustomerFullName()}</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i> Trực
							tuyến</a>
					</div>
				</div>

				<!-- search form (Optional) -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Tìm kiếm..." /> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->

				<!-- Sidebar Menu -->
				<ul class="sidebar-menu">
					<li class="treeview"><a href="#"><i
							class="fa fa-paper-plane-o"></i> <span>Dịch vụ cung cấp</span> <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-list"></i>Danh sách dịch
									vụ</a></li>
							<li><a href="#"><i class="fa fa-plus-circle"></i>Thêm
									mới dịch vụ</a></li>
						</ul></li>
					<li class="treeview"><a href="#"><i class="fa fa-list"></i>
							<span>Danh sách đơn hàng</span> <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath}/viewCustomerOrder"><i
									class="fa fa-calendar-o"></i> <span>Thực hiện</span></a></li>
							<li class="active"><a href="viewCustomerOrderComplete.jsp"><i
									class="fa fa-check"></i> <span>Đã hoàn thành</span></a></li>
							<li><a href="viewCustomerOrderCancel.jsp"><i
									class="fa fa-remove"></i> <span>Đã hủy</span></a></li>
						</ul></li>
					<li class="treeview"><a href="#"><i class="fa fa-link"></i>
							<span>Liên lạc</span> <i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="Mailbox.html"> <i class="fa fa-envelope"></i>
									<span>Hộp thư</span> <small class="label pull-right bg-yellow">12</small>
							</a></li>
							<li><a href="Chat.html"> <i class="fa fa-wechat"></i> <span>Chat</span>
									<small class="label pull-right bg-green">6</small>
							</a></li>
						</ul></li>

					<li><a href="Invoice.html"><i class="fa fa-money"></i> <span>Thu
								nhập</span></a></li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Danh sách đơn hàng</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-home"></i>Home</a></li>
					<li class="active">Danh sách hoàn thành</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">Đơn hàng đã đặt</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body">
									<div id="example1_wrapper"
										class="dataTables_wrapper form-inline dt-bootstrap">
										<div class="row">
											<div class="col-sm-6">
												<div class="dataTables_length" id="example1_length">
													<label>Show <select name="example1_length"
														aria-controls="example1" class="form-control input-sm"><option
																value="10">10</option>
															<option value="25">25</option>
															<option value="50">50</option>
															<option value="100">100</option></select> entries
													</label>
												</div>
											</div>
											<div class="col-sm-6">
												<div id="example1_filter" class="dataTables_filter">
													<label>Search:<input type="search"
														class="form-control input-sm" placeholder=""
														aria-controls="example1"></label>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<table id="example1"
													class="table table-bordered table-striped dataTable"
													role="grid" aria-describedby="example1_info">
													<thead>
														<tr role="row">
															<th class="sorting_asc" tabindex="0"
																aria-controls="example1" rowspan="1" colspan="1"
																style="width: 181px;" aria-sort="ascending"
																aria-label="Rendering engine: activate to sort column descending">Rendering
																engine</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1" style="width: 224px;"
																aria-label="Browser: activate to sort column ascending">Browser</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1" style="width: 198px;"
																aria-label="Platform(s): activate to sort column ascending">Platform(s)</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1" style="width: 155px;"
																aria-label="Engine version: activate to sort column ascending">Engine
																version</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1" style="width: 110px;"
																aria-label="CSS grade: activate to sort column ascending">CSS
																grade</th>
														</tr>
													</thead>
													<tbody>
														<tr role="row" class="odd">
															<td class="sorting_1">Gecko</td>
															<td>Firefox 1.0</td>
															<td>Win 98+ / OSX.2+</td>
															<td>1.7</td>
															<td>A</td>
														</tr>
														<tr role="row" class="even">
															<td class="sorting_1">Gecko</td>
															<td>Firefox 1.5</td>
															<td>Win 98+ / OSX.2+</td>
															<td>1.8</td>
															<td>A</td>
														</tr>
														<tr role="row" class="odd">
															<td class="sorting_1">Gecko</td>
															<td>Firefox 2.0</td>
															<td>Win 98+ / OSX.2+</td>
															<td>1.8</td>
															<td>A</td>
														</tr>
														<tr role="row" class="even">
															<td class="sorting_1">Gecko</td>
															<td>Firefox 3.0</td>
															<td>Win 2k+ / OSX.3+</td>
															<td>1.9</td>
															<td>A</td>
														</tr>
														<tr role="row" class="odd">
															<td class="sorting_1">Gecko</td>
															<td>Camino 1.0</td>
															<td>OSX.2+</td>
															<td>1.8</td>
															<td>A</td>
														</tr>
														<tr role="row" class="even">
															<td class="sorting_1">Gecko</td>
															<td>Camino 1.5</td>
															<td>OSX.3+</td>
															<td>1.8</td>
															<td>A</td>
														</tr>
														<tr role="row" class="odd">
															<td class="sorting_1">Gecko</td>
															<td>Netscape 7.2</td>
															<td>Win 95+ / Mac OS 8.6-9.2</td>
															<td>1.7</td>
															<td>A</td>
														</tr>
														<tr role="row" class="even">
															<td class="sorting_1">Gecko</td>
															<td>Netscape Browser 8</td>
															<td>Win 98SE+</td>
															<td>1.7</td>
															<td>A</td>
														</tr>
														<tr role="row" class="odd">
															<td class="sorting_1">Gecko</td>
															<td>Netscape Navigator 9</td>
															<td>Win 98+ / OSX.2+</td>
															<td>1.8</td>
															<td>A</td>
														</tr>
														<tr role="row" class="even">
															<td class="sorting_1">Gecko</td>
															<td>Mozilla 1.0</td>
															<td>Win 95+ / OSX.1+</td>
															<td>1</td>
															<td>A</td>
														</tr>
													</tbody>
													<tfoot>
														<tr>
															<th rowspan="1" colspan="1">STT</th>
															<th rowspan="1" colspan="1">CreateDate</th>
															<th rowspan="1" colspan="1">Total Price</th>
															<th rowspan="1" colspan="1">Status</th>
															<th rowspan="1" colspan="1">Note</th>
														</tr>
													</tfoot>
												</table>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-5">
												<div class="dataTables_info" id="example1_info"
													role="status" aria-live="polite">Showing 1 to 10 of
													57 entries</div>
											</div>
											<div class="col-sm-7">
												<div class="dataTables_paginate paging_simple_numbers"
													id="example1_paginate">
													<ul class="pagination">
														<li class="paginate_button previous disabled"
															id="example1_previous"><a href="#"
															aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a></li>
														<li class="paginate_button active"><a href="#"
															aria-controls="example1" data-dt-idx="1" tabindex="0">1</a></li>
														<li class="paginate_button "><a href="#"
															aria-controls="example1" data-dt-idx="2" tabindex="0">2</a></li>
														<li class="paginate_button "><a href="#"
															aria-controls="example1" data-dt-idx="3" tabindex="0">3</a></li>
														<li class="paginate_button "><a href="#"
															aria-controls="example1" data-dt-idx="4" tabindex="0">4</a></li>
														<li class="paginate_button "><a href="#"
															aria-controls="example1" data-dt-idx="5" tabindex="0">5</a></li>
														<li class="paginate_button "><a href="#"
															aria-controls="example1" data-dt-idx="6" tabindex="0">6</a></li>
														<li class="paginate_button next" id="example1_next"><a
															href="#" aria-controls="example1" data-dt-idx="7"
															tabindex="0">Next</a></li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /.box-body -->
							</div>
						</div>
					</div>
				</div>

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div class="pull-right hidden-xs">Servicing Portal</div>
			<!-- Default to the left -->
			<strong>Copyright &copy; 2019 <a href="#">Company</a>.
			</strong> All rights reserved.
		</footer>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
				<li class="active"><a href="#control-sidebar-home-tab"
					data-toggle="tab"><i class="fa fa-home"></i></a></li>
				<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
						class="fa fa-gears"></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content">
				<!-- Home tab content -->
				<div class="tab-pane active" id="control-sidebar-home-tab">
					<h3 class="control-sidebar-heading">Recent Activity</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript::;"> <i
								class="menu-icon fa fa-birthday-cake bg-red"></i>
								<div class="menu-info">
									<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

					<h3 class="control-sidebar-heading">Tasks Progress</h3>
					<ul class="control-sidebar-menu">
						<li><a href="javascript::;">
								<h4 class="control-sidebar-subheading">
									Custom Template Design <span
										class="label label-danger pull-right">70%</span>
								</h4>
								<div class="progress progress-xxs">
									<div class="progress-bar progress-bar-danger"
										style="width: 70%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->

				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
					Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane" id="control-sidebar-settings-tab">
					<form method="post">
						<h3 class="control-sidebar-heading">General Settings</h3>
						<div class="form-group">
							<label class="control-sidebar-subheading"> Report panel
								usage <input type="checkbox" class="pull-right" checked />
							</label>
							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->
					</form>
				</div>
				<!-- /.tab-pane -->
			</div>
		</aside>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 2.1.4 -->
	<script src="partner/plugins/jQuery/jQuery-2.1.4.min.js"
		type="text/javascript"></script>
	<!-- Bootstrap 3.3.2 JS -->
	<script src="partner/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="partner/dist/js/app.min.js" type="text/javascript"></script>

	<!-- Optionally, you can add Slimscroll and FastClick plugins.
          Both of these plugins are recommended to enhance the
          user experience. Slimscroll is required when using the
          fixed layout. -->
</body>
</html>
