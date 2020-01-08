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
		<title>식자재 수정</title>
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
			$(document).ready(function(){
				$(".update").click(function(){
						update_store_reg_btn();
					});
				});		
				
			function update_store_reg_btn(){
				var trArr = new Array();
				
				$(".ingredient_list_tr").each(function(index){
					trArr[index] = new Array();
					trArr[index].push($(this).find("[name='i_no']").val());
					trArr[index].push($(this).find("[name='ia_code']").val());
					trArr[index].push($(this).find("[name='ib_code']").val());
					trArr[index].push($(this).find("[name='io_code']").val());
					trArr[index].push($(this).find("[name='i_name']").val());
					trArr[index].push($(this).find("[name='i_size']").val());
				});
				
				$.ajax({
					// 접속할 서버 쪽 url 주소 설정
					url : "/ida/ingredient_update_proc.ida"
					// 전송 방법 설정
					, type : "post"
					// 서버로 보낼 파라미터명과 파라미터값을 설정
					, data : "trArr=" + trArr
					// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
					// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
					, success : function(ingredient_update_cnt){
						if(ingredient_update_cnt>=0){
							alert("수정 성공하였습니다.");
							location.replace("${cr}/ingredient_form.ida");
						}else{
							alert("수정 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
						}
					}
					// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
					,error : function(){
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
							<i class="fas fa-table"></i> 식자재 수정 
							<span name=store_insert_form style='float: right'>
								<button type="button" class="btn btn-primary update" value="수정완료">수정완료 </button>
							</span>
						</div>
						<div class="card-body">
						<form name="updateIngForm" method="post" action="/ida/ingredient_update_form.ida">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<tr>
									<td align=center resize=3><b>식자재 번호</b></td>
									<td align=center><b>대분류</b></td>
									<td align=center><b>소분류</b></td>
									<td align=center><b>원산지</b></td>
									<td align=center><b>식자재명</b></td>
									<td align=center><b>규격</b></td>
									<td align=center><b>매입가격</b></td>
									<td align=center><b>등록일</b></td>
									<td align=center><b>삭제여부</b></td>
								</tr>
			<tbody>
				<c:forEach items="${ingredient_list}" var="ingredient" varStatus="loopTagStatus">
				<tr class="ingredient_list_tr" style="cursor:pointer">
					<td align=center>${loopTagStatus.index+1}<input type="hidden" name="i_no" value="${ingredient.i_no}"></td>
					<td align=center>
									<select name="ia_code">
										<option value="title" selected="selected">-선택-</option>
											<option value="1">과일/채소</option>
											<option value="2">농/수산물</option>
											<option value="3">정육</option>
											<option value="4">가공식품</option>
											<option value="5">공산품</option>
											<option value="6">카페/음료</option>
										</select></td>
					<td align=center>
										<select name="ib_code" id="ib_code" value="${Code_ingredientDTO.ib_nameList}">
											<option value="title" selected="selected">-선택-</option>
											<option value="1">김치</option>
											<option value="2">신선채소</option>
											<option value="3">냉동채소</option>
											<option value="4">오징어/낙지/쭈꾸미</option>
											<option value="5">새우/꽃게</option>
											<option value="6">냉동패류</option>
											<option value="7">초밥재료</option>
											<option value="8">기타냉동수산</option>
											<option value="9">냉장계육</option>
											<option value="10">냉동계육</option>
											<option value="11">돈육/우육</option>
											<option value="12">파우더/염지제</option>
											<option value="13">사과/배</option>
											<option value="14">한라봉/감귤</option>
											<option value="15">감/홍시</option>
											<option value="16">키위/참다래</option>
											<option value="17">토마토</option>
											<option value="18">포도</option>
											<option value="19">메론/수박</option>
											<option value="20">딸기/베리류</option>
											<option value="21">자몽/레몬</option>
											<option value="22">냉동과일</option>
											<option value="23">소스/양념류</option>
											<option value="24">통조림/기름</option>
											<option value="25">면/떡/베이커리</option>
											<option value="26">탕/찜/죽/면/용기</option>
											<option value="27">포장/박스</option>
											<option value="28">종이/비닐봉투</option>
											<option value="29">수저/젓가락</option>
											<option value="30">캔</option>
											<option value="31">페트</option>
											<option value="32">팩</option>
											<option value="33">커피원두</option>
											<option value="34">병</option>
											<option value="35">디저트</option>
										</select></td>
					<td align=center>
										<select name="io_code" id="io_code" value="${Code_ingredientDTO.io_nameList}">
											<option value="title" selected="selected">-선택-</option>
											<option value="1">국내산</option>
											<option value="2">뉴질랜드산</option>
											<option value="3">모리타니아산</option>
											<option value="4">미국산</option>
											<option value="5">베트남산</option>
											<option value="6">브라질산</option>
											<option value="7">중국산</option>
											<option value="8">외국산</option>
											<option value="9">칠레산</option>
											<option value="10">캐나다산</option>
											<option value="11">태국산</option>
											<option value="12">페루산</option>
											<option value="13">필리핀산</option>
										</select></td>
					<td align=center>
					<input type="text" name="i_name" value="${ingredient.i_name}"
											size=10></td>
					<td align=center>
					<input type="text" name="i_size" value="${ingredient.i_size}"
											size=10></td>
					<td align=center>${ingredient.i_price}</td>
					<td align=center>${ingredient.reg_date}</td>
					<td align=center>${ingredient.is_del}</td>
				</tr>
		</c:forEach>
			</tbody>
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