<%--
  Created by IntelliJ IDEA.
  User: 86241
  Date: 2019/1/6
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vercode.js"></script>
    <script src="${pageContext.request.contextPath}/css/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/user/login.js"></script>
    <script src="${pageContext.request.contextPath}/js/cookie.js"></script>
    <script src="${app}/js/tongji.js"></script>
</head>
<body>
<div class="layui-container" id="content">
    <h1 class="text-center">用 户 登 录</h1>
    <div class="login">
        <form method="post" id="login_form" class="layui-form text-center">
            <div class="form-content">
                <i class="layui-icon layui-icon-username form-font"></i>
                <input type="text" class="form-css" lay-verify="uname"
                       autocomplete="off" name="userName"
                       placeholder="请输入用户名">
            </div>
            <div class="form-content">
                <i class="layui-icon layui-icon-password form-font"></i>
                <input type="password" class="form-css" name="userPassword" autocomplete="off"
                       lay-verify="password"
                       placeholder="请输入密码">
            </div>
            <div class="form-content">
                <i class="layui-icon layui-icon-vercode form-font"></i>
                <input type="text" autocomplete="off" lay-verify="vercode" style="width:
                150px;"
                       class="form-css"
                       name="vercode"
                       placeholder="请输入验证码">|
                <b class="vercode-content">
                    <span id="vercode" onclick="generateVercode()"></span>
                </b>
            </div>
            <div style="margin-top: 10px;height: 30px" class="layui-form-item">
                <input type="checkbox" name="autologin" checked title="30天内自动登陆">
            </div>
            <div class="btn-content">
                <input type="submit" lay-submit lay-filter="login" class="btn"
                       value="登录">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a style="width: 130px;height: 50px;background: lightgray;padding: 15px;color:
                #0000FF;border-radius: 10px;box-shadow: gray 0px 1px 10px;border: 1px solid
                deepskyblue;"
                   id="regist"
                   class="btn"
                   href="${pageContext.request.contextPath}/page/user/regist.jsp">注册
                </a>
            </div>
            <br>
        </form>
    </div>
</div>
</body>
</html>
