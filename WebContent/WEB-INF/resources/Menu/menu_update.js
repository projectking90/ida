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
	
	alert($("[name=updateMenuForm]").serialize());
	
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/menu_update.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : $("[name=updateMenuForm]").serialize()
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(update_result){						
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
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}