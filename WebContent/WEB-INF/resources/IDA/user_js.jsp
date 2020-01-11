<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resources/IDA/ida_js.jsp" %>
<!DOCTYPE html>

<!-- javascript 파일 수입 -->
<script src="${cr}/resources/IDA/user.js" type="text/javascript"></script>
<!-- Page level plugin CSS-->
<link href="${cr}/resources/IDA/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<!-- Page level plugin JavaScript-->
<script src="${cr}/resources/IDA/datatables/jquery.dataTables.js"></script>
<script src="${cr}/resources/IDA/datatables/dataTables.bootstrap4.js"></script>
<!-- Custom scripts for all pages-->
<script src="${cr}/resources/IDA/js/sb-admin.min.js"></script>
<!-- Demo scripts for this page-->
<script src="${cr}/resources/IDA/js/demo/datatables-demo.js"></script>

<script>
	$(document).ready(function(){
		$("body").addClass("sidebar-toggled");
		titleBars('${cr}', '${sessionScope.s_id}');
		setSidebars('${cr}');
		setLogoutFunc('${cr}');
	});
</script>