<!-- JSP 기술의 한 종류인 Page Directive를 이용하여 현 JSP 페이지 처리 방식 선언하기 -->
<!-- 현재 이 JSP 페이지 실행 후 생성되는 문서는 HTML이고, -->
<!-- 이 문서 안의 데이터는 UTF-8방식으로 인코딩한다라고 설정함 -->
<!-- 현재 이 JSP 페이지는 UTF-8 방식으로 인코딩한다. -->
<!-- UTF-8 인코딩 방식은 한글을 포함 전 세계 모든 문자열을 부호화할 수 있는 방법이다.-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/resources/IDA/user_js.jsp" %>
<!DOCTYPE html>

<!-- javascript 파일 수입 -->
<script src="${cr}/resources/Share/share.js" type="text/javascript"></script>
<!-- CSS 파일 수입-->
<link href="${cr}/resources/Share/share.css" rel="stylesheet">

<script>
	$(document).ready(function(){
		$('#dataTable').DataTable();
		$('#dataTable2').DataTable();
		
		//검은 막 띄우기
		$('.insert_share_btn').click(function(e){
			e.preventDefault();
			wrapWindowByMask();
		});
	
		//닫기 버튼을 눌렀을 때
		$('.window .close').click(function (e) {  
			//링크 기본동작은 작동하지 않도록 한다.
			e.preventDefault();  
			$('#all_mask, .window').hide();  
		});       
		
		//검은 막을 눌렀을 때
	/* 				$('#all_mask').click(function () {  
			$(this).hide();  
			$('.window').hide();  
		}); */      
		
		$('#all_mask').one('touchstart', function () {  
		    $(this).unbind('click');
		});
	});
	
	function wrapWindowByMask(){
		//검은색 스크린 띄우기
		var maskHeight = $(document).height();  
		var maskWidth = $(window).width();  

		//마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
		$('#page-top').attr("style", "overflow:hidden");
		$('#all_mask').css({'width':maskWidth,'height':maskHeight});  
		//애니메이션 효과 - 일단 0.01초동안 까맣게 됐다가 90% 불투명도로 간다.
		$('#all_mask').fadeIn(1);      
		$('#all_mask').fadeTo("slow",0.9); 
		// 변경 내용
		var div_tag_open_size="<div class='layer'><div class='layer_inner'><div class='content'>";
		var div_tag_open_css="<div class='card mb-3'><div class='card-header'><span style='float:left'><i class='fas fa-table'></i> 공유 재고 등록</span>"
		var btn="<span name=share_form style='float:right'><input type='button' class='btn btn-success' value='공유 재고 추가' onClick='insert_share_btn();'> <input type='button' class='btn btn-success' value='목록 가기' onClick='return_share_btn();'></span></div>";	
		var div_tag_table_css="<div class='card-body'><div class='table-responsive'>";	
			
		var table_tag_open="<table class='table table-bordered' id='dataTable' width='100%' cellspacing='0'>";
		var table_i_no_get_value="<tr><td> 식자재명 <td><select name='st_no'><c:forEach items='${stock_list}' var='stock' varStatus='loopTagStatus'><option value='${stock.st_no}'>${stock.i_name}</c:forEach>";
		var table_si_quantity_get_value="<tr><td> 수량 <td><input type='text' name='si_quantity'>";
		var table_sr_state_get_value="<tr><td> 입/출고 여부 <td><select name='sr_state'><option value='i'>입고<option value='o'>출고</select>";
		var table_deal_value="<tr><td> 조건 <td><textarea style='width:100%;  height:80%; resize:none;' name='deal'></textarea>"
		var table_tag_close="</table>"
		var div_tag_close="</div></div></div></div></div></div></div></div>";

		$('#all_mask').prepend("<form name='insert_share_form'>"+div_tag_open_size+div_tag_open_css+btn+div_tag_table_css+table_tag_open+table_i_no_get_value+table_si_quantity_get_value+table_sr_state_get_value
				+table_deal_value+	table_tag_close+div_tag_close+"</form>");
		
		//윈도우 같은 거 띄운다.
		$('.window').show();
	}

	function return_share_btn(){
		location.replace("${cr}/share_form.ida");
	}

	function insert_share_btn(){
		if($("[name=si_quantity]").val()==""){
			alert("수량을 입력해주시기 바랍니다.");
			return;
		}

		var check_num = /^[0-9]*$/;
		var not_num = /^(0)[0-9]{1,}$/;
		
		if(check_num.test($("[name=si_quantity]").val())==false || not_num.test($("[name=si_quantity]").val())==true){
			alert("0 이상의 정수로만 입력해주시기 바랍니다.");
			return;
		}

		//alert($("[name=insert_share_form]").serialize());
		$.ajax({
			url:"/ida/insert_share_reg.ida"
			,type:"post"
			,data:$("[name=insert_share_form]").serialize()
			,success:function(share_reg_cnt){
				//alert(stock_reg_cnt);
				if(share_reg_cnt==1){
					alert("공유 재고가 등록되었습니다.");
					location.replace("/ida/share_form.ida");
				}else if(share_reg_cnt==-1){
					alert("공유 재고가 등록되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
				}else if(share_reg_cnt==-2){
					alert("이미 똑같은 입/출고 상태로 등록된 공유 재고입니다.");
				}
			}
			,error:function(){
				alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
			}
		});
	}
	// 타 매장 공유 현황 중 원하는 행 자세히 보기
	function different_share_content_tr(si_no){
		var str="si_no="+si_no+"&"+$('[name=different_share_form]').serailize();
	}

	// 내 매장 공유 현황 중 원하는 행 자세히 보기
	function my_share_content_tr(si_no){
		var str="si_no="+si_no+"&"+$('[name=my_share_form]').serailize();
		
	}
</script>