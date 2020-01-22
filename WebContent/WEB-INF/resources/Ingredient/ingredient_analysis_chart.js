function getChartData(cr, chart_search) {
	$.ajax({
		// 접속할 서버 쪽 url 주소 설정
		url : cr + "/ingredeint_analysis_chart.ida"
		// 전송 방법 설정
		,
		type : "post"
		// 서버로 보낼 파라미터명과 파라미터값을 설정
		,
		data : "chart_search=" + chart_search
		// 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
		,
		success : function(chart_data) {

			$("#myChart").remove();
			$(".card-body")
					.append(
							'<canvas id="myChart" width="100%" height="30"></canvas>');

			if ($("[name=chart_search]").val() == '주') {
				drawBarChartWeek2(chart_data);
				$(".top3")
						.click(
								function() {
									$("#myChart").remove();
									$(".card-body")
											.append(
													'<canvas id="myChart" width="100%" height="30"></canvas>');

									drawBarChartWeek1(chart_data);
								});
				$(".top5")
						.click(
								function() {
									$("#myChart").remove();
									$(".card-body")
											.append(
													'<canvas id="myChart" width="100%" height="30"></canvas>');

									drawBarChartWeek2(chart_data);
								});
				$(".top10")
						.click(
								function() {
									$("#myChart").remove();
									$(".card-body")
											.append(
													'<canvas id="myChart" width="100%" height="30"></canvas>');

									drawBarChartWeek3(chart_data);
								});
			} else if ($("[name=chart_search]").val() == '월') {
				drawAreaChartMonth2(chart_data);
				$(".top3")
						.click(
								function() {
									$("#myChart").remove();
									$(".card-body")
											.append(
													'<canvas id="myChart" width="100%" height="30"></canvas>');
									drawAreaChartMonth1(chart_data);
								});
				$(".top5")
						.click(
								function() {
									$("#myChart").remove();
									$(".card-body")
											.append(
													'<canvas id="myChart" width="100%" height="30"></canvas>');
									drawAreaChartMonth2(chart_data);
								});
				$(".top10")
						.click(
								function() {
									$("#myChart").remove();
									$(".card-body")
											.append(
													'<canvas id="myChart" width="100%" height="30"></canvas>');
									drawAreaChartMonth3(chart_data);
								});
			} else if ($("[name=chart_search]").val() == '분기') {
				drawPieChart(chart_data);
				$(".top3").hide();
				$(".top5").hide();
				$(".top10").hide();
			}
		}
		// 서버의 응답을 못받았을 경우 실행할 익명함수 설정
		,
		error : function() {
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}
function drawAreaChartMonth1(data) {

	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example

	var ctx = document.getElementById('myChart').getContext('2d');
	var data = {
		// The type of chart we want to create
		type : 'line',
		// The data for our dataset
		data : {
			labels : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월",
					"10월", "11월", "12월", ],
			datasets : [ {
				label : "삼겹살 10mm",
				backgroundColor : 'rgb(255, 99, 132)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 99, 132)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 12, 10, 7, 22, 19, 24, 27, 30, 15, 11, 12, 19 ]
			}, {
				label : "깐양파",
				backgroundColor : 'rgb(255, 153, 000)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 153, 000)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 4, 5, 17, 22, 39, 29, 15, 12, 13, 11, 22, 27 ]
			}, {
				label : "청양고추",
				backgroundColor : 'rgb(000, 204, 051)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(000, 204, 051)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 20, 25, 17, 22, 13, 14, 15, 12, 13, 5, 12, 17 ]
			}, ]
		},
		// Configuration options go here
		options : {

			responsive : true,
			hover : {
				animationDuration : 0

			},
			title : {
				display : true,
				text : '월 별 식자재 가격 변동 현황 TOP 5 ( 단위 : % , 기준 : 전달 대비)'
			},

		}
	}
	var chart = new Chart(ctx, data);

}

function drawAreaChartMonth2(data) {

	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example

	var ctx = document.getElementById('myChart').getContext('2d');
	var data = {
		// The type of chart we want to create
		type : 'line',
		// The data for our dataset
		data : {
			labels : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월",
					"10월", "11월", "12월", ],
			datasets : [ {
				label : "삼겹살 10mm",
				backgroundColor : 'rgb(255, 99, 132)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 99, 132)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 12, 10, 7, 22, 19, 24, 27, 30, 15, 11, 12, 19 ]
			}, {
				label : "깐양파",
				backgroundColor : 'rgb(255, 153, 000)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 153, 000)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 4, 5, 17, 22, 39, 29, 15, 12, 13, 11, 22, 27 ]
			}, {
				label : "청양고추",
				backgroundColor : 'rgb(000, 204, 051)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(000, 204, 051)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 20, 25, 17, 22, 13, 14, 15, 12, 13, 5, 12, 17 ]
			}, {
				label : "대파",
				backgroundColor : 'rgb(051, 102, 255)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(051, 102, 255)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 15, 17, 20, 22, 10, 8, 6, 10, 13, 15, 22, 24 ]
			}, {
				label : "생새우살",
				backgroundColor : 'rgb(204, 102, 255)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(204, 102, 255)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 5, 7, 7, 12, 20, 28, 26, 20, 13, 15, 8, 4 ]
			} ]
		},
		// Configuration options go here
		options : {

			responsive : true,
			hover : {
				animationDuration : 0

			},
			title : {
				display : true,
				text : '월 별 식자재 가격 변동 현황 TOP 5 ( 단위 : % , 기준 : 전달 대비)'
			},

		}
	}
	var chart = new Chart(ctx, data);

}

function drawAreaChartMonth3(data) {

	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Area Chart Example

	var ctx = document.getElementById('myChart').getContext('2d');
	var data = {
		// The type of chart we want to create
		type : 'line',
		// The data for our dataset
		data : {
			labels : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월",
					"10월", "11월", "12월", ],
			datasets : [ {
				label : "삼겹살 10mm",
				backgroundColor : 'rgb(255, 99, 132)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 99, 132)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 12, 10, 7, 22, 19, 24, 27, 30, 15, 11, 12, 19 ]
			}, {
				label : "깐양파",
				backgroundColor : 'rgb(255, 153, 000)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 153, 000)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 4, 5, 17, 22, 39, 29, 15, 12, 13, 11, 22, 27 ]
			}, {
				label : "청양고추",
				backgroundColor : 'rgb(000, 204, 051)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(000, 204, 051)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 20, 25, 17, 22, 13, 14, 15, 12, 13, 5, 12, 17 ]
			}, {
				label : "대파",
				backgroundColor : 'rgb(051, 102, 255)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(051, 102, 255)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 15, 17, 20, 22, 10, 8, 6, 10, 13, 15, 22, 24 ]
			}, {
				label : "생새우살",
				backgroundColor : 'rgb(255, 255, 051)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(255, 255, 051)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 5, 7, 7, 12, 20, 28, 26, 20, 13, 15, 8, 4 ]
			}, {
				label : "양배추",
				backgroundColor : 'rgb(204, 102, 255)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(204, 102, 255)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 22, 27, 17, 12, 25, 18, 16, 10, 8, 15, 18, 24 ]
			}, {
				label : "흙당근",
				backgroundColor : 'rgb(000, 255, 255)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(000, 255, 255)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 15, 17, 17, 22, 20, 28, 26, 20, 23, 15, 18, 14 ]
			}, {
				label : "무우",
				backgroundColor : 'rgb(153, 102, 051)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(153, 102, 051)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 5, 7, 7, 2, 10, 8, 6, 11, 13, 5, 8, 4 ]
			}, {
				label : "깐마늘",
				backgroundColor : 'rgb(204, 204, 255)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(204, 204, 255)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 25, 27, 17, 12, 20, 18, 16, 21, 13, 18, 13, 14 ]
			}, {
				label : "브로콜리",
				backgroundColor : 'rgb(102, 102, 102)',
				fill : false, // line의 아래쪽을 색칠할 것인가?
				borderColor : 'rgb(102, 102, 102)',
				lineTension : 0.1, // 값을 높이면, line의 장력이 커짐.
				data : [ 1, 2, 1, 3, 5, 8, 16, 20, 13, 15, 28, 24 ]
			} ]
		},
		// Configuration options go here
		options : {

			responsive : true,
			hover : {
				animationDuration : 0

			},
			title : {
				display : true,
				text : '월 별 식자재 가격 변동 현황 TOP 5 ( 단위 : % , 기준 : 전달 대비)'
			},

		}
	}
	var chart = new Chart(ctx, data);

}

function drawBarChartWeek1(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Bar Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ "첫째 주", "둘째 주", "셋째 주", "넷째 주" ],
			datasets : [ {
				label : "삼겹살 10mm",
				backgroundColor : "#FC3A00",
				borderColor : "#FC3A00",
				data : [ 4, 16, 10, 30 ],
			}, {
				label : "깐양파",
				backgroundColor : "rgb(255, 153, 000)",
				borderColor : "rgb(255, 153, 000)",
				data : [ 14, 26, 40, 28 ],
			}, {
				label : "청양고추",
				backgroundColor : "#FFEE00",
				borderColor : "#FFEE00",
				data : [ 24, 26, 20, 30 ],
			}, ],
		},
		options : {
			responsive : true,
			hover : {
				animationDuration : 0

			},
			title : {
				display : true,
				text : '주 별 식자재 가격 변동 현황 ( 단위 : % )'
			},
			scales : {
				xAxes : [ {
					time : {
						unit : 'month'
					},
					gridLines : {
						display : true
					},
					ticks : {
						maxTicksLimit : 12
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 100,
						maxTicksLimit : 5
					},
					gridLines : {
						display : true
					}
				} ],
			},
			legend : {
				display : true,
			}
		}
	});
}

function drawBarChartWeek2(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Bar Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ "첫째 주", "둘째 주", "셋째 주", "넷째 주" ],
			datasets : [ {
				label : "삼겹살 10mm",
				backgroundColor : "#FC3A00",
				borderColor : "#FC3A00",
				data : [ 4, 16, 10, 30 ],
			}, {
				label : "깐양파",
				backgroundColor : "rgb(255, 153, 000)",
				borderColor : "rgb(255, 153, 000)",
				data : [ 14, 26, 40, 28 ],
			}, {
				label : "청양고추",
				backgroundColor : "#FFEE00",
				borderColor : "#FFEE00",
				data : [ 24, 26, 20, 30 ],
			}, {
				label : "대파",
				backgroundColor : "#8ADB00",
				borderColor : "#8ADB00",
				data : [ 14, 26, 20, 40 ],
			}, {
				label : "생새우살",
				backgroundColor : "#0077E0",
				borderColor : "#0077E0",
				data : [ 24, 56, 20, 30 ],
			} ],
		},
		options : {
			responsive : true,
			hover : {
				animationDuration : 0

			},
			title : {
				display : true,
				text : '주 별 식자재 가격 변동 현황 ( 단위 : % )'
			},
			scales : {
				xAxes : [ {
					time : {
						unit : 'month'
					},
					gridLines : {
						display : true
					},
					ticks : {
						maxTicksLimit : 12
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 100,
						maxTicksLimit : 5
					},
					gridLines : {
						display : true
					}
				} ],
			},
			legend : {
				display : true,
			}
		}
	});
}

function drawBarChartWeek3(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Bar Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ "첫째 주", "둘째 주", "셋째 주", "넷째 주" ],
			datasets : [ {
				label : "삼겹살 10mm",
				backgroundColor : "#FC3A00",
				borderColor : "#FC3A00",
				data : [ 4, 16, 10, 30 ],
			}, {
				label : "깐양파",
				backgroundColor : "rgb(255, 153, 000)",
				borderColor : "rgb(255, 153, 000)",
				data : [ 14, 26, 40, 28 ],
			}, {
				label : "청양고추",
				backgroundColor : "#FFEE00",
				borderColor : "#FFEE00",
				data : [ 24, 26, 20, 30 ],
			}, {
				label : "대파",
				backgroundColor : "#8ADB00",
				borderColor : "#8ADB00",
				data : [ 14, 26, 20, 40 ],
			}, {
				label : "생새우살",
				backgroundColor : "#0077E0",
				borderColor : "#0077E0",
				data : [ 24, 56, 20, 30 ],
			}, {
				label : "양배추",
				backgroundColor : "#0003E5",
				borderColor : "#0003E5",
				data : [ 14, 16, 10, 15 ],
			}, {
				label : "흙당근",
				backgroundColor : "#00D5F2",
				borderColor : "#00D5F2",
				data : [ 4, 6, 10, 3 ],
			}, {
				label : "무우",
				backgroundColor : "#BC00B6",
				borderColor : "#BC00B6",
				data : [ 14, 36, 30, 40 ],
			}, {
				label : "깐마늘",
				backgroundColor : "rgb(051, 051, 000)",
				borderColor : "rgb(051, 051, 000)",
				data : [ 44, 36, 20, 30 ],
			}, {
				label : "브로콜리",
				backgroundColor : "rgb(153, 153, 153)",
				borderColor : "rgb(153, 153, 153)",
				data : [ 24, 26, 30, 40 ],
			} ],
		},
		options : {
			responsive : true,
			hover : {
				animationDuration : 0

			},
			title : {
				display : true,
				text : '주 별 식자재 가격 변동 현황 ( 단위 : % )'
			},
			scales : {
				xAxes : [ {
					time : {
						unit : 'month'
					},
					gridLines : {
						display : true
					},
					ticks : {
						maxTicksLimit : 12
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 100,
						maxTicksLimit : 5
					},
					gridLines : {
						display : true,
					}
				} ],
			},
			legend : {
				display : true,
			}
		}
	});
}

function drawPieChart(data) {
	// Set new default font family and font color to mimic Bootstrap's default
	// styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Pie Chart Example
	var ctx = document.getElementById("myChart");
	var myPieChart = new Chart(ctx,
			{
				type : 'pie',
				data : {
					labels : [ "1/4분기", "2/4분기", "3/4분기", "4/4분기" ],
					datasets : [ {
						data : [ 38, 22, 15, 25 ],
						backgroundColor : [ '#ff6384', '#36ae2b', '#ffce56',
								'#36a2eb' ],
					} ],
				},

				options : {
					responsive : true,
					title : {
						display : true,
						text : '분기 별 식자재 가격 변동 현황 ( 단위 : % )'
					},
				},
			});
}