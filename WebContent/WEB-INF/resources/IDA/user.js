/**
* Titlebar Setting
*/
function titleBars(cr, id){
	$(".navbar").prepend('<a class="navbar-brand mr-1" href="#"><i class="fas fa-chart-bar"></i> IDA</a>');
	$(".navbar").append('<ul class="navbar-nav ml-auto mr-0 mr-md-3 my-2 my-md-0"></ul>');
	
	$(".navbar-nav").append('<a class="navbar-brand mr-1" href="#">' + id + '</a>');
	$(".navbar-nav").append('<li class="nav-item dropdown no-arrow"></li>');
	$(".navbar-nav").find('li').append('<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user-circle fa-fw"></i></a>');
	$(".navbar-nav").find('li').append('<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown"></div>');
	
	$(".dropdown-menu").append('<a class="dropdown-item" href="'+ cr + '/user_info_update_form.ida">회원정보변경</a>');
	$(".dropdown-menu").append('<div class="dropdown-divider"></div>');
	$(".dropdown-menu").append('<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>');
}

/**
* Sidebar Setting
*/
function setSidebars(cr){
	$("#wrapper").prepend('<ul class="sidebar navbar-nav toggled"></ul>');
	
	$(".sidebar").append('<li class="nav-item dropdown order_side"></li>');
	$(".sidebar").append('<li class="nav-item dropdown menu_side"></li>');
	$(".sidebar").append('<li class="nav-item dropdown ingredient_side"></li>');
	$(".sidebar").append('<li class="nav-item dropdown stock_side"></li>');
	$(".sidebar").append('<li class="nav-item dropdown share_side"></li>');
	$(".sidebar").append('<li class="nav-item dropdown customer_side"></li>');
	
	$(".order_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
	$(".order_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
	$(".order_side").find('a').append('<i class="fas fa-bars"></i> <span>주문</span>');
	$(".order_side").find('div').append('<a class="dropdown-item" href="' + cr + '/order_form.ida"><i class="fas fa-fw fa-table"></i>주문관리</a>');
	$(".order_side").find('div').append('<a class="dropdown-item" href="' + cr + '/order_analysis_chart_form.ida"><i class="fas fa-fw fa-chart-area"></i>주문분석</a>');
	
	$(".menu_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
	$(".menu_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
	$(".menu_side").find('a').append('<i class="fas fa-bars"></i> <span>메뉴</span>');
	$(".menu_side").find('div').append('<a class="dropdown-item" href="' + cr + '/menu_form.ida"><i class="fas fa-fw fa-table"></i>메뉴관리</a>');
	$(".menu_side").find('div').append('<a class="dropdown-item" href="' + cr + '/menu_analysis_chart_form.ida"><i class="fas fa-fw fa-chart-area"></i>메뉴분석</a>');
	
	$(".ingredient_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
	$(".ingredient_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
	$(".ingredient_side").find('a').append('<i class="fas fa-bars"></i> <span>식자재</span>');
	$(".ingredient_side").find('div').append('<a class="dropdown-item" href="' + cr + '/ingredient_form.ida"><i class="fas fa-fw fa-table"></i>식자재관리</a>');
	$(".ingredient_side").find('div').append('<a class="dropdown-item" href="' + cr + '/ingredient_analysis_chart_form.ida"><i class="fas fa-fw fa-chart-area"></i>식자재분석</a>');
	
	$(".stock_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
	$(".stock_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
	$(".stock_side").find('a').append('<i class="fas fa-bars"></i> <span>재고</span>');
	$(".stock_side").find('div').append('<a class="dropdown-item" href="' + cr + '/stock_form.ida"><i class="fas fa-fw fa-table"></i>재고관리</a>');
	$(".stock_side").find('div').append('<a class="dropdown-item" href="' + cr + '/stock_analysis_chart_form.ida"><i class="fas fa-fw fa-chart-area"></i>재고분석</a>');
	
	$(".share_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
	$(".share_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
	$(".share_side").find('a').append('<i class="fas fa-bars"></i> <span>공유</span>');
	$(".share_side").find('div').append('<a class="dropdown-item" href="' + cr + '/share_form.ida"><i class="fas fa-fw fa-table"></i>공유관리</a>');
	$(".share_side").find('div').append('<a class="dropdown-item" href="' + cr + '/share_analysis_chart_form.ida"><i class="fas fa-fw fa-chart-area"></i>공유분석</a>');
	
	$(".customer_side").append('<a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>');
	$(".customer_side").append('<div class="dropdown-menu" aria-labelledby="pagesDropdown"></div>');
	$(".customer_side").find('a').append('<i class="fas fa-bars"></i> <span>고객</span>');
	$(".customer_side").find('div').append('<a class="dropdown-item" href="' + cr + '/customer_form.ida"><i class="fas fa-fw fa-table"></i>고객관리</a>');
	$(".customer_side").find('div').append('<a class="dropdown-item" href="' + cr + '/customer_analysis_chart_form.ida"><i class="fas fa-fw fa-chart-area"></i>고객분석</a>');
}

/**
 * Breadcrumbs Setting
 */
function setBreadcrumbs(cr, user_flag){
	var path = new String(document.location);
	path = path.substr(path.indexOf('ida/')+4, path.indexOf('.ida') - path.indexOf('ida/'));
	
	var data = "path=" + path + "&user_flag=" + user_flag;
	
	$.ajax({
		url : cr + "/get_path.ida"
		, type : "post"
		, data : data
		, success : function(data){
			for(var i=data.length-1; i>=0; i--){
				if(i!=0){
					$(".breadcrumb").append('<li class="breadcrumb-item"><a href="' + data[i].path +'">' + data[i].label + '</a></li>');
				}else{
					$(".breadcrumb").append('<li class="breadcrumb-item active">' + data[i].label + '</li>');
				}
			}
		}, error : function(){
			alert("서버 통신 실패<br>");
		}
	});
}

/**
 * Card Footer Setting
 */
function setCardFooter(table_name, cr){
	$.ajax({
		url : cr + "/get_last_update_data.ida"
		, type : "post"
		, data : "table_name=" + table_name
		, success : function(date){
			var update_date = new Date(date);
			var day = update_date.getDay();
			
			switch(day){
				case 0:
					day = "일";
					break;
				case 1:
					day = "월";
					break;
				case 2:
					day = "화";
					break;
				case 3:
					day = "수";
					break;
				case 4:
					day = "목";
					break;
				case 5:
					day = "금";
					break;
				case 6:
					day = "토";
					break;
			}
			
			$(".card-footer").html("마지막 변경일 : "
					+ update_date.getFullYear() + "-"
					+ (update_date.getMonth()+1) + "-"
					+ update_date.getDate() + "("
					+ day + ") "
					+ update_date.getHours() + ":"
					+ update_date.getMinutes());
		}, error : function(){
			alert("서버 통신 실패<br>");
		}
	});
}

/**
 * Scroll to Top Button
 */
function setTopUp(){
	$(".rounded").append('<i class="fas fa-angle-up"></i>');
}

/**
 * Footer Setting
 */
function setFooter(){
	$(".sticky-footer").append('<div class="container my-auto"></div>');
	$(".container").append('<div class="copyright text-center my-auto"></div>');
	$(".copyright").append('<span>Copyright © IDA 2020</span>');
}

/**
* Logout Function
*/
function setLogoutFunc(cr){
	$("#logoutModal").prepend('<div class="modal-dialog logout_dialog" role="document"></div>');
	
	$(".logout_dialog").append('<div class="modal-content logout_content"></div>');
	
	$(".logout_content").append('<div class="modal-header logout_header"></div>');
	$(".logout_content").append('<div class="modal-body logout_body"></div>');
	$(".logout_content").append('<div class="modal-footer logout_footer"></div>');
	
	$(".logout_header").append('<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>');
	$(".logout_header").append('<button class="close" type="button" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>');
	
	$(".logout_body").append('정말로 로그아웃 하시겠습니까?<br>로그아웃 하시면 로그인 페이지로 돌아갑니다.');

	$(".logout_footer").append('<button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button> <a class="btn btn-primary" href="'+ cr + '/logout_form.ida">로그아웃</a>');
}