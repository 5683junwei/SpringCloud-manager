<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>风险测评</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/Font-Awesome/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/build.css">
    <script src="${pageContext.request.contextPath}/js/question.js"></script>
    <script src="${app}/js/tongji.js"></script>
</head>
<body>
<input type="hidden" name="userId" value="${sessionScope.get("userId")}" />
<div class="container">
    <h2 class="text-center">用户风险测评</h2>
    <hr/>
    <div class="container" id="question">
        <form action="" method="post">
            <div class="que">
                <h3>1.您是否有如下需求？（可多选）</h3>
                <div class="form-group">
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_1" value="2" id="o1" class="styled">
                        <label for="o1">买房买车</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_1" value="2" id="o2" class="styled">
                        <label for="o2">子女教育</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_1" value="2" id="o3" class="styled">
                        <label for="o3">养老储备</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_1" value="1" id="o4" class="styled">
                        <label for="o4">偿还贷款</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_1" value="1" id="o5" class="styled">
                        <label for="o5">其他</label>
                    </div>
                </div>
            </div>
            <hr/>
            <div class="que">
                <h3>2.您目前投资哪些产品？（可多选）</h3>
                <div class="form-group">
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_2" value="3" id="t1" class="styled">
                        <label for="t1">股票</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_2" value="2" id="t2" class="styled">
                        <label for="t2">浮动收益类理财产品（公募基金、私募基金、银行理财等）</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_2" value="3" id="t3" class="styled">
                        <label for="t3">互联网理财产品（P2P）</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_2" id="t4" value="1" class="styled">
                        <label for="t4">固定收益理财产品（银行理财、信托、储蓄型保险等）</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_2" id="t5" value="0" class="styled">
                        <label for="t5">现金类理财产品（一行存款、国债、余额宝等）</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>3.您过去三年投资的整体收益如何？</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_3" value="3" id="h1">
                        <label for="h1">亏损，大于30%</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_3" value="2" id="h2">
                        <label for="h2">亏损，小于30%</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_3" value="2" id="h3">
                        <label for="h3">盈利，小于10%</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_3" value="3" id="h4">
                        <label for="h4">盈利，介于10%~30%之间</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_3" value="4" id="h5">
                        <label for="h5">盈利，30%以上</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>4.购买基金后，您通常会采取什么态度？</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_4" value="3" id="f1">
                        <label for="f1">一般不查看账户盈亏，注重长期收益</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_4" value="2" id="f2">
                        <label for="f2">偶尔看一下账户盈亏，觉得差不多了就赎回</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_4" value="0" id="f3">
                        <label for="f3">很紧张账户盈亏，每天要查看收益情况</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_4" value="1" id="f4">
                        <label for="f4">频繁的申购、赎回，以短期套利</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>5.进行一项重大投资后，您通常会觉得</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_5" value="1" id="i1">
                        <label for="i1">很高兴，对自己决定很有信息</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_5" value="2" id="i2">
                        <label for="i2">轻松，持乐观态度</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_5" value="3" id="i3">
                        <label for="i3">基本没有什么影响</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_5" value="1" id="i4">
                        <label for="i4">比较担心投资结果</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_5" value="0" id="i5">
                        <label for="i5">非常担心投资结果</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>6.假设您持有的两个产品，产品A盈利10%，产品B亏损10%，您目前急需用钱需要出卖茶品筹集资金，您会如何选择？</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_6" value="2" id="s1">
                        <label for="s1">全部卖出产品A</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_6" value="1" id="s2">
                        <label for="s2">全部卖出产品B</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_6" value="3" id="s3">
                        <label for="s3">A、B两种产品各卖出一半</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>7.假设您面临一项可能有损失的投资，一下哪种情况是您能接受的？</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_7" value="1" id="e1">
                        <label for="e1">肯定损失2%</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_7" value="2" id="e2">
                        <label for="e2">20%的可能损失5%，80%的可能不损失</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_7" value="3" id="e3">
                        <label for="e3">50%的可能损失10%，50%的可能盈利5%</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_7" value="4" id="e4">
                        <label for="e4">80%可能损失20%，20%的可能盈利50%</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>8.假设您有100万元，现在有一个投资项目，80%的可能性盈利200%，20%的可能性血本无归，您会投资多少？</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_8" value="1" id="g1">
                        <label for="g1">0-10万元</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_8" value="2" id="g2">
                        <label for="g2">10-3-万元</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_8" value="3" id="g3">
                        <label for="g3">30-50万元</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_8" value="4" id="g4">
                        <label for="g4">50-80万元</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_8" value="4" id="g5">
                        <label for="g5">100万元</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>9.对下列可能发生的风险，您最担心什么？</h3>
                <div class="form-group">
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_9" value="3" id="n1">
                        <label for="n1">疾病>失业>投资巨亏</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_9" value="3" id="n2">
                        <label for="n2">疾病>投资巨亏>失业</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_9" value="1" id="n3">
                        <label for="n3">投资巨亏>失业>疾病</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_9" value="1" id="n4">
                        <label for="n4">投资巨亏>疾病>失业</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_9" value="2" id="n5">
                        <label for="n5">失业>投资巨亏>疾病</label>
                    </div>
                    <div class="radio radio-primary">
                        <input type="radio" name="answer_9" value="2" id="n6">
                        <label for="n6">失业>疾病>投资巨亏</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="que">
                <h3>10.您赎回基金主要因为？（可多选）</h3>
                <div class="form-group">
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_10" value="2" id="z1" class="styled">
                        <label for="z1">自己需要现金</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_10" value="1" id="z2" class="styled">
                        <label for="z2">股市表现不好或者有下跌的可能</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_10" value="2" id="z3" class="styled">
                        <label for="z3">基金经理发生变动</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_10" value="2" id="z4" class="styled">
                        <label for="z4">基金业绩与同类基金相比很差</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_10" value="4" id="z5" class="styled">
                        <label for="z5">基金业绩已达到预期目标</label>
                    </div>
                    <div class="checkbox checkbox-primary">
                        <input type="checkbox" name="answer_10" value="2" id="z6" class="styled">
                        <label for="z6">朋友或者专家建议</label>
                    </div>
                </div>
            </div>
            <hr/>

            <div class="form-group">
                <button type="button" id="submit" class="btn btn-block btn-success">确认提交</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
