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
	
		<div class="modal-content text-center">
	
			<div class="modal-header">
				<h2 class="modal-title">로그인</h2>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			
			<form:form modelAttribute="user">
				<div class="modal-body">
					<div class="container">
						<div class="form-group row">
							<form:input path="user_id" class="form-control input-lg" placeholder="ID"/>
							<form:errors path="user_id" class="text-danger" />
						</div>
						<div class="form-group row">
							<form:password path="user_password" class="form-control input-lg" placeholder="Password"/>
							<form:errors path="user_password" class="text-danger" />
						</div>
					</div>
				</div>
	
				<div class="modal-footer pb-0">
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-sm-6 mb-3">
								<input type="submit" value="로그인" class="btn btn-primary btn-block btn-lg" />
							</div>
							<div class="col-sm-6  mb-3">
								<input type="reset" value="취소" class="btn btn-danger btn-block btn-lg" />
							</div>
						</div>
						<div class="row justify-content-center pb-0">
							<div class="col-sm-6 mb-3">
								<a href="<%=root%>/user/findid.do" class="btn btn-success btn-block btn-lg">아이디 찾기</a>
							</div>
							<div class="col-sm-6">
								<a href="<%=root%>/user/findpassword.do" class="btn btn-success btn-block btn-lg">비밀번호 찾기</a>
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