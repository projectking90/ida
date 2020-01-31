<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resources/IDA/user_js.jsp" %>
<!DOCTYPE html>

<!-- javascript 파일 수입 -->
<script src="${cr}/resources/Stock/stock_analysis_chart.js" type="text/javascript"></script>

<script>
	$(document).ready(function(){
		$("body").attr("background", stock_bg_img);
		$(".month").hide();
		$(".year").hide();

		getChartData("${cr}", $("[name=chart_search]").val(), $("[name=week]").val(), $("[name=month]").val(), $("[name=year]").val(), $("[name=quarter]").val());
		
		$("[name=chart_search]").change(function(){
			//getChartData("${cr}", $(this).val(), $("[name=week]:checked").val(), $("[name=month]").val(), $("[name=year]").val());
			getChartData("${cr}", $(this).val(), $("[name=week]").val(), $("[name=month]").val(), $("[name=year]").val(),  $("[name=quarter]").val());
		});
		
		$("[name=week]").change(function(){
			//alert($(this).val());
			getChartData("${cr}", $("[name=chart_search]").val(), $(this).val(), $("[name=month]").val(), $("[name=year]").val(),  $("[name=quarter]").val());
		});
		
		$("[name=month]").change(function(){
			//alert($(this).val());
			getChartData("${cr}", $("[name=chart_search]").val(), $("[name=week]").val(),  $(this).val(), $("select[name=year]").val(),  $("[name=quarter]").val());
		});
		
		$("[name=year]").change(function(){
			//alert($(this).val());
			getChartData("${cr}", $("[name=chart_search]").val(), $("[name=week]").val(), $("select[name=month]").val(), $(this).val(),  $("[name=quarter]").val());
		});
		
		$("[name=quarter]").change(function(){
			getChartData("${cr}", $("[name=chart_search]").val(), $("[name=week]").val(), $("[name=month]").val(),  $("[name=year]").val(), $(this).val());
		});
		
		$(".s_table").click(function(){
			location.replace("${cr}/stock_analysis_form.ida");
		});
	});
</script>