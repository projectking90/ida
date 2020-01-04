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
		<title>회원가입</title>
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
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">회원가입</div>
				<div class="card-body">
					<form>
						<div class="form-group">
							<div class="form-label-group">
								<input type="text" id="inputText" class="form-control"
									placeholder="ID" required="required"> <label
									for="inputText">아이디</label>
							</div>
						</div>
	
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<div class="form-label-group">
										<input type="password" id="inputPassword" class="form-control"
											placeholder="Password" required="required"> <label
											for="inputPassword">비밀번호</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-label-group">
										<input type="password" id="confirmPassword"
											class="form-control" placeholder="Confirm password"
											required="required"> <label for="confirmPassword">비밀번호
											확인</label>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<input type="text" id="inputText" class="form-control"
									placeholder="text" required="required"> <label
									for="inputText">가게명</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<input type="text" id="inputText" class="form-control"
									placeholder="text" required="required"> <label
									for="inputText">사업자명</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<input type="text" id="inputText" class="form-control"
									placeholder="text" required="required"> <label
									for="inputText">사업자등록번호</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<input type="text" id="inputText" class="form-control"
									placeholder="text" required="required"> <label
									for="inputText">핸드폰</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<input type="text" id="inputText" class="form-control"
									placeholder="text" required="required"> <label
									for="inputText">이메일</label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								메뉴 대분류 : <input type="checkbox"> 한식 <input
									type="checkbox"> 중식 <input type="checkbox"> 일식 <input
									type="checkbox"> 양식 <input type="checkbox"> 분식 <input
									type="checkbox"> 패스트푸드 <input type="checkbox">
								카페
							</div>
						</div>
						<a class="btn btn-primary btn-block" href="login.html">회원가입</a>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>