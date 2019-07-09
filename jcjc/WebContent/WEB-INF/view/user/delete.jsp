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
				<h2 class="modal-title">계정 삭제</h2>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			
			<form:form modelAttribute="user" commandName="user">
				<div class="modal-body">
					<div class="container text-center">
							<p>${ user.user_name } 님 정말 삭제하시겠습니까?<br>
							그렇다면 비밀번호를 입력해주세요.</p>
					</div>
					<div class="container">
						<div class="form-group row">
							<form:password path="user_password" class="form-control input-lg" placeholder="Password"/>
							<form:errors path="user_password" class="text-danger" />
						</div>
					</div>
				</div>
	
				<div class="modal-footer">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-sm-6 mb-3">
								<input type="submit" value="계정 삭제" class="btn btn-danger btn-block btn-lg">
							</div>
							<div class="col-sm-6">
								<input type="reset" value="초기화" class="btn btn-primary btn-block btn-lg" />
							</div>
						</div>
					</div>
				</div>
			</form:form>
			
		</div>
	</div>
</div>











