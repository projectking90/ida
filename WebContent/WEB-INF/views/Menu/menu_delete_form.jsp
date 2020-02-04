<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Menu/menu_delete_js.jsp"%>
<!DOCTYPE html>
<!-- ******************************** 삭제 ************************* -->
<html>
	<head>
		<meta charset="UTF-8">
		<title>메뉴 삭제</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 메뉴 현황
							<span style='float: right'>
								<button type="button" class="btn btn-danger delete">메뉴 삭제완료</button>
							</span>
						</div>
						
						<div class="card-body">
							<div class="table-responsive">
								<form name="deleteMenuForm" method="post" action="${cr}/menu_delete.ida">
									<table class="table" id="dataTable">
										<thead>
											<tr>
												<td align=center><b>선택</b>
												<td align=center><b>대분류</b></td>
												<td align=center><b>소분류</b></td>
												<td align=center><b>메뉴이름</b></td>
												<td align=center><b>가격(원)</b></td>
												<td align=center><b>설명</b></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${menu_list}" var="menu">
												<tr class="menu_list_tr">
													<td align=center>
														<input type="checkbox" name="delete_menu" value="${menu.mi_no}">
													<td align=center>${menu.ma_code}
													<td align=center>${menu.mb_code}
													<td align=center>${menu.mi_name}
													<td align=right>${menu.price}
													<td align=center>${menu.mi_comment}
											</c:forEach>
										</tbody>
									</table>
								</form>
							</div>
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