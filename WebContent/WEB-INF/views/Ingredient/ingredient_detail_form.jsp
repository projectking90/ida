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
		<title>식자재 수정</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<form name="ingredient_detail_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i> 상세보기
								<span style='float:right'>
									<input type="button" class="btn btn-primary update" value="식자재 수정">
									<input type='button' class='btn btn-success' value='목록 가기' onClick='return_ingredient_btn();'>
								</span> 
							</div>
							
							<div class="card-body">
								<div class="table-responsive">
									<input type="hidden" name="s_no" value="${ingredientDTO.s_no}">
									<input type="hidden" name="i_no" value="${ingredientDTO.i_no}">
									<table class="table" id="dataTable2">
										<tr class="ingredient_list_tr" style="cursor:pointer">
										<tr>
											<td>대분류
											<td>
												<select name="ia_name">
													<c:forEach items="${ingredientDTO.ia_nameList}" var="ia_name_list" varStatus="loopTagStatus">
														<option value="${ia_name_list.ia_name}"
														${ingredientDTO.ia_name == ia_name_list.ia_name ? 'selected="selected"' : '' }
														>${ia_name_list.ia_name}</option>
													</c:forEach>
												</select>
										<tr>
											<td>소분류
											<td>
												<select name="ib_name">
													<c:forEach items="${ingredientDTO.ib_nameList}" var="ib_name_List" varStatus="loopTagStatus">
														<option value="${ib_name_List.ib_name}"
														${ingredientDTO.ib_name == ib_name_List.ib_name ? 'selected="selected"' : '' }
														>${ib_name_List.ib_name}</option>
													</c:forEach>
												</select>
										<tr>	
											<td>원산지
											<td>
												<select name="io_name">
													<c:forEach items="${ingredientDTO.io_nameList}" var="io_name_List" varStatus="loopTagStatus">
														<option value="${io_name_List.io_name}"
														${ingredientDTO.io_name == io_name_List.io_name ? 'selected="selected"' : '' }
														>${io_name_List.io_name}</option>
													</c:forEach>
												</select>
										<tr> 
											<td>식자재명
											<td>
												<input type="text" name="i_name" value="${ingredientDTO.i_name}">
										<tr> 
											<td>규격
											<td>
												<input type="text" name="i_size"value="${ingredientDTO.i_size}">
										<tr> 
											<td>가격
											<td>
												<input type="text" name="i_price" value="${ingredientDTO.i_price}">
										<tr> 
											<td>등록일
											<td>${ingredientDTO.reg_date}
										<tr>
											<td>알레르기코드
											<td>
												<form:form name="ingredientCheckForm" commandName="code_ingredientDTO">
													<form:checkboxes path="a_name" 
													items="${code_ingredientDTO.a_nameList}" itemLabel="a_name" itemValue="a_name" />
												</form:form>
									</table>
								</div>
							</div>
							<div class="card-footer small text-muted"></div>
						</div>
					</form>
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