<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- css에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/IDA/ida_js.jsp" %>
<!DOCTYPE html>

<!-- javascript 파일 수입 -->
<script src="${cr}/resources/User/register.js" type="text/javascript"></script>

<script>
	$(document).ready(function(){
		$(".register").click(function(){
			registerUser("{cr}");
		});
		
		$(".back").click(function(){
			location.replace("${cr}/login_form.ida");
		});
		
		setCity();
		
		$("[name=register_user_form] [name=city]").change(function(){
			setGun("{cr}");
		});
		
		$("[name=register_user_form] [name=gun]").change(function(){
			setGu("{cr}");
			setDong("{cr}");
		});
		
		$("[name=register_user_form] [name=gu]").change(function(){
			setDong("{cr}");
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
</script>





