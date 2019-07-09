<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jcjc.politician.entity.*"%>
<% String root = request.getContextPath(); %>
<% Politician politician = (Politician) session.getAttribute("politician"); %>

<div class="row p-0 m-0">
	<!-- name -->
	<div class="col-sm-3 bg-dark text-white d-flex align-content-center flex-wrap">
		<div class="m-3">
			<p>
				<% if (politician.getOrig_name() != null) { %>
				${ politician.orig_name }
				<% } %>
			</p>
			<h3>
				<a class="text-white" href="<%=root%>/politician/prediction.do?politician_no=${ politician.politician_no }">
					${ politician.politician_kor_name }
				</a>
			</h3>
		</div>
	</div>

	<div class="col" style="background-color: #F1F2F3;">
		<div class="row align-items-center p-3">
			<div class="col-sm-3  text-center p-0">
				<img src="${ politician.politician_jpg_link }" alt="profile" class="img-fluid pb-3 pb-sm-0">
			</div>
			<div class="col p-2 ml-5 mr-5 ml-sm-2 mr-sm-2">
				<table class="table table-hover m-0">
					<tr>
						<td class="border-0 p-1">정당</td>
						<td class="border-0 p-1">${ politician.poly_name }</td>
					</tr>
					<tr>
						<td class="border-0 p-1">선거구</td>
						<td class="border-0 p-1">${ politician.orig_name }</td>
					</tr>
					<% if (politician.getShrt_name() != null) { %>
					<tr>
						<td class="border-0 p-1">소속위원회</td>
						<td class="border-0 p-1">${ politician.shrt_name }</td>
					</tr>
					<% } %>
					<tr>
						<td class="border-0 p-1">당선횟수</td>
						<td class="border-0 p-1">${ politician.reele_gbn_name }&nbsp;[${ politician.election_name }]</td>
					</tr>
					<tr>
						<td class="border-0 p-1">연락처</td>
						<td class="border-0 p-1">${ politician.assem_tel }</td>
					</tr>
					<tr>
						<td class="border-0 p-1">이메일</td>
						<td class="border-0 p-1">${ politician.assem_email }</td>
					</tr>
				</table>
			</div>
		</div>
		<div
			class="row navbar navbar-expand bg-light navbar-light pl-5 p-sm-1 pl-sm-4">
			<!-- 궁합보기/공약평가 메뉴 -->
			<div class="navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href="<%=root%>/politician/matching.do?politician_no=${ politician.politician_no }">궁합보기</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<%=root%>/commitment/list.do?politician_no=${ politician.politician_no }">공약평가</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
