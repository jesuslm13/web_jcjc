<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.post.entity.*"%>
<%@ page import="jcjc.reply.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String root = request.getContextPath(); %>


<!-- 댓글  -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready( function() {

	/* 댓글 리스트 */
		$.ajax({
			type: "GET",
			url: "<%=root%>/reply/list.do?post_no=${ post.post_no }",
			dataType: "text", // 응답받을 타입
			error: function() {
			},
			success: function(data) {
				$("#reply-list").html(data);
			}			
		});
	
	/* 댓글 작성 창 */
		$.ajax({
			type: "GET",
			url: "<%=root%>/reply/insert.do?post_no=${ post.post_no }",
			dataType: "text", // 응답받을 타입
			error: function() {
			},
			success: function(data) {
				$("#reply-insert-form").html(data);
			}			
		});
		
	});
	
	/* 댓글 추가시 리스트 갱신 */
	$(function() {
		$("#reply-insert-btn").click(function() {
			alert("insert!!");
			<%-- 
			$.ajax({
				type: "GET",
				url: "<%=root%>/reply/list.do?post_no=${ post.post_no }",
				dataType: "text", // 응답받을 타입
				error: function() {
				},
				success: function(data) {
					$("#reply-list").html(data);
				}			
			});
			 --%>
		});
	});
</script>

<!-- 댓글 리스트 -->
<div class="form-group" id="reply-list">댓글 리스트</div>
	<!-- 댓글 작성 창 -->
	<div class="card-body pt-0 pb-0">
	<form:form modelAttribute="reply">
		<div class="row d-flex align-items-center border border-top-0 border-left-0 border-right-0 pb-3">
			<div class="container">
				<!-- 
				<div class="form-group row">
					<form:input path="post_no" class="form-control" readonly="true"/>
				</div>
				<div class="form-group row">
					<form:input path="user_id" class="form-control" readonly="true"/>
				</div>
				 -->
				<div class="row">
					<div class="col p-0 pr-3">
						<form:textarea path="reply_content" class="form-control" />
					</div>
					<div class="col-3 p-0 d-flex align-self-stretch">
						<input type="submit" value="댓글달기" class="btn btn-primary btn-block" id="reply-insert-btn">
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>
