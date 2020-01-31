<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Stock/stock_delete_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>재고삭제</title>
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
								<input type="button" class="btn btn-danger delete" value="재고 삭제">
							</span>
						</div>
						
						<div class="card-body">
							<div class="table-responsive">
								<table class="table" id="dataTable">
									<thead>
										<tr>
											<td align=center><b>선택</b></td>
											<td align=center><b>대분류</b></td>
											<td align=center><b>소분류</b></td>
											<td align=center><b>원산지</b></td>
											<td align=center><b>식자재명</b></td>
											<td align=center><b>규격</b></td>
											<td align=center><b>재고수량</b></td>
											<td align=center><b>상태</b></td>
											<td align=center><b>가격(원)</b></td>
											<td align=center><b>날짜</b></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${stock_list}" var="stock">
											<tr class="stock_list_tr">
												<td align=center>
													<input type="checkbox" name="delete_stock" value='${stock.st_no}'>
												<td align=center class="ia_name">${stock.ia_name}
												<td align=center class="ib_name">${stock.ib_name}
												<td align=center class="io_name">${stock.io_name}
												<td align=center class="i_name">${stock.i_name}
												<td align=center class="i_size">${stock.i_size}
												<td align=center class="quantity">${stock.quantity}
												<td align=center class="st_state">${stock.st_state}
												<td align=right class="i_price">${stock.i_price}
												<td align=center class="reg_date">${stock.reg_date}
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						
						<div class="card-footer small text-muted"></div>
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