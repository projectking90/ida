function getChartData(cr, chart_search){
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/stock_analysis_chart.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "chart_search=" + chart_search
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(chart_data){
	         $("#myChart").remove();
	         $(".card-body").append('<canvas id="myChart" width="100%" height="30"></canvas>');

			if($("[name=chart_search]").val() == '주'){
				drawLineWeekChart5(chart_data);
				$(".top3").click(function(){
			         $("#myChart").remove();
			         $(".card-body").append(
			               '<canvas id="myChart" width="100%" height="30"></canvas>');

			         drawLineWeekChart3(chart_data);
		       });
		       $(".top5").click(function(){
			         $("#myChart").remove();
			         $(".card-body").append(
			               '<canvas id="myChart" width="100%" height="30"></canvas>');

			         drawLineWeekChart5(chart_data);
		       });
		       $(".top10").click(function(){
			         $("#myChart").remove();
			         $(".card-body").append(
			               '<canvas id="myChart" width="100%" height="30"></canvas>');
			         drawLineWeekChart10(chart_data);

		       });
			}else if($("[name=chart_search]").val() == '월'){	    	  
				drawAreaChartMonth2(chart_data);
		       $(".top3").click(function(){
			         $("#myChart").remove();
			         $(".card-body").append(
			               '<canvas id="myChart" width="100%" height="30"></canvas>');
		    	   drawAreaChartMonth1(chart_data);
		       });
		       $(".top5").click(function(){
			         $("#myChart").remove();
			         $(".card-body").append(
			               '<canvas id="myChart" width="100%" height="30"></canvas>');
		    	   drawAreaChartMonth2(chart_data);
		       });
		       $(".top10").click(function(){
			         $("#myChart").remove();
			         $(".card-body").append(
			               '<canvas id="myChart" width="100%" height="30"></canvas>');
		    	   drawAreaChartMonth3(chart_data);
		       });
				drawLineMonthChart(chart_data);
			}else if($("[name=chart_search]").val() == '시간'){
				drawLineTimeChart(chart_data);
			}else if($("[name=chart_search]").val() == '분기'){
					drawPieQuarterChart(chart_data);
		    	   $(".top3").hide();
		    	   $(".top5").hide();
		    	   $(".top10").hide();
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function drawLineWeekChart3(data) {
	
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	
	var ctx = document.getElementById('myChart').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: data.label,
                datasets: [{
                    label: "1주차 재고 입/출고 총합",
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:data.data1
                }
                ]
            },
            // Configuration options go here
            options: {
            	
            	
    			responsive: true,
    			hover: {
    				animationDuration: 0
    				
    			},
    			title: {
    				display: true,
    				text: '주 별 재고 입/출고 총 현황 TOP 3'
    			},
            	
            	
            	
            }
        }
        var chart = new Chart(ctx, data);
    
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: data.label,
                datasets: [{
                    label: "2주차 재고 입/출고 총합",
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:data.data1
                }
                ]
            },
            // Configuration options go here
            options: {
            	
            	
    			responsive: true,
    			hover: {
    				animationDuration: 0
    				
    			},
    			title: {
    				display: true,
    				text: '주 별 재고 입/출고 총 현황 TOP 3'
    			},
            	
            	
            	
            }
        }
        var chart = new Chart(ctx, data);
}

function drawLineWeekChart5(data) {
	
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	
	var ctx = document.getElementById('myChart').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: data.label,
                datasets: [{
                    label: "재고 입/출고 총합",
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:data.data1
                }
                ]
            },
            // Configuration options go here
            options: {
            	
            	
    			responsive: true,
    			hover: {
    				animationDuration: 0
    				
    			},
    			title: {
    				display: true,
    				text: '주 별 재고 입/출고 총 현황 TOP 5'
    			},
            	
            	
            	
            }
        }
        var chart = new Chart(ctx, data);
}

function drawLineWeekChart10(data) {
	
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	
	var ctx = document.getElementById('myChart').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: data.label,
                datasets: [{
                    label: "재고 입/출고 총합",
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:data.data1
                }
                ]
            },
            // Configuration options go here
            options: {
            	
            	
    			responsive: true,
    			hover: {
    				animationDuration: 0
    				
    			},
    			title: {
    				display: true,
    				text: '주 별 재고 입/출고 총 현황 TOP 10'
    			},
            	
            	
            	
            }
        }
        var chart = new Chart(ctx, data);
}

function drawLineMonthChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myMonthChart");
	var myLineChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
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
				data : [4670,3544,4093,4233,4080,4189,4654,4432,4122,3324,4320,4532,4234,4876],
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
						max : 10000,
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

function drawLineTimeChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myTimeChart");
	var myLineChart = new Chart(ctx, {
		type : 'line',
		data : {
			labels : ["1시","2시","3시","4시","5시","6시","7시","8시","9시","10시","11시","12시","13시","14시","15시","16시","17시","18시","19시","20시","21시","22시","23시","24시"],
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
				data : [0,0,0,0,0,0,0,0,0,3145,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
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
						max : 5000,
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

function drawPieQuarterChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myQuarterChart");
	var myLineChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : ["1분기", "2분기", "3분기", "4분기"],
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
				data : [12456,21089,16433,17633],
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
						max : 50000,
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