<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>money--商品搜索</title>
    <link rel="stylesheet" type="text/css" href="${app}/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${app}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${app}/css/index_product.css">
    <script src="${app}/js/jquery-3.2.1.min.js"></script>
    <script src="${app}/js/ajax_search.js"></script>
    <script src="${app}/js/gaoliang.js"></script>
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
    </script>
    <style>
        table tr th {
            font-weight: bold;
            font-size: 18px;
        }
    </style>
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

<div class="container" style="margin-top: 20px;">
    <table class="table text-center table-bordered table-striped">
        <tr>
            <th class="text-center">商品名称</th>
            <th class="text-center">商品单价</th>
            <th class="text-center">商品分类</th>
            <th class="text-center">商品数量</th>
            <th class="text-center">公司名称</th>
            <th class="text-center">商品详情</th>
        </tr>
        <c:forEach items="${pageBean.pageList}" var="p">
            <tr>
                <td>${p.productName}</td>
                <td>${p.productPrice}元</td>
                <td>
                    <c:if test="${p.productCategoryId==1}">
                        股票型
                    </c:if>
                    <c:if test="${p.productCategoryId==2}">
                        混合型
                    </c:if>
                    <c:if test="${p.productCategoryId==3}">
                        债券型
                    </c:if>
                    <c:if test="${p.productCategoryId==4}">
                        指数型
                    </c:if>
                    <c:if test="${p.productCategoryId==5}">
                        货币型
                    </c:if>
                    <c:if test="${p.productCategoryId==6}">
                        原油
                    </c:if>
                    <c:if test="${p.productCategoryId==7}">
                        黄金
                    </c:if>
                </td>
                <td>${p.productNum}</td>
                <td>
                    <c:if test="${p.productComId == 1}">
                        万家
                    </c:if>
                    <c:if test="${p.productComId == 2}">
                        国泰
                    </c:if>
                    <c:if test="${p.productComId == 3}">
                        南方
                    </c:if>
                    <c:if test="${p.productComId == 4}">
                        汇添富
                    </c:if>
                    <c:if test="${p.productComId == 5}">
                        易方达
                    </c:if>
                    <c:if test="${p.productComId == 6}">
                        天弘
                    </c:if>
                    <c:if test="${p.productComId == 7}">
                        嘉实
                    </c:if>
                    <c:if test="${p.productComId == 8}">
                        前海开源
                    </c:if>
                    <c:if test="${p.productComId == 9}">
                        平安
                    </c:if>
                    <c:if test="${p.productComId == 10}">
                        华泰
                    </c:if>
                    <c:if test="${p.productComId == 11}">
                        广发
                    </c:if>
                    <c:if test="${p.productComId == 12}">
                        华夏
                    </c:if>
                    <c:if test="${p.productComId == 13}">
                        国寿
                    </c:if>
                </td>
                <td>${p.productDescription}</td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="..." class="text-center">
        <ul class="pagination">
            <li style="cursor: pointer"><a
                    <c:if test="${page!=1}">
                        href="/es/queryProduct?page=${page-1}&type=${type}&query=${query}"
                    </c:if>
                    aria-label="Previous"><span aria-hidden="true">Previous
            </span></a></li>
            <c:forEach begin="1"
                       end="${pageBean.total%pageBean.pageSize==0?pageBean.total/pageBean.pageSize:(pageBean.total/pageBean.pageSize)+1}"
                       var="i">
                <li <c:if test="${page==i}">class="active"</c:if>><a
                        href="/es/queryProduct?page=${i}&type=${type}&query=${query}">${i}<span
                        class="sr-only">(current)</span></a></li>
            </c:forEach>
            <li style="cursor: pointer"><a
                    <c:if
                            test="${page<(pageBean.total%pageBean.pageSize==0?(pageBean.total/pageBean.pageSize):((pageBean.total/pageBean.pageSize)+1))&&page>0}">
                        href="/es/queryProduct?page=${page+1}&type=${type}&query=${query}"
                    </c:if>
                    aria-label="Previous"><span aria-hidden="true">Next
            </span></a></li>
        </ul>
    </nav>
</div>
</body>
</html>