<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resources/IDA/user_js.jsp" %>
<!DOCTYPE html>

<!-- javascript 파일 수입 -->
<script src="${cr}/resources/Order/order.js" type="text/javascript"></script>

<script>
	$(document).ready(function(){
		$("body").attr("background", order_bg_img);
		setDataTable('#dataTable');
		
		$(".insert").click(function(){
			insert_order_reg("${cr}");
		});
		
		$(".update").click(function(){
			location.replace("${cr}/order_update_form.ida");
		});
	
		$(".delete").click(function(){
			location.replace("${cr}/order_delete_form.ida");
		});
		
		$("[name=insertOrderForm] [name=c_phone]").keyup(function(){
			var str = new String($(this).val());
			str = str.replace("-", "");
			$(this).val(str);
		});
	});
	
	function append_menu_tr_btn(){
		var tableObj = $("#insertOrderTable");
		var lastTrObj = tableObj.find("tr").last();
		
		tableObj.append( '<tr><th>메뉴<th>'+
				'<select name=mi_name'+$("[name=mi_name]").index()+'>'+
				'<c:forEach items="${menu_listDTO.mi_nameList}" var="mi_nameList">'+
					'<option value="${mi_nameList.mi_name}">${mi_nameList.mi_name}</option>'+
				'</c:forEach>'+
			'</select><th>수량<th><input type="text" name=quantity'+$("[name=quantity]").index()+'>' );
		return;
	}
	
	function remove_menu_tr_btn(){
		var tableObj = $("#insertOrderTable");
		var tableTrsObj = tableObj.find("tr");
		
		var lastTrObj = tableObj.find("tr").last();

		if(tableTrsObj.length>3){
			lastTrObj.remove();
		}
	}
</script>