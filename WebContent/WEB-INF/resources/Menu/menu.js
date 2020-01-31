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

function menu_delete_reg(cr) {
	var trArr = new Array();
	$(".menu_list_tr").each(function(index){
		if($(this).find("[name='delete_menu']").prop("checked")==true){
			trArr.push($(this).find("[name='delete_menu']").val());
			if(trArr[index]==""){
				trArr[index].splice(index, 1);
			}
			//alert($(this).find("[name='delete_menu']").val());
		}
	});

	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/menu_delete.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "trArr=" + trArr
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(delete_result){						
			if(delete_result>=1){
				alert("삭제 성공하였습니다.");
				location.replace(cr + "/menu_form.ida");
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

/**
 * DataTable Setting
 */
function setDataTable(table_id){
	var dt = $(table_id).DataTable({
		"columnDefs" : [
			{"searchable" : false, "orderable" : false, "targets" : 0}
		]
		,"order": [[6, "asc"]]
	});
	
	dt.on( 'order.dt search.dt', function () {
		dt.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			cell.innerHTML = i+1;
		} );
	} ).draw();
}