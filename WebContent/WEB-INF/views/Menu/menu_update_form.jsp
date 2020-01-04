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
		<title>메뉴 수정</title>
		
		<!-- Custom fonts for this template-->
		<link href="${cr}/resources/Menu/fontawesome-free/css/all.min.css"
			rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="${cr}/resources/Menu/datatables/dataTables.bootstrap4.css"
			rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="${cr}/resources/Menu/css/sb-admin.css" rel="stylesheet">
		
		
		<!-- Bootstrap core JavaScript-->
		<script src="${cr}/resources/Menu/jquery/jquery.min.js"></script>
		<script src="${cr}/resources/Menu/bootstrap/js/bootstrap.bundle.min.js"></script>
		
		<!-- Core plugin JavaScript-->
		<script src="${cr}/resources/Menu/jquery-easing/jquery.easing.min.js"></script>
		
		<!-- Page level plugin JavaScript-->
		<script src="${cr}/resources/Menu/datatables/jquery.dataTables.js"></script>
		<script src="${cr}/resources/Menu/datatables/dataTables.bootstrap4.js"></script>
		
		<!-- Custom scripts for all pages-->
		<script src="${cr}/resources/Menu/js/sb-admin.min.js"></script>
		
		<!-- Demo scripts for this page-->
		<script src="${cr}/resources/Menu/js/demo/datatables-demo.js"></script>
		<script>
			function update_menu_reg_btn() {
			}
		</script>
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
							<i class="fas fa-table"></i> 메뉴 수정 <span name=stock_insert_form
								style='float: right'>
								<button type="button" class="btn btn-primary" value='메뉴 수정'
									onClick='update_menu_reg_btn();'>메뉴 수정완료</button>
							</span>
						</div>
						<div class="card-body">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<tr>
									<td align=center resize=3><b>메뉴 번호</b></td>
									<td align=center><b>대분류</b></td>
									<td align=center><b>소분류</b></td>
									<td align=center><b>가게번호</b></td>
									<td align=center><b>메뉴이름</b></td>
									<td align=center><b>가격</b></td>
									<td align=center><b>설명</b></td>
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
											size=1 value="T"></b></td>
									<td align=center><b><input type="text"
											name="recent_date" size=15 value="2019-12-23(월)"></b></td>
	
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