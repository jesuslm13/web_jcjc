<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jcjc.commitment.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String root = request.getContextPath(); %>

<br>
<table class="table table-hover">
	<thead>
		<tr>
			<th>No</th>
			<th>제안일</th>
			<th>공약 내용</th>
			<th>구분</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="commitment" items="${ commitmentList }" varStatus="i">
		<tr>
			<td>${ i.index + 1 }</td>
			<td>${ commitment.commitment_proposal_date }</td>
			<td>${ commitment.commitment_title }</td>
			<td>${ commitment.commitment_fulfillment }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
