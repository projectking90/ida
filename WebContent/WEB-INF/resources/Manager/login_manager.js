/**
 * 
 */
$(document).ready(function(){
	$(".login").click(function(){
		checkLoginForm();
	});
	
	$(".register").click(function(){
		location.replace("${cr}/register_manager_form.ida");
	});
	
	$(".user").click(function(){
		location.replace("${cr}/login_form.ida");
	})
});

function checkLoginForm(){
	if(is_empty("[name=manger_info_form] [name=m_id]")){
		alert("아이디를 입력하세요");
		return;
	}
	
	if(is_empty("[name=manger_info_form] [name=pwd]")){
		alert("비밀번호를 입력하세요");
		return;
	}
	
	$.ajax({
		url : "${cr}/login_proc.ida"
		, type : "post"
		, data : $("[name=manger_info_form]").serialize()
		, success : function(loginCnt){
			if(loginCnt==1){
				location.replace("${cr}/order_form.ida");
			} else{
				alert("아이디 혹은 비밀번호를 잘못 입력하였습니다");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}