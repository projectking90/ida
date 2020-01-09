<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/User/login_js.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문관리</title>
		<!-- Custom fonts for this template-->
		<link href="${cr}/resources/Order/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<!-- Page level plugin CSS-->
		<link href="${cr}/resources/Order/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		<!-- Custom styles for this template-->
		<link href="${cr}/resources/Order/css/sb-admin.css" rel="stylesheet">
		<!-- Bootstrap core JavaScript-->
		<script src="${cr}/resources/Order/jquery/jquery.min.js"></script>
		<script src="${cr}/resources/Order/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="${cr}/resources/Order/jquery-easing/jquery.easing.min.js"></script>
		<!-- Page level plugin JavaScript-->
		<script src="${cr}/resources/Order/datatables/jquery.dataTables.js"></script>
		<script src="${cr}/resources/Order/datatables/dataTables.bootstrap4.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="${cr}/resources/Order/js/sb-admin.min.js"></script>
		<!-- Demo scripts for this page-->
		<script src="${cr}/resources/Order/js/demo/datatables-demo.js"></script>
		<script>
			$(document).ready(function(){
				$(".update").click(function(){
					location.replace("${cr}/order_update_form.ida");
				});

				$(".delete").click(function(){
					location.replace("${cr}/order_delete_form.ida");
				});
			});
		</script>
	</head>
	<body id="page-top" class="sidebar-toggled">
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
							<i class="fas fa-table"></i> 주문 현황
							<span name=stock_form style='float:right'>
								<input type="button" class="update" value="주문 수정">
								<input type="button" class="delete" value="주문 삭제">
							</span>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
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
									</thead>
									<tbody>
										<tr>
											<td align=center><b>4000001</b></td>
											<td align=center><b>대분류1</b></td>
											<td align=center><b>소분류1</b></td>
											<td align=center><b>양파</b></td>
											<td align=center><b>136</b></td>
											<td align=center><b>T</b></td>
											<td align=center><b>2019-12-23(월)</b></td>
											<td align=center><b>1000</b></td>
											<td align=center><b>1500</b></td>
										</tr>
										<tr>
											<td align=center><b>4000002</b></td>
											<td align=center><b>대분류2</b></td>
											<td align=center><b>소분류2</b></td>
											<td align=center><b>당근</b></td>
											<td align=center><b>150</b></td>
											<td align=center><b>T</b></td>
											<td align=center><b>2019-12-23(월)</b></td>
											<td align=center><b>1500</b></td>
											<td align=center><b>2100</b></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
	
					<!--추가-->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 재고 추가 <span name=stock_insert_form
								style='float: right'> <input type='button' value='재고 추가'
								onClick='insert_stock_reg_btn();'>
							</span>
						</div>
						<div class="card-body">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<!--select option 으로 바꿀 예정-->
								<tr>
									<th>대분류
									<th><input type="text" name="ca_code">
								<tr>
									<th>소분류
									<th><input type="text" name="cb_code">
								<tr>
									<th>식자재명
									<th><input type="text" name="i_name">
								<tr>
									<th>재고수량
									<th><input type="text" name="quantity">
								<tr>
									<th>사용여부
									<th><select name="st_state">
											<option value='t'>T
											<option value='f'>F
									</select>
								<tr>
									<th>매입가격
									<th><input type="text" name="purchase_price">
								<tr>
									<th>판매가격
									<th><input type="text" name="sell_price">
							</table>
						</div>
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
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		</div>
	</body>
</html>