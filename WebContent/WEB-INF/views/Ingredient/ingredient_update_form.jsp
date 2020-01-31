<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Ingredient/ingredient_update_js.jsp"%>
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
					<!-- Breadcrumbs-->
					<ol class="breadcrumb"></ol>
	
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 식자재 수정 
							<span style='float: right'>
								<button type="button" class="btn btn-primary update" value="수정완료">수정완료 </button>
							</span>
						</div>
						
						<div class="card-body">
							<table class="table" id="dataTable">
								<thead>
									<tr>
										<td align=center><b>번호</b></td>
										<td align=center><b>대분류</b></td>
										<td align=center><b>소분류</b></td>
										<td align=center><b>원산지</b></td>
										<td align=center><b>식자재명</b></td>
										<td align=center><b>규격</b></td>
										<td align=center><b>가격(원)</b></td>
										<td align=center><b>등록일</b></td>
									</tr>
								</thead>
								<tbody>
									<form:form name="updateIngForm" modelAttribute="ingredient_list">
										<c:forEach items="${ingredient_list}" var="ingredient">
											<tr class="ingredient_list_tr" style="cursor:pointer">
												<td align=center>
												<td>
													<form:hidden path="" name="i_no" value="${ingredient.i_no}"/>
													<select name="ia_name">
														<c:forEach items="${ingredient.ia_nameList}" var="ia_nameList" varStatus="loopTagStatus">
															<option value="${ia_nameList.ia_name}"
															${ingredient.ia_name == ia_nameList.ia_name ? 'selected="selected"' : '' }
															>${ia_nameList.ia_name}</option>
														</c:forEach>
													</select>
													
												<td>
													<select name="ib_name">
														<c:forEach items="${ingredient.ib_nameList}" var="ib_nameList" varStatus="loopTagStatus">
															<option value="${ib_nameList.ib_name}"
															${ingredient.ib_name == ib_nameList.ib_name ? 'selected="selected"' : '' }
															>${ib_nameList.ib_name}</option>
														</c:forEach>
													</select>
													
												<td>
													<select name="io_name">
														<c:forEach items="${ingredient.io_nameList}" var="io_nameList" varStatus="loopTagStatus">
															<option value="${io_nameList.io_name}"
															${ingredient.io_name == io_nameList.io_name ? 'selected="selected"' : '' }
															>${io_nameList.io_name}</option>
														</c:forEach>
													</select>
												<td>
													<form:input path="" name="i_name" value="${ingredient.i_name}"/>
												<td>
													<form:input path="" name="i_size" value="${ingredient.i_size}"/> 
												<td>
													<form:input path="" name="i_price" value="${ingredient.i_price}"/> 
												<td align=center>${ingredient.reg_date} 
											</tr>
										</c:forEach>
									</form:form>
								</tbody>
							</table>
						</div>
						
						<div class="card-footer small text-muted"></div>
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