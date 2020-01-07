<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- css에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/IDA/common.jsp" %>
<!DOCTYPE html>
<style>
</style>

<script>
	$(document).ready(function(){
		$(".register").click(function(){
			registerUser();
		});
		
		setCity();
		
		$("[name=register_user_form] [name=city]").change(function(){
			setGun();
		});
		
		$("[name=register_user_form] [name=gun]").change(function(){
			setGu();
			setDong();
		});
		
		$("[name=register_user_form] [name=gu]").change(function(){
			setDong();
		});
		
		$("[name=register_user_form] [name=s_phone]").keyup(function(){
			var str = new String($(this).val());
			str = str.replace("-", "");
			$(this).val(str);
		});
	});
	
	function setCity(){
		var city = $("[name=register_user_form] [name=city]");
		city.append("<option></option>");
		<c:forEach items="${city_list}" var="city" varStatus="loopTagStatus">
			city.append("<option value='${city.city}'>${city.city}</option>");
		</c:forEach>
	}
	
	function setGun(){
		var city = $("[name=register_user_form] [name=city]").val();
		var gun = $("[name=register_user_form] [name=gun]");
		var gu = $("[name=register_user_form] [name=gu]");
		var dong = $("[name=register_user_form] [name=dong]");
		
		gu.empty();
		dong.empty();
		
		$.ajax({
			url : "${cr}/get_gun.ida"
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
	
	function setGu(){
		var gun = $("[name=register_user_form] [name=gun]").val();
		var gu = $("[name=register_user_form] [name=gu]");
		
		$.ajax({
			url : "${cr}/get_gu.ida"
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
	
	function setDong(){
		var city = $("[name=update_user_form] [name=city]").val();
		var gun = $("[name=register_user_form] [name=gun]").val();
		var gu = $("[name=register_user_form] [name=gu]").val();
		var dong = $("[name=register_user_form] [name=dong]");

		$.ajax({
			url : "${cr}/get_dong.ida"
			, type : "post"
			, data : "city=" + city + "gun=" + gun + "&gu=" + gu
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
	
	function registerUser(){
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
			url : "${cr}/register_user_proc.ida"
			, type : "post"
			, data : $("[name=register_user_form]").serialize()
			, success : function(regCnt){
				if(regCnt==1){
					alert("회원가입에 성공");
					location.replace("${cr}/login_form.ida");
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
</script>





