<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Ajax</title>

<!-- jQuery -->
<script src="http://code.jquery.com/jquery-1.12.0.js"></script>
<script>
    $(document).ready(function() {
      $('#btnLogin').click(function() {
    	var user_id = $("#user_id").val();
    	var user_password = $("#user_password").val();
        var data = "user_id=" + user_id + "&user_password=" + user_password;
		var url = "index.jsp?BODY_PATH=login.do";
        
        alert(user_id + user_password);
        
        $.ajax({
			type: "POST",
			url: action
			data: data,
			success: function(response) {
			  $("#result").html(response);
			}
        });
      });
    });
  </script>
</head>
<body>
	<h2>Login Ajax(jQuery)</h2>
	<hr />
	<form id="frmLogin" name="frmLogin" action="login_ok.jsp" method="post">
		<input type="text" id="user_id" name="user_id" placeholder="아이디" /><br />
		<input type="password" id="user_pw" name="user_pw" placeholder="패스워드" /><br />
		<input type="button" id="btnLogin" value="로그인" />
	</form>
	<div id="msg"></div>
</body>
</html>