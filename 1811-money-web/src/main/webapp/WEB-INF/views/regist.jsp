           <%--
  Created by IntelliJ IDEA.
  User: 86241
  Date: 2019/1/6
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/regist.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vercode.js"></script>
    <script src="${pageContext.request.contextPath}/css/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/js/user/regist.js"></script>
    <script src="${app}/js/tongji.js"></script>
</head>
<body>
<div id="parent" class="container">
    <h1 class="text-center">用 户 注 册</h1>
    <div id="regist" class="container">
        <form class="layui-form layui-form-pane" id="regist_form"  method="post">
            <br>
            <div class="layui-form-item">
                <label class="layui-form-label"><i style="font-size: 25px;color: #009688"
                                                   class="layui-icon layui-icon-username layui-form"></i></label>
                <div class="layui-input-block">
                    <input type="text" name="userName"
                           lay-verify="uname"
                           autocomplete="off"
                           placeholder="请输入用户名 最少两个字符"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label
                        class="layui-form-label"><i style="font-size: 25px;color: #009688"
                                                    class="layui-icon layui-icon-password layui-form"></i></label>
                <div class="layui-input-block">
                    <input type="password" name="userPassword" lay-verify="password"
                           onKeyUp="checkComplex(this.value)"
                           autocomplete="off"
                           placeholder="请输入密码 密码长度在6-12位"
                           class="layui-input">
                </div>
                <div id="pwd_complex" class="layui-input-block">
                    <table border="1">
                        <tr>
                            <td id="little"></td>
                            <td id="middle">无</td>
                            <td id="strong"></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="layui-form-item">
                <label
                        class="layui-form-label"><i style="font-size: 25px;color: #009688"
                                                    class="layui-icon layui-icon-auz layui-form"></i></label>
                <div class="layui-input-block">
                    <input type="password" lay-verify="relPassword" name="relPwd" autocomplete="off"
                           placeholder="请重新输入密码"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item" pane="">
                <label class="layui-form-label">
                    <i style="font-size: 25px;color: #009688"
                       class="layui-icon layui-icon-male layui-form"></i>
                    <i style="font-size: 25px;color: #009688"
                       class="layui-icon layui-icon-female layui-form"></i>
                </label>
                <div class="layui-input-block">
                    <input type="radio" name="userGender" value="先生" title="先生" checked="">
                    <input type="radio" name="userGender" value="女士" title="女士">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">
                    <i style="font-size: 25px;color: #009688"
                       class="layui-icon layui-icon-note layui-form"></i>
                </label>
                <div class="layui-input-inline">
                    <input type="text" name="userEmail" placeholder="邮箱" lay-verify="email"
                           autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <br/><br/>
            <div class="layui-form-item">
                <label class="layui-form-label">
                    <i style="font-size: 25px;color: #009688"
                       class="layui-icon layui-icon-vercode form-font"></i>
                </label>
                <div class="layui-input-block">
                    <input type="text" autocomplete="off" lay-verify="vercode"
                           class="layui-input"
                           name="vercode" style="width: 200px;display: inline-block"
                           placeholder="请输入验证码">&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
                    <b class="vercode-content">
                        <span id="vercode" style="cursor: pointer"
                              onclick="generateVercode()"></span>
                    </b>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo1">立即注册</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
