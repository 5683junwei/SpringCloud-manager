<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>money--购物车</title>
<link rel="stylesheet" type="text/css" href="${app}/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${app}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${app}/css/cart.css" />
<script src="${app}/js/jquery-3.2.1.min.js"></script>
<script src="${app}/js/ajax_search.js"></script>
<script src="${app}/js/gaoliang.js"></script>
<script src="${app}/js/tongji.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#logout_a").click(function () {
                delCookie("autoLogin");
            })
            var otext = $("input[name=query]").val();
            $('table').GL({
                ocolor: 'red', //设置关键词高亮颜色
                oshuru: otext //设置要显示的关键词
            });
        })
        	function sub(){
	        	$("form").submit();
            }
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
                    <input type="text"  autocomplete="off" class="form-control"
                           value="${query}" name="query" onkeyup="ajaxSearch()"
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

	<div id="cart" class="container">
		<c:forEach items="${cartList}" var="cart">
			<div class="container" id="product">
				<div class="img">
					<img src="${cart.productImage}" alt="图片加载失败">
				</div>
				<h5 class="text-center">${cart.productName }</h5>
				<ul>
					<li id="num" class="text-center">数量：${cart.num}</li>
					<li id="price" class="text-center">价格：${cart.productPrice }元</li>
				</ul>
				<a href="/cart/deleteCart" class="btn btn-drange" style="display:block">删除</a>
				<form action="/order/save" method="post">
					<input type="hidden" name="productId" value="${cart.productId }" />
					<input type="hidden" name="productImage" value="${cart.productImage}" />
					<input type="hidden" name="productName" value="${cart.productName }" />
					<input type="hidden" name="num" value="${cart.num}" />
					<input type="hidden" name="productPrice" value="${cart.productPrice}" />
					<button type="button" onclick="sub()" class="btn btn-success btn-block">去结算</button>
					<!-- <input type="submit" value="去结算" calss="btn btn-success btn-block" /> -->
				</form>
			</div>
		</c:forEach>
	</div>
	<%@include file="foot.jsp"%>
</body>
</html>