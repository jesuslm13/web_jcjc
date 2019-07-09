<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.bill.entity.*"%>
<%@ page import="java.util.*"%>
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

<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/material.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		nav_active("nav4");
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
		
		<div id="chartdiv" style="width: 100%; height: 400px;"></div>
		
		<br>		
		<table class="table table-hover text-small">
			<thead>
				<tr>
					<th>No</th>
					<th>의안명</th>
					<!-- <th>제안자</th>
					<th>제안자구분</th> -->
					<th>소관위원회</th>
					<th>제안일자</th>
					<th>회부일</th>
					<th>의결일자</th>
					<th>의결결과</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bill" items="${ billList }" varStatus="i">
				<tr>
					<td>${ i.index + 1 }</td>
					<td>${ bill.bill_name }</td>
					<%-- <td>${ bill.proposer }</td>
					<td>${ bill.proposer_kind }</td> --%>
					<td>${ bill.committee_name }</td>
					<td>${ fn:substring(bill.propose_dt, 0, 10) }</td>
					<td>${ fn:substring(bill.submit_dt, 0, 10) }</td>
					<td>${ fn:substring(bill.proc_dt, 0, 10) }</td>
					<td>${ bill.general_result }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>


		
	</div>
</div>







<!-- Chart code -->
<script type="text/javascript">
//Themes begin
am4core.useTheme(am4themes_animated);
// Themes end

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

$.ajax({
	type: "GET",
	url: "<%=root%>/bill/graphData.do?politician_no=${ politician.politician_no }",
	dataType: "json", // 응답받을 타입
	contentType: "application/json;charset=UTF-8",
	error: function() {
		alert("통신실패!!");
	},
	success: function(result) {
		chart.data = result.data;
	}
});

var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.renderer.grid.template.location = 0;
categoryAxis.dataFields.category = "bill";

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
valueAxis.min = 0;
valueAxis.max = 650;
valueAxis.strictMinMax = true;
valueAxis.renderer.minGridDistance = 50;



// axis break
var axisBreak = valueAxis.axisBreaks.create();
axisBreak.startValue = 100;
axisBreak.endValue = 600;
axisBreak.breakSize = 0.05;



/*
// make break expand on hover
var hoverState = axisBreak.states.create("hover");
hoverState.properties.breakSize = 1;
hoverState.properties.opacity = 0.1;
hoverState.transitionDuration = 1500;
*/



//axisBreak.defaultState.transitionDuration = 1000;



/*
// this is exactly the same, but with events
axisBreak.events.on("over", function() {
  axisBreak.animate(
    [{ property: "breakSize", to: 1 }, { property: "opacity", to: 0.1 }],
    1500,
    am4core.ease.sinOut
  );
});
axisBreak.events.on("out", function() {
  axisBreak.animate(
    [{ property: "breakSize", to: 0.005 }, { property: "opacity", to: 1 }],
    1000,
    am4core.ease.quadOut
  );
});*/

var series = chart.series.push(new am4charts.ColumnSeries());

series.dataFields.valueY = "count";
series.dataFields.categoryX = "bill";
series.columns.template.tooltipText = "{valueY.value}건";
//series.columns.template.tooltipY = 0;
series.columns.template.strokeWidth = 0;

chart.colors.list = [
  am4core.color(poly_color("${ politician.poly_name }"))
];

// as by default columns of the same series are of the same color, we add adapter which takes colors from chart.colors color set
series.columns.template.adapter.add("fill", function(fill, target) {
  return chart.colors.getIndex(target.dataItem.index);
});

</script>




</body>
</html>