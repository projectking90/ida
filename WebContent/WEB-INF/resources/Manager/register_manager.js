/**
 * 
 */
$(document).ready(function(){
	$(".register").click(function(){
		registerUser();
	});
	
	$(".back").click(function(){
		location.replace("${cr}/login_manager_form.ida");
	});
});

function registerUser(){
	if(is_empty("[name=register_manager_form] [name=m_id]")){
		alert("아이디를 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_manager_form] [name=pwd]")){
		alert("비밀번호를 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_manager_form] [id=confirmPassword]")){
		alert("비밀번호 확인을 입력하세요");
		return;
	}
	
	if(check_pwd("[name=register_manager_form] [name=pwd]", "[name=register_manager_form] [id=confirmPassword]")){
		alert("입력한 비밀번호가 다릅니다.");
		return;
	}
	
	if(is_empty("[name=register_manager_form] [name=m_name]")){
		alert("이름을 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_manager_form] [name=email]")){
		alert("이메일을 입력하세요");
		return;
	}
	
	if(!is_valid_email("[name=register_manager_form] [name=email]")){
		alert("이메일 양식이 아닙니다");
		return;
	}
	
	alert($("[name=register_manager_form]").serialize());
	return;
	
	$.ajax({
		url : "${cr}/register_manager_proc.ida"
		, type : "post"
		, data : $("[name=register_manager_form]").serialize()
		, success : function(regCnt){
			if(regCnt==1){
				alert("회원가입에 성공");
				location.replace("${cr}/login_manager_form.ida");
			} else if(regCnt==-1){
				alert("아이디가 중복됩니다");
			} else{
				alert("회원가입에 실패");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}