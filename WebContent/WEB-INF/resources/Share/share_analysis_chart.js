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
	
	//alert("chart_search=" + chart_search +"&week=" + week + "&month=" + month + "&year=" + year + "&chart_cnt=" + chart_cnt + "&quarter=" + quarter);
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/share_analysis_chart.ida"
		// 전송 방법 설정
		, type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		, data : "chart_search=" + chart_search +"&week=" + week + "&month=" + month + "&year=" + year + "&chart_cnt=" + chart_cnt + "&quarter=" + quarter
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		// 매개변수 boardRegCnt에는 입력 행의 개수가 들어온다.
		, success : function(chart_data){
			$(".card-body").append(
					'<canvas id="myChart1" width="100%" height="30"></canvas>'+
					'<canvas id="myChart2" width="100%" height="30"></canvas>'+
					'<canvas id="myChart3" width="100%" height="30"></canvas>'+
					'<canvas id="myChart4" width="100%" height="30"></canvas>');

	    	   $("#myChart1").remove();
		       $("#myChart2").remove();
	    	   $("#myChart3").remove();
		       $("#myChart4").remove();
	         
			if($("[name=chart_search]").val() == '주'){
				drawBarWeekInputChart5(chart_data);
		        drawBarWeekOutputChart5(chart_data);
				$(".top3").click(function(){
		    	   $("#myChart1").remove();
			       $("#myChart2").remove();
		    	   $("#myChart3").remove();
			       $("#myChart4").remove();
			        $(".card-body").append(
				            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
				            '<canvas id="myChart2" width="100%" height="30"></canvas>'+
				            '<canvas id="myChart3" width="100%" height="30"></canvas>'+
							'<canvas id="myChart4" width="100%" height="30"></canvas>');
			         drawBarWeekInputChart3(chart_data);
			         drawBarWeekOutputChart3(chart_data);
		       });
		       $(".top5").click(function(){
		    	   $("#myChart1").remove();
			       $("#myChart2").remove();
		    	   $("#myChart3").remove();
			       $("#myChart4").remove();
			        $(".card-body").append(
				            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
				            '<canvas id="myChart2" width="100%" height="30"></canvas>'+
				            '<canvas id="myChart3" width="100%" height="30"></canvas>'+
							'<canvas id="myChart4" width="100%" height="30"></canvas>');
			         drawBarWeekInputChart5(chart_data);
			         drawBarWeekOutputChart5(chart_data);
		       });
		       $(".top10").click(function(){
		    	   $("#myChart1").remove();
			       $("#myChart2").remove();
		    	   $("#myChart3").remove();
			       $("#myChart4").remove();

			        $(".card-body").append(
			            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
			            '<canvas id="myChart2" width="100%" height="30"></canvas>'+
			            '<canvas id="myChart3" width="100%" height="30"></canvas>'+
						'<canvas id="myChart4" width="100%" height="30"></canvas>');
			        
			       drawBarWeekInputChart10(chart_data);
			       drawBarWeekOutputChart10(chart_data);
		       });
			}else if($("[name=chart_search]").val() == '월'){	   
		         drawBarMonthInputChart5(chart_data);
		         drawBarMonthOutputChart5(chart_data);
				$(".top3").click(function(){
					$("#myChart1").remove();
					$("#myChart2").remove();
					$("#myChart3").remove();
					$("#myChart4").remove();
					
			        $(".card-body").append(
			            '<canvas id="myChart1" width="100%" height="30"></canvas>'+
			            '<canvas id="myChart2" width="100%" height="30"></canvas>'+
			            '<canvas id="myChart3" width="100%" height="30"></canvas>'+
						'<canvas id="myChart4" width="100%" height="30"></canvas>');
			         drawBarMonthInputChart3(chart_data);
			         drawBarMonthOutputChart3(chart_data);
		       });
		       $(".top5").click(function(){
					$("#myChart1").remove();
					$("#myChart2").remove();
					$("#myChart3").remove();
					$("#myChart4").remove();
					
			        $(".card-body").append(
			        	'<canvas id="myChart1" width="100%" height="30"></canvas>'+
		               	'<canvas id="myChart2" width="100%" height="30"></canvas>'+
		               	'<canvas id="myChart3" width="100%" height="30"></canvas>'+
						'<canvas id="myChart4" width="100%" height="30"></canvas>');
			         drawBarMonthInputChart5(chart_data);
			         drawBarMonthOutputChart5(chart_data);
		       });
		       $(".top10").click(function(){
					$("#myChart1").remove();
					$("#myChart2").remove();
					$("#myChart3").remove();
					$("#myChart4").remove();
					
			        $(".card-body").append(
			        	'<canvas id="myChart1" width="100%" height="30"></canvas>'+
		               	'<canvas id="myChart2" width="100%" height="30"></canvas>'+
		               	'<canvas id="myChart3" width="100%" height="30"></canvas>'+
						'<canvas id="myChart4" width="100%" height="30"></canvas>');
			         drawBarMonthInputChart10(chart_data);
			         drawBarMonthOutputChart10(chart_data);
		       });
			}else if($("[name=chart_search]").val() == '시간'){
				$("#myChart1").remove();
				$("#myChart2").remove();
				$("#myChart3").remove();
				$("#myChart4").remove();
				
		        $(".card-body").append(
		        	'<canvas id="myChart1" width="100%" height="30"></canvas>'+
	               	'<canvas id="myChart2" width="100%" height="30"></canvas>'+
	               	'<canvas id="myChart3" width="100%" height="30"></canvas>'+
					'<canvas id="myChart4" width="100%" height="30"></canvas>');
		        
				drawLineTimeInputChart(chart_data);
				drawLineTimeOutputChart(chart_data);
			}else if($("[name=chart_search]").val() == '분기'){
				$("#myChart1").remove();
				$("#myChart2").remove();
				$("#myChart3").remove();
				$("#myChart4").remove();
				
		        $(".card-body").append(
		        	'<canvas id="myChart1" width="100%" height="30"></canvas>'+
	               	'<canvas id="myChart2" width="100%" height="30"></canvas>'+
	               	'<canvas id="myChart3" width="100%" height="30"></canvas>'+
					'<canvas id="myChart4" width="100%" height="30"></canvas>');
					drawPieQuarterInputChart(chart_data);
					drawPieQuarterOutputChart(chart_data);
					drawBarQuarterInputChart5(chart_data);
					//drawBarQuarterOutputChart5(chart_data);
					
					$(".top3").click(function(){
			    	   $("#myChart1").remove();
				       $("#myChart2").remove();
			    	   $("#myChart3").remove();
				       $("#myChart4").remove();
				       
				       $(".card-body").append(
				    		'<canvas id="myChart1" width="100%" height="30"></canvas>'+
				    		'<canvas id="myChart2" width="100%" height="30"></canvas>'+
				    		'<canvas id="myChart3" width="100%" height="30"></canvas>'+
							'<canvas id="myChart4" width="100%" height="30"></canvas>');
						drawPieQuarterInputChart(chart_data);
						drawPieQuarterOutputChart(chart_data);
						drawBarQuarterInputChart3(chart_data);
						//drawBarQuarterOutputChart3(chart_data);
			       });
			       $(".top5").click(function(){
			    	   $("#myChart1").remove();
				       $("#myChart2").remove();
			    	   $("#myChart3").remove();
				       $("#myChart4").remove();
				       $(".card-body").append(
					    		'<canvas id="myChart1" width="100%" height="30"></canvas>'+
					    		'<canvas id="myChart2" width="100%" height="30"></canvas>'+
					    		'<canvas id="myChart3" width="100%" height="30"></canvas>'+
								'<canvas id="myChart4" width="100%" height="30"></canvas>');
						drawPieQuarterInputChart(chart_data);
						drawPieQuarterOutputChart(chart_data);
						drawBarQuarterInputChart5(chart_data);
						//drawBarQuarterOutputChart5(chart_data);
			       });
			       $(".top10").click(function(){
			    	   $("#myChart1").remove();
				       $("#myChart2").remove();
			    	   $("#myChart3").remove();
				       $("#myChart4").remove();
				       $(".card-body").append(
					    		'<canvas id="myChart1" width="100%" height="30"></canvas>'+
					    		'<canvas id="myChart2" width="100%" height="30"></canvas>'+
					    		'<canvas id="myChart3" width="100%" height="30"></canvas>'+
								'<canvas id="myChart4" width="100%" height="30"></canvas>');
						drawPieQuarterInputChart(chart_data);
						drawPieQuarterOutputChart(chart_data);
						drawBarQuarterInputChart10(chart_data);
						//drawBarQuarterOutputChart10(chart_data);
			       });
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function drawBarWeekInputChart3(data) {
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
    				text: '지난 달 '+data.dataset+'차 공유 재고 입고 총 현황 TOP 3'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawBarWeekInputChart5(data) {
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
    				text: '지난 달 '+data.dataset+'차 공유 재고 입고 총 현황 TOP 5'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawBarWeekInputChart10(data) {
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
                labels: [data.label[0], data.label[1], data.label[2], data.label[3], data.label[4], data.label[5], data.label[6], data.label[7], data.label[8], data.label[9]],
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
    				text: '지난 달 '+data.dataset+'차 공유 재고 입고 총 현황 TOP 10'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawBarWeekOutputChart3(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label2[0], data.label2[1], data.label2[2]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data2[0], data.data2[1], data.data2[2]]
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
    				text: '지난 달 '+data.dataset+'차 공유 재고 출고 총 현황 TOP 3'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawBarWeekOutputChart5(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label2[0], data.label2[1], data.label2[2], data.label2[3], data.label2[4]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data2[0], data.data2[1], data.data2[2], data.data2[3], data.data2[4]]
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
    				text: '지난 달 '+data.dataset+'차 공유 재고 출고 총 현황 TOP 5'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawBarWeekOutputChart10(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label2[0], data.label2[1], data.label2[2], data.label2[3], data.label2[4], data.label2[5], data.label2[6], data.label2[7], data.label2[8], data.label2[9]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data2[0], data.data2[1], data.data2[2], data.data2[3], data.data2[4], data.data2[5], data.data2[6], data.data2[7], data.data2[8], data.data2[9]]
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
    				text: '지난 달 '+data.dataset+'차 공유 재고 출고 총 현황 TOP 10'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}



function drawBarMonthInputChart3(data) {
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
    				text: data.dataset+' 공유 재고 입고 총 현황 TOP 3'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawBarMonthInputChart5(data) {
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
    				text: data.dataset+' 공유 재고 입고 총 현황 TOP 5'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawBarMonthInputChart10(data) {
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
                labels: [data.label[0], data.label[1], data.label[2], data.label[3], data.label[4], data.label[5], data.label[6], data.label[7], data.label[8], data.label[9]],
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
    				text: data.dataset+' 공유 재고 입고 총 현황 TOP 10'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawBarMonthOutputChart3(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label2[0], data.label2[1], data.label2[2]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data2[0], data.data2[1], data.data2[2]]
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
    				text: data.dataset+' 공유 재고 출고 총 현황 TOP 3'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawBarMonthOutputChart5(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label2[0], data.label2[1], data.label2[2], data.label2[3], data.label2[4]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data2[0], data.data2[1], data.data2[2], data.data2[3], data.data2[4]]
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
    				text: data.dataset+' 공유 재고 출고 총 현황 TOP 5'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawBarMonthOutputChart10(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'bar',
            // The data for our dataset
            data: {
                labels: [data.label2[0], data.label2[1], data.label2[2], data.label2[3], data.label2[4], data.label2[5], data.label2[6], data.label2[7], data.label2[8], data.label2[9]],
                datasets: [{
                    label:  data.dataset,
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: [data.data2[0], data.data2[1], data.data2[2], data.data2[3], data.data2[4], data.data2[5], data.data2[6], data.data2[7], data.data2[8], data.data2[9]]
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
    				text: data.dataset+' 공유 재고 출고 총 현황 TOP 10'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}



function drawLineTimeInputChart(data) {

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
                    label: '시간별 공유 재고 입고 총 합계',
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
    				text: '지난 달 기준 시간별 공유 재고 입고 총 현황'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}


function drawLineTimeOutputChart(data) {

	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('myChart2').getContext('2d');
    var data = {
            // The type of chart we want to create
            type: 'line',
            // The data for our dataset
            data: {
                labels: data.label2,
                datasets: [{
                    label: '시간별 공유 재고 출고 총 합계',
                    backgroundColor: 'rgb(255, 99, 132)',
                    fill:false, // line의 아래쪽을 색칠할 것인가? 
                    borderColor: 'rgb(255, 99, 132)',
                    lineTension:0.1, // 값을 높이면, line의 장력이 커짐.
                    data: data.data2
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
    				text: '지난 달 기준 시간별 공유 재고 출고 총 현황'
    			},
            }
        }
        var chart = new Chart(ctx, data);
}

function drawPieQuarterInputChart(data) {
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
				text : '지난 연도 분기별 공유 재고 입고 총 현황'
			}
		}
	});
}


function drawPieQuarterOutputChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Pie Chart Example
	var ctx = document.getElementById("myChart2");
	var myPieChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : data.label2,
			datasets : [ {
				data : data.data2,
				backgroundColor : ['#007bff', '#dc3545', '#ffc107', '#28a745'],
			} ],
		},
		options:{
			title:{
				display : true,
				text : '지난 연도 분기별 공유 재고 출고 총 현황'
			}
		}
	});
}

function drawBarQuarterInputChart3(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart3");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [data.label3[0],data.label3[1],data.label3[2]],
			datasets : [ {
				label : data.dataset2,
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
				data : [data.data3[0],data.data3[1],data.data3[2]],
			} ],
		},
		options : {
			title:{
				display : true,
				text : '지난 연도 '+data.dataset2+' 공유 재고 입고 총 현황'
			},
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

function drawBarQuarterInputChart5(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart3");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [data.label3[0],data.label3[1],data.label3[2],data.label3[3],data.label3[4]],
			datasets : [ {
				label : data.dataset2,
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
				data : [data.data3[0],data.data3[1],data.data3[2],data.data3[3],data.data3[4]]
			} ],
		},
		options : {
			title:{
				display : true,
				text : '지난 연도 '+data.dataset2+' 공유 재고 입고 총 현황'
			},
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

function drawBarQuarterInputChart10(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById("myChart3");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : data.label3,
			datasets : [ {
				label : data.dataset2,
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
				data : data.data3
			} ],
		},
		options : {
			title:{
				display : true,
				text : '지난 연도 '+data.dataset2+' 공유 재고 입고 총 현황'
			},
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
	

	function drawBarQuarterOutputChart3(data) {
		// Set new default font family and font color to mimic Bootstrap's default
		// styling
		Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
		Chart.defaults.global.defaultFontColor = '#292b2c';

		// Area Chart Example
		var ctx = document.getElementById("myChart4");
		var myLineChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : [data.label4[0],data.label4[1],data.label4[2]],
				datasets : [ {
					label : data.dataset2,
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
					data : [data.data4[0],data.data4[1],data.data4[2]],
				} ],
			},
			options : {
				title:{
					display : true,
					text : '지난 연도 '+data.dataset2+' 공유 재고 출고 총 현황'
				},
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

	
	function drawBarQuarterOutputChart5(data) {
		// Set new default font family and font color to mimic Bootstrap's default
		// styling
		Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
		Chart.defaults.global.defaultFontColor = '#292b2c';

		// Area Chart Example
		var ctx = document.getElementById("myChart4");
		var myLineChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : [data.label4[0],data.label4[1],data.label4[2],data.label4[3],data.label4[4]],
				datasets : [ {
					label : data.dataset2,
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
					data : [data.data4[0],data.data4[1],data.data4[2],data.data4[3],data.data4[4]]
				} ],
			},
			options : {
				title:{
					display : true,
					text : '지난 연도 '+data.dataset2+' 공유 재고 출고 총 현황'
				},
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

	function drawBarQuarterOutputChart10(data) {
		// Set new default font family and font color to mimic Bootstrap's default
		// styling
		Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
		Chart.defaults.global.defaultFontColor = '#292b2c';

		// Area Chart Example
		var ctx = document.getElementById("myChart4");
		var myLineChart = new Chart(ctx, {
			type : 'bar',
			data : {
				labels : data.label4,
				datasets : [ {
					label : data.dataset2,
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
					data : data.data4
				} ],
			},
			options : {
				title:{
					display : true,
					text : '지난 연도 '+data.dataset2+' 공유 재고 출고 총 현황'
				},
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
}