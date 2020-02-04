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
		<title>재고 공유 승인 현황</title>
	</head>
	<body id="page-top">
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<form name="my_share_approve_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i> 내 매장 재고 공유 승인 현황
								<span style='float:right'></span>
							</div>
							<div class="card-body">
								<div class="tableXe-responsive">
									<table class="table" id="dataTable2">
										<thead>
											<tr>
												<td align=center><b>등록번호</b></td>
												<td align=center><b>요청매장명</b></td>
												<td align=center><b>요청매장주소</b></td>
												<td align=center><b>요청매장연락처</b></td>
												<td align=center><b>대분류</b></td>
												<td align=center><b>소분류</b></td>
												<td align=center><b>원산지</b></td>
												<td align=center><b>식자재명</b></td>
												<td align=center><b>수량</b></td>
												<td align=center><b>입/출고 여부</b></td>
												<td align=center><b>등록일</b></td>
												<td align=center><b>요청일</b></td>
												<td align=center><b>승인일</b></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${my_share_approve_list}" var="my_share_approve" varStatus="loopTagStatus">
												<tr style="cursor:pointer" onClick="share_request_content(${my_share_approve.si_no})">
													<td align=center>${loopTagStatus.index+1}
														<input type="hidden" name="si_no" value="${my_share_approve.si_no}">
													<td align=center>${my_share_approve.com_name}
													<td align=center>${my_share_approve.city}
														<c:if test="${my_share_approve.gun!=''}">
															&nbsp;${my_share_approve.gun}
														</c:if>
														<c:if test="${my_share_approve.gu!=''}">
															&nbsp;${my_share_approve.gu}
														</c:if>
														<c:if test="${my_share_approve.dong!=''}">
															&nbsp;${my_share_approve.dong}
														</c:if>
														<c:if test="${my_share_approve.ri!=''}">
															&nbsp;${my_share_approve.ri}
														</c:if>
														<c:if test="${my_share_approve.addr_detail!=''}">
															&nbsp;${my_share_approve.addr_detail}
														</c:if>
													<td align=center>${my_share_approve.s_phone}
													<td align=center>${my_share_approve.ia_name}
													<td align=center>${my_share_approve.ib_name}
													<td align=center>${my_share_approve.io_name}
													<td align=center>${my_share_approve.i_name}
													<td align=center>${my_share_approve.si_quantity}
													<td align=center>${my_share_approve.sr_state}
													<td align=center>${my_share_approve.reg_date}
													<td align=center>${my_share_approve.r_reg_date}
													<td align=center>${my_share_approve.a_reg_date}
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
					<form name="different_share_approve_form">
						<div class="card mb-3">
							<div class="card-header different_share_table_title_form">
								<i class="fas fa-table"></i> 타 매장 재고 공유 승인 현황
								<span style='float:right'></span>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table" id="dataTable">
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
												<td align=center><b>요청일</b></td>
												<td align=center><b>승인일</b></td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${different_share_approve_list}" var="different_share_approve" varStatus="loopTagStatus">
												<tr style="cursor:pointer">
													<td align=center>${loopTagStatus.index+1}
														<input type="hidden" name="si_no" value="${my_share.si_no}">
													<td align=center>${different_share_approve.com_name}
													<td align=center>${different_share_approve.city}
														<c:if test="${different_share_approve.gun!=''}">
															&nbsp;${different_share_approve.gun}
														</c:if>
														<c:if test="${different_share_approve.gu!=''}">
															&nbsp;${different_share_approve.gu}
														</c:if>
														<c:if test="${different_share_approve.dong!=''}">
															&nbsp;${different_share_approve.dong}
														</c:if>
														<c:if test="${different_share_approve.ri!=''}">
															&nbsp;${different_share_approve.ri}
														</c:if>
													<td align=center>${different_share_approve.ia_name}
													<td align=center>${different_share_approve.ib_name}
													<td align=center>${different_share_approve.io_name}
													<td align=center>${different_share_approve.i_name}
													<td align=center>${different_share_approve.si_quantity}
													<td align=center>${different_share_approve.sr_state}
													<td align=center>${different_share_approve.reg_date}
													<td align=center>${different_share_approve.r_reg_date}
													<td align=center>${different_share_approve.a_reg_date}
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