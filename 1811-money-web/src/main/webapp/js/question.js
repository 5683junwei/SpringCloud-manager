var sum = 0;
var numFlag = false;
$(function() {
	var userId = $("input[name=userId]").val();
	console.log(userId);
	$("#submit").click(
			function() {
				checkSelect();
				if (numFlag == true) {
					calculation();
					if (sum != 0) {
						var userId = $("input[name=userId]").val();
						window.location.href = "/user_ajax/usernum?num=" + sum
								+ "&userId=" + userId;
					}
				}
			});

	function calculation() {
		var num = $(".que").length;
		for (var i = 0; i < num; i++) {
			var inpFlag = false;
			var score = 0;
			var inp = $("input[name=answer_" + (i + 1) + "]").length;
			for (var j = 0; j < inp; j++) {
				inpFlag = $("input[name=answer_" + (i + 1) + "]").eq(j).prop(
						"checked");
				if (inpFlag == true) {
					score += eval($("input[name=answer_" + (i + 1) + "]").eq(j)
							.attr("value"));
					console.log("score:" + score);
					break;
				}
			}
			sum += score;
		}
		console.log("您的测评结果为:" + sum);
	}
	// 问题未选择校验
	function checkSelect() {
		var num = $(".que").length;
		for (var i = 0; i < num; i++) {
			var inpFlag = false;
			var inp = $("input[name=answer_" + (i + 1) + "]").length;
			for (var j = 0; j < inp; j++) {
				inpFlag = $("input[name=answer_" + (i + 1) + "]").eq(j).prop(
						"checked");
				if (inpFlag == true) {
					numFlag = inpFlag;
					break;
				} else {
					numFlag = inpFlag;
				}
			}
			if (numFlag == false) {
				break;
			}
		}
		if (numFlag == false) {
			console.log("您还有没有选择完成的问题");
		} else {
			console.log("问题选择完成");
		}
	}
})
