<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>

<div class="form-row border border-top-0 border-left-0 border-right-0 mb-3">
	<div class="col">
		<div class="row">
			<div class="col-sm-3">
			<!-- 작성자 -->
			<p class="mb-0">${ list.user_id }</p>
			
			</div>
			<div class="col pb-3">
				<p class="mb-0">${ list.reply_content }</p>
				<div class="text-gray text-small">
					${ list.reply_date }
				</div>
			</div>
		</div>
	</div>
	<div class="col-2 text-right">
		<div onclick="getUpdateForm(${ list.reply_no })" class="text-primary">수정</div>
		<%-- <a href="<%=root%>/reply/update.do?reply_no=${ list.reply_no }">수정</a> --%>
		<div onclick="del_reply(${ list.reply_no })" class="text-primary">삭제</div>
	</div>
</div>