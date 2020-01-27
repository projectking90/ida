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