function insert_order_reg(cr) {
	if(is_empty("[name=insertOrderForm] [name=c_phone]")){
		alert("핸드폰 번호를 입력해주시기 바랍니다.");
		$("[name=c_phone]").focus();
		return;
	}
	if(is_empty("[name=insertOrderForm] [name=mi_name]")){
		alert("메뉴를 선택해 주시기 바랍니다.");
		$("[name=mi_name]").focus();
		return;
	}
	if(is_empty("[name=insertOrderForm] [name=quantity]")){
		alert("수량을 입력해 주시기 바랍니다.");
		$("[name=quantity]").focus();
		return;
	}
	
	$.ajax({
		url : cr + "/order_insert.ida"
		, type : "post"
		,data : $("[name=insertOrderForm]").serialize()
		,success : function(insert_result){
			if(insert_result==1){
				alert("메뉴 등록 성공하였습니다.");
				location.replace(cr + '/order_form.ida');
			}else{
				alert("메뉴 등록 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}
	});
}