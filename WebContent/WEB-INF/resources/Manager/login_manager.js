function checkLoginForm(cr){
	if(is_empty("[name=manger_info_form] [name=m_id]")){
		alert("아이디를 입력하세요");
		return;
	}
	
	if(is_empty("[name=manger_info_form] [name=pwd]")){
		alert("비밀번호를 입력하세요");
		return;
	}
	
	$.ajax({
		url : cr + "/login_manager_proc.ida"
		, type : "post"
		, data : $("[name=manger_info_form]").serialize()
		, success : function(loginCnt){
			if(loginCnt==1){
				location.replace(cr + "/order_manager_form.ida");
			} else{
				alert("아이디 혹은 비밀번호를 잘못 입력하였습니다");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}