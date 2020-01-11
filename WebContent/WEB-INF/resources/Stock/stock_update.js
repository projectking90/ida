function stock_update(cr){
	var trArr = new Array();
	
	$(".stock_list_tr").each(function(index){
		trArr[index] = new Array();
		trArr[index].push($(this).find("[name='st_no']").val());
		trArr[index].push($(this).find("[name='quantity']").val());
		trArr[index].push($(this).find("[name='st_state']").val());
	});

	//alert(trArr);
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/stock_update_proc.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "trArr=" + trArr
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(stock_update_cnt){						
			if(stock_update_cnt>=0){
				alert("수정 성공하였습니다.");
				location.replace(cr + "/stock_form.ida");
			}else{
				alert("수정 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}