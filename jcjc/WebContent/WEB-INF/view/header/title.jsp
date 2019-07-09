<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String root = request.getContextPath(); %>
<%@ page import="jcjc.user.entity.User"%>
<% User user = (User) session.getAttribute("user"); %>

<!-- body -->
<nav class="navbar navbar-expand-sm bg-light navbar-light">
	<div class="container">
		<!-- brand logo -->
		<a href="<%=root%>/index.jsp" class="navbar-brand">
			<img src="<%=root%>/img/logo.png" alt="정치정치" height="30">
		</a>
		<!-- menu -->
		<div class="collapse navbar-collapse justify-content-end" id="collapseibleNavBar">
			<ul class="nav navbar-nav">
				<% if ( user != null ) { %>
				<li class="nav-item p-2">
					<a href="<%=root%>/user/update.do" class="text-primary">
						${ user.user_name } 님
					</a>
				</li>
				<li class="nav-item">
					<a href="<%=root%>/user/logout.do" class="nav-link">
						로그아웃
					</a>
				</li>
				<% } else { %>
				<li class="nav-item">
					<a href="<%=root%>/user/login.do" class="nav-link" id="login">
					<!-- <a href="" class="nav-link" data-toggle="modal" data-target="#modalLogin"> -->
						로그인
					</a>
				</li>
				<li class="nav-item">
					<a href="<%=root%>/user/join.do" class="nav-link">
					<!-- <a href="" class="nav-link" data-toggle="modal" data-target="#modalJoin"> -->
						회원가입
					</a>
				</li>
				<% } %>
			</ul>
		</div>
	</div>
</nav>
