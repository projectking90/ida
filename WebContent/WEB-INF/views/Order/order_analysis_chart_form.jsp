<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Order/order_analysis_chart_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>주문 분석 - 차트</title>
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
						<select name="chart_search">
							<option value='주'>주
							<option value='월'>월
							<option value='시간'>시간
							<option value='분기'>분기
							<option value='성별'>성별
							<option value='나이대'>나이대
						</select>
					</div>
					
					<table><tr height=10><td></table>	
					
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-fw fa-chart-area"></i>주문 분석 차트
							<span name='order_analysis_chart_btn' style='float:right'>
								<button type="button" class="btn btn-primary o_table">주문 표</button>
							</span>
						</div>
						
						<div class="card-body">
							<canvas id="myChart" width="100%" height="30"></canvas>
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