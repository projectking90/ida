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
		<title>식자재 관리</title>
		<!-- Custom fonts for this template-->
		<link href="${cr}/resources/Ingredient/fontawesome-free/css/all.min.css" rel="stylesheet"
			type="text/css">
		
		<!-- Page level plugin CSS-->
		<link href="${cr}/resources/Ingredient/datatables/dataTables.bootstrap4.css"
			rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="${cr}/resources/Ingredient/css/sb-admin.css" rel="stylesheet">
		<!-- Bootstrap core JavaScript-->
		<script src="${cr}/resources/Ingredient/jquery/jquery.min.js"></script>
		<script src="${cr}/resources/Ingredient/bootstrap/js/bootstrap.bundle.min.js"></script>
		
		<!-- Core plugin JavaScript-->
		<script src="${cr}/resources/Ingredient/jquery-easing/jquery.easing.min.js"></script>
		
		<!-- Page level plugin JavaScript-->
		<script src="${cr}/resources/Ingredient/datatables/jquery.dataTables.js"></script>
		<script src="${cr}/resources/Ingredient/datatables/dataTables.bootstrap4.js"></script>
		
		<!-- Custom scripts for all pages-->
		<script src="${cr}/resources/Ingredient/js/sb-admin.min.js"></script>
		
		<!-- Demo scripts for this page-->
		<script src="${cr}/resources/Ingredient/js/demo/datatables-demo.js"></script>
		<script>
			$(document).ready(function(){
				$(".update").click(function(){
					location.replace("${cr}/ingredient_update_form.ida");
				});

				$(".delete").click(function(){
					location.replace("${cr}/ingredient_delete_form.ida");
				});
			});
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
							<i class="fas fa-table"></i> 식자재 현황
							<span name=store_form style='float:right'>
								<input type="button" class="update" value="식자재 수정">
								<input type="button" class="delete" value="식자재 삭제">
							</span>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<td align=center resize=3><b>식자재 번호</b></td>
											<td align=center><b>가게번호</b></td>
											<td align=center><b>대분류</b></td>
											<td align=center><b>소분류</b></td>
											<td align=center><b>원산지</b></td>
											<td align=center><b>이름</b></td>
											<td align=center><b>규격</b></td>
											<td align=center><b>가격</b></td>
											<td align=center><b>등록일</b></td>
											<td align=center><b>삭제여부</b></td>
										</tr>
									</thead>
		<c:forEach items="${ingredient_list}" var="ingredient" varStatus="loopTagStatus">
			<tbody>
				<tr>
					<td align=center>${ingredient.i_no}</b></td>
					<td align=center>${ingredient.s_no}</b></td>
					<td align=center>${ingredient.ia_code}</b></td>
					<td align=center>${ingredient.ib_code}</b></td>
					<td align=center>${ingredient.io_code}</b></td>
					<td align=center>${ingredient.i_name}</b></td>
					<td align=center>${ingredient.i_size}</b></td>
					<td align=center>${ingredient.i_price}</b></td>
					<td align=center>${ingredient.reg_date}</b></td>
					<td align=center>${ingredient.is_del}</b></td>
				</tr>
			</tbody>
		</c:forEach>
								</table>
							</div>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
	
					<!--추가-->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 식자재 추가 <span name=store_insert_form
								style='float: right'> <input type='button' value='식자재 추가'
								onClick='insert_store_reg_btn();'>
							</span>
						</div>
						<div class="card-body">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<!--select option 으로 바꿀 예정-->
								<tr>
									<th>대분류
									<th><input type="text" name="ia_code">
								<tr>
									<th>소분류
									<th><input type="text" name="ib_code">
								<tr>
									<th>식자재명
									<th><input type="text" name="i_name">
								<tr>
									<th>식자재수량
									<th><input type="text" name="quantity">
								<tr>
									<th>매입가격
									<th><input type="text" name="purchase_price">
								<tr>
									<th>알레르기코드
									<th><input type="text" name="sell_price">
								<tr>
									<th>삭제여부
									<th><select name="st_state">
											<option value='t'>T
											<option value='f'>F
									</select>
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