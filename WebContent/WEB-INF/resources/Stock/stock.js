function insert_stock_reg(cr){
	if($("[name=quantity]").val()==""){
		alert("수량을 입력해주시기 바랍니다.");
		return;
	}

	var check_num = /^[0-9]*$/;
	var not_num = /^(0)[0-9]{1,}$/;
	
	if(check_num.test($("[name=quantity]").val())==false || not_num.test($("[name=quantity]").val())==true){
		alert("0 이상의 정수로만 입력해주시기 바랍니다.");
		return;
	}
	
	$.ajax({
		url: cr + "/insert_stock_reg.ida"
		, type:"post"
		, data:$("[name=insert_stock_form]").serialize()
		, success:function(stock_reg_cnt){
			//alert(stock_reg_cnt);
			if(stock_reg_cnt==1){
				alert("재고가 등록되었습니다.");
				location.replace(cr + "/stock_form.ida");
			}else if(stock_reg_cnt==-1){
				alert("재고가 등록되지 않았습니다. 관리자에게 문의해주시기 바랍니다.");
			}else if(stock_reg_cnt==-2){
				alert("이미 등록된 재고입니다.");
			}else if(stock_reg_cnt==-3){
				alert("재고가 등록되었습니다.");
				location.replace(cr + "/stock_form.ida");
			}
		}
		,error:function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function delete_stock_reg(cr){
	var trArr = new Array();
	$(".stock_list_tr").each(function(index){
		if($(this).find("[name='delete_stock']").prop("checked")==true){
			trArr.push($(this).find("[name='delete_stock']").val());
			if(trArr[index]==""){
				trArr[index].splice(index, 1);
			}
		}
	});
	
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/stock_delete_proc.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "trArr=" + trArr
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(stock_delete_cnt){						
			if(stock_delete_cnt>=0){
				alert("삭제 성공하였습니다.");
				location.replace(cr + "/stock_form.ida");
			}else{
				alert("삭제 실패하였습니다. 관리자에게 문의해주시기 바랍니다.");
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

/**
 * DataTable Setting
 */
function setDataTable(table_id){
	var dt = $(table_id).DataTable({
		"columnDefs" : [
			{"searchable" : false, "orderable" : false, "targets" : 0}
		]
		,"order": [[9, "asc"]]
	});
	
	dt.on( 'order.dt search.dt', function () {
		dt.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
			cell.innerHTML = i+1;
		} );
	} ).draw();
}