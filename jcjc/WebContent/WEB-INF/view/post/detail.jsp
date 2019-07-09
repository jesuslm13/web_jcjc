<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.commitment.entity.*"%>
<%@ page import="jcjc.post.entity.*"%>
<%@ page import="jcjc.reply.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String root = request.getContextPath(); %>
<% Commitment commitment = (Commitment) request.getAttribute("commitment"); %>
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
	<!-- 게시물 삭제 확인창 -->
	<script>
		function del_post(post_no) {
			if (confirm("정말로 삭제하시겠습니까?")) {
				location.href = "<%=root%>/post/delete.do?post_no=" + post_no;
			} else {
				alert("게시물 삭제 실패");
			}
		}
		
	</script>

	<!-- 댓글  -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">

	/* 페이지 로딩 초기에 댓글 불러오기 */
	$(document).ready(function() {
		getReplyList();
	});
		
	/* 댓글 리스트 */
	function getReplyList() {
		$.ajax({
			type: "GET",
			url: "<%=root%>/reply/list.do?post_no=${ post.post_no }",
			dataType: "text", // 응답받을 타입
			error: function() {
				alert("통신실패!!");
			},
			success: function(data) {
				$("#reply-list").html(data);
			}			
		});
	}

	/* 댓글 추가 */
	function insertReply() {
		var formData = $("#replyForm").serialize();
		$.ajax({
			type: "POST",
			url: "<%=root%>/reply/insert.do?post_no=${ post.post_no }",
			data: formData,
			dataType: "text", // 응답받을 타입
			error: function() {
				alert("통신실패!!");
			},
			success: function(data) {
				getReplyList();
				$("#replyContent").val("");
			}			
		});
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

		<div id="accordion" role="tablist">
			<div class="card bg-light">
				<div class="card-header" role="tab" id="heading1">
					<div class="container">
						<div class="row">
							<div class="col-3">
								<div class="row">
									${ post.user_id }
								</div>
								<div class="row">
									<div class="text-warning text-small">
										<c:forEach var="score" begin="1" end="${ post.post_score }" step="1">
											★
										</c:forEach>
										<c:forEach var="score" begin="${ post.post_score }" end="4" step="1">
											☆
										</c:forEach>
									</div>
								</div>
							</div>
							<div class="col">
								<h5 class="mb-0">${ post.post_title }</h5>
							</div>
							<div class="col-3 text-right text-gray text-small">
								${ post.post_date }
							</div>
						</div>
					</div>
				</div>
				<div class="card-body pb-0">
						<div class="form-row border border-top-0 border-left-0 border-right-0">
							<p>${ post.post_content }</p>
						</div>
						<div class="container">
							<!-- 댓글 리스트 -->
							<div class="form-group" id="reply-list">
								댓글 리스트
							</div>
							<!-- 댓글 작성 창 -->
							<div class="form-group" id="reply-insert">
								<form id="replyForm" name="reply" method="post">
									<div class="row d-flex align-items-center border border-top-0 border-left-0 border-right-0 pb-3">
										<div class="container">
											<div class="row">
												<div class="col p-0 pr-3">
													<textarea name="reply_content" id="replyContent" class="form-control"></textarea>
												</div>
												<div class="col-3 p-0 d-flex align-self-stretch">
													<div class="btn btn-primary btn-block d-flex align-items-center justify-content-center" onclick="insertReply()">
														댓글달기
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					<div class="form-row justify-content-center pb-3">
						<div class="col-2">
							<a href="<%=root%>/commitment/list.do?politician_no=${ politician.politician_no }" class="btn btn-secondary btn-block">
								목록
							</a>
						</div>
						<div class="col-2">
							<a href="<%=root%>/post/update.do?post_no=${ post.post_no }" class="btn btn-secondary btn-block">
								수정
							</a>
						</div>
						<div class="col-2">
							<a onclick="del_post(${ post.post_no })" class="btn btn-secondary btn-block text-white">
								삭제
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
