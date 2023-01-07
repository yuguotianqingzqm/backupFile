<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				    <li><a href="addFood.jsp">添加新菜单</a></li>
					<li role="separator" class="divider"></li>
				    <li><a href="${pageContext.request.contextPath}/findAllFoodsServlet">菜单信息列表</a></li>
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
				    <li><a href="${pageContext.request.contextPath}/findAllSortServlet">类别信息列表</a></li>
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
			<aside id="right">			<%--//上传文件必须要设置enctype属性--%>
				<form class="form-horizontal" v-bind:action="action" enctype="multipart/form-data" method="post">
				  <div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">菜品名称:</label>
					<div class="col-sm-10">
					  <input maxlength="10" type="text" class="form-control" name="foodName" id="inputEmail3">
					</div>
				  </div>
				  <div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">价格:</label>
					<div class="col-sm-10">
					  <input type="number"maxlength="10" class="form-control" name="foodPrice" id="inputPassword3" placeholder="">
					</div>
				  </div>
				  <div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label"  >会员价格:</label>
					<div class="col-sm-10">
					  <input type="number"maxlength="10" class="form-control" name="vipPrice" id="inputPassword3" placeholder="">
					</div>
				  </div>
				  <div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">特殊说明:</label>
					<div class="col-sm-10">
					   <input type="text"maxlength="10" class="form-control" name="specialHint" id="inputPassword3"/>
					</div>
				  </div>
				  <div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label" >菜品类别:</label>
					<div class="col-sm-10">
						<!-- Split button -->
						<div class="btn-group">
							<button type="button" class="btn btn-danger">{{sortName}}</button>
							<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<span class="caret"></span>
								<span class="sr-only">Toggle Dropdown</span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#" v-for="(item,index) in sort" @click="addSortId(index)">{{item.sortName}}</a></li>
								<li role="separator" class="divider"></li>
<%--								<select style="width: 100px;background-color: greenyellow;" name="sortId" class="form-control">--%>
<%--									<option  v-for="(item,index) in sort" @click="addSortId(1)"></option>--%>
<%--								</select>--%>
							</ul>
						</div>
					</div>
				  </div>
				  <div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">上传图片:</label>
					<div class="col-sm-10">
					  <input name="image" type="file"/>
					</div>
				  </div>
				  <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					  <button type="submit" class="btn btn-success"style="width: 100px;margin-left: 50px;"@click="add">添加</button>
					</div>
				  </div>
				</form>
			</aside>
		</section>
	<script type="text/javascript">
		var app=new Vue({
			el:"#right",
			data:{
				sort:[
				<c:forEach items="${sort}" var="sort" varStatus="s">
					{sortId:"${sort.sortId}",sortName:"${sort.sortName}"},
					</c:forEach>
				],
				sortId:"${sort[0].sortId}",
				sortName:"${sort[0].sortName}",
				action:"${pageContext.request.contextPath}/addFoodServlet?sortId="+this.sortId,  //获取不到sortId
				//	字符串“”不能少	属性缺少“”会报Uncaught SyntaxError: Unexpected token ','错误
			},
			methods:{
				addSortId:function(sortId) {
					<c:forEach items="${sort}" var="sort" varStatus="s">
					if(sortId==${s.index}){
						this.action="${pageContext.request.contextPath}/addFoodServlet?sortId="+this.sortId;
						this.sortName="${sort.sortName}";
						this.sortId=${sort.sortId};
					}
					</c:forEach>
				},
				add:function () {
					this.action="${pageContext.request.contextPath}/addFoodServlet?sortId="+this.sortId;
				},
			},
		});

	</script>
	</body>
</html>
