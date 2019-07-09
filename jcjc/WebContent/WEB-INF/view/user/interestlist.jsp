<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>관심 분야 선택</title>
		<!-- Bootsrap CDN -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	    <!-- CSS -->
	    <link rel="stylesheet" type="text/css" href="<%=root%>/css/main.css">
	    <!-- FontAwesome -->
	    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
	    
	</head>
		<script type="text/javascript">
			function inputcommittee(){
				var res = $("input[name='committee_select']:checked").val();
				
				if(res == ""){
					alert("선택한 분야가 없습니다");	
				} else{
	 				window.opener.document.getElementById("user_interest").value = res;
					window.close();
				}
			}
		</script>
<body class="fluid p-0 m-0" >
	
	<div class="container w-100 h-100">
		<div class="row-fluid p-3">
			<h3 class="text-center pb-3">관심있는 분야를 선택해주세요!</h3>
				<form action="get" name="findpolitician" class="form-group row">
					<div class="col pr-0">
						<input type="text" name="findpolitician" id="findpolitician" placeholder="이름" class="form-control">
					</div>
					<div class="col pr-0">
						<select name="poly_name" class="form-control">
							<option value="" selected disabled hidden>소속정당</option>
                            <option value="더불어민주당">더불어민주당</option>
                            <option value="자유한국당">자유한국당</option>
                            <option value="바른미래당">바른미래당</option>
                            <option value="민주평화당">민주평화당</option>
                            <option value="정의당">정의당</option>
                            <option value="무소속">무소속</option>
                            <option value="민중당">민중당</option>
                            <option value="대한애국당">대한애국당</option>
                    	</select>
					</div>
					<div class="col pr-0">
						<select name="city" class="form-control">
							<option value="" selected disabled hidden>선거구</option>
	                        <optgroup label = "서울">
	                            <option value="송파구">송파구</option>
	                            <option value="강남구">강남구</option>
	                            <option value="서초구">서초구</option>
	                            <option value="중구">중구</option>
	                        </optgroup>
	                         <optgroup label="경기도">
	                            <option value="성남시">성남시</option>
	                            <option value="수원시">수원시</option>
	                            <option value="용인시">용인시</option>
	                            <option value="안양시">안양시</option>
	                        </optgroup>         
                    	</select>
					</div>
					<div class="col-2">
						<input type="button" value="검색" id="btnfindpolitician" onclick="findPolitician()" class="btn btn-secondary btn-block">
					</div>
				</form>
		</div>
	
		<form method="get" name="politicianlist">
			<div class="row" style="height: 500px; overflow-y:scroll;">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">선호분야 코드</th>
							<th class="text-center">선호분야</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="committee_list" items="${committee_list}" varStatus="i">
					  	<tr>
							<td class="text-center">
								<label for="select${ i.index }" class="form-label m-0">
									${committee_list.jurisdiction_committee_code}
								</label>
							</td>
						    <td>
						    	<label for="select${ i.index }" class="form-label m-0">
							    	${committee_list.jurisdiction_committee_name}
								</label>
							</td>
						    <td>
						    	<input type="radio" name="committee_select" id="select${ i.index }" value="${committee_list.jurisdiction_committee_code}">
						    </td>
					    </tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		
			<div class="row-fluid text-center p-3">
				<input type="button" value="선택하기" id="select" class="btn btn-primary" onclick="inputcommittee()">
			</div>	
		</form>
	</div>
</body>
</html>
