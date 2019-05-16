<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>monye--首页</title>
    <link rel="stylesheet" type="text/css" href="${app}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${app}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${app}/css/index_product.css">
    <script src="${app}/js/jquery-3.2.1.min.js"></script>
    <script src="${app}/js/ajax_search.js"></script>
    <script src="${app}/js/gaoliang.js"></script>
    <script src="${app}/js/tongji.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#logout_a").click(function () {
                delCookie("autoLogin");
            })
        })
    </script>
</head>
<body>
<div id="gy_top_wper">
    <div class="gy_top px1000 clearfix">
        <div class="gy_top_l fl"><img src="${app}/images/service_pic.png" alt="">
            <span style="color:#999999;padding-left:10px;">在线客服:</span>
            <img style="padding-left:10px;" src="${app}/images/service_photo.png" alt="">
            <span style="color: #5DB9E9;padding-left:10px;">客服热线：400-660-8612</span>
        </div>
        <div class="gy_top_r fr clearfix">
            <c:if test="${empty sessionScope.userName}" var="eptun" scope="page">
                <a href="${app }/page/login">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                href="${app}/page/regist">注册</a>
            </c:if>
            <c:if test="${!eptun}">
                欢迎${sessionScope.userName}&nbsp;&nbsp;<a id="logout_a" href="${app}/user_ajax/logout">注销</a>
            </c:if>
            <a href="">新手指导</a><span>|</span>
            <a href="">帮助</a>
        </div>
    </div>
</div>
<!-- end top -->

<div id="gy_nav_wper">
    <div class="gy_nav px1000 clearfix">
       <div class="gy_nav_l fl"><a href="/page/index"><img src="${app}/images/gy_logo.png" alt="" ></a></div>
        <ul class="gy_nav_c fr clearfix">
            <li class="gy_nav_c_ts" style="z-index:1000;">
                <a href="/page/product_list"> 我要投资</a>
            </li>
            <li><a href="/cart/mycart">我的购物车</a></li>
            <li><a href="/page/order">我的订单</a></li>
            <li><a href="/page/mine">持有基金</a></li>
            <li><a href="">业务模式</a></li>
            <li><a href="">产品特色</a></li>
        </ul>
        <div class="search" style="margin-left: 300px;">
            <form action="/es/queryProduct" method="get">
                <div class="" style="display: inline-block">
                    <select name="type" id="type" class="form-control" style="width: 120px;">
                        <option value="product">商品名称</option>
                        <option value="categroy">商品分类</option>
                        <option value="com">公司名称</option>
                    </select>
                </div>
                <div class="" style="display: inline-block">
                    <input type="text" class="form-control"
                           onkeyup="ajaxSearch()" name="query"
                           placeholder="请输入您想查询的内容">
                </div>
                <div class="" style="display: inline-block">
                    <button type="submit" class="btn btn-default">点击搜索</button>
                </div>
            </form>
        </div>
    </div>
</div>
<ul class="tip"
    style="width: 300px;z-index: 100;position: fixed;top:
    150px;left: 46%;background: white;font-size: 15px;color: grey">
</ul>
<div class="flexslider"
     style="background: url(../../images/index_banner.jpg) 50% 0 no-repeat;height: 600px">
</div>

<div id="gy_bargain_sum">
    <div class="px1000 gy_bargain_sum_main">
        <div class="gy_bargain_sum_main_mover">
            <span class="gybargain_summain_dv">成交总金额<span
                    class="gy_bargain_sum_sz"><b>4,210,214,02</b></span>万元</span>
            <span class="gy_bargain_sum_jg">|</span>
            <span class="gybargain_summain_dv">成交总金额<span
                    class="gy_bargain_sum_sz"><b>4,210,214,02</b></span>万元</span>
            <span class="gy_bargain_sum_jg">|</span>
            <span class="gybargain_summain_dv">累计投资<span
                    class="gy_bargain_sum_sz"><b>12491</b></span>万元</span>
            <span class="gy_bargain_sum_jg">|</span>
            <span class="gybargain_summain_dv">累计为投资人赚取<span
                    class="gy_bargain_sum_sz"><b>12491.00</b></span>万元</span>
        </div>
    </div>
</div>
<div class="container" id="product">
    <div class="content">
        <p>智能投资组合</p>
        <p>全球资产组合配置</p>
        <p>4%~16.41%</p>
        <p>
            <del>上证指数近3年收益负25.27%</del>
        </p>
        <p>预期年化收益率</p>
        <ul>
            <li>风险分散</li>
            <li>量身定制</li>
            <li>指导调仓</li>
            <li>1000元起购</li>
        </ul>
        <div id="btn">
            <span><a href="/page/product_list">查看购买</a></span>
            <span>></span>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 100px">
    <p class="text-center" style="font-size: 28px;font-weight: bold">我们的投资组合优于单支基金</p>
    <div style="width: 720px;margin: 20px auto">
        <img src="${app}/images/img1.png" alt="">
    </div>
    <p class="text-center" style="font-size: 22px;margin-top: 15px;">金牛智投的投资组合以现代投资组合理论MPT为理论基础</p>
    <p class="text-center" style="font-size: 22px;margin-top: 15px;">旨在匹配每个用户的风险承受能力</p>
    <p class="text-center" style="font-size: 22px;margin-top: 15px;">并在该风险水平上获得最高投资收益</p>
</div>

<div class="container" style="margin-top: 100px">
    <p class="text-center" style="font-size: 28px;font-weight: bold">360度基金评价筛选</p>
    <div style="width: 268px;margin: 20px auto">
        <img src="${app}/images/img2.jpg" alt="">
    </div>
    <p class="text-center" style="font-size: 22px;margin-top: 15px;">Jensen、Sortino、Sharpe等多测度挖掘业绩稳定基金</p>
    <p class="text-center" style="font-size: 22px;margin-top: 15px;">监测识别每个基金的投资风格和市场适应环境</p>
    <p class="text-center" style="font-size: 22px;margin-top: 15px;">根据市场现状选择稳定适合的基金进行投资</p>
</div>
<div class="container" style="margin-top: 100px;width: 780px;">
    <p class="text-center" style="font-size: 28px;font-weight: bold">为什么选择金牛智投</p>
    <div style="float: left;font-size: 18px;margin-top: 50px;" class="text-center">
        <p>总是买完就跌，卖完就涨？</p>
        <p>面对大量基金缺少选择方法？</p>
        <p>让金牛智投来协助您吧</p>
    </div>
    <div style="float: right;margin-top: 20px">
        <img src="${app}/images/img3.png" alt="">
    </div>
</div>
<!--1-->
<div class="container">
    <p class="text-center" style="font-size: 28px;font-weight: bold;margin-top: 80px;">我们帮您在3,
        000多只基金中定制投资策略</p>
    <div style="width: 1000px;margin: 0 auto;margin-top: 20px;margin-bottom: 20px">
        <img src="${app}/images/foot_bg.jpg" alt="">
    </div>
</div>
<%@include file="foot.jsp" %>
</body>
</html>
