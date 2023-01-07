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
    <style type="text/css">
        body{
            background: url(images/4.jpg);
            background-repeat: no-repeat;
            background-size: cover;
        }
        form{
            border: 1px solid white;
            background-color: whitesmoke;
            border-radius: 5px;
            opacity: 0.5;
            width: 500px;
            margin: auto;
            height: 300px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            position: relative;
            margin-top:150px;
        }
        form>div{
            margin-top: 30px;
            width: 90%;
        }
        input[type=text],input[type=password]{
            width:100%;
        }
        button[type=submit]{
            margin-left: 50px;
            width: 200px;
            opacity: 0.8;
        }
        button[type=button]{
            margin-left: 300px;
        }
    </style>
</head>
<body>
<section>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/findByConditionServlet">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="userName" placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3"name="password" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">登录</button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default">立即注册</button>
            </div>
        </div>
    </form>
</section>
</body>
</html>

