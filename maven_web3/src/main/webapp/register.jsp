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
            height: 450px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            position: relative;
            margin-top:150px;
            padding-left: 15px;
        }
        form>div{
            margin-top: 30px;
            width: 90%;
        }
        input[type=text],input[type=password]{
            width:100%;
        }
        button{
            margin-left: 50px;
            width: 200px;
        }
        .col-sm-10{

            height: 60px;
        }
    </style>
</head>
<body>
<section>
    <form class="form-horizontal"action="${pageContext.request.contextPath}/addUserServlet">
        <h1>欢迎注册</h1>
        <h5>已有帐号？<a href="">登录</a></h5>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" @blur="checkName"v-model="name" class="form-control" id="inputEmail3"name="userName" placeholder="用户名">
                <span v-show="icon" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span>{{tip}}</span>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password"@blur="checkPassWord"v-model="passWord" class="form-control"name="password" id="inputPassword3" placeholder="密码">
                <span v-show="iconPassWord" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span>{{tipPassWord}}</span>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button v-bind:type="button" class="btn btn-primary">注册</button>
            </div>
        </div>
    </form>
</section>
<script type="text/javascript">
    var app=new Vue({
        el:".form-horizontal",
        data:{
            "name":"",
            "tip":"",
            "icon":false,
            "passWord":"",
            "tipPassWord":"",
            "iconPassWord":false,
            "button":"button"
        },
        methods:{
            checkName:function(){
                var reg=/^[\u4E00-\u9fa5a-zA-Z0-9_-]{3,15}$/;
                if(reg.test(this.name)){
                    this.tip="";
                    this.icon=true;
                    // 改变注册按钮的属性，必须全符合才允许提交
                    if(this.icon=="false"&&this.iconPassWord=="false"){
                        this.button="submit";

                    }
                }else{
                    this.tip="请输入3-15位字符,（中英文数字_-）都可以";
                    this.icon=false;
                }

            },
            checkPassWord:function(){
                var reg=/^[a-zA-Z0-9_@.]{3,15}$/;
                if(reg.test(this.passWord)){
                    this.tipPassWord="";
                    this.iconPassWord=true;

                    // 改变注册按钮的属性，必须全符合才允许提交
                    if(this.icon&&this.iconPassWord){
                        this.button="submit";

                    }
                }else{
                    this.tipPassWord="请输入3-15位字符,（英文数字_-@.）都可以";
                    this.iconPassWord=false;
                }

            },
        }
    })
</script>
</body>
</html>

