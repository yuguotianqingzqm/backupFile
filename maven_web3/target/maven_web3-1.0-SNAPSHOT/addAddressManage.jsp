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
            position: relative;
        }
        button{
            position: absolute;
            width: 200px;
            top: 150px;
            left: 120px;
        }
        form{
            height: 400px;
            border:0.1px solid white;

        }
        form>div{
            margin-top: 50px;
            width: 80%;
        }
        h1{
            margin-left: 200px;
        }
        .checkbox{

            padding-left: 300px;
        }
        .checkbox input[type=checkbox]{
            border: solid;
            margin-left: 50px;
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
                <a class="navbar-brand" href="login.html">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class=""><a href="order.jsp">我的订单 <span class="sr-only">(current)</span></a></li>
                    <li class=""><a href="${pageContext.request.contextPath}/addAddressManage.jsp">地址管理</a></li>
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
    <form class="form-horizontal" action="${pageContext.request.contextPath}/addAddressServlet" method="post">
        <h1>新建收货地址</h1>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">收货人</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="contactName" placeholder="请填写收货人姓名">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">手机号码</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="inputPassword3" name="contactTelephone" placeholder="请填写收货人手机号码">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">所在地区</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" name="contactAddress" placeholder="请填写详细地址">
            </div>
        </div>
        <div class="checkbox">
            <label>  是否设置为默认地址</label>
            <input type="checkbox" name="defaultAddress" value="1">
        </div>
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">保存</button>
        </div>
    </form>
</section>
</body>
</html>

