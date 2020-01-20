function getChartData(cr, chart_search){
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/order_analysis_chart.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "chart_search=" + chart_search
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(chart_data){
			$("[id=myChart]").remove();
			$(".card-body").append('<canvas id="myChart" width="100%" height="30"></canvas>');
			
			if($("[name=chart_search]").val() == '성별'){
				drawdoubleBarChart(chart_data);
			}else if($("[name=chart_search]").val() == '나이대'){
				drawPieChart(chart_data);
			}else if($("[name=chart_search]").val() == '주'){
				drawAreaChart(chart_data);
			}else if($("[name=chart_search]").val() == '월'){
				drawAreaChart(chart_data);
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function drawAreaChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : data.label,
			datasets : [ {
				label : "Sessions",
				lineTension : 0.3,
				backgroundColor : "rgba(2,117,216,0.2)",
				borderColor : "rgba(2,117,216,1)",
				pointRadius : 5,
				pointBackgroundColor : "rgba(2,117,216,1)",
				pointBorderColor : "rgba(255,255,255,0.8)",
				pointHoverRadius : 5,
				pointHoverBackgroundColor : "rgba(2,117,216,1)",
				pointHitRadius : 50,
				pointBorderWidth : 2,
				data : data.data1,
			} ],
		},
		options : {
			scales : {
				xAxes : [ {
					time : {
						unit : 'date'
					},
					gridLines : {
						display : false
					},
					ticks : {
						maxTicksLimit : 7
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 1000,
						maxTicksLimit : 5
					},
					gridLines : {
						color : "rgba(0, 0, 0, .125)",
					}
				} ],
			},
			legend : {
				display : false
			}
		}
	});
}

function drawPieChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Pie Chart Example
	var ctx = document.getElementById("myChart");
	var myPieChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : data.label,
			datasets : [ {
				data : data.data1,
				backgroundColor : [ '#007bff', '#dc3545', '#ffc107', '#28a745','#38a789' ],
			} ],
		},
	});
}

function drqwBarChart(data){
	//Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	//Bar Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : data.label,
			datasets : [ {
				label : data.dataset,
				backgroundColor : "rgba(2,117,216,1)",
				borderColor : "rgba(2,117,216,1)",
				data : data.data1
			} ],
		},
		options : {
			scales : {
				xAxes : [ {
					time : {
						unit : 'month'
					},
					gridLines : {
						display : false
					},
					ticks : {
						maxTicksLimit : 15
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 20,
						maxTicksLimit : 10
					},
					gridLines : {
						display : true
					}
				} ],
			},
			legend : {
				display : false
			}
		}
	});
}

function drawdoubleBarChart(data){
	//Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';
	
	//Bar Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : data.label,
			datasets : [ {
				label : data.dataset,
				backgroundColor : "rgba(2,117,216,1)",
				borderColor : "rgba(2,117,216,1)",
				data : data.data1
			} , {
				label : data.dataset,
				backgroundColor : "rgba(100,350,216,1)",
				borderColor : "rgba(2,117,216,1)",
				data : data.data2
			}],
		},
		options : {
			scales : {
				xAxes : [ {
					time : {
						unit : 'month'
					},
					gridLines : {
						display : false
					},
					ticks : {
						maxTicksLimit : 15
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 20,
						maxTicksLimit : 10
					},
					gridLines : {
						display : true
					}
				} ],
			},
			legend : {
				display : false
			}
		}
	});
}