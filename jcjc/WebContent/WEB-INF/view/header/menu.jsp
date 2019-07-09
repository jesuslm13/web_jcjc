<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #1E2124;">
	<div class="container">
	    <!-- nav -->
	 
	    <!-- 햄버거 버튼 -->
	    <button class="navbar-toggler" data-toggle="collapse" data-target="#myNavbar">
	        <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="myNavbar">
	        <ul class="nav navbar-nav">
	            <li class="nav-item">
	                <a class="nav-link text-white" href="<%=root%>/politician/type.do">정치인 정보</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link text-white" href="#">나와 맞는 정치인</a>
	            </li>
	            <li class="nav-item">
	                <a class="nav-link text-white" href="<%=root%>/politician/all.do">인물별 게시판</a>
	            </li>
	        </ul>
	    </div>
	</div>
</nav>
