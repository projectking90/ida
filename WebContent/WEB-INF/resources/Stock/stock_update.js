function stock_update(cr){
	
	if($("[name=quantity]").val()==""){
		alert("수량을 입력해주시기 바랍니다.");
		return;
	}

	var check_num = /^[0-9]*$/;
	var not_num = /^(0)[0-9]{1,}$/;
	
	if(check_num.test($("[name=quantity]").val())==false || not_num.test($("[name=quantity]").val())==true){
		alert("0 이상의 정수로만 입력해주시기 바랍니다.");
		return;
	}
	
	alert($("[name=update_stock_form]").serialize());
	
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/stock_update_proc.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : $("[name=update_stock_form]").serialize()
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(stock_update_cnt){						
			if(stock_update_cnt==1){
				alert("수정 성공하였습니다.");
				location.replace(cr + "/stock_form.ida");
			}else if(stock_update_cnt==-2){
				alert("이미 삭제된 재고입니다.");
				location.replace(cr + "/stock_form.ida");
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