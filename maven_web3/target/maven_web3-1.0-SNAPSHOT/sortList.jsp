<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>Bootstrap 101 Template</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="css/bootstrap.min.css" >
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="js/jquery-3.6.0.min.js" ></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="js/bootstrap.min.js" ></script>
		<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
		<link rel="stylesheet" type="text/css" href="css/foodList.css"/>
		<link rel="stylesheet" type="text/css" href="css/backgroundStyle.css"/>
	</head>
	<body>
		<header>
			<h2>网上订餐后台系统</h2>
			<ul>管理员<span></span>您好，感谢登录使用</ul>
			<input type="button" value="退出" />
		</header>
		<!-- 中间内容区域 -->
		<section>
			<aside id="left">
				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				   菜单管理
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="${pageContext.request.contextPath}/findAllSortServlet?name=addFood">添加新菜单</a></li>
					<li role="separator" class="divider"></li>
				    <li><a href="addMenu.html">菜单信息列表</a></li>
				  </ul>
				</div>
				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				   菜品类别管理
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="${pageContext.request.contextPath}/addSort.jsp">添加新类别</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">类别信息列表</a></li>
				  </ul>
				</div>
				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				   公告信息管理
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">Action</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">Separated link</a></li>
				  </ul>
				</div>
				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				   销售订单管理
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">Action</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">Separated link</a></li>
				  </ul>
				</div>
				<div class="dropdown">
				  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
				系统用户管理
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">Action</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">Separated link</a></li>
				  </ul>
				</div>
				
			</aside>
			<aside id="right">
				<table class="table table-bordered table-hover">
					 <tr>
						 <td colspan="8" style="background-color: white;">类别信息列表</td>
					</tr>
					<tr>
						<td>类别id</td>
						<td>类别名称</td>
						<td></td>
						<td></td>
					</tr>
					<c:forEach items="${sort}" var="sort" varStatus="s">
						<tr>
							<td>${sort.sortId}</td>
							<td>${sort.sortName}</td>
							<td>修改</td>
							<td><a href="${pageContext.request.contextPath}/deleteSortServlet?sortId=${sort.sortId}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
			</aside>
		</section>
	</body>
</html>
