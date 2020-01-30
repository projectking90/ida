<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- javascript에 관련된 jsp 파일 수입 -->
<%@ include file="/WEB-INF/resources/Ingredient/ingredient_js.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공유관리</title>
		<script>
		function update_store_reg(cr){
	var trArr = new Array();
	
	$(".ingredient_list_tr").each(function(index){
		trArr[index] = new Array();
		trArr[index].push($(this).find("[name='i_no']").val());
		trArr[index].push($(this).find("[name='ia_name']").val());
		trArr[index].push($(this).find("[name='ib_name']").val());
		trArr[index].push($(this).find("[name='io_name']").val());
		trArr[index].push($(this).find("[name='i_name']").val());
		trArr[index].push($(this).find("[name='i_size']").val());
		trArr[index].push($(this).find("[name='a_name']").val());
		trArr[index].push(withoutComma($(this).find("[name='i_price']").val()));
	});
	
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/ingredient_update_proc.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "trArr=" + trArr
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(ingredient_update_cnt){
			if(ingredient_update_cnt>=0){
				alert("수정 성공하였습니다.");
				location.replace(cr + "/ingredient_form.ida");
			}else{
				alert("수정 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}
		$(document).ready(function(){
			$('#dataTable').DataTable();
			setCardFooter("ingredient", "${cr}");
			
			$(".update").click(function(){
				update_store_reg("${cr}");
			});
		});
		</script>
	</head>
	<body id="page-top">      
	<div id="all_mask"></div>  
      <div class="window"></div>
		<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		</nav>
	
		<div id="wrapper">
			<div id="content-wrapper">
				<div class="container-fluid">
	
					<!-- Breadcrumbs-->
					<ol class="breadcrumb"></ol>
					
					<!-- DataTables Example -->
					<form name="ingredient_detail_form">
						<div class="card mb-3">
							<div class="card-header">
								<i class="fas fa-table"></i>  상세보기
							<span name=ingredient_detail_form style='float:right'>
								<input type="button" class="btn btn-primary update" value="식자재 수정">
								<input type='button' class='btn btn-success' value='목록 가기' onClick='return_ingredient_btn();'>
							</span> 
							</div>
							<div class="card-body">
								<div class="table-responsive">
								<input type=hidden name=i_no value="${ingredientDTO.i_no}">
								<table class="table" id="dataTable2">
									<tr class="ingredient_list_tr" style="cursor:pointer">
									<tr>
										<td>대분류
										<td>
											<select name="ia_name">
												<c:forEach items="${ingredientDTO.ia_nameList}" var="ia_name_list" varStatus="loopTagStatus">
													<option value="${ia_name_list.ia_name}"
													${ingredientDTO.ia_name == ia_name_list.ia_name ? 'selected="selected"' : '' }
													>${ia_name_list.ia_name}</option>
												</c:forEach>
											</select>
									<tr>
										<td>소분류
										<td>
											<select name="ib_name">
												<c:forEach items="${ingredientDTO.ib_nameList}" var="ib_nameList" varStatus="loopTagStatus">
													<option value="${ib_nameList.ib_name}"
													${ingredientDTO.ib_name == ib_nameList.ib_name ? 'selected="selected"' : '' }
													>${ib_nameList.ib_name}</option>
												</c:forEach>
											</select>
									<tr>	
										<td>원산지
										<td>
											<select name="io_name">
												<c:forEach items="${ingredientDTO.io_nameList}" var="io_nameList" varStatus="loopTagStatus">
													<option value="${io_nameList.io_name}"
													${ingredientDTO.io_name == io_nameList.io_name ? 'selected="selected"' : '' }
													>${io_nameList.io_name}</option>
												</c:forEach>
											</select>
									<tr> 
										<td>식자재명
										<td>
										<input type="text" name="i_name" value="${ingredientDTO.i_name}">
									<tr> 
										<td>규격
										<td>
										<input type="text" name="i_size"value="${ingredientDTO.i_size}">
									<tr> 
										<td>가격
										<td>
										<input type="text" name="i_price" value="${ingredientDTO.i_price}">
									<tr> 
										<td>등록일
										<td>
											${ingredientDTO.reg_date}
											
									<tr>
										<td>알레르기코드
										<td>
										
									<form:form name="ingredientCheckForm" commandName="code_ingredientDTO">
										<form:checkboxes path="a_name" 
										items="${code_ingredientDTO.a_nameList}" itemLabel="a_name" itemValue="a_name" />
									</form:form>
								</table>
								</div>
							</div>
								</form>
							<div class="card-footer small text-muted">Updated yesterday
								at 11:59 PM</div>
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