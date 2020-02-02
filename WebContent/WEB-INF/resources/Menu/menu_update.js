function update_menu_reg(cr) {
	var price = "[name=price]";

	$(price).val($.trim(withoutComma($(price).val())));

	if($("[name=price]").val()==""){
		alert("가격을 입력해주시기 바랍니다.");
		return;
	}

	var check_num = /^[0-9]*$/;
	var not_num = /^(0)[0-9]{1,}$/;

	if(check_num.test($("[name=price]").val())==false || not_num.test($("[name=price]").val())==true){
		alert("0 이상의 정수로만 입력해주시기 바랍니다.");
		return;
	}
	
	$.ajax({
		url : cr + "/menu_update.ida"
		, type : "post"
		, data : $("[name=updateMenuForm]").serialize()
		,success : function(update_result){					
			if(update_result==1){
				alert("수정 성공하였습니다.");
				location.replace(cr + "/menu_form.ida");
			}else if(update_result==-2){
				alert("이미 삭제된 메뉴입니다.");
				location.replace(cr + "/menu_form.ida");
			}
			else{
				alert("수정 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
			}
		}
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}

	});
}