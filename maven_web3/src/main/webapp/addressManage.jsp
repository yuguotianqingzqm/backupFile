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
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <style>
        body{
            background: url(images/4.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        }
        section{

            background-color: whitesmoke;
            height: 650px;
            width: 700px;
            margin: auto;
            overflow-y: scroll;
            position: relative;
        }
        #div1{
            display: flex;
            flex-wrap: wrap;
            background: white;
            margin-top: 20px;
        }
        #div1 ul li{
            margin: 20px;
        }
        div input[type=button]{
            background-color:darkorange;
            border-radius: 5px;
            border: none;
            width: 80px;
            margin-left:400px;
            margin-top: 40px;
            height: 30px;
        }
        #addAddress{
            position: absolute;
            width: 200px;
            bottom: 20px;
            left: 230px;
        }
    </style>

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
                <a class="navbar-brand" href="${pageContext.request.contextPath}/loginServlet">首页</a>
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
<section>
    <div id="top">
        <c:forEach items="${addressManages}" var="addressManages" varStatus="a">
          <div id="div1">
            <ul>
                <li>${addressManages.contactAddress}</li>
                <li>${addressManages.contactName}<span>${addressManages.contactTelephone}</span></li>
            </ul>
            <input type="button" value="修改">
        </div>
        </c:forEach>

    </div>
    <a href="${pageContext.request.contextPath}/addAddressManage.jsp" id="addAddress" class="btn btn-primary">新建收货地址</a>
</section>
</body>
</html>

