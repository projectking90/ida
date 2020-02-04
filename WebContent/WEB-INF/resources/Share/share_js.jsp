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
		setCardFooter("share_ingredient", "${cr}");
   });
   
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

      $.ajax({
         url:"/ida/insert_share_reg.ida"
         ,type:"post"
         ,data:$("[name=insert_share_form]").serialize()
         ,success:function(share_reg_cnt){
            if(share_reg_cnt==1 || share_reg_cnt==-3){
               alert("공유 재고가 등록되었습니다.");
               location.replace("/ida/share_form.ida");
            }else if(share_reg_cnt==-1){
               alert("공유 재고가 등록되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
            }else if(share_reg_cnt==-2){
               alert("이미 똑같은 입/출고 상태로 등록된 공유 재고입니다.");
            }else{
               alert("공유 재고가 등록되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
            }
         }
         ,error:function(){
            alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
         }
      });
   }
   // 타 매장 공유 재고 상세보기
   function different_share_content_tr(si_no){
      location.replace("${cr}/different_share_content_form.ida?si_no="+si_no);
   }

   // 내 매장 공유 재고 상세보기
   function my_share_content_tr(si_no){
      location.replace("${cr}/my_share_content_form.ida?si_no="+si_no);
   }

   // 내 매장 공유 재고 update
   function update_my_share_btn(){
      //alert($('[name=my_share_update_form]').serialize());

      var check_num = /^[0-9]*$/;
      var not_num = /^(0)[0-9]{1,}$/;
      
      if(check_num.test(($("[name=quantity]").val())==false && $("[name=quantity]").val()==0) || not_num.test($("[name=quantity]").val())==true){
         alert("수량은 1 이상의 정수로만 입력해주시기 바랍니다.");
         return;
      }
      
      $.ajax({
         url: "/ida/my_share_update_proc.ida"
         ,type : "post"
         ,data: $('[name=my_share_update_form]').serialize()
         ,success:function(share_update_cnt){
            if(share_update_cnt==1){
               alert("공유 재고가 수정되었습니다.");
               location.replace("/ida/share_form.ida");
            }else if(share_update_cnt==-1){
               alert("공유 재고가 수정되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
            }else if(share_update_cnt==-2){
               alert("이미 삭제된 공유 재고라서 수정할 수 없습니다.");
               location.replace("/ida/share_form.ida");
            }else{
               alert("공유 재고가 수정되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
            }
         }
         ,error:function(){
            alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
         }
      });
   }

   function delete_my_share_btn(){
      if(confirm("정말 삭제하겠습니까?")==false){
         return;
      }   
      $.ajax({
         url: "/ida/my_share_delete_proc.ida"
         ,type : "post"
         ,data: $('[name=share_content_form]').serialize()
         ,success:function(share_delete_cnt){
            if(share_delete_cnt==1){
               alert("공유 재고가 삭제되었습니다.");
               location.replace("/ida/share_form.ida");
            }else if(share_delete_cnt==-1){
               alert("공유 재고가 삭제되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
            }else if(share_delete_cnt==-2){
               alert("이미 삭제된 공유 재고 입니다.");
               location.replace("/ida/share_form.ida");
            }else{
               alert("공유 재고가 삭제되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
            }
         }
         ,error:function(){
            alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
         }
      });
   }

   function request_share_btn(){
      if(confirm("정말 공유를 요청하겠습니까?")==false){
         return;
      }   
      $.ajax({
         url: "/ida/request_share.ida"
         ,type : "post"
         ,data: $('[name=different_share_content_form]').serialize()
         ,success:function(share_request_cnt){
            if(share_request_cnt==1){
               alert("공유 요청이 완료되었습니다.");
               location.replace("/ida/share_form.ida");
            }else if(share_request_cnt==-1){
               alert("공유 요청을 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
            }else if(share_request_cnt==-2){
               alert("이미 요청된 공유 재고 입니다.");
            }else{
               alert("공유 요청을 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
            }
         }
         ,error:function(){
            alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
         }
      });
   }
   
	// 내 매장 공유 재고 요청 현황 상세보기
   function share_request_content(si_no, s_no){
      location.replace("${cr}/share_request_content_form.ida?si_no="+si_no+"&s_no="+s_no);
   }
   
   function approve_share_btn(){
	   if(confirm("정말 수락하겠습니까?")==false){
	         return;
	      }   
	      $.ajax({
	         url: "/ida/approve_share_reg.ida"
	         ,type : "post"
	         ,data: $('[name=share_request_content_form]').serialize()
	         ,success:function(share_approve_cnt){
	            if(share_approve_cnt==1){
	               alert("수락 완료하였습니다.");
	               location.replace("/ida/share_form.ida");
	            }else if(share_approve_cnt==-1){
	               alert("공유 재고가 수락되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
	            }else if(share_approve_cnt==-2){
	               alert("이미 수락된 공유 재고입니다.");
	            }else if(share_approve_cnt==-3){
	               alert("삭제된 공유 재고입니다.");
	            }
	         }
	         ,error:function(){
	            alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
	         }
	      });
	}
</script>