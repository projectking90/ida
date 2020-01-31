function checkLogin(cr){
	var form = "[name=user_info_form]";
	var s_id = form + " [name=s_id]";
	var pwd = form + " [name=pwd]";
	
	if(is_empty(s_id)){
		alert("아이디를 입력하세요");
		$(s_id).focus();
		
		return;
	}
	
	if(checkSpace(s_id)){
		alert("공백은 입력할 수 없습니다");
		$(s_id).focus();
		
		return;
	}
	
	if(!is_valid_pattern(s_id, /^[0-9a-z]{1,10}$/)){
		alert("아이디는 영어 소문자 또는 숫자 10자리 이내만 입력할 수 있습니다");
		$(s_id).focus();
		
		return;
	}
	
	if(is_empty(pwd)){
		alert("비밀번호를 입력하세요");
		$(pwd).focus();
		
		return;
	}
	
	if(checkSpace(pwd)){
		alert("공백은 입력할 수 없습니다");
		$(pwd).focus();
		
		return;
	}
	
	if(!is_valid_pattern(pwd, /^[0-9a-z]{1,15}$/)){
		alert("비밀번호는 영어 소문자 또는 숫자 15자리 이내만 입력할 수 있습니다");
		$(pwd).focus();
		
		return;
	}
	
	$.ajax({
		url : cr + "/login_proc.ida"
		, type : "post"
		, data : $(form).serialize()
		, success : function(loginCnt){
			if(loginCnt==1){
				location.replace(cr + "/user_main_form.ida");
			} else{
				alert("아이디 혹은 비밀번호를 잘못 입력하였습니다");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}