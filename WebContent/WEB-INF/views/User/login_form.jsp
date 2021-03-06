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
	</head>
	<body class="bg-dark">
		<div class="container">
			<div class="card card-login mx-auto mt-5">
				<div class="card-header">로그인</div>
				
				<div class="card-body">
					<form name="user_info_form">
						<div class="form-group">
							<div class="form-label-group">
								<input type="text"
									id="inputSId" class="form-control" placeholder="ID"
									required="required" autofocus="autofocus" name="s_id">
								<label for="inputSId">아이디</label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-label-group">
								<input type="password"
									id="inputPassword" class="form-control" placeholder="Password"
									required="required" name="pwd">
								<label for="inputPassword">비밀번호</label>
								<%-- <form:errors path="pwd"/> --%>
							</div>
						</div>
					</form>
				</div>
				
				<a class="btn btn-primary btn-block login">로그인</a>
				
				<div class="form-group"></div>
				
				<div class="text-center">
					<a class="d-done small mt-3 register">[회원가입]</a>
				</div>
				
				<div class="form-group"></div>
			</div>
		</div>
	</body>
</html>