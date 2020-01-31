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
		<title>식자재 관리</title>
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
							<i class="fas fa-table"></i> 식자재 현황
							<span style='float:right'>
								<button type="button" class="btn btn-primary update"> 식자재 수정 </button>
								<button type="button" class="btn btn-danger delete"> 식자재 삭제 </button>
							</span>
						</div>
						
						<div class="card-body">
							<div class="table-responsive">
								<form name="IngredientForm" method="post" action="${cr}/ingredient.ida">
									<table class="table" id="dataTable">
										<thead>
											<tr>
												<td align=center><b>번호</b></td>
												<td align=center><b>대분류</b></td>
												<td align=center><b>소분류</b></td>
												<td align=center><b>원산지</b></td>
												<td align=center><b>이름</b></td>
												<td align=center><b>규격</b></td>
												<td align=center><b>가격(원)</b></td>
												<td align=center><b>등록일</b></td>
												<td align=center><b>삭제</b></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${ingredient_list}" var="ingredient">
												<tr class="ingredient_list_tr" style="cursor:pointer" onClick="goIngredientDetailForm(${ingredient.i_no});">
													<td align=center>
													<td align=center>${ingredient.ia_name}</td>
													<td align=center>${ingredient.ib_name}</td>
													<td align=center>${ingredient.io_name}</td>
													<td align=center>${ingredient.i_name}</td>
													<td align=center>${ingredient.i_size}</td>
													<td align=right>${ingredient.i_price}</td>
													<td align=center>${ingredient.reg_date}</td>
													<td align=center onclick="event.cancelBubble=true;">
														<input type="checkbox" name="delete_ingredient" value="${ingredient.i_no}">
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
							</div>
						</div>
						
						<div class="card-footer small text-muted"></div>
					</div>
	
					<!--추가-->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 식자재 추가
							<span style='float:right'>
								<button type="button" class="btn btn-success insert">식자재 추가</button>
							</span>
						</div>
						
						<div class="card-body">
							<form name="insertIngForm" method="post" action="${cr}/ingredient_insert.ida">
								<table class="table table-bordered" id="insertIngredientTable">
									<tr>
										<th>대분류
										<th>
											<select name="ia_name">
												<c:forEach items="${code_ingredientDTO.ia_nameList}" var="ia_nameList">
													<option value="${ia_nameList.ia_name}">${ia_nameList.ia_name}</option>
												</c:forEach>
											</select>
									<tr>
										<th>소분류
										<th>
											<select name="ib_name">
												<c:forEach items="${code_ingredientDTO.ib_nameList}" var="ib_nameList">
													<option value="${ib_nameList.ib_name}">${ib_nameList.ib_name}</option>
												</c:forEach>
											</select>
									<tr>
										<th>원산지
										<th>
											<select name="io_name">
												<c:forEach items="${code_ingredientDTO.io_nameList}" var="io_nameList">
													<option value="${io_nameList.io_name}">${io_nameList.io_name}</option>
												</c:forEach>
											</select>
									<tr>
										<th>식자재명
										<th><input type="text" name="i_name">
									<tr>
										<th>규격
										<th><input type="text" name="i_size">
									<tr>
										<th>매입가격
										<th><input type="text" name="i_price">
									<tr>
										<th>알레르기코드
										<th>
											<form:form name="ingredientCheckForm" commandName="code_ingredientDTO">
												<form:checkboxes path="a_name" items="${code_ingredientDTO.a_nameList}" itemLabel="a_name" itemValue="a_name" />
											</form:form>
								</table>
							</form>
						</div>
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