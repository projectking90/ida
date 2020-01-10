<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- css에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/IDA/ida_js.jsp" %>
<!DOCTYPE html>
<style>
</style>

<script>
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
</script>





