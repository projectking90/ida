function getChartDataStockMonth(cr){
	var chart_cnt = 5;
	var chart_search = '월';
	var year = '2020';
	var month = '1';
	var data = "chart_search=" + chart_search + "&month=" + month + "&year=" + year + "&chart_cnt=" + chart_cnt 

	$.ajax({
		url : cr + "/stock_analysis_chart.ida"
		, type : "post"
		, data : data
		, success : function(chart_data){
			drawLineMonthChart5(chart_data);
		} ,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function getChartDataOrderGender(cr){
	var chart_search = '성별';
	var chart_cnt = '5';
	var data = "chart_search=" + chart_search + "&chart_cnt=" + chart_cnt;
		
	$.ajax({
		url : cr + "/order_analysis_chart.ida"
		, type : "post"
		, data : data
		, success : function(chart_data){
				drawManBarChart(chart_data);
				drawWomanBarChart(chart_data);
		} ,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function getChartDataOrderAge(cr){
	var chart_search = '나이대';
	var age = '20';
	var chart_cnt = '5';
	var data = "chart_search=" + chart_search + "&age=" + age + "&chart_cnt=" + chart_cnt;
		
	$.ajax({
		url : cr + "/order_analysis_chart.ida"
		, type : "post"
		, data : data
		, success : function(chart_data){
			drawAgePieChart(chart_data);
		} ,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function drawLineMonthChart5(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example
	var ctx = document.getElementById('stockMonthChart').getContext('2d');
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
					text: '월별 재고 입고 총 현황 TOP 5'
				},
			}
		}
	var chart = new Chart(ctx, data);
}

function drawManBarChart(data){
	//Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	//Bar Chart Example
	var ctx = document.getElementById("orderManChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : data.label,
			datasets : [ {
				label : data.dataset[0],
				backgroundColor : [
 					"rgba(2,117,216,1)",
					'rgba(255, 99, 132, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)' ],
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
						suggestedmax : 20,
						maxTicksLimit : 10
					},
					gridLines : {
						display : true
					}
				} ],
			},
			legend : {
				display : false
			},
			title:{
				display : true,
				text : '남자 주문 메뉴 순위'
			}
		}
	});
}

function drawWomanBarChart(data){
	//Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	//Bar Chart Example
	var ctx = document.getElementById("orderWomanChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : data.label2,
			datasets : [ {
				label : data.dataset[0],
				backgroundColor :[
 					"rgba(2,117,216,1)",
					'rgba(255, 99, 132, 1)',
					'rgba(153, 102, 255, 1)',
					'rgba(255, 206, 86, 1)',
					'rgba(75, 192, 192, 1)' ],
				borderColor : "rgba(2,117,216,1)",
				data : data.data2
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
						suggestedmax : 20,
						maxTicksLimit : 10
					},
					gridLines : {
						display : true
					}
				} ],
			},
			legend : {
				display : false
			},			
			title:{
				display : true,
				text : '여자 주문 메뉴 순위'
			}
		}
	});
}

function drawAgePieChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Pie Chart Example
	var ctx = document.getElementById("orderAgeChart");
	var myPieChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels : data.label,
			datasets : [ {
				data : data.data1,
				backgroundColor : [ '#007bff', '#dc3545', '#ffc107', '#28a745','#6919EC' ],
			} ],
		},
		options:{
			title:{
				display : true,
				text : '나이대 별 주문 횟수'
			}
		}
	});
}

function drawAreaChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';
	// Area Chart Example
	var ctx = document.getElementById("myChart1");
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
						suggestedmax : 100,
						maxTicksLimit : 5
					},
					gridLines : {
						color : "rgba(0, 0, 0, .125)",
					}
				} ],
			},
			legend : {
				display : false
			},
			title:{
				display : true,
				text : '시간대 별 주문 횟수'
			}
		}
	});
}