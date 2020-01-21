<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Stock/stock_analysis_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>재고 분석</title>
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
					
					<div class="text-center">
						<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="검색어를 입력하세요" aria-label="Search" aria-describedby="basic-addon2">
								
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</form>
					</div>
			
					<div class="text-right">
						<input type="checkbox" value="주"><b>주</b>&nbsp;
						<input type="checkbox" value="월"><b>월</b>&nbsp;
						<input type="checkbox" value="시간"><b>시간</b>&nbsp;
						<input type="checkbox" value="분기"><b>분기</b>
					</div>
	
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> 재고 분석
							<span name='stock_analysis_btn' style='float:right'>
								<button type="button" class="btn btn-primary s_chart">재고 차트</button>
							</span>
						</div>
						
						<div class="card-body">
						<div class="table-responsive">
								<table class="table" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>재고번호
											<th>대분류
											<th>소분류
											<th>원산지
											<th>식자재명
											<th>규격
											<th>재고수량
											<th>가격(원)
											<th>날짜
										</tr>
									</thead>
									
									<tbody>
										<c:forEach items="${stock_anl_list}" var="stock_anl_list" varStatus="loopTagStatus">
											<tr>
												<th>
													<input type="hidden" name="st_no" value="${stock_anl_list.st_no}">
													${loopTagStatus.index+1}
												<th>${stock_anl_list.ia_name}
												<th>${stock_anl_list.ib_name}
												<th>${stock_anl_list.io_name}
												<th>${stock_anl_list.i_name}
												<th>${stock_anl_list.i_size}
												<th>${stock_anl_list.quantity}
												<th>${stock_anl_list.i_price}
												<th>${stock_anl_list.reg_date}
											</tr>
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