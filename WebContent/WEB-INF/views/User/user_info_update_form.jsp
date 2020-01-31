<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/User/user_info_update_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보 수정</title>
	</head>
	<body class="bg-dark">
		<div class="container">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">회원정보수정</div>
				
				<div class="card-body">
					<form:form name="update_user_form" commandName="user_info">
						<div class="form-group">
							<div class="form-label-group">
								<form:password path="pwd" id="inputPassword" class="form-control" placeholder="Confirm password" required="required"/>
								<form:label path="pwd" for="inputPassword">현재 비밀번호</form:label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<form:password path="newPwd" id="newPassword" class="form-control" placeholder="Confirm password" required="required"/>
								<form:label path="newPwd" for="newPassword">새로운 비밀번호(필수아님)</form:label>
							</div>
						</div>
						<div class="form-group">
							<div class="form-label-group">
								<form:password path="confirmPwd" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required"/>
								<form:label path="confirmPwd" for="confirmPassword">비밀번호 확인(필수아님)</form:label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-label-group">
								<form:input path="com_name" id="inputStoreName" class="form-control" placeholder="text" required="required"/>
								<form:label path="com_name" for="inputStoreName">가게명</form:label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-label-group">
								<form:input path="s_name" id="inputSName" class="form-control" placeholder="text" required="required"/>
								<form:label path="s_name" for="inputSName">사업자명</form:label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-label-group">
								<form:input path="s_reg_num" id="inputSRegNum" class="form-control" placeholder="text" required="required"/>
								<form:label path="s_reg_num" for="inputSRegNum">사업자등록번호(***-**-*****)</form:label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-label-group">
								<form:input path="s_phone" id="inputSPhone" class="form-control" placeholder="text" required="required"/>
								<form:label path="s_phone" for="inputSPhone">핸드폰(-없이)</form:label>
							</div>
						</div>
						
						<div class="form-group">
							<div class="form-label-group">
								<form:input path="email" id="inputEmail" class="form-control" placeholder="text" required="required"/>
								<form:label path="email" for="inputEmail">이메일</form:label>
							</div>
						</div>
						
						주소<br>
						<form:select path="city">
							<form:options items="${user_info.city_list}" itemLabel="city" itemValue="city"/>
						</form:select>
						<form:select path="gun">
							<form:options items="${user_info.gun_list}" itemLabel="gun" itemValue="gun"/>
						</form:select>
						<form:select path="gu">
							<form:options items="${user_info.gu_list}" itemLabel="gu" itemValue="gu"/>
						</form:select>
						<form:select path="dong">
							<form:options items="${user_info.dong_list}" itemLabel="dong" itemValue="dong"/>
						</form:select>
						
						<div class="form-group"></div>
						
						<div class="form-group">
							<div class="form-label-group">
								<form:input path="addr_detail" id="addrDetail" class="form-control" placeholder="text" required="required"/>
								<form:label path="addr_detail" for="addrDetail">상세주소</form:label>
							</div>
						</div>
						
						<a class="btn btn-primary btn-block update">회원정보 변경</a>
						
						<div class="text-center">
							<a class="d-block mt-3 back">이전</a>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</body>
</html>