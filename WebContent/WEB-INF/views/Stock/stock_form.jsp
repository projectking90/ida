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
		<title>재고관리</title>
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
		<link href="${cr}/resources/Stock/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<!-- Page level plugin CSS-->
		<link href="${cr}/resources/Stock/datatables/dataTables.bootstrap4.css" rel="stylesheet">
		<!-- Custom styles for this template-->
		<link href="${cr}/resources/Stock/css/sb-admin.css" rel="stylesheet">

		<script>
			function insert_stock_reg_btn(){
				if($("[name=quantity]").val()==""){
					alert("수량을 입력해주시기 바랍니다.");
					return;
				}

				var check_num = /^[0-9]*$/;
				var not_num = /^(0)[0-9]{1,}$/;
				
				if(check_num.test($("[name=quantity]").val())==false || not_num.test($("[name=quantity]").val())==true){
					alert("0 이상의 정수로만 입력해주시기 바랍니다.");
					return;
				}
				alert($("[name=insert_stock_form]").serialize());
				
				$.ajax({
					url:"/ida/insert_stock_reg.ida"
					,type:"post"
					,data:$("[name=insert_stock_form]").serialize()
					,success:function(stock_reg_cnt){
						//alert(stock_reg_cnt);
						if(stock_reg_cnt==1){
							alert("재고가 등록되었습니다.");
							location.replace("/ida/stock_form.ida");
						}else if(stock_reg_cnt==-1){
							alert("재고가 등록되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
						}else if(stock_reg_cnt==-2){
							alert("이미 등록된 재고입니다.");
						}else if(stock_reg_cnt==-3){
							alert("재고가 등록되었습니다.");
							location.replace("/ida/stock_form.ida");
						}
					}
					,error:function(){
						alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
					}
				});
			}
			
			function stock_update_btn(){
				location.replace("${cr}/stock_update_form.ida");
			}
			
			function stock_delete_btn(){
				location.replace("${cr}/stock_delete_form.ida");
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
							<i class="fas fa-table"></i> 재고 현황
							<span name=stock_form style='float:right'>
								<input type="button" class="btn btn-primary" value="재고 수정" onClick='stock_update_btn();'>
								<input type="button" class="btn btn-danger"value="재고 삭제" onClick='stock_delete_btn();'>
							</span>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
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
											<td align=center><b>날짜</b></td>
											<td align=center><b>가격</b></td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${stock_list}" var="stock" varStatus="loopTagStatus">
											<tr style="cursor:pointer">
												<td align=center>${loopTagStatus.index+1}
													<input type="hidden" name="st_no" value="${stock.st_no}">
												<td align=center>${stock.ia_name}
												<td align=center>${stock.ib_name}
												<td align=center>${stock.io_name}
												<td align=center>${stock.i_name}
												<td align=center>${stock.i_size}
												<td align=center>${stock.quantity}
												<td align=center>${stock.st_state}
												<td align=center>${stock.reg_date}
												<td align=center>${stock.i_price}
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>
					</div>
	
					<!--추가-->
					<form name="insert_stock_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i> 재고 추가 <span name=stock_insert_form
									style='float: right'> 
									<input type='button' class="btn btn-success" value='재고 추가' onClick='insert_stock_reg_btn();'>
								</span>
							<br>
							</div>
							<div class="card-body">
								<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
									<!--select option 으로 바꿀 예정-->
									<!-- 추가 : 식자재명, 재고상태, 수량 -->
									<tr>
										<th>식자재명
										<th>
											<select name="i_no" class="i_no">
												<c:forEach items="${ingredient_list}" var="ingredient" varStatus="loopTagStatus">
													<option value="${ingredient.i_no}">${ingredient.i_name}
												</c:forEach>
											</select>
									<tr>
										<th>재고수량
										<th><input type="text" name="quantity" class="quantity">
									<tr>
										<th>상태
										<th>
											<select name="st_state" class="st_state">
													<option value='t'>t
													<option value='f'>f
											</select>
								</table>
							</div>
						</div>
					</form>
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