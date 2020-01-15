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
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		</nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
	
					<!-- Breadcrumbs-->
					<ol class="breadcrumb"></ol>
	
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 재고 현황
							<span name=stock_form style='float:right'>
								<input type="button" class="btn btn-primary update" value="재고 수정완료">
							</span>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<td align=center resize=10><b>재고번호</b></td>
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
										<c:forEach items="${stock_list}" var="stock" varStatus="loopTagStatus">
											<tr class="stock_list_tr" style="cursor:pointer">
												<td align=center>${loopTagStatus.index+1}
													<input type="hidden" name="st_no" value="${stock.st_no}">
												<td align=center>${stock.ia_name}
												<td align=center>${stock.ib_name}
												<td align=center>${stock.io_name}
												<td align=center>${stock.i_name}
												<td align=center>${stock.i_size}
												<td align=center><input type="text" name="quantity" size=6 value="${stock.quantity}">
												<td align=center>
													<select name="st_state">
														<option value="${stock.st_state}">${stock.st_state}
														<c:if test="${stock.st_state=='t'}">
															<option value="f">f				
														</c:if>
														<c:if test="${stock.st_state=='f'}">
															<option value="t">t
														</c:if>
													</select>
												<td align=center>${stock.i_price}
												<td align=center>${stock.reg_date}
											</tr>
										</c:forEach>
								</table>
							</div>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
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