<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Log를 직접 남기기 위해서 log4j 라이브러리 수입 -->
<%@ page import="org.apache.log4j.*" %>
<!-- JSP 페이지에서 사용할 사용자 정의 태그인 JSTL의 C코어 태그 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- JSP 페이지에서 사용할 사용자 정의 태그인 spring 폼 태그 선언 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<!-- JSTL의 C코어 태그를 사용하여 변수들을 선언 -->
<!-- ContextRoot명 저장 -->
<c:set var="cr" value="/ida"/>

<!-- JQuery 라이브러리 파일 수입 -->
<script src="${cr}/resources/IDA/jquery-1.11.0.min.js" type="text/javascript"></script>
<!-- CSS파일 수입 -->
<%-- <link href="${cr}/resources/IDA/common.css" rel="stylesheet" type="text/css"> --%>
<!-- javascript 파일 수입 -->
<script src="${cr}/resources/IDA/common.js" type="text/javascript"></script>

<script>
	$(document).ready(function(){
		titleBars();
		setSidebars();
		setLogoutFunc();
	});
	
	/**
	* Titlebar Setting
	*/
	function titleBars(){
		$(".navbar").prepend('<a class="navbar-brand mr-1" href="${cr}/order_form.ida">IDA</a>');
		$(".navbar").append('<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>');
		
		$(".navbar").append('<ul class="navbar-nav ml-auto mr-0 mr-md-3 my-2 my-md-0"></ul>');
		$(".navbar-nav").append('<a class="navbar-brand mr-1" href="#">${sessionScope.s_id}</a>');
		$(".navbar-nav").append('<li class="nav-item dropdown no-arrow"></li>');
		$(".navbar-nav").find('li').append('<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-circle fa-fw"></i></a>');
		$(".navbar-nav").find('li').append('<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown"></div>');
		$(".dropdown-menu").append('<a class="dropdown-item" href="${cr}/user_info_update_form.ida">회원정보변경</a>');
		$(".dropdown-menu").append('<div class="dropdown-divider"></div>');
		$(".dropdown-menu").append('<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>');
		
	}
	
	/**
	* Sidebar Setting
	*/
	function setSidebars(){
		$("#wrapper").prepend('<ul class="sidebar navbar-nav toggled"></ul>');
		
		$(".sidebar").append('<li class="nav-item dropdown order_side"></li>');
		$(".sidebar").append('<li class="nav-item dropdown menu_side"></li>');
		$(".sidebar").append('<li class="nav-item dropdown ingredient_side"></li>');
		$(".sidebar").append('<li class="nav-item dropdown stock_side"></li>');
		$(".sidebar").append('<li class="nav-item dropdown customer_side"></li>');
		
		$(".order_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
		$(".order_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
		$(".order_side").find('a').append('<i class="fas fa-bars"></i> <span>주문</span>');
		$(".order_side").find('div').append('<a class="dropdown-item" href="${cr}/order_form.ida"><i class="fas fa-fw fa-table"></i>주문관리</a>');
		$(".order_side").find('div').append('<a class="dropdown-item" href="charts.html"><i class="fas fa-fw fa-chart-area"></i>주문분석</a>');
		
		$(".menu_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
		$(".menu_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
		$(".menu_side").find('a').append('<i class="fas fa-bars"></i> <span>메뉴</span>');
		$(".menu_side").find('div').append('<a class="dropdown-item" href="${cr}/menu_form.ida"><i class="fas fa-fw fa-table"></i>메뉴관리</a>');
		$(".menu_side").find('div').append('<a class="dropdown-item" href="charts.html"><i class="fas fa-fw fa-chart-area"></i>메뉴분석</a>');
		
		$(".ingredient_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
		$(".ingredient_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
		$(".ingredient_side").find('a').append('<i class="fas fa-bars"></i> <span>식자재</span>');
		$(".ingredient_side").find('div').append('<a class="dropdown-item" href="${cr}/ingredient_form.ida"><i class="fas fa-fw fa-table"></i>식자재관리</a>');
		$(".ingredient_side").find('div').append('<a class="dropdown-item" href="charts.html"><i class="fas fa-fw fa-chart-area"></i>식자재분석</a>');
		
		$(".stock_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
		$(".stock_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
		$(".stock_side").find('a').append('<i class="fas fa-bars"></i> <span>재고</span>');
		$(".stock_side").find('div').append('<a class="dropdown-item" href="${cr}/stock_form.ida"><i class="fas fa-fw fa-table"></i>재고관리</a>');
		$(".stock_side").find('div').append('<a class="dropdown-item" href="charts.html"><i class="fas fa-fw fa-chart-area"></i>재고분석</a>');

		$(".customer_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
		$(".customer_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
		$(".customer_side").find('a').append('<i class="fas fa-bars"></i> <span>고객</span>');
		$(".customer_side").find('div').append('<a class="dropdown-item" href="${cr}/customer_form.ida"><i class="fas fa-fw fa-table"></i>고객관리</a>');
		$(".customer_side").find('div').append('<a class="dropdown-item" href="charts.html"><i class="fas fa-fw fa-chart-area"></i>고객분석</a>');
	}
	
	/**
	* Logout Function
	*/
	function setLogoutFunc(){
		$("#logoutModal").prepend('<div class="modal-dialog logout_dialog" role="document"></div>');
		
		$(".logout_dialog").append('<div class="modal-content logout_content"></div>');
		
		$(".logout_content").append('<div class="modal-header logout_header"></div>');
		$(".logout_content").append('<div class="modal-body logout_body"></div>');
		$(".logout_content").append('<div class="modal-footer logout_footer"></div>');
		
		$(".logout_header").append('<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>');
		$(".logout_header").append('<button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>');
		
		$(".logout_body").append('정말로 로그아웃 하시겠습니까?<br>로그아웃 하시면 로그인 페이지로 돌아갑니다.');

		$(".logout_footer").append('<button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button> <a class="btn btn-primary" href="${cr}/logout_form.ida">로그아웃</a>');
	}
</script>
<%
	Logger logger = Logger.getLogger(this.getClass());
	logger.info("common.jsp 수입");
%>