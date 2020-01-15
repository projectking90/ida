function insert_menu_reg(cr) {
	if(is_empty("[name=insertMenuForm] [name=mi_name]")){
		alert("메뉴명을 입력해주시기 바랍니다.");
		$("[name=m_name]").focus();
		return;
	}
	if(is_empty("[name=insertMenuForm] [name=price]")){
		alert("가격을 입력해주시기 바랍니다.");
		$("[name=price]").focus();
		return;
	}
	
	$("[name=insertMenuForm] [name='i_price']").val(withoutComma($("[name=insertMenuForm] [name='i_price']").val()));	
	
	$.ajax({
		url : cr + "/menu_insert.ida"
		, type : "post"
		,data : $("[name=insertMenuForm]").serialize()
		,success : function(insert_result){
			if(insert_result==1){
				alert("메뉴 등록 성공하였습니다.");
				location.replace(cr + '/menu_form.ida');
			}else{
				alert("메뉴 등록 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}

	});
}