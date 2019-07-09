<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<%
 Date now = new Date();
 SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 E요일 a hh:mm:ss");
 String today = sf.format(now);
%>
<%= now %><br>
<%= today %>
<p style="background-color: yellow;">삽입 내용1</p>
<p style="color: red">삽입 내용2</p>
<form>
<input type="button" value="페이지 새로 고침" onClick="window.location.reload()">
</form>
