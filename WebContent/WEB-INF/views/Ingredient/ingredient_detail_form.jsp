<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Ingredient/ingredient_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공유관리</title>
	</head>
	<body id="page-top">      
	<div id="all_mask"></div>  
      <div class="window"></div>
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		</nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
	
					<!-- Breadcrumbs-->
					<ol class="breadcrumb"></ol>
					
					<!-- DataTables Example -->
					<form name="ingredient_detail_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i>  상세보기
							<span name=ingredient_detail_form style='float:right'>
								<input type="button" class="btn btn-primary update" value="식자재 수정" onClick='request_share_btn();'>
								<input type='button' class='btn btn-success' value='목록 가기' onClick='return_ingredient_btn();'>
							</span> 
							</div>
							<div class="card-body">
								<div class="table-responsive">
								<input type=hidden name=i_no value="${ingredientDTO.i_no}">
									<table class="table" id="dataTable2" width="100%" cellspacing="0">
										<tr>
											<td>식자재번호
											<td>${ingredientDTO.i_no}
										<tr>
											<td>대분류
											<td>${ingredientDTO.ia_name}
										<tr>
											<td>소분류
											<td>${ingredientDTO.ib_name}
										<tr>	
											<td>원산지
											<td>${ingredientDTO.io_name}
										<tr> 
											<td>식자재명
											<td>${ingredientDTO.i_name}
										<tr> 
											<td>수량
											<td>${ingredientDTO.i_size}
										<tr> 
											<td>입/출고 여부
											<td>${ingredientDTO.i_price}
										<tr> 
											<td>등록일
											<td>${ingredientDTO.reg_date}
									</table>
								</div>
							</div>
								</form>
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