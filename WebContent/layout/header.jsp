<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Simple Responsive Admin</title>
<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="<%=request.getContextPath()%>/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/assets/css/custom.css"
	rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/assets/css/style.css"
	rel="stylesheet" />

</head>
<body>



	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <img
						src="assets/img/logo.png" />
					</a>
				</div>

				<span class="logout-spn"> <a href="#" style="color: #fff;">LOGOUT</a>

				</span>
			</div>
		</div>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">
				<li><a href="index.html"><i class="fa fa-desktop "></i>Dashboard
						<span class="badge">Included</span></a></li>


				<li><a href="ui.html"><i class="fa fa-table "></i>UI
						Elements <span class="badge">Included</span></a></li>
				<li class="active-link"><a href="blank.html"><i
						class="fa fa-edit "></i>Blank Page <span class="badge">Included</span></a>
				</li>



				<li><a href="#"><i class="fa fa-qrcode "></i>My Link One</a></li>
				<li><a href="#"><i class="fa fa-bar-chart-o"></i>My Link
						Two</a></li>

				<li><a href="#"><i class="fa fa-edit "></i>My Link Three </a></li>
				<li><a href="#"><i class="fa fa-table "></i>My Link Four</a></li>
				<li><a href="#"><i class="fa fa-edit "></i>My Link Five </a></li>
			</ul>
		</div>

		</nav>
		<div id="page-wrapper" >
            <div id="page-inner">