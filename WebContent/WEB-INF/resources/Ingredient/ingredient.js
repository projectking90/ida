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
	
	if(!is_valid_pattern(i_price, /^[1-9]{1}[\d]{0,7}$/)){
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
			if(delete_result>=1){
				alert("삭제 성공하였습니다.");
				location.replace(cr + "/ingredient_form.ida");
			}else{
				alert("삭제 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function update_store_reg(cr){
	var form = "[name=ingredient_detail_form]";
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
	
	if(!is_valid_pattern(i_price, /^[1-9]{1}[\d]{0,7}$/)){
		alert("가격은 100,000,000 미만의 정수로만 입력 가능합니다.");
		$(i_price).focus();
		
		return;
	}
	
	$(i_price).val(withoutComma($(i_price).val()));
	
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/ingredient_update_proc.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : $(form).serialize()
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(ingredient_update_cnt){
			if(ingredient_update_cnt>=0){
				alert("수정 성공하였습니다.");
				location.replace(cr + "/ingredient_form.ida");
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

/**
 * DataTable Setting
 */
function setDataTable(table_id){
	var dt = $(table_id).DataTable({
		"columnDefs" : [
			{"searchable" : false, "orderable" : false, "targets" : 0}
		]
		,"order": [[7, "asc"]]
	});
	
	dt.on( 'order.dt search.dt', function () {
		dt.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			cell.innerHTML = i+1;
		} );
	} ).draw();
}