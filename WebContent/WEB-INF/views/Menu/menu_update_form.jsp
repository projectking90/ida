<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Menu/menu_update_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메뉴 수정</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 메뉴 수정
							<span style='float:right'>
								<button type="button" class="btn btn-primary update">메뉴 수정완료</button>
							</span>
						</div>
						
						<div class="card-body">
							<form:form name="updateMenuForm" method="post" action="${cr}/menu_update.ida" commandName="menuDTO">
								<table class="table" id="dataTable">
									<tr>
										<td>대분류
										<td>
											<form:hidden name="mi_no" path="mi_no" className="mi_no"/>
											<select name="ma_code">
												<c:forEach items="${codemenuDTO.ma_nameList}" var="ma_nameList">
													<option value="${ma_nameList.ma_name}"
													${menuDTO.ma_code == ma_nameList.ma_name ? 'selected="selected"' : '' }
													>${ma_nameList.ma_name}</option>
												</c:forEach>
											</select>
									<tr>
										<td>소분류
										<td>
											<select name="mb_code">
												<c:forEach items="${codemenuDTO.mb_nameList}" var="mb_nameList">
													<option value="${mb_nameList.mb_name}" 
													${menuDTO.mb_code == mb_nameList.mb_name ? 'selected="selected"' : '' }
													>${mb_nameList.mb_name}</option>
												</c:forEach>
											</select>
									<tr>	
										<td>메뉴이름
										<td><form:input path="mi_name" className="mi_name"/>
									<tr> 
										<td>가격(원)
										<td><form:input path="price" className="price"/>
									<tr> 
										<td>설명
										<td><form:input path="mi_comment" className="mi_comment"/>
									<tr> 
										<td>등록일
										<td>${menuDTO.reg_date}
												<input type="hidden" name="s_id" value="${sessionScope.s_id}">
								</table>
							</form:form>
						</div>
						
						<div class="card-footer small text-muted"></div>
					</div>
				</div>
				<!-- /.container-fluid -->
	
				<!-- Sticky Footer -->
				<footer class="sticky-footer"></footer>
			</div>
			<!-- /.content-wrapper -->
		</div>
		<!-- /#wrapper -->
	
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"></a>
	
		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"></div>
	</body>
</html>