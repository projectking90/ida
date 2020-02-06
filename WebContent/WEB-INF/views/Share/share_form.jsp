<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Share/share_js.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공유관리</title>
	</head>
	<body id="page-top">
		<div class="window"></div>
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<form name="different_share_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i> 타 매장 재고 공유 현황
								<span style='float:right'></span>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table" id="dataTable2">
										<thead>
											<tr>
												<td align=center><b>등록번호</b></td>
												<td align=center><b>매장명</b></td>
												<td align=center><b>매장주소</b></td>
												<td align=center><b>대분류</b></td>
												<td align=center><b>소분류</b></td>
												<td align=center><b>원산지</b></td>
												<td align=center><b>식자재명</b></td>
												<td align=center><b>수량</b></td>
												<td align=center><b>입/출고 여부</b></td>
												<td align=center><b>등록일</b></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${different_share_list}" var="different_share" varStatus="loopTagStatus">
												<tr style="cursor:pointer" onClick="different_share_content_tr(${different_share.si_no})">
													<td align=center>${loopTagStatus.index+1}
														<input type="hidden" name="si_no" value="${my_share.si_no}">
													<td align=center>${different_share.com_name}
													<td align=center>${different_share.city}
														<c:if test="${different_share.gun!=''}">
															&nbsp;${different_share.gun}
														</c:if>
														<c:if test="${different_share.gu!=''}">
															&nbsp;${different_share.gu}
														</c:if>
														<c:if test="${different_share.dong!=''}">
															&nbsp;${different_share.dong}
														</c:if>
														<c:if test="${different_share.ri!=''}">
															&nbsp;${different_share.ri}
														</c:if>
														<c:if test="${different_share.addr_detail!=''}">
															&nbsp;${different_share.addr_detail}
														</c:if>
													<td align=center>${different_share.ia_name}
													<td align=center>${different_share.ib_name}
													<td align=center>${different_share.io_name}
													<td align=center>${different_share.i_name}
													<td align=center>${different_share.si_quantity}
													<td align=center>${different_share.sr_state}
													<td align=center>${different_share.reg_date}
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<div class="card-footer small text-muted">Updated yesterday
								at 11:59 PM</div>
						</div>
					</form>
	
					<!--추가-->
					<form name="my_share_form">
						<div class="card mb-3">
							<div class="card-header my_share_table_title_form">
								<i class="fas fa-table"></i> 내 매장 재고 공유 현황
								<span style='float:right'></span>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table" id="dataTable">
										<thead>
											<tr>
												<td align=center><b>등록번호</b></td>
												<td align=center><b>대분류</b></td>
												<td align=center><b>소분류</b></td>
												<td align=center><b>원산지</b></td>
												<td align=center><b>식자재명</b></td>
												<td align=center><b>수량</b></td>
												<td align=center><b>입/출고 여부</b></td>
												<td align=center><b>등록일</b></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${my_share_list}" var="my_share" varStatus="loopTagStatus">
												<tr style="cursor:pointer" onClick="my_share_content_tr(${my_share.si_no})">
													<td align=center>${loopTagStatus.index+1}
														<input type="hidden" name="si_no" value="${my_share.si_no}">
													<td align=center>${my_share.ia_name}
													<td align=center>${my_share.ib_name}
													<td align=center>${my_share.io_name}
													<td align=center>${my_share.i_name}
													<td align=center>${my_share.si_quantity}
													<td align=center>${my_share.sr_state}
													<td align=center>${my_share.reg_date}
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<div class="card-footer small text-muted">Updated yesterday
								at 11:59 PM</div>
						</div>
					</form>
					
					<!--추가-->
					<form name="insert_share_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i> 공유 재고 추가 
								<span style='float: right'> 
									<input type='button' class="btn btn-success insert" value='재고 추가' onClick="insert_share_btn();">
								</span>
							<br>
							</div>
							<div class="card-body">
								<table class="table" id="dataTable">
									<tr>
										<th>식자재명
										<th>
											<select name='st_no'>
												<c:forEach items='${stock_list}' var='stock' varStatus='loopTagStatus'>
													<option value='${stock.st_no}'>${stock.i_name}
												</c:forEach>
											</select>
									<tr>
										<th>수량
										<th><input type="text" name="si_quantity" class="si_quantity">
									<tr>
										<th>상태
										<th>
											<select name="sr_state" class="sr_state">
													<option value='i'>입고희망
													<option value='o'>출고
											</select>
									<tr>
										<th> 조건
										<th><textarea style='width:100%;  height:80%; resize:none;' name='deal'></textarea>
								</table>
							</div>
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