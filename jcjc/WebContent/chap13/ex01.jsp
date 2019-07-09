<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    $(function() {
        $("#get").click(function() {
            $("#res").load("data.jsp");
        });
    });
</script>
</head>
<body>
	<div>
		<div>
			<h2>원래 제목</h2>
		</div>
		<div id="res"></div>
		<button id="get">가져오기</button>
	</div>

	<hr />
	<div>
		<div>
			<h2>원래 제목</h2>
		</div>
		<div><jsp:include page="data.jsp"></jsp:include>
		</div>
	</div>
	<hr />
	<div>
		<div>
			<h2>원래 제목</h2>
		</div>
		<div><%@include file="data.jsp"%></div>
	</div>
	<hr />
	<div>
		<div>
			<h2>원래 제목</h2>
		</div>
		<div style="width: 700px; height: 500px;">
			<iframe src="data.jsp"
				style="width: 100%; height: 100%; border: none;"></iframe>
		</div>
	</div>
</body>
</html>

