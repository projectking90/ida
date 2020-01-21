function getChartData(cr, chart_search){
	$.ajax({
	    // 접속할 서버 쪽 url 주소 설정
	    url : cr + "/ingredeint_analysis_chart.ida"
	    // 전송 방법 설정
	    , type : "post"
	    // 서버로 보낼 파라미터명과 파라미터값을 설정
	    , data : "chart_search=" + chart_search
	    // 서버의 응답을 성공적으로 받았을 경우 실행할 익명함수 설정
	    , success : function(chart_data){

	         $("#myChart").remove();
	         $(".card-body").append(
	               '<canvas id="myChart" width="100%" height="30"></canvas>');

	       if($("[name=chart_search]").val() == '주'){
	    	   drawAreaChart(chart_data);
	       }else if($("[name=chart_search]").val() == '월'){
	    	   drawBarChart(chart_data);
	       }else if($("[name=chart_search]").val() == '분기'){
	    	   drawPieChart(chart_data);
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
			labels : ["첫째주","둘째주","셋째주","넷째주"],
			datasets : [ {
				label : "식자재 가격 변동률",
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
				data : [12,34,5,22],
			} ],
		},
		options : {
			responsive: true,
			title: {
				display: true,
				text: '주차별 식자재 가격 변동 현황 ( 단위 : % )'
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
						maxTicksLimit : 10
					}
				} ],
				yAxes : [ {
					ticks : {
						min : 0,
						max : 100,
						maxTicksLimit : 10
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

function drawBarChart(data){
	//Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Bar Chart Example
	var ctx = document.getElementById("myChart");
	var myLineChart = new Chart(ctx, {
	  type: 'bar',
	  data: {
	    labels: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
	    datasets: [{
	      label: data.dataset,
	      backgroundColor: "rgba(2,117,216,1)",
	      borderColor: "rgba(2,117,216,1)",
	      data: [22,20,18,11,8,9,15,17,6,8,10,21,29],
	    }],
	  },
	  options: {
			responsive: true,
			title: {
				display: true,
				text: '월 별 식자재 가격 변동 현황 ( 단위 : % )'
			},
	    scales: {
	      xAxes: [{
	        time: {
	          unit: 'month'
	        },
	        gridLines: {
	          display: false
	        },
	        ticks: {
	          maxTicksLimit: 12
	        }
	      }],
	      yAxes: [{
	        ticks: {
	          min: 0,
	          max: 100,
	          maxTicksLimit: 5
	        },
	        gridLines: {
	          display: true
	        }
	      }],
	    },
	    legend: {
	      display: false
	    }
	  }
	});
}

function drawPieChart(data){
	// Set new default font family and font color to mimic Bootstrap's default styling
	Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	Chart.defaults.global.defaultFontColor = '#292b2c';

	// Pie Chart Example
	var ctx = document.getElementById("myChart");
	var myPieChart = new Chart(ctx, {
	  type: 'pie',
	  data: {
	    labels: ["1/4분기","2/4분기","3/4분기","4/4분기"],
	    datasets: [{
	      data: [38,22,15,25],
	      backgroundColor: ['#ff6384', '#36ae2b', '#ffce56', '#36a2eb'],
	    }],
	  },

	    options: {
			responsive: true,
			title: {
				display: true,
				text: '분기 별 식자재 가격 변동 현황 ( 단위 : % )'
	        },
	    },
	});
}