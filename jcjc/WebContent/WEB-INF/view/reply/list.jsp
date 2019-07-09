<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.reply.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String root = request.getContextPath(); %>

<!-- 댓글 삭제 확인창 -->
<script type="text/javascript">
function deleteConfirm(reply_no) {
	if (confirm("정말로 삭제하시겠습니까?")) {
		deleteReply(reply_no);
	} else {
		alert("댓글 삭제 실패");
	}
}
</script>


<script type="text/javascript">
/* 페이지 로딩 초기에 댓글 내용 불러오기 */
$(document).ready(function() {
	getContent();
});
	
/* 댓글 리스트 */
function getContent() {
	var formData = replyList;
	$.ajax({
		type: "GET",
		url: "<%=root%>/reply/content.do",
		dataType: "text", // 응답받을 타입
		data: formData,
		error: function() {
			alert("통신실패!!");
		},
		success: function(data) {
			$("#reply-content").html(data);
		}			
	});
}

/* 댓글 수정 창 */
function updateOpen(reply_index, reply_no) {
	getReplyList();
	/* alert("#reply" + reply_index + " div에 들어있는 " + reply_no + "번 게시물 수정"); */
	$.ajax({
		type: "GET",
		url: "<%=root%>/reply/update.do?reply_no=" + reply_no,
		dataType: "text", // 응답받을 타입
		error: function() {
			alert("본인이 작성한 댓글만 수정 가능합니다.");
		},
		success: function(data) {
			$("#reply" + reply_index).html(data);
		}			
	});
}

/* 댓글 수정 */
function updateReply(reply_no) {
	var formData = $("#replyUpdateForm").serialize();
	$.ajax({
		type: "POST",
		url: "<%=root%>/reply/update.do?reply_no=" + reply_no,
		data: formData,
		dataType: "text", // 응답받을 타입
		error: function() {
			alert("통신 실패!!");
		},
		success: function(data) {
			getReplyList();
		}			
	});
}
	 

/* 댓글 삭제 */
function deleteReply(reply_no) {
	$.ajax({
		type: "GET",
		url: "<%=root%>/reply/delete.do?reply_no=" + reply_no,
		dataType: "text",
		error: function() {
			alert("본인이 작성한 댓글만 삭제 가능합니다.");
		},
		success: function(data) {
			getReplyList();
		}			
	});
}
</script>
<div class="card-body pb-0">
	<c:forEach var="reply" items="${ replyList }" varStatus="i">
		<div class="form-row border border-top-0 border-left-0 border-right-0 mb-3" id="reply${ i.index }">
			<div class="col">
				<div class="row">
					<div class="col-sm-3">
					<p class="mb-0">${ reply.user_id }</p>
					
					</div>
					<div class="col pb-3">
						<p class="mb-0">${ reply.reply_content }</p>
						<div class="text-gray text-small">
							${ reply.reply_date }
						</div>
					</div>
				</div>
			</div>
			<div class="col-3 text-right">
				<div class="container">
				<div class="row justify-content-end">
					<div onclick="updateOpen(${ i.index }, ${ reply.reply_no })" class="text-primary pr-2">수정</div>
					<div onclick="deleteConfirm(${ reply.reply_no })" class="text-primary">삭제</div>
				</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
