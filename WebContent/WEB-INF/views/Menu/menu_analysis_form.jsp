<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Menu/menu_analysis_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메뉴 분석</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i>메뉴 분석
							<span style='float:right'>
								<button type="button" class="btn btn-primary m_chart">메뉴 차트</button>
							</span>
						</div>
						<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
							<div class="text-center">
								<div class="text-center">
									<div class="input-group">
										<input type="text" name="keyword" class="form-control" placeholder="검색어를 입력하세요" aria-label="Search" aria-describedby="basic-addon2">
										
										<button class="btn btn-primary list" type="button">
											<i class="fas fa-search"></i>
										</button>
									</div>
								</div>
							</div>
				
							<div class="text-right">
								<b>대분류 : </b>
								<input type="checkbox" value="한식" name="search_condition">한식&nbsp;
								<input type="checkbox" value="중식" name="search_condition">중식&nbsp;
								<input type="checkbox" value="일식" name="search_condition">일식&nbsp;
								<input type="checkbox" value="양식" name="search_condition">양식&nbsp;
								<input type="checkbox" value="분식" name="search_condition">분식&nbsp;
								<input type="checkbox" value="패스트푸드" name="search_condition">패스트푸드&nbsp;
								<input type="checkbox" value="카페" name="search_condition">카페&nbsp;
								<b>소분류 : </b>
								<input type="checkbox" value="일반" name="search_condition">일반&nbsp;
								<input type="checkbox" value="베지테리언" name="search_condition">베지테리언&nbsp;
								<input type="checkbox" value="알레르기" name="search_condition">알레르기&nbsp;
								<b>가격 : </b>
								<input type="checkbox" value="5000" name="search_condition">5000원 이상&nbsp;
								<input type="checkbox" value="10000" name="search_condition">10000원 이상&nbsp;
							</div>
						
							<div class="text-right">
								<b>대분류 : </b>
								<input type="checkbox" value="한식" name="search_condition">한식&nbsp;
								<input type="checkbox" value="중식" name="search_condition">중식&nbsp;
								<input type="checkbox" value="일식" name="search_condition">일식&nbsp;
								<input type="checkbox" value="양식" name="search_condition">양식&nbsp;
								<input type="checkbox" value="분식" name="search_condition">분식&nbsp;
								<input type="checkbox" value="패스트푸드" name="search_condition">패스트푸드&nbsp;
								<input type="checkbox" value="카페" name="search_condition">카페&nbsp;
								<b>소분류 : </b>
								<input type="checkbox" value="일반" name="search_condition">일반&nbsp;
								<input type="checkbox" value="베지테리언" name="search_condition">베지테리언&nbsp;
								<input type="checkbox" value="알레르기" name="search_condition">알레르기&nbsp;
								<b>가격 : </b>
								<input type="checkbox" value="5000" name="search_condition">5000원 이상&nbsp;
								<input type="checkbox" value="10000" name="search_condition">10000원 이상&nbsp;
							</div>
						</form>
						
						<div class="card-body">
						<div class="table-responsive">
								<table class="table" id="dataTable">
									<thead>
										<tr>
											<td align=center><b>메뉴 번호</b></td>
											<td align=center><b>대분류</b></td>
											<td align=center><b>소분류</b></td>
											<td align=center><b>메뉴이름</b></td>
											<td align=center><b>가격(원)</b></td>
											<td align=center><b>설명</b></td>
											<td align=center><b>등록일</b></td>
											
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${menu_list}" var="menu" varStatus="loopTagStatus">
											<tr>
												<td align=center>${menu.mi_no}
												<td align=center>${menu.ma_code}
												<td align=center>${menu.mb_code}
												<td align=center>${menu.mi_name}
												<td align=center>${menu.price}
												<td align=center>${menu.mi_comment}
												<td align=center>${menu.reg_date}
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