<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.politician.entity.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<style>
#profile:hover {
	background: powderblue;
	opacity: 0.7;
}
</style>


<script type="text/javascript">
function politicianProfile(politician_no) {
	location.href = "<%=root%>/politician/prediction.do?politician_no=" + politician_no;	
}
</script>
</head>
<body>

<!-- header -->
<div class="fixed-top">
	<jsp:include page="/WEB-INF/view/header/title.jsp" flush="true"/>
    <jsp:include page="/WEB-INF/view/header/menu.jsp" flush="true"/>
</div>

<!-- body -->
<div class="container-fluid">

	<div class="row d-flex justify-content-center">
		<c:forEach var="politician" items="${ all }" varStatus="i">
			<div class="border m-2 p-0" id="profile" onclick="politicianProfile(${ politician.politician_no })" style="width: 180px; height: 270px;">
				<div class="row-fluid d-flex justify-content-center">
					<img src="${ politician.politician_jpg_link }" alt="프로필 사진" style="width: 100%; height: 220px;"/>
				</div>
				<div class="row-fluid text-white" id="poly${ i.index }">
					<div class="container">
						<div class="row d-flex justify-content-center">
							<p class="m-0 p-0">${ politician.politician_kor_name }</p>
						</div>
						<div class="row d-flex justify-content-center">
							<p class="m-0 p-0">${ politician.orig_name }</p>
						</div>
					</div>
				</div>
				<%-- <div class="row-fluid d-flex justify-content-center">
					${ politician.politician_no }
				</div> --%>
			</div>
			
			<script type="text/javascript">
				poly_color("${ politician.poly_name }", "${ i.index }");
				
				function poly_color(poly_name, index) {
					if (poly_name == "더불어민주당") 
						$("#poly" + index).css("background-color", "#357FC4");
					else if (poly_name == "자유한국당") 
						$("#poly" + index).css("background-color", "#DC5356");
					else if (poly_name == "바른미래당") 
						$("#poly" + index).css("background-color", "#36B8CF");
					else if (poly_name == "민주평화당") 
						$("#poly" + index).css("background-color", "#41AF39");
					else if (poly_name == "정의당") 
						$("#poly" + index).css("background-color", "#E8D825");
					else if (poly_name == "무소속") 
						$("#poly" + index).css("background-color", "#A6A6A6");
					else if (poly_name == "민중당") 
						$("#poly" + index).css("background-color", "#FD4E37");
					else if (poly_name == "대한애국당") 
						$("#poly" + index).css("background-color", "#384CE8");
					else $("#poly" + index).css("background-color", "#000000");
				}
			</script>
		</c:forEach>
	</div>

</div>

</body>
</html>
