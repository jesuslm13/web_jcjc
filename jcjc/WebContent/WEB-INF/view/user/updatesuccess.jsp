<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.user.entity.User"%>
<% User user = (User) session.getAttribute("user"); %>

<h1>업데이트 성공!</h1>
${ user }