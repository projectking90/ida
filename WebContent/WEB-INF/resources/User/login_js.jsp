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
		$(".login").click(function(){
			location.replace("${cr}/order_form.ida");
		});
		
		$(".register").click(function(){
			location.replace("${cr}/register_form.ida");
		});
	});
	
	function checkLoginForm(){
		if(is_empty("[name=admin_id]")){
			alert("아이디를 입력해주시기 바랍니다.");
	
			$('[name=admin_id]').val("");
			$('[name=admin_id]').focus();
			return;
		}
	
		if(is_empty("[name=pwd]")){
			alert("비밀번호를 입력해주시기 바랍니다.");
			$('[name=pwd]').val("");
			$('[name=pwd]').focus();
			return;
		}
		 
		$.ajax({
			url : "/ictProject/loginProc.do"
			, type : "post"
			, data : $("[name=loginForm]").serialize()
			, success : function(admin_idCnt){
				if(admin_idCnt==1){
					location.replace("/ictProject/mainForm.do");
				}
				else if(admin_idCnt==0){
					alert("아이디, 암호 존재하지 않습니다.");
				}
				else{
					alert("서버 오류 발생! 관리자에게 문의해주시기 바랍니다.");
				}
			}
			, error : function(){
				alert("서버 접속 실패! 관리자에게 문의해주시기 바랍니다.");
			}
		});
	}
</script>