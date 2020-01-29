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
		alert("가격을 입력해주시기 바랍니다.");
		$("[name=i_price]").focus();
		return;
	}
	
	$("[name=insertIngForm] [name='i_price']").val(withoutComma($("[name=insertIngForm] [name='i_price']").val()));
	
	$.ajax({
		url : cr + "/ingredient_insert.ida"
		, type : "post"
		,data : $("[name=insertIngForm]").serialize()
		,success : function(ingredient_reg_cnt){
			if(ingredient_reg_cnt==1){
				alert("식자재 등록 성공하였습니다.");
				location.replace(cr + '/ingredient_form.ida');
			}else {
				alert("식자재가 등록되지 않았습니다. 관리자에게 문의하시기 바랍니다.");
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}

	});
}


function ing_delete_reg(cr) {
	var trArr = new Array();
	$(".ingredient_list_tr").each(function(index){
		if($(this).find("[name='delete_ingredient']").prop("checked")==true){
			trArr.push($(this).find("[name='delete_ingredient']").val());
			if(trArr[index]==""){
				trArr[index].splice(index, 1);
			}
		}
	});
	
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/ingredient_delete.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "trArr=" + trArr
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(delete_result){
			alert("test");
			if(delete_result>=1){
				alert("삭제 성공하였습니다.");
				location.replace(cr + "/ingredient_form.ida");
			}else{
				alert("삭제 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(xhr,errorThrown){
			alert(xhr);
			alert(errorThrown);
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}