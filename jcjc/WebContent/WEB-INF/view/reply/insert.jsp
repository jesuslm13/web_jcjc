<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.reply.entity.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String root = request.getContextPath(); %>

<script type="text/javascript">
	
</script>
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