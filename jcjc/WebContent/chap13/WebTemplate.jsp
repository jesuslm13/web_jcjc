<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹 템플릿 예제</title>
</head>
<body>

<h3>웹 템플릿 예제</h3>
<table border=1 width=500 cellpadding=10>
	<tr>
		<td width=150 vaitn=top>
			<a href="WebTemplate.jsp?BODY_PATH=Intro.jsp">회사 소개</a> <br>
			<a href="books-info">책 정보</a> <br>
			<a href="WebTemplate.jsp?BODY_PATH=BBSInput.jsp">게시판 글쓰기</a> <br>
			<a href="bbs-list">게시판 글 읽기</a> <br>
		</td>
		<td>
			<jsp:include page="${ param.BODY_PATH }" />
		</td>
	</tr>
</table>
<h5>Copyright@</h5>

</body>
</html>