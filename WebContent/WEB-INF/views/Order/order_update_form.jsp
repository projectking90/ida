<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Order/order_update_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문수정</title>
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
							<i class="fas fa-table"></i> 주문 수정
							<span style='float: right'>
								<button type="button" class="btn btn-primary update">주문 수정완료</button>
							</span>
						</div>
						
						<div class="card-body">
							<table class="table" id="dataTable">
								<thead>
									<tr>
										<td align=center><b>번호</b></td>
										<td align=center><b>핸드폰</b></td>
										<td align=center><b>주문메뉴</b></td>
										<td align=center><b>수량</b></td>
										<td align=center><b>성별</b></td>
										<td align=center><b>나이대</b></td>
										<td align=center><b>주문시간</b></td>
										<td align=center><b>픽업시간</b></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${order_list}" var="order">
										<tr class="order_list_tr">
											<td align=center>
											<td align=center>
												<input type="hidden" name="oi_no" value="${order.oi_no}">
												<input type="text" name="c_phone" value="${order.c_phone}">
											<td align=center>
												<select name="mi_name">
													<c:forEach items="${menu_listDTO.mi_nameList}" var="mi_nameList" varStatus="loopTagStatus">
														<option value="${mi_nameList.mi_name}" 
														${order.mi_name == mi_nameList.mi_name ? 'selected="selected"' : '' }
														>${mi_nameList.mi_name}</option>
													</c:forEach>
												</select>
											<td align=center>
												<b><input type="text" name="quantity" value="${order.quantity}"></b>
											<td align=center>
												<select name="gender">
													<option value="1" <c:if test="${order.gender == '남'}">selected</c:if> >남</option>
													<option value="2" <c:if test="${order.gender == '여'}">selected</c:if> >여</option>
												</select>
											<td align=center>
												<select name="age">
													<option value="10" <c:if test="${order.age == '10'}">selected</c:if> >10대</option>
													<option value="20" <c:if test="${order.age == '20'}">selected</c:if> >20대</option>
													<option value="30" <c:if test="${order.age == '30'}">selected</c:if> >30대</option>
													<option value="40" <c:if test="${order.age == '40'}">selected</c:if> >40대</option>
													<option value="50" <c:if test="${order.age == '50'}">selected</c:if> >50대</option>
													<option value="60" <c:if test="${order.age == '60'}">selected</c:if> >60대</option>
												</select>
											<td align=center>${order.order_time}
												<input type="hidden" name="s_id" value="${sessionScope.s_id}">
											<td align=center>
												<b><input type="text" name="pickup_time" value="${order.pickup_time}"></b>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<div class="card-footer small text-muted"></div>
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