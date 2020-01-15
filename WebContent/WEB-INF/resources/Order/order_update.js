function update_order_reg(cr) {
	var trArr = new Array();
	
	$(".order_list_tr").each(function(index){
		trArr[index] = new Array();
		trArr[index].push($(this).find("[name='oi_no']").val());
		trArr[index].push($(this).find("[name='c_phone']").val());
		trArr[index].push($(this).find("[name='mi_name']").val());
		trArr[index].push($(this).find("[name='quantity']").val());
		trArr[index].push($(this).find("[name='gender']").val());
		trArr[index].push($(this).find("[name='age']").val());
		trArr[index].push($(this).find("[name='pickup_time']").val());
		trArr[index].push($(this).find("[name='s_id']").val());
	});
	
	$.ajax({
		url : cr + "/order_update.ida"
		, type : "post"
		,data : "trArr=" + trArr
		,success : function(update_result){
			if(update_result>=0){
				alert("주문 수정 성공하였습니다.");
				location.replace(cr + '/order_form.ida');
			}else{
				alert("주문 수정 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}
	});
}