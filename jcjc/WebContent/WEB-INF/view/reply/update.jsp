<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.reply.entity.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String root = request.getContextPath(); %>

<div class="col">
	<div class="row">
		<%-- 
		<div class="col-sm-3">
		<p class="mb-0">${ reply.user_id }</p>
		</div>
		 --%>
		<div class="col pb-3">
			<form:form modelAttribute="ReplyEntity" commandName="reply" id="replyUpdateForm">
				<form:textarea path="reply_content" class="form-control"/>
			</form:form>
		</div>
	</div>
</div>
<div class="col-2 pb-3 d-flex align-self-stretch">
	<div class="btn btn-primary btn-block d-flex align-items-center justify-content-center" onclick="updateReply(${ reply.reply_no })">
		수정
	</div>
</div>
<div class="col-2 pb-3 d-flex align-self-stretch">
	<div class="btn btn-primary btn-block d-flex align-items-center justify-content-center" onclick="getReplyList()">
		취소
	</div>
</div>