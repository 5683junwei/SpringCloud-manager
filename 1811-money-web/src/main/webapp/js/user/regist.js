var flag = false;
/*注册页面js*/
$(function () {
    $("form").submit(function () {
        return register();
    });
});
function register() {
    var userName = $("form input[name=userName]").val();
    var userPassword = $("form input[name=userPassword]").val();
    var userGender = $("form input[name=userGender]").val();
    var userEmail = $("form input[name=userEmail]").val();
    //var vcode=$("form input[name=valistr]").val();
    if (flag) {
        console.log(flag);
        $.ajax({
            url: "/user_ajax/regist",
            type: "post",
            data: {
                //按照pojo的属性名称修改参数
                "userName": userName,
                "userPassword": userPassword,
                "userGender": userGender,
                "userEmail": userEmail
            },
            dataType: "json",
            success: function (result) {
                if (result.status == 1) {
                    window.location.href = "/page/index";
                } else if (result.status == 0) {
                    alert(result.msg);
                }
            },
            error: function () {
                alert("请求失败！");
            }
        });
    }

    return false;
}
layui.use(['form', 'laydate'], function () {
    var form = layui.form, laydate = layui.laydate;
    laydate.render({
        elem: '#date1'
    });
    $("input[name=userName]").blur(function () {
        checkUserName();
    })
    function checkUserName(){
        layui.use('layer', function(){
            var layer = layui.layer;
            var resutl = checkUname($("input[name=userName]").val());
            if (resutl==true){
                layer.msg("当前用户名已被使用");
            }
        });
    }
    form.render();
    //自定义验证规则
    form.verify({
        uname: function (value) {
            if (value.length == 0) {
                return "用户名不能为空！";
            } else if (value.length < 2) {
                return '用户名至少得2个字符啊！';
            }else if (checkUname(value)){
                return "当前用户名已被使用！";
            }else {
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
            }else {
                flag = true;
            }
            if (checkComplex(value) <= 1) {
                return "密码等级太低啦！";
            }else {
                flag = true;
            }
        },
        relPassword: function (value) {
            var pwd = $("[name=userPassword]").val();
            if (value.length == 0) {
                return "确认密码不能为空呦！";
            } else if (value != pwd) {
                return "第二次密码好像有点儿问题呀！";
            }else {
                flag =true;
            }
        },
        vercode: function (value) {
            if (value.length == 0) {
                return "验证码不能为空！";
            } else if (!(value.toUpperCase() == code.toUpperCase())) {
                generateVercode();
                return "验证码不正确！";
            }else {
                flag = true;
            }
        }
    });
    //监听提交
    form.on('submit(login)', function (data) {
        return false;
    });
});

function checkComplex(pwd) {
    var m = 0;
    var little = $("#little");
    var middle = $("#middle");
    var strong = $("#strong");
    //匹配数字
    if (/\d+/.test(pwd)) {
        m++;
    }
    //匹配字母
    if (/[A-Za-z]+/.test(pwd)) {
        m++;
    }
    //匹配除数字字母外的特殊符号
    if (/[^0-9a-zA-Z]+/.test(pwd)) {
        m++;
    }
    switch (m) {
        case 0:
            middle.text("无");
            $("#little,#middle,#strong").css({"background": "gainsboro"});
            break;
        case 1:
            middle.text("弱");
            little.css({"background": "red"});
            $("#middle,#strong").css({"background": "gainsboro"});
            break;
        case 2:
            middle.text("中");
            $("#little,#middle").css({"background": "orange"});
            strong.css({"background": "gainsboro"});
            break;
        case 3:
            middle.text("强");
            $("#little,#middle,#strong").css({"background": "green"});
            break;
    }
    return m;
}

function checkUname(value) {
    var result = null;
    $.ajax({
        async: false,
        cache: false,
        url: "/user/checkUserName",
        data: {
            userName : value
        },
        type: "POST",
        dataType: "json",
        success: function (res) {
            result = res;
        }
    });
    return result;
}
