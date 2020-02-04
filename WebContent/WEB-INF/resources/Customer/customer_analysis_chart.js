function getChartData(cr, chart_search, chart_cnt, age){
	if($("[name=chart_search]").val()=="나이대") {
		$(".chart_cnt").show();
		$(".age_select").show();
	} else if($("[name=chart_search]").val() == "성별") {
		$(".chart_cnt").show();
	} else {
		$(".chart_cnt").hide();
		$(".age_select").hide();
	}
	
	$.ajax({
		url : cr + "/customer_analysis_chart.ida"
		, type : "post"
		, data : "chart_search=" + chart_search + "&chart_cnt=" + chart_cnt + "&age=" + age
		, success : function(chart_data){
			$("[id^=myChart]").remove();
			$(".card-body").append(
					'<canvas id="myChart" width="100%" height="30"></canvas>'+
					'<canvas id="myChart1" width="100%" height="30"></canvas>'
			);

			if($("[name=chart_search]").val() == '성별'){
				drawGenderPieChart(chart_data);
			}else if($("[name=chart_search]").val()=="나이대"){
				drawBarChart(chart_data);
			}
		}
		,error : function(){
			alert("서버 접속 실패하였습니다. 다시 시도해주시기 바랍니다.");
		}
	});
}

function drawGenderPieChart(data) {
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
				backgroundColor : [ '#007bff', '#dc3545', '#ffc107', '#28a745','#6919EC' ],
			} ],
		},
		options:{
			title:{
				display : true,
				text : '고객 성별 현황'
			}
		}
	});
}

function drawBarChart(data){
	//Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	//Bar Chart Example
	var ctx = document.getElementById("myChart1");
	var myLineChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : data.label,
			datasets : [ {
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
				text : '고객 나이대 현황'
			}
		}
	});
}