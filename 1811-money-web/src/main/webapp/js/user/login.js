var flag = false;
//login js文件
$(function () {
    //30天自动登录
    var alogin_info = getCookie("autoLogin");
    //alert("alogin_info="+alogin_info);
    if (alogin_info != "") {
        var infos = alogin_info.split(":");
        //alert(infos[0]+"    "+infos[1]);
        $("form input[name=userName]").val(infos[0]);
        $("form input[name=userPassword]").val(infos[1]);
        $("form input[name=vercode]").val(generateVercode());
        flag=true;
        return login();
    }
    //给form表单添加submit事件
    $("form").submit(function () {
        return login();
    });
});

function login() {
    //获取页面数据
    var userName = $("form input[name=userName]").val();
    var userPassword = $("form input[name=userPassword]").val();
    var autologin = $("form input[name=autologin]").get(0).checked;
    //发送异步请求
    if (flag) {
        $.ajax({
            url: "/user_ajax/login",
            type: "post",
            data: {"userName": userName, "userPassword": userPassword},
            dataType: "json",
            success: function (result) {
                //result是服务端返回的数据
                if (result.status == 1) {
                	console.log("登录成功");
                    //window.location.href="index.html";
                    window.location.href = "/page/index";
                    if (autologin) {
                        if (getCookie("autoLogin") == "") {
                            var value = userName + ":" + userPassword;
                            setCookie("autoLogin", value);
                        }
                    } else {
                        delCookie("autoLogin");
                    }
                } else if (result.status == 0) {
                	console.log("登录失败！");
                    alert(result.msg);
                }
            },
            error: function () {
                alert("请求失败!");
            }
        });
    }
    return false;
}

layui.use('form', function () {
    var form = layui.form;
    //自定义验证规则
    form.verify({
        uname: function (value) {
            if (value.length == 0) {
                return "用户名不能为空！";
            } else if (value.length < 2) {
                return '用户名至少得2个字符啊！';
            } else {
                flag = true;
            }
        }
        , password: function (value) {
            if (value.length == 0) {
                return "密码不能为空！"
            } else if (value.length < 6) {
                return "密码太短了！不安全哟！6位比较适中！";
            } else if (value.length > 12) {
                return "密码那么长！记不住啊！12位就行啦！";
            } else {
                flag = true;
            }
        },
        vercode: function (value) {
            if (value.length == 0) {
                return "验证码不能为空！";
            } else if (!(value.toUpperCase() == code.toUpperCase())) {
                generateVercode();
                return "验证码不正确！";
            } else {
                flag = true;
            }
        }
    });
    //监听提交
    form.on('submit(login)', function (data) {
    });
});

