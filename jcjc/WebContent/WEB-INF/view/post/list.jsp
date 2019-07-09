<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.commitment.entity.*"%>
<%@ page import="jcjc.post.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String root = request.getContextPath(); %>
<!-- 삭제 확인창 -->
<script>
	function del() {
		alert("정말로 삭제하시겠습니까?");		
	}
	
	function next(post_no) {
		if (confirm("정말로 삭제하시겠습니까?")) {
			location.href = "<%=root%>/post/delete.do?post_no=" + post_no;
		} else {
		}
	}
</script>

<c:forEach var="post" items="${ postList }">
	<div class="container">
		<div class="row border border-top-0 border-left-0 border-right-0 pb-2 mb-3">
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
			<div class="col pb-2">
				<div class="row">
					<a href="<%=root%>/post/detail.do?post_no=${ post.post_no }" class="text-dark">
						${ post.post_title }
					</a>
				</div>
				<div class="row text-left text-gray text-small">
				${ fn:substring(post.post_date, 0, 10) }
			</div>
			</div>
		</div>
	</div>
</c:forEach>
