<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css-files/signup.css">
<title>Santosh Hospital</title>
</head>
<body class="fl">
	<div id="Signup" class="nn">
		<form class="fl" action="Signup" method="post">
			<table>
				<tr>
					<th><label for="username">Username : </label></th>
					<td><input type="text" id="username" required></td>
				</tr>
				<tr>
					<th><label for="phoneNo">Phone no. : </label></th>
					<td><input type="tel" name="" id="phoneNo" required></td>
				</tr>

				<button id="sendOTP" onclick="sendOTP()">send OTP</button>
				
				<div id="OTPSction" class="nn">
					<tr>
						<th><label for="otp">OTP : </label></th>
						<td><input type="number" id="otp"></td>
					</tr>
					<button onclick="verifyOTP()">Verify OTP</button>
				</div>
				
				<div id="passwordSection" class="nn">
					<tr>
						<th><label for="pass">Password : </label></th>
						<td><input type="text" id="pass"></td>
					</tr>
					<tr>
						<th><label for="confirmPass">Confirm Password : </label></th>
						<td><input type="text" id="confirmPass"></td>
					</tr>
				</div>
			</table>
			<input type="submit" value="Sign-up">
		</form>
	</div>
	<script type="text/javascript" src="js-files/signup.js"></script>

</body>
</html>