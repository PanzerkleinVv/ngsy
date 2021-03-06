<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<base href="<%=basePath%>">
<meta charset="utf-8" />
<title>干部人事管理系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<meta name="MobileOptimized" content="320">

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN THEME STYLES -->
<link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
<link href="assets/css/style.css" rel="stylesheet" type="text/css" />
<link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
<link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
<link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
<link href="assets/css/people.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->

<link rel="shortcut icon" href="app/img/favicon.ico" />
<link href="assets/plugins/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
<link href="app/css/index.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/summernote/summernote.css" rel="stylesheet" />
<link href="assets/plugins/bootstrap/css/bootstrap-multiselect.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap/css/bootstrap-treeview.css" rel="stylesheet" type="text/css" />
<link href="assets/css/easyui.css" rel="stylesheet" type="text/css" />
<link href="assets/css/icon.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="assets/plugins/bootstrapStyle/bootstrapStyle.css" type="text/css">
<link rel="alternate icon" type="image/png" href="assets/i/favicon.png">
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- BEGIN HEADER -->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<!-- BEGIN TOP NAVIGATION BAR -->
		<div class="header-inner">
			<!-- BEGIN LOGO -->
			<span class="navbar-brandText">广东省农工商职业技术学院干部人事管理系统 </span>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <img src="assets/img/menu-toggler.png" alt="" />
			</a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown user"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true"> <span class="username"> ${userInfo.userdesc} </span> <i class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:;" id="trigger_fullscreen"> <i class="fa fa-move"></i> 全屏
						</a></li>
						<li><a href="rest/user/logout"> <i class="fa fa-key"></i> 退出
						</a></li>
					</ul></li>
				<!-- END USER LOGIN DROPDOWN -->
			</ul>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END TOP NAVIGATION BAR -->
	</div>
	<!-- END HEADER -->
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar-wrapper">
			<div class="page-sidebar navbar-collapse collapse">
				<!-- BEGIN SIDEBAR MENU -->
				<ul class="page-sidebar-menu" id="page-sidebar-menu">
					<li class="sidebar-toggler-wrapper">
						<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
						<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					</li>

					<li class="start active"><a href="./rest/page/dashboard" id="btn-dashboard"> <i class="fa fa-home"></i> <span class="title"> 首页 </span> <span class="selected"> </span>
					</a></li>

					<shiro:hasAnyRoles name="admin">
						<li class=""><a href="./rest/page/findPerson"> <i class="fa fa-search"></i> <span class="title"> 人员查找 </span> <span class="selected "> </span>
						</a></li>

						<li class=""><a href="./rest/page/addPerson"> <i class="fa fa-plus"></i> <span class="title"> 人员新增 </span> <span class="selected "> </span>
						</a></li>

						<li class=""><a href="./rest/unit/index" id="btn-dashboard"> <i class="fa fa-sitemap"></i> <span class="title"> 单位机构 </span> <span class="selected"> </span>
						</a></li>
					</shiro:hasAnyRoles>

					<li class=""><a href="./rest/user/mine" id="btn-dashboard"> <i class="fa fa-user"></i> <span class="title"> 个人信息 </span> <span class="selected"> </span>
					</a></li>

					<shiro:hasRole name="admin">
						<li class=""><a href="javascript:;"> <i class="fa fa-gears"></i> <span class="title"> 系统管理 </span> <span class="arrow "> </span>
						</a>
							<ul class="sub-menu">
								<li><a href="./rest/user/admin"> 用户管理 </a></li>
								<li><a href="./rest/user/info"> 用户新增 </a></li>
								<li><a href="./rest/code/admin"> 字典管理 </a></li>
								<li><a href="./rest/log/admin"> 日志管理 </a></li>
							</ul></li>
					</shiro:hasRole>
				</ul>
				<!-- END SIDEBAR MENU -->
			</div>
		</div>
		<!-- END SIDEBAR -->
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">Widget settings form goes here</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<!-- BEGIN STYLE CUSTOMIZER -->
				<div class="theme-panel hidden-xs hidden-sm">
					<div class="toggler"></div>
					<div class="toggler-close"></div>
					<div class="theme-options">
						<div class="theme-option theme-colors clearfix">
							<span> 主题颜色 </span>
							<ul>
								<li class="color-blue current color-default" data-style="default"></li>
								<li class="color-black" data-style="blue"></li>
								<li class="color-brown" data-style="brown"></li>
								<li class="color-purple" data-style="purple"></li>
								<li class="color-grey" data-style="grey"></li>
								<li class="color-white color-light" data-style="light"></li>
							</ul>
						</div>
						<div class="theme-option">
							<span> 布局 </span>
							<select class="layout-option form-control input-small">
								<option value="fluid">顺序</option>
								<option value="boxed">盒状</option>
							</select>
						</div>
						<div class="theme-option">
							<span> 标题 </span>
							<select class="header-option form-control input-small">
								<option value="fixed">固定</option>
								<option value="default">默认</option>
							</select>
						</div>
						<div class="theme-option">
							<span> 工具栏 </span>
							<select class="sidebar-option form-control input-small">
								<option value="fixed">固定</option>
								<option value="default">默认</option>
							</select>
						</div>
						<div class="theme-option">
							<span> 工具栏位置 </span>
							<select class="sidebar-pos-option form-control input-small">
								<option value="left">左边</option>
								<option value="right">右边</option>
							</select>
						</div>
						<div class="theme-option">
							<span> 页脚 </span>
							<select class="footer-option form-control input-small">
								<option value="fixed">固定</option>
								<option value="default">默认</option>
							</select>
						</div>
					</div>
				</div>
				<!-- END STYLE CUSTOMIZER -->

				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title page-title1" id="index-page-title">提醒预览</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> 首页 <i class="fa fa-angle-right"></i></li>
							<li id="current-page-title">提醒预览</li>
							<li id="goBack" style="display: none; color: blue;" onclick="goBack()" class="clickable">&emsp;&emsp;&emsp;&emsp;返回</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->

				<!-- BEGIN DASHBOARD STATS -->
				<div id="main-content"></div>
				<div id="msg-content"></div>
				<!-- END PORTLET-->
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->
	<!-- BEGIN FOOTER -->
	<div class="footer">
		<div class="footer-inner">2018 &copy; 广东省信息网络有限公司</div>
		<div class="footer-tools">
			<span class="go-top">
				<i class="fa fa-angle-up"></i>
			</span>
		</div>
	</div>
	<!--[if lt IE 9]>
        <script src="assets/plugins/respond.min.js"></script>
        <script src="assets/plugins/excanvas.min.js"></script>
        <script src="assets/scripts/selectivizr.js"></script>
        <![endif]-->
	<script src="assets/scripts/jquery.min.js" type="text/javascript"></script>
	<script src="assets/plugins/ajaxfileupload(2).js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/scripts/bootstrap-treeview.min.js" type="text/javascript"></script>
	<script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
	<script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

	<script src="assets/plugins/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
	<script src="assets/plugins/jquery-validation/dist/localization/messages_zh.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/plugins/select2/select2.min.js"></script>

	<script src="assets/scripts/app.js" type="text/javascript"></script>
	<script type="text/javascript" src="app/js/index.js"></script>
	<script src="assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
	<script type="text/javascript" src="assets/plugins/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js" charset="UTF-8"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap-multiselect.js"></script>
	<script src="assets/plugins/ueditor/ueditor.config.js"></script>
	<script src="assets/plugins/ueditor/ueditor.all.min.js"></script>
	<script src="assets/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/layer.js"></script>
	<script lang="javaScript">
		var URL = window.UEDITOR_HOME_URL || "assets/plugins/ueditor/";
	</script>
	<script type="text/javascript" src="assets/scripts/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="assets/scripts/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="assets/scripts/jquery.ztree.exedit.js"></script>
	<script type="text/javascript" src="assets/scripts/jquery.form.js"></script>
	<script type="text/javascript" src="assets/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
	<script type="text/javascript" src="assets/plugins/bootstrap-fileinput/js/locales/zh.js"></script>
</body>
</html>