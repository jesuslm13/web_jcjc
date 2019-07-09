<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.commitment.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
		<div id="accordion" role="tablist">
		<c:forEach var="commitment" items="${ commitmentList }" varStatus="i">
			<div class="card bg-light">
				<div class="card-header" role="tab" id="heading${ i.index }">
					<div class="container">
						<div class="collapsed row" data-toggle="collapse" href="#collapse${ i.index }" aria-expanded="false" aria-controls="collapse${ i.index }">
							<div class="col-3 text-warning p-0" id="avg-score${ i.index }">★ ${commitment.commitment_avg}</div>
							<div class="col p-0">
								<h5 class="mb-0">${ commitment.commitment_title }</h5>
							</div>
							<div class="col-1 text-right text-secondary">▼</div>
						</div>
					</div>
				</div>
				<div id="collapse${ i.index }" class="collapse" role="tabpanel" aria-labelledby="heading1" data-parent="#accordion">
					<div class="card-body pb-0">
							<div class="container">
								<div class="row border border-top-0 border-left-0 border-right-0 pb-2 mb-3">
									${ commitment.commitment_content }
								</div>
							</div>
						<div class="form-row justify-content-center pb-3">
							<div class="container-fluid" id="post-list${ i.index }"></div>
							
							<div class="form-row justify-content-center">
								<a href="<%=root%>/post/insert.do?commitment_no=${ commitment.commitment_no }" class="btn btn-secondary">글쓰기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			
<%-- 			<script type="text/javascript">
				$.ajax({
					type: "GET",
					url: "<%=root%>/post/avg.do?commitment_no=${ commitment.commitment_no }",
					dataType: "text", // 응답받을 타입
					error: function() {
						alert("통신실패!!");
					},
					success: function(data) {
						$("#avg-score${ i.index }").append(data);
					}			
				});
			</script> --%>
		
			
			<script type="text/javascript">
				$.ajax({
					type: "GET",
					url: "<%=root%>/post/list.do?commitment_no=${ commitment.commitment_no }",
					dataType: "text", // 응답받을 타입
					error: function() {
						alert("통신실패!!");
					},
					success: function(data) {
						$("#post-list${ i.index }").html(data);
					}			
				});
			</script>
			
		</c:forEach>
		</div>

	</div>
</div>
</body>
</html>