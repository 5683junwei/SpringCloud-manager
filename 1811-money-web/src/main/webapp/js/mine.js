$(function () {
    $.ajax({
        async: true,
        cache: false,
        url: "/mymoney",
        data: {},
        type: "POST",
        dataType: "json",
        success: function (data) {
        	if(data=="index"){
        		window.location.href="/page/index"
        	}
        	if(data=="order"){
        		window.location.href="/page/order"
        	}
        	$("#img").prop("src",data[0].imgurl);
            for (var i = 0; i < data.length; i++){
                $("#title").after(" <tr rowspan=\"3\">\n" +
                    "                <td style=\"line-height: 50px\">"+data[i].categroyName+"</td>\n" +
                    "                <td style=\"line-height: 50px\">"+data[i].categroyNum+"%</td>\n" +
                    "                <td class=\"product_name"+i+"\"></td><td" +
                    " class=\"product_num"+i+"\"></td></tr>");
                for(var j = 0; j < data[i].productList.length; j++){
                    $(".product_name"+i).append("<table style=\"width: 250px\">\n" +
                        "                            <tr>\n" +
                        "                                <td>\n" +
                        "                                "+data[i].productList[j].productName+
                        "                                </td>\n" +
                        "                            </tr>\n" +
                        "                        </table>");
                    $(".product_num"+i).append("<table style=\"width: 150px\">\n" +
                        "                            <tr>\n" +
                        "                                <td>\n" +
                        "                                "+(data[i].productList[j].productNum/10)+
                        "                                %</td>\n" +
                        "                            </tr>\n" +
                        "                        </table>");
                }
            }
        },
        error:function(){
        	console.log("请求异常");
        }
    });
})