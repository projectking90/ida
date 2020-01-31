<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Stock/stock_update_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>재고수정</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 재고 현황
							<span style='float:right'>
								<input type="button" class="btn btn-primary update" value="재고 수정완료">
							</span>
						</div>
						
						<div class="card-body">
							<div class="table-responsive">
								<form name='update_stock_form'>
									<table class="table" id="dataTable2">
										<tr>
											<td>대분류
											<td>
												<input type="hidden" name="st_no" value="${stockDTO.st_no}">
												${stockDTO.ia_name}
										<tr>
											<td>소분류
											<td>${stockDTO.ib_name}
										<tr>	
											<td>원산지
											<td>${stockDTO.io_name}
										<tr> 
											<td>식자재명
											<td>${stockDTO.i_name}
										<tr> 
											<td>규격
											<td>${stockDTO.i_size}
										<tr> 
											<td>재고수량
											<td><input type="text" name="quantity" size=6 value="${stockDTO.quantity}">
										<tr> 
											<td>상태
											<td>
											<select name="st_state">
												<option value="${stockDTO.st_state}">${stockDTO.st_state}
													<c:if test="${stockDTO.st_state=='t'}">
														<option value="f">f				
													</c:if>
													<c:if test="${stockDTO.st_state=='f'}">
														<option value="t">t
													</c:if>
												</option>
											</select>
										<tr> 
											<td>가격(원)
											<td>${stockDTO.i_price}
										<tr> 
											<td>등록일
											<td>${stockDTO.reg_date}
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-wrapper -->
		</div>
		<!-- /#wrapper -->
	
		<!-- Sticky Footer -->
		<footer class="sticky-footer"></footer>
		
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"></a>
	
		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"></div>
	</body>
</html>