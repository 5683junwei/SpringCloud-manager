$(function () {
    $.ajax({
        async: true,
        cache: false,
        url: "/order/list",
        data: {},
        type: "POST",
        dataType: "json",
        success: function (data) {
            for(var i = 0; i < data.length; i++){
            	var status = "已支付";
            	$("#img").prop("src",data[i].productImg);
            	if (data[i].payState==0){
                    status="未支付";
                    $("#submit").css({"display":"block"});
                }else{
                	$("#submit").css({"display":"none"});
                }
                $("#title").after("<tr><td>"+data[i].productName+"</td><td>"+data[i].productPrice+"</td><td>"+data[i].num+"</td><td>"+status+"</td><td>"+data[i].orderDate+"</td></tr>");
            }
        }
    });
})