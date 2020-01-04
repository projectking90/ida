<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/User/login_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
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
	</head>
	<body class="bg-dark">
		<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">Login</div>
				<div class="card-body">
					<form>
						<div class="form-group">
							<div class="form-label-group">
								아이디 : <label for="inputtext"></label> <input type="text"
									id="inputtext" class="form-control" placeholder="ID"
									required="required" autofocus="autofocus">
	
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								비밀번호 : <label for="inputPassword"></label> <input type="password"
									id="inputPassword" class="form-control" placeholder="Password"
									required="required">
	
							</div>
						</div>
					</form>
				</div>
				<a class="btn btn-primary btn-block login">로그인</a>
				<div class="text-center">
					<a class="d-block small mt-3 register">회원가입</a> <a
						class="d-block small" href="forgot-password.html">아이디/비밀번호 찾기</a>
				</div>
			</div>
		</div>
	</body>
</html>