<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jcjc.politician.entity.*"%>
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
		getCommitmentList();
		nav_active("nav1");
	});
	
	function getCommitmentList() {
		$.ajax({
			type: "GET",
			url: "<%=root%>/commitment/pred.do",
			dataType: "text", // 응답받을 타입
			error: function() {
				alert("통신실패!!");
			},
			success: function(data) {
				$("#commitment-list").html(data);
			}			
		});
	}
	
	function poly_color(poly_name) {
		var poly_color = new Array();
		
		if (poly_name == "더불어민주당") {
			poly_color[0] = "#357FC4";
			poly_color[1] = "#5092cf";
			poly_color[2] = "#6fa5d8";
		}
		else if (poly_name == "자유한국당") {
			poly_color[0] = "#DC5356";
			poly_color[1] = "#e16c6f";
			poly_color[2] = "#e68688";
		}
		else if (poly_name == "바른미래당") {
			poly_color[0] = "#36B8CF";
			poly_color[1] = "#54c2d6";
			poly_color[2] = "#72cddd";
		}
		else if (poly_name == "민주평화당") {
			poly_color[0] = "#41AF39";
			poly_color[1] = "#54c44c";
			poly_color[2] = "#72cf6c";
		}
		else if (poly_name == "정의당") {
			poly_color[0] = "#E8D825";
			poly_color[1] = "#ebdd45";
			poly_color[2] = "#eee366";
		}
		else if (poly_name == "무소속") {
			poly_color[0] = "#A6A6A6";
			poly_color[1] = "#b3b3b3";
			poly_color[2] = "#c0c0c0";
		}
		else if (poly_name == "민중당") {
			poly_color[0] = "#FD4E37";
			poly_color[1] = "#fd6855";
			poly_color[2] = "#fd8373";
		}
		else if (poly_name == "대한애국당") {
			poly_color[0] = "#384CE8";
			poly_color[1] = "#5566eb";
			poly_color[2] = "#7381ee";
		}
		else {
			poly_color[0] = "#000000";
			poly_color[1] = "#262626";
			poly_color[2] = "#4c4c4c";
		}
	
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

<!-- body -->
<div class="row p-0 m-0">
	<jsp:include page="/WEB-INF/view/politician/menu.jsp" />
	<!-- body -->
		<div class="col p-3">
		
		<div class="container">
			<div class="row justify-content-center">
				<div id="chartdiv" style="width: 100%; height: 400px;"></div>
			</div>
			<div class="row justify-content-center">
				<div class="text-center" id="commitment-list" style="width: 90%;"></div>
			</div>
<div id="test" class="border border-danger">제이슨 데이터</div>
		</div>
		
	</div>
</div>


<!-- Chart code -->
<script type="text/javascript">
// Themes begin
//am4core.useTheme(am4themes_material);
am4core.useTheme(am4themes_animated);
// Themes end

var chart = am4core.create("chartdiv", am4charts.PieChart3D);
chart.hiddenState.properties.opacity = 0; // this creates initial fade-in
chart.hiddenState.properties.radius = am4core.percent(0);

chart.legend = new am4charts.Legend();
/* 
chart.data = [
  {
    "commitment": "진행",
    "count": 1
  },
  {
	"commitment": "미이행",
    "count": 1
  },
  {
	"commitment": "이행",
    "count": 1
  }
];
 */

$.ajax({
	type: "GET",
	url: "<%=root%>/commitment/graphData.do?politician_no=${ politician.politician_no }",
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
 
var series = chart.series.push(new am4charts.PieSeries3D());

var color = poly_color("${ politician.poly_name }");
series.colors.list = [
  am4core.color(color[0]),
  am4core.color(color[1]),
  am4core.color(color[2])
];

series.dataFields.value = "count";
series.dataFields.category = "commitment";
series.slices.template.tooltipText = "{value}건";

series.ticks.template.disabled = true;
series.alignLabels = false;
series.labels.template.text = "{category}\n{value.percent.formatNumber('#.')}%";
series.labels.template.radius = am4core.percent(-40);
series.labels.template.fill = am4core.color("white");

chart.legend.valueLabels.template.text = "";


</script>


</body>
</html>