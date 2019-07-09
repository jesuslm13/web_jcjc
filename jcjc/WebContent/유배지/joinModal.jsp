<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.user.entity.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String root = request.getContextPath(); %>
<!DOCTYPE html>

<!-- 다음 지도 API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
    new daum.Postcode({
       oncomplete: function(data) {
         // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

         // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
         // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
         var roadAddr = data.roadAddress; // 도로명 주소 변수
         var extraRoadAddr = ''; // 참고 항목 변수

         // 법정동명이 있을 경우 추가한다. (법정리는 제외)
         // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
         if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
             extraRoadAddr += data.bname;
         }
         // 건물명이 있고, 공동주택일 경우 추가한다.
         if(data.buildingName !== '' && data.apartment === 'Y'){
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
         }
         // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
         if(extraRoadAddr !== ''){
             extraRoadAddr = ' (' + extraRoadAddr + ')';
         }

         // 우편번호와 주소 정보를 해당 필드에 넣는다.
         document.getElementById('user_postcode').value = data.zonecode;
         document.getElementById("user_roadAddress").value = roadAddr;
         document.getElementById("user_jibunAddress").value = data.jibunAddress;
         
         // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
         if(roadAddr !== ''){
             document.getElementById("user_extraAddress").value = extraRoadAddr;
         } else {
             document.getElementById("user_extraAddress").value = '';
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

	
<!-- .modal: 배경이 아닌 모달 페이지임을 나타냄// 명시하지 않을 시 모달창까지 배경으로 인식  -->
<!-- .fade: 애니메이션으로 자연스러운 효과 -->
<!-- modalLogin -->
<div id="modalJoin" class="modal fade" role="dialog">

    <!-- .modal-dialog: 모달창의 사이즈를 결정한다 -->
    <!-- +++추가옵션 .modal-sm, .modal-lg -->
    <div class="modal-dialog">

        <!-- Modal content: 모달창에 들어갈 내용 삽입 -->
        <div class="modal-content text-center">

            <!-- .modal-header: modal창 상단바 -->
            <div class="modal-header">
                <h2 class="modal-title">회원가입</h2>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
			
			<form:form modelAttribute="user" action="join.do">
				아이디 : 
				<form:input path="user_id" />
				<form:errors path="user_id" cssStyle="color:tomato;" /><br>
				
				비밀번호 : 
				<form:password path="user_password" />
				<form:errors path="user_password" cssStyle="color:tomato;" /><br>
				
				생일 : 
				<form:input path="user_birthdate" type="date" min="1919-01-01" max="2019-03-28"/>
				<form:errors path="user_birthdate" cssStyle="color:tomato;" /><br>
	
				주소 : 
				<form:input path="user_postcode" placeholder="우편번호"/>
				<form:errors path="user_postcode" cssStyle="color:tomato;" /><br>
				
				<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				
				<form:input path="user_roadAddress" placeholder="도로명주소"/>
				<form:errors path="user_roadAddress" cssStyle="color:tomato;"  /><br>
				
				<form:input path="user_jibunAddress" placeholder="지번주소"/>
				<form:errors path="user_jibunAddress" cssStyle="color:tomato;" /><br>
				<span id="guide" style="color:#999;display:none"></span>
										
				<form:input path="user_detailAddress" placeholder="상세주소"/>
				<form:errors path="user_detailAddress" cssStyle="color:tomato;" /><br>
				
				<form:input path="user_extraAddress" placeholder="참고항목"/>
				<form:errors path="user_extraAddress" cssStyle="color:tomato;" /><br>
				
				투표여부 : 
				<form:input path="user_voting_ex"/>
				<form:errors path="user_voting_ex" cssStyle="color:tomato;" /><br>
				
				선호하는 정치인 : 
				<form:input path="user_prefer_politician"/>
				<form:errors path="user_prefer_politician" cssStyle="color:tomato;" /><br>
				
				지지하는 정치인 : 
				<form:input path="user_support_politician"/>
				<form:errors path="user_support_politician" cssStyle="color:tomato;" /><br>
				
				관심분야 : 
				<form:input path="user_interest"/>
				<form:errors path="user_interest" cssStyle="color:tomato;" /><br>																		
				
				<input type="submit" value="회원가입">
				<input type="reset" value="초기화">
			</form:form>
			
			
			<%-- <form action="join.do" method="post">
				<!-- .modal-body: modal창 본 컨텐츠를 담음. -->
				<div class="modal-body">
					<div class="form-group row">
						<label for="user_id" class="col-sm-3 col-form-label">아이디</label>
						<div class="col">
							<input type="text" class="form-control" id="user_id" placeholder="ID">
						</div>
					</div>
					<div class="form-group row">
						<label for="user_password" class="col-sm-3 col-form-label">비밀번호</label>
						<div class="col">
							<input type="password" class="form-control" id="user_password" placeholder="Password">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-form-label col-sm-3">투표경험</div>
						<div class="col-form-label col-sm-3">
							<label class="form-check-label">
							<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
								있다
							</label>
						</div>
						<div class="col-form-label col-sm-3">
							<label class="form-check-label">
							<input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
								없다
							</label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-2">Checkbox</div>
						<div class="col-sm-10">
							<div class="form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox"> Check me out
								</label>
							</div>
						</div>
					</div>
					
					<!-- .modal-footer: modal창 하단바 -->
            		<div class="modal-footer">
						<div class="col-md-6">
		                	<input type="submit" value="가입하기" class="btn btn-primary btn-block btn-lg" />
		                </div>
            		</div>
            	</div>
			</form> --%>
			
			
        </div>
    </div>
</div>