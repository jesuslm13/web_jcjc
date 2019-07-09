<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<script type="text/javascript">
		
		function selectpolitician(){
			
			var res = document.selectpolitician.politician.value;
			
			alert(res);
		}
	</script>
	<body>
		<form method="get" name="selectpolitician">
			<h1>선호하는 정치인을 선택해주세요!</h1>

			<table border="1" >
				<thead>
					<tr>
						<td>정치인 번호</td>
						<td>정치인 이름</td>
						<td>구분</td>
						<td>지역구</td>
						<td>소속 정당</td>
						<td>선택</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="politician" items="${politician}">
				  	<tr>
							<td>${politician.politician_no}</td>
					    <td>${politician.politician_name}</td>
					    <td>${politician.politician_type}</td>
					    <td>${politician.politician_location}</td>
					    <td>${politician.politician_party}</td>
					    <td><input type="radio" name="politician" id="politician" value="${politician.politician_no}"></td>
				    </tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" value="선택하기" id="select" onclick="selectpolitician()">
		</form>
	</body>
</html>