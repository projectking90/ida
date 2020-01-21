<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resources/IDA/user_js.jsp" %>
<!DOCTYPE html>

<!-- javascript 파일 수입 -->
<script src="${cr}/resources/Menu/menu_analysis.js" type="text/javascript"></script>

<script>
	$(document).ready(function(){
		$('#dataTable').DataTable({
			"language": {
				"search": "결과 내 검색 : "
			}
		});	
		
		$(".list").click(function(){
			menu_list();
		});
		
		<c:forEach items="${menu_searchDTO.search_condition}" var="search_condition">
			inputData("[name=search_condition]","${search_condition}");
		</c:forEach>
		
		$(".m_chart").click(function(){
			location.replace("${cr}/menu_analysis_chart_form.ida");
		});
	});
</script>