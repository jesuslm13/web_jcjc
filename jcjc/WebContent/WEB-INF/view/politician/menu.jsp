<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<script type="text/javascript">

function nav_active(div){
	for (var i=1; i<=6; i++) {
		$("#nav" + i).removeClass("active");
	}
	$("#" + div).addClass("active");
}

</script>
<!-- 여기에요 -->
<div class="col-sm-3 bg-secondary navbar-dark d-flex align-content-start flex-wrap">
	<div class="navbar navbar-expand-sm p-0 m-3">
		<!-- 햄버거 버튼 -->
		<button class="navbar-toggler" data-toggle="collapse"
			data-target="#myMenu">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- 좌측 메뉴 -->
		<div class="collapse navbar-collapse" id="myMenu">
			<ul class="nav navbar-nav flex-column">
				<li class="nav-item">
					<a href="<%=root%>/politician/prediction.do?politician_no=${ politician.politician_no }" 
					class="nav-link pl-0" id="nav1" onclick="nav_active(1)">공약 이행률 예측</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link pl-0" id="nav2" onclick="nav_active('nav2')">관계도</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link pl-0" id="nav3" onclick="nav_active('nav3')">치트 그래프</a>
				</li>
				<li class="nav-item">
					<a href="<%=root%>/bill/list.do" 
					class="nav-link pl-0" id="nav4" onclick="nav_active('nav4')">의정활동 평가</a>
				</li>
				<li class="nav-item">
					<a href="<%=root%>/activity/score.do?politician_no=${politician.politician_no}" 
					class="nav-link pl-0" id="nav5" onclick="nav_active('nav5')">활동성지수</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link pl-0" id="nav6" onclick="nav_active('nav6')">후보자 비교</a>
				</li>
			</ul>
		</div>
	</div>
</div>
<!-- 여기까지 -->