<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Order/order_analysis_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문 분석</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		</nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
	
					<!-- Breadcrumbs-->
					<ol class="breadcrumb"></ol>
			
					<table><tr height=10><td></table>
					
					<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0" name="orderAnalysisForm" 
						method="post" action="/ida/order_analysis_form.ida">
						<div class="text-center">
								<div class="input-group">
									<input type="text" class="form-control" name="keyword" placeholder="검색어를 입력하세요" aria-label="Search" aria-describedby="basic-addon2">
									
									<button class="btn btn-primary list" type="button">
										<i class="fas fa-search"></i>
									</button>
								</div>
						</div>
				
						<div class="text-right">
							<input type="checkbox" value="주" name="search_condition"><b>주</b>&nbsp;
							<input type="checkbox" value="월" name="search_condition"><b>월</b>&nbsp;
							<input type="checkbox" value="시간" name="search_condition"><b>시간</b>&nbsp;
							
							<input type="checkbox" value="분기" name="search_condition"><b>분기</b>&nbsp;
							<b>성별 : </b> 
							<input type="checkbox" value="남자" name="search_condition"><b>남</b>&nbsp;
							<input type="checkbox" value="여자" name="search_condition"><b>여</b>&nbsp;
							<b>나이대 : </b>
							<input type="checkbox" value="10" name="search_condition"><b>10대</b>
							<input type="checkbox" value="20" name="search_condition"><b>20대</b>
							<input type="checkbox" value="30" name="search_condition"><b>30대</b>
							<input type="checkbox" value="40" name="search_condition"><b>40대</b>
							<input type="checkbox" value="50" name="search_condition"><b>50대</b>
							<input type="checkbox" value="60" name="search_condition"><b>60대</b>
						</div>
					</form>
	
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 주문 분석
							<span name='order_analysis_btn' style='float:right'>
								<button type="button" class="btn btn-primary o_chart">주문 차트</button>
							</span>
						</div>
						
						<div class="card-body">
						<div class="table-responsive">
								<table class="table" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>주문번호
											<th>핸드폰
											<th>주문메뉴
											<th>성별
											<th>나이대
											<th>주문시간
											<th>픽업시간
										</tr>
									</thead>
									
									<tbody>
										<c:forEach items="${order_list}" var="order" varStatus="loopTagStatus">
											<tr>
												<td align=center>${order.oi_no}
												<td align=center>${order.c_phone}
												<td align=center>${order.order_menus}
												<td align=center>${order.gender}
												<td align=center>${order.age}대
												<td align=center>${order.order_time}
												<td align=center>${order.pickup_time}
										</c:forEach>
									</tbody>
									
								</table>
							</div>
						</div>
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