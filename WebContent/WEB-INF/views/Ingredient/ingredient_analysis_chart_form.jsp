<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Ingredient/ingredient_analysis_chart_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>식자재 분석 - 차트</title>
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
			
					
					<table><tr height=10><td></table>
	
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-fw fa-chart-area"></i>식자재 분석
							<span name='ingredient_analysis_chart_btn' style='float:right'>
								<button type="button" class="btn btn-primary i_table">식자재 표</button>
							</span>
						</div>

						<div class="card-body">
							<canvas id="myChart" width="100%" height="30"></canvas>
							<button type="button" class="btn btn-outline-info btn-sm top3">TOP 3</button>
							<button type="button" class="btn btn-outline-info btn-sm top5">TOP 5</button>
							<button type="button" class="btn btn-outline-info btn-sm top10">TOP 10</button>
							
							
					<div class="text-right">
						<select name="chart_search">
							<option value='주'>주</option>
							<option value='월'>월</option>
							<option value='시간'>시간</option>
							<option value='분기'>분기</option>
						</select>
					</div>
					<span class="week_select">
						<input type="radio" name="week" value="1">1주
						<input type="radio" name="week" value="2">2주
						<input type="radio" name="week" value="3">3주
						<input type="radio" name="week" value="4">4주
						<input type="radio" name="week" value="5">5주
					</span>
					<span class="year_select">
						<select name="year">
							<option value="2016">2016
							<option value="2017">2017
							<option value="2018">2018
							<option value="2019">2019
							<option value="2020" selected>2020
						</select>년&nbsp;
					</span>
					
					<span class="month_select">
							<select name="month">
								<option value="01" selected>01
								<option value="02">02
								<option value="03">03
								<option value="04">04
								<option value="05">05
								<option value="06">06
								<option value="07">07
								<option value="08">08
								<option value="09">09
								<option value="10">10
								<option value="11">11
								<option value="12">12
							</select>월
					</span>
						
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