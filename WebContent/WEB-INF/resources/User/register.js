function setGun(cr){
	var city = $("[name=register_user_form] [name=city]").val();
	var gun = $("[name=register_user_form] [name=gun]");
	var gu = $("[name=register_user_form] [name=gu]");
	var dong = $("[name=register_user_form] [name=dong]");
	
	gu.empty();
	dong.empty();
	
	$.ajax({
		url : cr + "/get_gun.ida"
		, type : "post"
		, data : "city=" + city
		, success : function(gun_list){
			gun.empty();
			gun.append("<option></option>");
			for(var i=0; i<gun_list.length; i++){
				gun.append("<option value=" + gun_list[i].gun +">" + gun_list[i].gun + "</option>");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}

function setGu(cr){
	var gun = $("[name=register_user_form] [name=gun]").val();
	var gu = $("[name=register_user_form] [name=gu]");
	
	$.ajax({
		url : cr + "/get_gu.ida"
		, type : "post"
		, data : "gun=" + gun
		, success : function(gu_list){
			gu.empty();
			gu.append("<option></option>");
			for(var i=0; i<gu_list.length; i++){
				gu.append("<option value=" + gu_list[i].gu +">" + gu_list[i].gu + "</option>");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}

function setDong(cr){
	var city = $("[name=register_user_form] [name=city]").val();
	var gun = $("[name=register_user_form] [name=gun]").val();
	var gu = $("[name=register_user_form] [name=gu]").val();
	var dong = $("[name=register_user_form] [name=dong]");
	
	$.ajax({
		url : cr + "/get_dong.ida"
		, type : "post"
		, data : "city=" + city + "&gun=" + gun + "&gu=" + gu
		, success : function(dong_list){
			dong.empty();
			dong.append("<option></option>");
			for(var i=0; i<dong_list.length; i++){
				dong.append("<option value=" + dong_list[i].dong +">" + dong_list[i].dong + "</option>");
			}
		}, error : function(){
			alert("서버와 통신 실패");
		}
	});
}

function registerUser(cr){
	if(is_empty("[name=register_user_form] [name=s_id]")){
		alert("아이디를 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=pwd]")){
		alert("비밀번호를 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_user_form] [id=confirmPassword]")){
		alert("비밀번호 확인을 입력하세요");
		return;
	}
	
	if(check_pwd("[name=register_user_form] [name=pwd]", "[name=register_user_form] [id=confirmPassword]")){
		alert("입력한 비밀번호가 다릅니다.");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=com_name]")){
		alert("가게명을 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=s_name]")){
		alert("사업자명을 입력하세요");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=s_reg_num]")){
		alert("사업자등록번호를 입력하세요");
		return;
	}
	
	if(!is_valid_pattern("[name=register_user_form] [name=s_reg_num]", /^[\d]{3}-[\d]{2}-[\d]{5}$/)){
		alert("사업자등록번호이 아닙니다");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=s_phone]")){
		alert("핸드폰을 입력하세요");
		return;
	}
	
	if(!is_valid_pattern("[name=register_user_form] [name=s_phone]", /^010[\d]{8}$/)){
		alert("핸드폰 형식이 아닙니다");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=email]")){
		alert("이메일을 입력하세요");
		return;
	}
	
	if(!is_valid_email("[name=register_user_form] [name=email]")){
		alert("이메일 양식이 아닙니다");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=city]")){
		alert("시를 선택하세요");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=gun]")){
		alert("군를 선택하세요");
		return;
	}
	
	if(is_empty("[name=register_user_form] [name=gu]") && is_empty("[name=register_user_form] [name=dong]")){
		alert("나머지 주소를 선택하세요");
		return;
	}
	
	$.ajax({
		url : cr + "/register_user_proc.ida"
		, type : "post"
		, data : $("[name=register_user_form]").serialize()
		, success : function(regCnt){
			if(regCnt==1){
				alert("회원가입에 성공");
				location.replace(cr + "/login_form.ida");
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

function check_pwd(selecter1, selecter2){
	var obj1 = $(selecter1);
	var obj2 = $(selecter2);
	
	try{
		if(obj1.val() != obj2.val()){
			return true;
		} else{
			return false;
		}
	} catch(e){
		alert("check_pwd 함수에서 에러");
		return;
	}
}