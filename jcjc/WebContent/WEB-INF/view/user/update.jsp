<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.user.entity.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String root = request.getContextPath(); %>
<% User user = (User) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정치정치</title>
	<!-- Bootsrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="<%=root%>/css/main.css">
    <!-- FontAwesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
    
	<!-- 다음 지도 API -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		function sample4_execDaumPostcode() {
		   new daum.Postcode({
		      oncomplete: function(data) {
		
		        var roadAddr = data.roadAddress; // 도로명 주소 변수
		        var extraRoadAddr = ''; // 참고 항목 변수
		
		        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		            extraRoadAddr += data.bname;
		        }
		        if(data.buildingName !== '' && data.apartment === 'Y'){
		           extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		        }
		        if(extraRoadAddr !== ''){
		            extraRoadAddr = ' (' + extraRoadAddr + ')';
		        }
		
		        document.getElementById("user_postcode").value = data.zonecode;
		        document.getElementById("user_road_address").value = data.roadAddress;
		        document.getElementById("user_jibun_address").value = data.jibunAddress;
		        
		        // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
		        if(roadAddr !== ''){
		            document.getElementById("user_extra_address").value = extraRoadAddr;
		        } else {
		            document.getElementById("user_extra_address").value = '';
		        }
		
		        var guideTextBox = document.getElementById("guide");
		        // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
		        if(data.autoRoadAddress) {
		            var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
		            guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
		            guideTextBox.style.display = 'block';
		
		        } else if(data.autoJibunAddress) {
		            var expJibunAddr = data.autoJibunAddress;
		            guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
		            guideTextBox.style.display = 'block';
		        } else {
		            guideTextBox.innerHTML = '';
		            guideTextBox.style.display = 'none';
		        }
		        
		      }
		   }).open();
		}
	</script>
	
	<!-- 선호하는 정치인 스크립트 -->
	<script>
		function userIdChk(){
			var user_id_chk = document.getElementById("user_id").value;
	 		if(user_id_chk.trim() == ""){
				alert("ID를 입력해주세요");
			} else{
				var url = "<%=root%>/user/useridchk.do?user_id=" + user_id_chk;
				window.open(url, "", "width=700, height=200, left=600");	
	 		} 
		}

		function preferPoliticianList(){
			var url = "<%=root%>/politician/prefer.do";
			window.open(url, "", "width=700, height=700, left=600");
		}
	
		function supportPoliticianList(){
			var url = "<%=root%>/politician/support.do";
			window.open(url, "", "width=700, height=700, left=600");
		}
		
		function userInterestList(){
			var url = "<%=root%>/user/interestlist.do"
			window.open(url, "", "width=700, height=700, left=600");
		}
	</script>
	
	<!-- 비밀번호 확인 -->
	<script type="text/javascript">
		function pwChk() {
			var pw = $("#user_password").val();
			var pwchk = $("#user_password_check").val();
			
			if (pw != '' && pwchk != '' &&
				pw == pwchk) {
				document.getElementById("pwchk").innerHTML = "비밀번호가 일치합니다.";
				document.getElementById("pwchk").style.color = "blue";
			} else {
				document.getElementById("pwchk").innerHTML = "비밀번호가 일치하지 않습니다.";
				document.getElementById("pwchk").style.color = "red";
			}
			
		}
	</script>
	
</head>
<body>

<!-- header -->
<div class="fixed-top">
	<jsp:include page="/WEB-INF/view/header/title.jsp" flush="true"/>
    <jsp:include page="/WEB-INF/view/header/menu.jsp" flush="true"/>
</div>

<!-- body -->
<div class="container">

	<div class="modal-header">
	    <h2 class="modal-title">정보수정</h2>
	    <button type="button" class="close" data-dismiss="modal">&times;</button>
	</div>
	
	<form:form modelAttribute="user" commandName="user_update">
		<div class="modal-body">
			<div class="form-group row">
				<label for="user_id" class="col-sm-3 col-form-label">아이디</label>
				<div class="col">
					<form:input path="user_id" class="form-control" readonly="true"/>
					<form:errors path="user_id" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_password" class="col-sm-3 col-form-label">비밀번호</label>
				<div class="col">
					<form:password path="user_password" class="form-control"/>
					<form:errors path="user_password" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_password_check" class="col-sm-3 col-form-label">비번 확인</label>
				<div class="col">
					<input type="password" id="user_password_check" class="form-control" onchange="pwChk()">
					<div id="pwchk"></div>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_name" class="col-sm-3 col-form-label">이름</label>
				<div class="col">
					<form:input path="user_name" class="form-control"/>
					<form:errors path="user_name" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_email" class="col-sm-3 col-form-label">이메일</label>
				<div class="col">
					<form:input path="user_email" class="form-control"/>
					<form:errors path="user_email" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_birthdate" class="col-sm-3 col-form-label">생일</label>
				<div class="col">
					<% String date = user.getUser_birthdate().substring(0, 10); %>
					<form:input path="user_birthdate" class="form-control" type="date" min="1910-01-01" max="2019-03-29" value="<%= date %>"/>
					<form:errors path="user_birthdate" class="text-danger"/>
					<script>
						/*
						var today = new Date();
						
						var yyyy = today.getFullYear();
						var mm = today.getMonth()+1; // January is 0
						var dd = today.getDate();
						
						if (dd < 10)
							dd = '0' + dd;
						if (mm < 10)
							mm = '0' + mm;
							
						today = yyyy + '-' + mm + '-' dd;
					
						document.getElementById('currentDate').value = today;

						var past = new Date();
						past.setdate(today.getDate() - 7);
						*/				
					</script>
				</div>
			</div>
			<div class="form-group row">
				<label for="" class="col-sm-3 col-form-label">주소</label>
				<div class="col">
					<form:input path="user_postcode" class="form-control" placeholder="우편번호" readonly="true"/>
					<form:errors path="user_postcode" class="text-danger"/>
				</div>
				<div class="col-4 pl-0">
					<input type="button" value="우편번호 찾기" class="btn btn-success btn-block" onclick="sample4_execDaumPostcode()">
				</div>
			</div>
			<div class="form-group row">
				<label for="user_road_address" class="col-sm-3 col-form-label">도로명주소</label>
				<div class="col">
					<form:input path="user_road_address" class="form-control" placeholder="도로명주소" readonly="true"/>
					<form:errors path="user_road_address" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_jibun_address" class="col-sm-3 col-form-label">지번주소</label>
				<div class="col">
					<form:input path="user_jibun_address" class="form-control" placeholder="지번주소" readonly="true"/>
					<form:errors path="user_jibun_address" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_detail_address" class="col-sm-3 col-form-label">상세주소</label>
				<div class="col">
					<form:input path="user_detail_address" class="form-control" placeholder="상세주소"/>
					<form:errors path="user_detail_address" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_extra_address" class="col-sm-3 col-form-label">참고주소</label>
				<div class="col">
					<form:input path="user_extra_address" class="form-control" placeholder="참고주소" readonly="true"/>
					<form:errors path="user_extra_address" class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="user_voting_ex" class="col-sm-3 col-form-label">투표여부</label>
				<div class="col">
					<div class="row">
						<div class="col-3">
							<form:radiobutton path="user_voting_ex" value="Y" class="" id="Y" />
							<label for="Y" class="">있음</label>
						</div>
						<div class="col-3">
							<form:radiobutton path="user_voting_ex" value="N" class="" id="N" />
							<label for="N" class="">없음</label>
						</div>
					</div>
					<form:errors path="user_voting_ex" class="text-danger" />
				</div>
			</div>
			<div class="form-group row">
				<label for="user_prefer_politician" class="col-sm-3 col-form-label">선호하는 정치인</label>
				<div class="col">
					<form:input path="user_prefer_politician" class="form-control" id="politician_prefer_politician"/>
					<form:errors path="user_prefer_politician" class="text-danger"/>
				</div>
				<div class="col-2 pl-0">
					<input type="button" value="찾기" class="btn btn-success btn-block" onclick="preferPoliticianList()">
				</div>
			</div>
			<div class="form-group row">
				<label for="user_support_politician" class="col-sm-3 col-form-label">지지하는 정치인</label>
				<div class="col">
					<form:input path="user_support_politician" class="form-control" id="politician_support_politician"/>
					<form:errors path="user_support_politician" class="text-danger"/>
				</div>
				<div class="col-2 pl-0">
					<input type="button" value="찾기" class="btn btn-success btn-block" onclick="supportPoliticianList()">
				</div>
			</div>
			<div class="form-group row">
				<label for="user_interest" class="col-sm-3 col-form-label">관심분야</label>
				<div class="col">
					<form:input path="user_interest" class="form-control" id="user_interest" />
					<form:errors path="user_interest" class="text-danger" />
				</div>
				<div class="col-2 pl-0">
					<input type="button" value="찾기" class="btn btn-success btn-block" onclick="userInterestList()">
				</div>
			</div>
		</div>
			
		<div class="modal-footer">
			<div class="container">
				<div class="row justify-content-center mt-3">
					<div class="col-md-3">
						<input type="submit" value="수정하기" class="btn btn-primary btn-block btn-lg">
					</div>
					<div class="col-md-3">
						<input type="reset" value="초기화" class="btn btn-primary btn-block btn-lg">
					</div>
				</div>
				<div class="row justify-content-center mt-3">
					<div class="col-md-3">
						<a href="<%=root%>/user/delete.do" class="btn btn-danger btn-block btn-lg">탈퇴하기</a>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>
</body>
</html>
