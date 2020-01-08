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
		<title>식자재 삭제</title>
		<!-- Custom fonts for this template-->
		<link href="${cr}/resources/Ingredient/fontawesome-free/css/all.min.css"
			rel="stylesheet" type="text/css">
		
		<!-- Page level plugin CSS-->
		<link
			href="${cr}/resources/Ingredient/datatables/dataTables.bootstrap4.css"
			rel="stylesheet">
		
		<!-- Custom styles for this template-->
		<link href="${cr}/resources/Ingredient/css/sb-admin.css"
			rel="stylesheet">
		<!-- Bootstrap core JavaScript-->
		<script src="${cr}/resources/Ingredient/jquery/jquery.min.js"></script>
		<script
			src="${cr}/resources/Ingredient/bootstrap/js/bootstrap.bundle.min.js"></script>
		
		<!-- Core plugin JavaScript-->
		<script
			src="${cr}/resources/Ingredient/jquery-easing/jquery.easing.min.js"></script>
		
		<!-- Page level plugin JavaScript-->
		<script src="${cr}/resources/Ingredient/datatables/jquery.dataTables.js"></script>
		<script
			src="${cr}/resources/Ingredient/datatables/dataTables.bootstrap4.js"></script>
		
		<!-- Custom scripts for all pages-->
		<script src="${cr}/resources/Ingredient/js/sb-admin.min.js"></script>
		
		<!-- Demo scripts for this page-->
		<script src="${cr}/resources/Ingredient/js/demo/datatables-demo.js"></script>
		<script>
			function ing_delete_reg_btn() {
				var trArr = new Array();
				$(".ingredient_list_tr").each(function(index){
					if($(this).find("[name='delete_ingredient']").prop("checked")==true){
						trArr.push($(this).find("[name='delete_ingredient']").val());
						if(trArr[index]==""){
							trArr[index].splice(index, 1);
						}
						alert($(this).find("[name='delete_ingredient']").val());
					}
				});
				alert($(".ingredient_list_tr").serialize());
				$.ajax({
					// 접속할 서버 쪽 url 주소 설정
					url : "/ida/ingredeint_delete.ida"
					// 전송 방법 설정
					, type : "post"
					// 서버로 보낼 파라미터명과 파라미터값을 설정
					, data : "trArr=" + trArr
					// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
					// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
					, success : function(delete_result){
						if(delete_result>=1){
							alert("삭제 성공하였습니다.");
							location.replace("${cr}/ingredient_form.ida");
						}else{
							alert("삭제 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
						}
					}
					// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
					,error : function(xhr,errorThrown){
						alert(xhr);
						alert(errorThrown);
						alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
					}
				});
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
							<i class="fas fa-table"></i> 식자재 현황 <span name=store_form
								style='float: right'> 
								<button type="button" class="btn btn-danger" value="식자재 삭제"
									onClick='ing_delete_reg_btn();'>식자재 삭제완료</button>
							</span>
						</div>
						<div class="card-body">
							<div class="table-responsive">
							<form name="deleteIngredient" method="post" action="/ida/ingredient_delete_form.ida">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<tr>
										<td align=center resize=1><b>선택</b>
										<td align=center resize=3><b>식자재 번호</b></td>
										<td align=center><b>대분류</b></td>
										<td align=center><b>소분류</b></td>
										<td align=center><b>원산지</b></td>
										<td align=center><b>이름</b></td>
										<td align=center><b>규격</b></td>
										<td align=center><b>가격</b></td>
										<td align=center><b>등록일</b></td>
									</tr>
									<c:forEach items="${ingredient_list}" var="ingredient" varStatus="loopTagStatus">
									<tr style="cursor:pointer" class="ingredient_list_tr">
										<td border="0"><input type="checkbox"
											name="delete_ingredient" value="${ingredient.i_no}">
										<td align=center>${loopTagStatus.index+1}
										<td align=center>${ingredient.ia_name}
										<td align=center>${ingredient.ia_name}
										<td align=center>${ingredient.io_name}
										<td align=center>${ingredient.i_name}
										<td align=center>${ingredient.i_size}
										<td align=center>${ingredient.i_price}
										<td align=center>${ingredient.reg_date}
									</c:forEach>
								</table>
							</form>
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
		<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		</div>
	</body>
</html>