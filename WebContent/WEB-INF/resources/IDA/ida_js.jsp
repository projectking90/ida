<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Log를 직접 남기기 위해서 log4j 라이브러리 수입 -->
<%@ page import="org.apache.log4j.*" %>
<!-- JSP 페이지에서 사용할 사용자 정의 태그인 JSTL의 C코어 태그 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSP 페이지에서 사용할 사용자 정의 태그인 spring 폼 태그 선언 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<!-- JSTL의 C코어 태그를 사용하여 변수들을 선언 -->
<!-- ContextRoot명 저장 -->
<c:set var="cr" value="/ida"/>

<!-- JQuery 라이브러리 파일 수입 -->
<script src="${cr}/resources/IDA/jquery-1.11.0.min.js" type="text/javascript"></script>
<!-- CSS파일 수입 -->
<%-- <link href="${cr}/resources/IDA/common.css" rel="stylesheet" type="text/css"> --%>
<!-- javascript 파일 수입 -->
<script src="${cr}/resources/IDA/ida.js" type="text/javascript"></script>
<!-- Custom fonts for this template-->
<link href="${cr}/resources/IDA/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<!-- Custom styles for this template-->
<link href="${cr}/resources/IDA/css/sb-admin.css" rel="stylesheet">
<!-- Bootstrap core JavaScript-->
<script src="${cr}/resources/IDA/jquery/jquery.min.js"></script>
<script src="${cr}/resources/IDA/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="${cr}/resources/IDA/jquery-easing/jquery.easing.min.js"></script>

<script>
	$(document).ready(function(){
	});
</script>