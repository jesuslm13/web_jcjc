<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정치정치</title>
	<!-- Bootsrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="<%=root%>/css/main.css">
    <!-- FontAwesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

<script type="text/javascript">
	$(document).ready(function() {
		nav_active("nav5");
	});
	
	function poly_color(poly_name) {
		var poly_color;
		
		if (poly_name == "더불어민주당") poly_color = "#357FC4";
		else if (poly_name == "자유한국당") poly_color = "#DC5356";
		else if (poly_name == "바른미래당") poly_color = "#36B8CF";
		else if (poly_name == "민주평화당") poly_color = "#41AF39";
		else if (poly_name == "정의당") poly_color = "#E8D825";
		else if (poly_name == "무소속") poly_color = "#A6A6A6";
		else if (poly_name == "민중당") poly_color = "#FD4E37";
		else if (poly_name == "대한애국당") poly_color = "#384CE8";
		else poly_color = "#000000";

		return poly_color;
	}
</script>

</head>
<body>

<!-- header -->
<div class="fixed-top">
	<jsp:include page="/WEB-INF/view/header/title.jsp" flush="true"/>
    <jsp:include page="/WEB-INF/view/header/menu.jsp" flush="true"/>
</div>

<jsp:include page="/politician/profile.do" flush="true"/>

<div class="row p-0 m-0">
	<jsp:include page="/WEB-INF/view/politician/menu.jsp" />
	<!-- body -->
	<div class="col p-3">
	
			<div id="chartdiv" style="width: 100%; height: 500px;"></div>
			
			<table class="table table-hover text-small">
				<thead>
					<tr>
						<c:forEach var="activity" items="${ activity_list }" varStatus="i">
							<th>${ fn:replace(activity.committee, '위원회', '') }</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="activity" items="${ activity_list }" varStatus="i">
							<td>${ activity.count }</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
			
			<div id="test" class="border border-success">제이슨 데이터</div>
			
	</div>
</div>



<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>

<!-- Chart code -->
<script>
// Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

/* Create chart instance */
var chart = am4core.create("chartdiv", am4charts.RadarChart);

$.ajax({
	type: "GET",
	url: "<%=root%>/activity/graphData.do?politician_no=${ politician.politician_no }",
	dataType: "json", // 응답받을 타입
	contentType: "application/json;charset=UTF-8",
	error: function() {
		alert("통신실패!!");
	},
	success: function(result) {
		chart.data = result.data;
		$("#test").html(JSON.stringify(result.data));
	}
});

/* Create axes */
var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "committee";

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.renderer.axisFills.template.fill = chart.colors.getIndex(2);
valueAxis.renderer.axisFills.template.fillOpacity = 0.05;
valueAxis.cursorTooltipEnabled = true;

/* Create and configure series */
var series = chart.series.push(new am4charts.RadarSeries());
series.dataFields.categoryX = "committee";
series.dataFields.valueY = "count";
series.strokeWidth = 3;
series.stroke = poly_color("${ politician.poly_name }");
series.fill = poly_color("${ politician.poly_name }");
series.fillOpacity = 0.5;
//series.valueAxis.template.tooltipText = "{valueY}건";
//series.dateAxis.template.tooltipText = "{valueY}건";

</script>


</body>
</html>