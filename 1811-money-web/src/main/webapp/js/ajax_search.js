$(function () {

});

function ajaxSearch() {
    var typeValue = $("#type").val();
    var queryValue = $("input[name=query]").val();
    console.log(queryValue);
    $.ajax({
        async: true,
        cache: false,
        url: "/es/getTip",
        data: {
            type: typeValue,
            query: queryValue
        },
        type: "POST",
        dataType: "json",
        success: function (data) {
            $(".tip li").remove();
            for (var i = 0; i < data.length; i++) {
                $(".tip").append("<li style='cursor: pointer;padding:" +
                    " 10px;'>"+data[i]+"</li>");
            }
            var otext = $("input[name=query]").val();
            $('.tip').GL({
                ocolor: 'red', //设置关键词高亮颜色
                oshuru: otext //设置要显示的关键词
            });
        }
    });
}