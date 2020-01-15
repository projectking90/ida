function insert_ing_reg(cr) {
	if(is_empty("[name=insertIngForm] [name=ia_name]")){
		alert("대분류명을 입력해주시기 바랍니다.");
		$("[name=ia_name]").focus();
		return;
	}
	if(is_empty("[name=insertIngForm] [name=ib_name]")){
		alert("소분류명을 입력해주시기 바랍니다.");
		$("[name=ib_name]").focus();
		return;
	}
	if(is_empty("[name=insertIngForm] [name=io_name]")){
		alert("원산지를 입력해주시기 바랍니다.");
		$("[name=io_name]").focus();
		return;
	}
	
	if(is_empty("[name=insertIngForm] [name=i_name]")){
		alert("식자재명을 입력해주시기 바랍니다.");
		$("[name=i_name]").focus();
		return;
	}
	if(is_empty("[name=insertIngForm] [name=i_size]")){
		alert("수량을 입력해주시기 바랍니다.");
		$("[name=i_size]").focus();
		return;
	}
	if(is_empty("[name=insertIngForm] [name=i_price]")){
		alert("소분류명을 입력해주시기 바랍니다.");
		$("[name=i_price]").focus();
		return;
	}
	if(is_empty("[name=insertIngForm] [name=a_name]")){
		alert("알레르기코드를 입력해주시기 바랍니다.");
		$("[name=a_name]").focus();
		return;
	}
	$.ajax({
		url : cr + "/ingredient_insert.ida"
		, type : "post"
		,data : $("[name=insertIngForm]").serialize()
		,success : function(insert_result){
			if(insert_result==1){
				alert("메뉴 등록 성공하였습니다.");
				location.replace(cr + '/ingredient_form.ida');
			}else{
				alert("메뉴 등록 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}

	});
}