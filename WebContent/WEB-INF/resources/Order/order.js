function insert_order_reg(cr) {
	var form = "[name=insertOrderForm]";
	var c_phone = form + " [name=c_phone]";
	var mi_name = form + " [name=mi_name]";
	var quantity = form + " [name=quantity]";
	
	if(is_empty(c_phone)){
		alert("핸드폰 번호를 입력해주시기 바랍니다.");
		$(c_phone).focus();
		
		return;
	}
	
	if(!is_valid_pattern(c_phone, /^010[\d]{8}$/)){
		alert("핸드폰 양식이 아닙니다");
		$(c_phone).focus();
		
		return;
	}
	
	if(is_empty(mi_name)){
		alert("메뉴를 선택해 주시기 바랍니다.");
		
		return;
	}
	
	if(is_empty(quantity)){
		alert("수량을 입력해 주시기 바랍니다.");
		$(quantity).focus();
		
		return;
	}
	
	if(!is_valid_pattern(quantity, /^[1-9]{1}[\d]{0,2}$/)){
		alert("수량은 0 초과, 1000 미만의 정수로만 입력 가능합니다.");
		$(quantity).focus();
		
		return;
	}

	var minameArr = new Array();
	
	$("[name^=mi_name]").each(function(index){
		/* minameArr[index] = new Array(); */
		minameArr.push($(this).val());
	});

	var quantityArr = new Array();
	
	$("[name^=quantity]").each(function(index){
		/* minameArr[index] = new Array(); */
		quantityArr.push($(this).val());
	});
	
	$.ajax({
		url : cr + "/order_insert.ida"
		, type : "post"
		,data : $(form).serialize()+"&minameArr="+minameArr+"&quantityArr="+quantityArr
		,success : function(insert_result){
			if(insert_result==1){
				alert("주문 등록 성공하였습니다.");
				location.replace(cr + '/order_form.ida');
			}else if(insert_result==-1){
				alert("주문메뉴의 재고수량이 부족합니다.")
			}else{
				alert("주문 등록 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}
	});
}

function remove_menu_tr_btn(){
	var tableObj = $("#insertMenuTable");
	var tableTrsObj = tableObj.find("tr");
	
	var lastTrObj = tableObj.find("tr").last();

	if(tableTrsObj.length>3){
		lastTrObj.remove();
	}
}

function order_delete_reg(cr) {
	var trArr = new Array();
	$(".order_list_tr").each(function(index){
		if($(this).find("[name='delete_order']").prop("checked")==true){
			trArr.push($(this).find("[name='delete_order']").val());
			if(trArr[index]==""){
				trArr[index].splice(index, 1);
			}
			alert($(this).find("[name='delete_order']").val());
		}
	});

	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/order_delete.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "trArr=" + trArr
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(delete_result){						
			if(delete_result>=1){
				alert("삭제 성공하였습니다.");
				location.replace(cr + "/order_form.ida");
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
		,"order": [[5, "asc"]]
	});
	
	dt.on( 'order.dt search.dt', function () {
		dt.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			cell.innerHTML = i+1;
		} );
	} ).draw();
}