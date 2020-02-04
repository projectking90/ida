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
		<title>내 매장 재고 공유 요청 현황 상세보기</title>
	</head>
	<body id="page-top">
		<div class="window"></div>
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top"></nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
					<!-- DataTables Example -->
					<form name="share_request_content_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i> 내 매장 재고 공유 상세보기
								<span style='float:right'>
									<input type="button" class="btn btn-primary update" value="요청 수락" onClick="approve_share_btn();">
									<input type='button' class='btn btn-success' value='목록 가기' onClick='return_share_btn();'>
								</span>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<input type="hidden" name="si_no" value="${shareDTO.si_no}">
									<input type="hidden" name="s_no" value="${shareDTO.s_no}">
									<table class="table" id="dataTable2">
										<tr>
											<td align=center><b>요청매장명</b></td>
											<td>${shareDTO.com_name}
										<tr>
											<td align=center><b>요청매장주소</b></td>
											<td>${shareDTO.city}
														<c:if test="${shareDTO.gun!=''}">
															&nbsp;${shareDTO.gun}
														</c:if>
														<c:if test="${shareDTO.gu!=''}">
															&nbsp;${shareDTO.gu}
														</c:if>
														<c:if test="${shareDTO.dong!=''}">
															&nbsp;${shareDTO.dong}
														</c:if>
														<c:if test="${shareDTO.ri!=''}">
															&nbsp;${shareDTO.ri}
														</c:if>
														<c:if test="${shareDTO.addr_detail!=''}">
															&nbsp;${shareDTO.addr_detail}
														</c:if>
										<tr>
											<td align=center><b>요청매장연락처</b></td>
											<td>${shareDTO.s_phone}
										<tr>
											<td align=center><b>대분류</b></td>
											<td>${shareDTO.ia_name}
										<tr>
											<td align=center><b>소분류</b></td>
											<td>${shareDTO.ib_name}
										<tr>
											<td align=center><b>원산지</b></td>
											<td>${shareDTO.io_name}
										<tr>
											<td align=center><b>식자재명</b></td>
											<td>${shareDTO.i_name}
										<tr>
											<td align=center><b>수량</b></td>
											<td>${shareDTO.si_quantity}
										<tr>
											<td align=center><b>입/출고 여부</b></td>
											<td>${shareDTO.sr_state}
										<tr>
											<td align=center><b>등록일</b></td>
											<td>${shareDTO.reg_date}
										<tr>
											<td align=center><b>요청일</b></td>
											<td>${shareDTO.r_reg_date}
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