<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>money--持有基金</title>
    <link rel="stylesheet" type="text/css" href="${app}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${app}/css/bootstrap.min.css">
    <script src="${app}/js/jquery-3.2.1.min.js"></script>
    <script src="${app}/js/ajax_search.js"></script>
    <script src="${app}/js/gaoliang.js"></script>
    <script src="${app}/js/mine.js"></script>
    <script src="${app}/js/tongji.js"></script>
</head>
<body>
<input type="hidden" name="userId" value="${sessionScope.get("userId")}" />
<input type="hidden" name="num" value="${sessionScope.get("userId")}" />
<div id="gy_top_wper">
    <div class="gy_top px1000 clearfix">
        <div class="gy_top_l fl"><img src="${app}/images/service_pic.png" alt="">
            <span style="color:#999999;padding-left:10px;">在线客服:</span>
            <img style="padding-left:10px;" src="${app}/images/service_photo.png" alt="">
            <span style="color: #5DB9E9;padding-left:10px;">客服热线：400-660-8612</span>
        </div>
        <
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
            <form autocomplete="off" action="/es/queryProduct" method="get">
                <div class="" style="display: inline-block">
                    <select name="type" id="type" class="form-control" style="width: 120px;">
                        <option value="product" <c:if test="${type=='product'}">selected</c:if>>
                            商品名称
                        </option>
                        <option value="categroy"
                                <c:if test="${type=='categroy'}">selected</c:if>>商品分类
                        </option>
                        <option value="com"
                                <c:if test="${type=='com'}">selected</c:if> >公司名称
                        </option>
                    </select>
                </div>
                <div class="" style="display: inline-block">
                    <input type="text" id="hid" autocomplete="off" name="query" class="form-control"
                           value="${query}" onkeyup="ajaxSearch()"
                           placeholder="请输入您想查询的内容"/>
                </div>
                <div class="" style="display: inline-block">
                    <button type="submit" class="btn btn-default">点击搜索</button>
                </div>
            </form>
        </div>
    </div>
</div>
<ul id="tip" class="tip"
    style="width: 300px;z-index: 100;position: fixed;top:
    150px;left: 46%;background: white;font-size: 15px;color: grey">
</ul>

<div class="container" style="margin-top: 30px;">
    <table class="table table-bordered text-center table-hover" style="cursor: pointer">
        <tr id="title">
            <th rowspan="22" style="width: 350px;">
                <h3 style="margin-top: 160px" class="text-center">组合占比图</h3>
                <img id="img"
                    style="display: inline-block;width: 330px;height:
            250px;margin-top: 50px;"
                                  src=""
                                  alt="图片加载失败"></th>
            <th class="text-center" style="font-weight: bold">类型名称</th>
            <th class="text-center" style="font-weight: bold">类型占比</th>
            <th class="text-center" style="width: 150px;font-weight: bold">商品名称</th>
            <th class="text-center" style="width: 150px;font-weight: bold">商品占比</th>
        </tr>

    </table>
</div>
</body>
</html>