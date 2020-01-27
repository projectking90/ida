function insert_ing_reg(cr) {
	var form = "[name=insertIngForm]";
	var ia_name = form + " [name=ia_name]";
	var ib_name = form + " [name=ib_name]";
	var io_name = form + " [name=io_name]";
	var i_name = form + " [name=i_name]";
	var i_size = form + " [name=i_size]";
	var i_price = form + " [name=i_price]";

	if(is_empty(ia_name)){
		alert("대분류명을 선택해주시기 바랍니다.");
		
		return;
	}
	if(is_empty(ib_name)){
		alert("소분류명을 선택해주시기 바랍니다.");

		return;
	}
	
	if(is_empty(io_name)){
		alert("원산지를 선택해주시기 바랍니다.");

		return;
	}
	
	if(is_empty(i_name)){
		alert("식자재명을 입력해주시기 바랍니다.");
		$(i_name).focus();
		
		return;
	}
	
	if(is_empty(i_size)){
		alert("규격을 입력해주시기 바랍니다.");
		$(i_size).focus();
		
		return;
	}
	
	if(is_empty(i_price)){
		alert("가격을 입력해주시기 바랍니다.");
		$(i_price).focus();
		
		return;
	}
	
	if(!is_valid_pattern(i_price, /^[\d]{1, 8}$/)){
		alert("가격은 100,000,000 미만의 정수로만 입력 가능합니다.");
		$(i_price).focus();
		
		return;
	}
	
	$(i_price).val(withoutComma($(i_price).val()));
	
	$.ajax({
		url : cr + "/ingredient_insert.ida"
		, type : "post"
		,data : $(form).serialize()
		,success : function(insert_result){
			if(insert_result==1){
				alert("식자재 등록 성공하였습니다.");
				location.replace(cr + '/ingredient_form.ida');
			}else{
				alert("식자재 등록 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}
	});
}