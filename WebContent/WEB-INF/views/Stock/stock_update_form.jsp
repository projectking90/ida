<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/User/login_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>재고수정</title>
		<!-- Bootstrap core JavaScript-->
		<script src="${cr}/resources/Stock/jquery/jquery.min.js"></script>
		<script src="${cr}/resources/Stock/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="${cr}/resources/Stock/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script src="${cr}/resources/Stock/datatables/jquery.dataTables.js"></script>
		<script src="${cr}/resources/Stock/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="${cr}/resources/Stock/js/sb-admin.min.js"></script>
		<!-- Demo scripts for this page-->
		<script src="${cr}/resources/Stock/js/demo/datatables-demo.js"></script>
		<!-- Custom fonts for this template-->
		<link href="${cr}/resources/Stock/fontawesome-free/css/all.min.css"
			rel="stylesheet" type="text/css">
		<!-- Page level plugin CSS-->
		<link href="${cr}/resources/Stock/datatables/dataTables.bootstrap4.css"
			rel="stylesheet">
		<!-- Custom styles for this template-->
		<link href="${cr}/resources/Stock/css/sb-admin.css" rel="stylesheet">
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		</nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
	
					<!-- Breadcrumbs-->
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
						<li class="breadcrumb-item active">Tables</li>
					</ol>
	
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 재고 수정 <span name=stock_insert_form
								style='float: right'> <input type='button' value='재고 수정'
								onClick='update_stock_reg_btn();'>
							</span>
						</div>
						<div class="card-body">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<tr>
									<td align=center resize=3><b>재고 번호</b></td>
									<td align=center><b>대분류</b></td>
									<td align=center><b>소분류</b></td>
									<td align=center><b>식자재명</b></td>
									<td align=center><b>재고수량</b></td>
									<td align=center><b>사용여부</b></td>
									<td align=center><b>날짜</b></td>
									<td align=center><b>매입가격</b></td>
									<td align=center><b>판매가격</b></td>
								</tr>
								<tr>
									<td align=center><b><input type="text" name="st_no"
											size=9 value="4000001"></b></td>
									<td align=center><b><input type="text" name="ca_code"
											size=6 value="대분류1"></b></td>
									<td align=center><b><input type="text" name="cb_code"
											size=6 value="소분류1"></b></td>
									<td align=center><b><input type="text" name="i_name"
											size=10 value="양파"></b></td>
									<td align=center><b><input type="text" name="quantity"
											size=5 value="136"></b></td>
									<td align=center><b><input type="text" name="st_state"
											size=4 value="T"></b></td>
									<td align=center><b><input type="text"
											name="recent_date" size=15 value="2019-12-23(월)"></b></td>
									<td align=center><b><input type="text"
											name="purchase_price" size=9 value="1000"></b></td>
									<td align=center><b><input type="text"
											name="sell_price" size=9 value="1500"></b></td>
								</tr>
								<tr>
									<td align=center><b><input type="text" name="st_no"
											size=9 value="4000002"></b></td>
									<td align=center><b><input type="text" name="ca_code"
											size=6 value="대분류2"></b></td>
									<td align=center><b><input type="text" name="cb_code"
											size=6 value="소분류2"></b></td>
									<td align=center><b><input type="text" name="i_name"
											size=10 value="당근"></b></td>
									<td align=center><b><input type="text" name="quantity"
											size=5 value="150"></b></td>
									<td align=center><b><input type="text" name="st_state"
											size=1 value="T"></b></td>
									<td align=center><b><input type="text"
											name="recent_date" size=15 value="2019-12-23(월)"></b></td>
									<td align=center><b><input type="text"
											name="purchase_price" size=9 value="1500"></b></td>
									<td align=center><b><input type="text"
											name="sell_price" size=9 value="2100"></b></td>
								</tr>
							</table>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
	
					<p class="small text-center text-muted my-5">
						<em>More table examples coming soon...</em>
					</p>
	
				</div>
				<!-- /.container-fluid -->
	
				<!-- Sticky Footer -->
				<footer class="sticky-footer">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright © Your Website 2019</span>
						</div>
					</div>
				</footer>
	
			</div>
			<!-- /.content-wrapper -->
	
		</div>
		<!-- /#wrapper -->
	
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>
	
		<!-- Logout Modal-->
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are ready
						to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>