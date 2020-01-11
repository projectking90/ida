function update_menu_reg(cr) {
	var trArr = new Array();
	
	$(".menu_list_tr").each(function(index){
		trArr[index] = new Array();
		trArr[index].push($(this).find("[name='mi_no']").val());
		trArr[index].push($(this).find("[name='ma_code']").val());
		trArr[index].push($(this).find("[name='mb_code']").val());
		trArr[index].push($(this).find("[name='mi_name']").val());
		trArr[index].push($(this).find("[name='price']").val());
		trArr[index].push($(this).find("[name='mi_comment']").val());
		trArr[index].push($(this).find("[name='s_id']").val());
	});
	
	$.ajax({
		url : cr + "/menu_update.ida"
		, type : "post"
		,data : "trArr=" + trArr
		,success : function(update_result){
			if(update_result>=0){
				alert("메뉴 수정 성공하였습니다.");
				location.replace(cr + '/menu_form.ida');
			}else{
				alert("메뉴 수정 실패하였습니다. 관리자에게 문의하시기 바랍니다.")
			}
		}
		,error : function(){
			alert("서버 접속을 실패하였습니다.");
		}

	});
}