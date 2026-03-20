<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css-files/login.css"> 
<link rel="stylesheet" href="css-files/message.css">

<title>Santosh Hospital</title>
</head>
<body >
    <%
	if (session != null && session.getAttribute("StatusMsg") != null) {
	%>
	<%@include file="html-files/message.html"%>
	<%
	session.removeAttribute("StatusMsg");
	}
	%>
	<div class="fl" id="mainDiv">

		<div class="fl" id="login">
			<form class="fl" action="login" method="post">
				<table>
					<tr>
						<th><label for="username">Username : </label></th>
						<td><input id="username" name="username" required="required" placeholder="username or email"></td>
					</tr>
					<tr>
						<th><label for="pass">Password : </label></th>
						<td><input type="password" id="pass" name="password" required="required"></td>
					</tr>
				</table>
				<input type="submit" value="log-in">
			</form>

			<span style="margin-top: 20px">if you have not an account : <a href="Signup">Sign-up</a></span>
		</div>
	</div>
<script type="text/javascript" src="js-files/massege.js"></script>
</body>
</html>