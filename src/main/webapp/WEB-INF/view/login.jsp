<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css-files/login.css">

<title>Santosh Hospital</title>
</head>
<body class="fl">

		<div class="fl" id="login">

			<form class="fl" action="login" method="post">
				<table>
					<tr>
						<th><label for="username">Username : </label></th>
						<td><input id="username" required="required"></td>
					</tr>
					<tr>
						<th><label for="pass">Password : </label></th>
						<td><input id="pass" required="required"></td>
					</tr>
				</table>
				<input type="submit" value="log-in">
			</form>

			<span>if you have not an account : <a href="Signup">Sign-up</a></span>
		</div>
</body>
</html>