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
			<link rel="stylesheet" type="text/css" href="css/login.css"/>
	</head>
	<body>
		<!-- 头部 -->
		<header>
			<nav class="navbar navbar-default navbar-inverse center">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">首页</a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
                  <li class=""><a href="${pageContext.request.contextPath}/findOrderByUserIdServlet">我的订单 <span class="sr-only">(current)</span></a></li>
				  <li class=""><a href="${pageContext.request.contextPath}/addressManage.jsp">地址管理</a></li>
		        <li class=""><a href="#">会员注册</a></li>
				<li class=""><a href="#">配送说明</a></li>
				<li class=""><a href="#">关于我们</a></li>
				<li class=""><a href="#">退出</a></li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
		</header>
		<!-- 中间区域 -->
		<section id="center">
			<aside id="left">
                <c:forEach items="${foods}" var="foods" varStatus="s">
				<div id="show-l">
					<ul>
						<img src="${pageContext.request.contextPath}/upload/${foods.foodImage}" alt="">
					</ul>
					<ul>
						<li><span>菜名：</span><span>${foods.foodName}</span></li>
						<li><span>价格：</span><span>${foods.foodPrice}</span></li>
						<li><span>会员价格：</span><span>${foods.vipPrice}</span></li>
						<li><span>特殊说明：</span><span>${foods.specialHint}</span></li>
						<li><span>菜品类型：</span><span>${foods.sortId}</span></li>
					</ul>
					<div id="" v-on:click="add(${s.index})">
						加入餐车
					</div>
				</div>
                </c:forEach>
			</aside>
			<aside id="right">
				<!-- 购物车 -->
				<div id="shoppingCart">
					<table class="table table-hover">
					  <tr style="background-color: ghostwhite;">
						<td></td>
					  	<td>菜品名称</td>
					  	<td>价格</td>
						<td></td>
					  	<td>数量</td>
						<td></td>
					  </tr>
					  <tr id="t-good" v-for="(item,index) in goods">
						  <td style="height: 80px;width: 80px;"><img v-bind:src="goods[index].foodImage" alt=""height="100%"width="100%"></td>
						  <td>{{item.foodName}}</td>
						  <td>{{item.price}}</td>
						  <td><input class="btn btn-default" type="button" value="-"@click="subtraction(index)"></td>
						   <td>{{item.number}}</td>
						   <td><input class="btn btn-default" type="button" value="+" @click="numAdd(index)"></td>

					</table>
				</div>
				<!-- //底部按钮 -->
				<div id="bottom-button">
					<div id="totalPrice">
						<span>总价格:</span>
						<span>￥{{totalPrice}}</span>
					</div>
					<div id="submit">
						<input class="btn btn-default" type="button" value="提交" @click="addRequest">
						<input class="btn btn-default" type="submit"@click="cancel()" value="全部取消">
					</div>
				</div>
			</aside>
		</section>
		<script type="text/javascript">
			// window.location.href='';
	var app=new Vue({
		el:"#center",
		data:{
			goods:[
			],
			totalPrice:0,
		},
		methods: {
			//发送异步请求到服务器，将数据提交
			addRequest:function(){
				<%--$.post("${pageContext.request.contextPath}/addOrder",{order:this.goods});--%>
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/addOrder2",
                    async:"true",
                    contentType:"application/json",
                    // dataType:"json",
                    data:JSON.stringify(this.goods)
					// JSON.stringify(this.goods)
                })
			},
			//计算总价格
			totalPrice1:function(){
				this.totalPrice=0;
				for(var i=0;i<this.goods.length;i++){
					this.totalPrice+=Number(this.goods[i].price)*Number(this.goods[i].number);
				}
			},
			//添加购物车
			add:function(index){
				<c:forEach items="${foods}" var="foods" varStatus="s">
				if(index==${s.index}){
					this.goods.push({orderId:"${pageContext.request.getSession(false).getAttribute("user")[0].userId}",foodName:"${foods.foodName}",price:"${foods.foodPrice}",number:"1",foodImage:"${pageContext.request.contextPath}/upload/${foods.foodImage}"});
				}
				//计算总价格
				this.totalPrice1();
				</c:forEach>

			},
			// 数量减法
			subtraction:function(index){
				var num=this.goods[index].number;
				this.goods[index].number=Number(num)-1;
				if(this.goods[index].number===0){
					this.goods.splice(index,1);
				};
				// 计算总价格
				this.totalPrice1();

			},
			//数量加法
			numAdd:function(index){
				var num=this.goods[index].number;
				this.goods[index].number=Number(num)+1;
				//计算总价格
				this.totalPrice1();
			},
			//取消全部订单
			cancel:function(){
				this.goods.splice(0,this.goods.length);
			},
		},
	});
</script>
		
	</body>
</html>
