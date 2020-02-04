function getChartData(cr, chart_search, week, month, year, quarter){
	var chart_cnt=10;
	if($("[name=chart_search]").val()=="주"){
		$(".month").hide();
		$(".year").hide();
		$(".quarter").hide();
		$(".week").show();
		$(".top3").show();
		$(".top5").show();
		$(".top10").show();
	}
	else if($("[name=chart_search]").val() == "월"){
		$(".week").hide();
		$(".quarter").hide();
		$(".month").show();
		$(".year").show();
		$(".top3").show();
		$(".top5").show();
		$(".top10").show();
	}
	else if($("[name=chart_search]").val() == "분기"){
		$(".week").hide();
		$(".month").hide();
		$(".year").hide();
		$(".quarter").show();
		$(".top3").show();
		$(".top5").show();
		$(".top10").show();
	}
	else{
		$(".week").hide();
		$(".month").hide();
		$(".year").hide();
		$(".quarter").hide();	
		$(".top3").hide();
		$(".top5").hide();
		$(".top10").hide();
	}

	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/stock_analysis_chart.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "chart_search=" + chart_search +"&week=" + week + "&month=" + month + "&year=" + year + "&chart_cnt=" + chart_cnt + "&quarter=" + quarter
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(chart_data){
			$(".card-body").append('<canvas id="myChart1" width="100%" height="30"></canvas>'+
					'<canvas id="myChart2" width="100%" height="30"></canvas>');
	         $("#myChart1").remove();
	         $("#myChart2").remove();

			if($("[name=chart_search]").val() == '주'){
				drawLineWeekChart5(chart_data);
				$(".top3").click(function(){
			         $("#myChart1").remove();
			         $("#myChart2").remove();
			         $(".card-body").append('<canvas id="myChart1" width="100%" height="30"></canvas>'+
								'<canvas id="myChart2" width="100%" height="30"></canvas>');
			         drawLineWeekChart3(chart_data);
		       });
		       $(".top5").click(function(){
			         $("#myChart1").remove();
			         $("#myChart2").remove();
			         $(".card-body").append('<canvas id="myChart1" width="100%" height="30"></canvas>'+
								'<canvas id="myChart2" width="100%" height="30"></canvas>');
			         drawLineWeekChart5(chart_data);
		       });
		       $(".top10").click(function(){
			         $("#myChart1").remove();
			         $("#myChart2").remove();
			         $(".card-body").append('<canvas id="myChart1" width="100%" height="30"></canvas>'+
								'<canvas id="myChart2" width="100%" height="30"></canvas>');
			         drawLineWeekChart10(chart_data);
		       });
			}else if($("[name=chart_search]").val() == '월'){	    	  
				drawLineMonthChart5(chart_data);
				$(".top3").click(function(){
					$("#myChart1").remove();
			         $("#myChart2").remove();
			        $(".card-body").append(
			               '<canvas id="myChart1" width="100%" height="30"></canvas>'+
							'<canvas id="myChart2" width="100%" height="30"></canvas>');
			        drawLineMonthChart3(chart_data);
		       });
		       $(".top5").click(function(){
		    	   	$("#myChart1").remove();
			         $("#myChart2").remove();
			        $(".card-body").append(
			               '<canvas id="myChart1" width="100%" height="30"></canvas>'+
							'<canvas id="myChart2" width="100%" height="30"></canvas>');
			        drawLineMonthChart5(chart_data);
		       });
		       $(".top10").click(function(){
		    	   $("#myChart1").remove();
			       $("#myChart2").remove();
			       $(".card-body").append(
			               '<canvas id="myChart1" width="100%" height="30"></canvas>'+
							'<canvas id="myChart2" width="100%" height="30"></canvas>');
			       drawLineMonthChart10(chart_data);
		       });
			}else if($("[name=chart_search]").val() == '시간'){
				drawLineTimeChart(chart_data);
			}else if($("[name=chart_search]").val() == '분기'){
					drawPieQuarterChart(chart_data);
					drawBarQuarterChart5(chart_data);
					$(".top3").click(function(){
						$("#myChart1").remove();
				         $("#myChart2").remove();
				        $(".card-body").append(
				            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
							'<canvas id="myChart2" width="100%" height="30"></canvas>');
						drawPieQuarterChart(chart_data);
						drawBarQuarterChart3(chart_data);
			       });
			       $(".top5").click(function(){
			    	   	$("#myChart1").remove();
				         $("#myChart2").remove();
				        $(".card-body").append(
				            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
							'<canvas id="myChart2" width="100%" height="30"></canvas>');
						drawPieQuarterChart(chart_data);
						drawBarQuarterChart5(chart_data);
			       });
			       $(".top10").click(function(){
			    	   $("#myChart1").remove();
				       $("#myChart2").remove();
				       $(".card-body").append(
				            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
							'<canvas id="myChart2" width="100%" height="30"></canvas>');
				       drawPieQuarterChart(chart_data);
				       drawBarQuarterChart10(chart_data);
			       });
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
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
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label[0], data.label[1], data.label[2]],
                datasets: [{
                    label: data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:[data.data1[0], data.data1[1], data.data1[2]]
                }]
            },
            // Configuration options go here
            options: {
    			responsive: true,
    			hover: {
    				animationDuration: 0
    			},
    			title: {
    				display: true,
    				text: data.dataset+' 재고 입/출고 총 현황 TOP 3'
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
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label[0], data.label[1], data.label[2], data.label[3], data.label[4]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data1[0], data.data1[1], data.data1[2], data.data1[3], data.data1[4]]
                }]
            },
            // Configuration options go here
            options: {
    			responsive: true,
    			scales: {
    				yAxes: [{
    					ticks: {
    						min: 0,
    						suggestedmax: 100,
    						maxTicksLimit : 5
    					}
    				}]
    			},
    			hover: {
    				animationDuration: 0
    				
    			},
    			title: {
    				display: true,
    				text: data.dataset+' 재고 입/출고 총 현황 TOP 5'
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
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels:  [data.label[0], data.label[1], data.label[2], data.label[3], data.label[4], data.label[5], data.label[6], data.label[7], data.label[8], data.label[9]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:[data.data1[0], data.data1[1], data.data1[2], data.data1[3], data.data1[4], data.data1[5], data.data1[6], data.data1[7], data.data1[8], data.data1[9]]
                }]
            },
            // Configuration options go here
            options: {
    			responsive: true,
    			scales: {
    				yAxes: [{
    					ticks: {
    						min: 0,
    						suggestedmax: 100,
    						maxTicksLimit : 5
    					}
    				}]
    			},
    			hover: {
    				animationDuration: 0
    			},
    			title: {
    				display: true,
    				text: data.dataset+' 재고 입/출고 총 현황 TOP 10'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawLineMonthChart3(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'line',
            // The data for our dataset
            data: {
                labels: [data.label[0], data.label[1], data.label[2]],
                datasets: [{
                    label: data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:[data.data1[0], data.data1[1], data.data1[2]]
                }]
            },
            // Configuration options go here
            options: {
    			responsive: true,
    			scales: {
    				yAxes: [{
    					ticks: {
    						min: 0,
    						suggestedmax: 100,
    						maxTicksLimit : 5
    					}
    				}]
    			},
    			hover: {
    				animationDuration: 0
    			},
    			title: {
    				display: true,
    				text: '월별 재고 입/출고 총 현황 TOP 3'
    			},
            }
        }
        var chart = new Chart(ctx, data);
    
}

function drawLineMonthChart5(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'line',
            // The data for our dataset
            data: {
                labels: [data.label[0], data.label[1], data.label[2], data.label[3], data.label[4]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data1[0], data.data1[1], data.data1[2], data.data1[3], data.data1[4]]
                }
                ]
            },
            // Configuration options go here
            options: {
    			responsive: true,
    			scales: {
    				yAxes: [{
    					ticks: {
    						min: 0,
    						suggestedmax: 100,
    						maxTicksLimit : 5
    					}
    				}]
    			},
    			hover: {
    				animationDuration: 0
    			},
    			title: {
    				display: true,
    				text: '월별 재고 입고 총 현황 TOP 5'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawLineMonthChart10(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'line',
            // The data for our dataset
            data: {
                labels:  [data.label[0], data.label[1], data.label[2], data.label[3], data.label[4], data.label[5], data.label[6], data.label[7], data.label[8], data.label[9]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data:[data.data1[0], data.data1[1], data.data1[2], data.data1[3], data.data1[4], data.data1[5], data.data1[6], data.data1[7], data.data1[8], data.data1[9]]
                }
                ]
            },
            // Configuration options go here
            options: {
            	
            	
    			responsive: true,
    			scales: {
    				yAxes: [{
    					ticks: {
    						min: 0,
    						suggestedmax: 100,
    						maxTicksLimit : 5
    					}
    				}]
    			},
    			hover: {
    				animationDuration: 0
    				
    			},
    			title: {
    				display: true,
    				text: '월별 재고 입/출고 총 현황 TOP 10'
    			},
            	
            	
            	
            }
        }
        var chart = new Chart(ctx, data);
}

function drawLineTimeChart(data) {

	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart1').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'line',
            // The data for our dataset
            data: {
                labels: data.label,
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: data.data1
                }
                ]
            },
            // Configuration options go here
            options: {
    			responsive: true,
    			scales: {
    				yAxes: [{
    					ticks: {
    						min: 0,
    						suggestedmax: 100,
    						maxTicksLimit : 5
    					}
    				}]
    			},
    			hover: {
    				animationDuration: 0
    			},
    			title: {
    				display: true,
    				text: '지난 달 기준 시간별 재고 입/출고 총 현황'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawPieQuarterChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Pie Chart Example
	var ctx = document.getElementById("myChart1");
	var myPieChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : data.label,
			datasets : [ {
				data : data.data1,
				backgroundColor : ['#007bff', '#dc3545', '#ffc107', '#28a745'],
			} ],
		},
		options:{
			title:{
				display : true,
				text : '지난 연도 분기별 재고 입/출고 총 현황'
			}
		}
	});
}

function drawBarQuarterChart3(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart2");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [data.label2[0],data.label2[1],data.label2[2]],
			datasets : [ {
				label : data.dataset,
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
				data : [data.data2[0],data.data2[1],data.data2[2]],
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
						suggestedmax: 100,
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

function drawBarQuarterChart5(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart2");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [data.label2[0],data.label2[1],data.label2[2],data.label2[3],data.label2[4]],
			datasets : [ {
				label : data.dataset,
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
				data : [data.data2[0],data.data2[1],data.data2[2],data.data2[3],data.data2[4]]
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
						suggestedmax: 100,
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

function drawBarQuarterChart10(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart2");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [data.label2[0],data.label2[1],data.label2[2],data.label2[3],data.label2[4],data.label2[5],data.label2[6],data.label2[7],data.label2[8],data.label2[9]],
			datasets : [ {
				label : data.dataset,
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
				data : [data.data2[0],data.data2[1],data.data2[2],data.data2[3],data.data2[4],data.data2[5],data.data2[6],data.data2[7],data.data2[8],data.data2[9]],
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
						suggestedmax: 100,
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