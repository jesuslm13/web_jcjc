<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.user.entity.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
</head>
<body>

<!-- header -->
<div class="fixed-top">
	<jsp:include page="/WEB-INF/view/header/title.jsp" flush="true"/>
    <jsp:include page="/WEB-INF/view/header/menu.jsp" flush="true"/>
</div>

<!-- body -->
<div class="container-fluid">
	<div class="modal-dialog">
	
		<div class="modal-content">
	
			<div class="modal-header">
				<h2 class="modal-title">아이디 찾기</h2>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			
			<form:form modelAttribute="user" commandName="user_find">
				<div class="modal-body">
					<div class="container text-center">
							<p>찾으려는 ID의 회원정보를 입력해주세요.</p>
					</div>
					<div class="container">
						<div class="form-group row">
							<form:input path="user_name" class="form-control input-lg" placeholder="Name"/>
							<form:errors path="user_name" class="text-danger" />
						</div>
						<div class="form-group row">
							<form:input path="user_email" class="form-control input-lg" placeholder="E-mail"/>
							<form:errors path="user_email" class="text-danger" />
						</div>
					</div>
				</div>
	
				<div class="modal-footer">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-sm-6">
								<input type="submit" value="ID 찾기" class="btn btn-success btn-block btn-lg">
							</div>
						</div>
					</div>
				</div>
			</form:form>
			
		</div>
	</div>
</div>
</body>
</html>