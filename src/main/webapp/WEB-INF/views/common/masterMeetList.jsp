<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 구글경로JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- JSTL Core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>M.MEET_NUM</th>
							<th>MA.MAIN_CATEGORY_NAME</th>
							<th>MC.CATEGORY_NAME</th>
							<th>M.MEET_NAME</th>
							<th>L.LOC_NAME</th>
							<th>U.USER_NICKNAME</th>
							<th>M.MEET_REGIST_DATE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="#{meetlist}" var="list">
							<tr>
								<td>${list.meet_num}</td>
								<td>${list.main_category_name}</td>
								<td>${list.category_name}</td>
								<td>${list.meet_name}</td>
								<td>${list.loc_name}</td>
								<td>${list.user_nickname}</td>
								<td>${list.meet_regist_date}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- 그래프 -->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {
			'packages' : [ 'corechart' ]
		});
		google.charts.setOnLoadCallback(drawVisualization);

		function drawVisualization() {
			
// 			var arr = new Array();
			
// 			arr[0] = ['날짜',"로그인 수", "만남 수"];
			
			
// 			<c:forEach var="stat" items="${statisticallist}" varStatus="status">
// 				var index = parseInt('${status.index}')+1;
// 				arr[index] = ['${stat.todate}', ${stat.todaylogin}, ${stat.todaymeet}];
// 			</c:forEach>
			
// 			console.log(arr);
			
// 			var data = google.visualization.arrayToDataTable
// 			([
// 				[ 'date', '로그인','만남 수' ],
// 				for(){
					
// 				}
// 				[ '12/05', ${todaylogin}, ${todaymeet} ]
// 			]);
			var data = google.visualization.arrayToDataTable
			([
				[ 'date','로그인 수', '로그인 회원 수','만남 수' ]
				<c:forEach var="stat" items="${statisticallist}" varStatus="status">
					,['${stat.todate}',${stat.todaylogin}, ${stat.todayloginmember}, ${stat.todaymeet} ]
				</c:forEach>
			]);

			var options = {
				title : '홈페이지 상황',
				vAxis : {
					title : ''
				},
				hAxis : {
					title : '일'
				},
				seriesType : 'bars'
// 				seriesType : 'line'
// 				,
// 				series : {
// 					5 : {
// 						type : 'line'
// 					}
// 				}
			};

			var chart = new google.visualization.ComboChart(document
					.getElementById('chart_div'));
			chart.draw(data, options);
		}

		//성별비율
		google.charts.load('current', {'packages':[ 'corechart' ]});
      	google.charts.setOnLoadCallback(drawGenderChart);

		function drawGenderChart() {

	        var data = google.visualization.arrayToDataTable([
				['성별','수']
				,['남성', ${mcount}]
				,['여성', ${fcount}]
			]);

			var options = {
				title: '성별비율',
// 				pieHole: 0.7,
				pieSliceTextStyle: {
					color: 'black',
				},
				pieSliceText: 'percentage',
				legend: 'none'
			};


			var chart = new google.visualization.PieChart(document.getElementById('donut_single'));
			chart.draw(data, options);
		}
		//만남 상태 비율
		google.charts.load('current', {'packages':[ 'corechart' ]});
      	google.charts.setOnLoadCallback(drawMeetStateChart);

		function drawMeetStateChart() {

	        var data = google.visualization.arrayToDataTable([
				['상태','수']
				,['대기중', ${wmeet}]
				,['만남중', ${imeet}]
				,['만남완료', ${cmeet}]
			]);

			var options = {
				title: '만남 비율',
// 				pieHole: 0.7,
				pieSliceTextStyle: {
					color: 'black',
				},
				pieSliceText: 'percentage',
				legend: 'none'
			};


			var chart = new google.visualization.PieChart(document.getElementById('donut_meetState'));
			chart.draw(data, options);
		}
	</script>
	<!-- 로그인 통계 -->
	<div id="chart_div"></div>
	<!-- 성비 -->
	<div id="donut_single"></div>
	<div id="donut_meetState"></div>
</body>
</html>