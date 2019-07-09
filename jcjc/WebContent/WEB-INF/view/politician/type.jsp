<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html class="fluid">
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
</head>
<body class="fluid">

<!-- header -->
<div class="fixed-top">
	<jsp:include page="/WEB-INF/view/header/title.jsp" flush="true"/>
    <jsp:include page="/WEB-INF/view/header/menu.jsp" flush="true"/>
</div>

<!-- body -->
<div class="w-100 h-100 d-flex align-items-center">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 m-2">
				<a href="<%=root%>/politician/location.do" class="btn btn-secondary btn-block">국회의원</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 m-2">
				<a href="#" class="btn btn-secondary btn-block">기초</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 m-2">
				<a href="#" class="btn btn-secondary btn-block">광역</a>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 m-2">
				<a href="#" class="btn btn-secondary btn-block">비례대표</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>