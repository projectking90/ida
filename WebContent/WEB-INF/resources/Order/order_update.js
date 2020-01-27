function update_order_reg(cr) {
	var trArr = new Array();
	
	$(".order_list_tr").each(function(index){
		var oi_no = "[name='oi_no']";
		var c_phone = "[name='c_phone']";
		var mi_name = "[name='mi_name']";
		var quantity = "[name='quantity']";
		
		trArr[index] = new Array();
		trArr[index].push($(this).find(oi_no).val());
		
		if(is_empty(c_phone)){
			alert("핸드폰 번호를 입력해주시기 바랍니다.");
			$(c_phone).focus();
			return;
		}
		
		if(!is_valid_pattern(c_phone, /^010[\d]{8}$/)){
			alert("핸드폰 양식이 아닙니다");
			$(c_phone).focus();
			
			return;
		}
		
		trArr[index].push($(this).find(c_phone).val());

		if(is_empty(mi_name)){
			alert("메뉴를 선택해 주시기 바랍니다.");
			
			return;
		}
		
		trArr[index].push($(this).find(mi_name).val());
		
		if(is_empty(quantity)){
			alert("수량을 입력해 주시기 바랍니다.");
			$(quantity).focus();
			
			return;
		}
		
		if(!is_valid_pattern(quantity, /^[1-9]{1}[\d]{0,2}$/)){
			alert("수량은 0 초과, 1000 미만의 정수로만 입력 가능합니다.");
			$(quantity).focus();
			
			return;
		}
		
		trArr[index].push($(this).find(quantity).val());
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