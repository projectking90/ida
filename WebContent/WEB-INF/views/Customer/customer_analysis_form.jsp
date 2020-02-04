<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Customer/customer_analysis_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>고객 분석</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		</nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i>고객 분석
							<span style='float:right'>
								<button type="button" class="btn btn-primary c_chart">고객 차트</button>
							</span>
						</div>
						
						
						<div class="text-center">
							<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0" name="ingredientAnalysisForm" 
								method="post" action="${cr}/ingredient_analysis_form.ida">
								<div class="input-group">
									<input type="text" class="form-control" name="keyword" placeholder="검색어를 입력하세요" aria-label="Search" aria-describedby="basic-addon2">

									<button class="btn btn-primary list" type="button">
										<i class="fas fa-search"></i>
									</button>
								</div>
								
								<table><tr height=10><td></table>
				
								<div class="text-right">
									<input type="checkbox" value="week" name="search_condition"><b>주</b>&nbsp;
									<input type="checkbox" value="month" name="search_condition"><b>월</b>&nbsp;
									<input type="checkbox" value="hour" name="search_condition"><b>시간</b>&nbsp;
									<input type="checkbox" value="quarter" name="search_condition"><b>분기</b>
								</div>
							</form>
						</div>
						
						<div class="card-body">
							<div class="table-responsive">
								<table class="table" id="dataTable">
									<thead>
										<tr>
											<th>번호
											<th>핸드폰
											<th>주문메뉴
											<th>성별
											<th>나이대
											<th>주문시간
											<th>픽업시간
										</tr>
									</thead>
									
									<tbody>
										<tr>
											<td align=center>${loopTagStatus.index+1}
												<input type="hidden" name="i_no" value="${ingredient_anl_list.i_no}">
												<input type="hidden" name="s_no" value="${ingredient_anl_list.s_no}">
											<td align=center>${ingredient_anl_list.ia_name}</td>
											<td align=center>${ingredient_anl_list.ib_name}</td>
											<td align=center>${ingredient_anl_list.io_name}</td>
									</tbody>
								</table>
							</div>
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