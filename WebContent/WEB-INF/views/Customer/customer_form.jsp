<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Customer/customer_js.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객관리</title>
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
							<i class="fas fa-table"></i> 고객 현황
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
											<td align=center resize=3><b>고객 번호</b></td>
											<td align=center><b>핸드폰</b></td>
											<td align=center><b>성별</b></td>
											<td align=center><b>나이대</b></td>
											<td align=center><b>주문시간</b></td>
											<td align=center><b>픽업시간</b></td>
										</tr>
									</thead>
								<c:forEach items="${customer_list}" var="customer" varStatus="loopTagStatus">
									<tbody>
										<tr>
											<td align=center><b>${loopTagStatus.index+1}</b></td>
											<td align=center><b>${customer.c_phone}</b></td>
											<td align=center><b>${customer.gender}</b></td>
											<td align=center><b>${customer.age}대</b></td>
											<td align=center><b>${customer.order_time}</b></td>
											<td align=center><b>${customer.pickup_time}</b></td>
										</tr>
									</tbody>
											</c:forEach>
								</table>
							</div>
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