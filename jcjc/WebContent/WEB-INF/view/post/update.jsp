<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="jcjc.post.entity.*"%>
<%@ page import="java.util.*"%>
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

<jsp:include page="/politician/profile.do" flush="true"/>

<div class="row p-0 m-0">
	<jsp:include page="/WEB-INF/view/politician/menu.jsp" />
	<!-- body -->
	<div class="col p-3">
	
	
	
		<div class="modal-dialog">
			<div class="modal-content text-center">
				<div class="modal-header">
					<h2 class="modal-title">게시물 수정</h2>
				</div>
				<form:form commandName="post">
					<div class="modal-body">
						<!-- 
						<div class="form-group row">
							<form:input path="post_no" class="form-control" readonly="true"/>
						</div>
						<div class="form-group row">
							<form:input path="commitment_no" class="form-control" readonly="true"/>
						</div>
						<div class="form-group row">
							<form:input path="user_id" class="form-control" readonly="true"/>
						</div>
						 -->
						<div class="form-group row">
							<label for="post_title" class="col-sm-2 col-form-label">제목</label>
							<div class="col">
								<form:input path="post_title" class="form-control"/>
								<form:errors path="post_title" class="text-danger"/>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-4">
								<form:radiobutton path="post_score" class="" value="1" id="star1"/>
								<label for="star1" class="text-warning">★☆☆☆☆</label>
							</div>
							<div class="col-4">
								<form:radiobutton path="post_score" class="" value="2" id="star2"/>
								<label for="star2" class="text-warning">★★☆☆☆</label>
							</div>
							<div class="col-4">
								<form:radiobutton path="post_score" class="" value="3" id="star3"/>
								<label for="star3" class="text-warning">★★★☆☆</label>
							</div>
							<div class="col-4">
								<form:radiobutton path="post_score" class="" value="4" id="star4"/>
								<label for="star4" class="text-warning">★★★★☆</label>
							</div>
							<div class="col-4">
								<form:radiobutton path="post_score" class="" value="5" id="star5"/>
								<label for="star5" class="text-warning">★★★★★</label>
							</div>
						</div>
						<div class="form-group row">
							<form:textarea path="post_content" class="form-control"/>
						</div>
						<!-- 
						<div class="form-group row">
							<form:input path="post_date" class="form-control" readonly="true"/>
						</div>
						 -->
						<div class="modal-footer pb-0">
							<div class="container">
								<div class="row justify-content-center">
									<div class="col-sm-6">
										<input type="submit" value="수정하기" class="btn btn-primary btn-block btn-lg">
									</div>
									<div class="col-sm-6">
										<input type="reset" value="초기화" class="btn btn-primary btn-block btn-lg">
									</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>



	</div>
</div>
</body>
</html>



