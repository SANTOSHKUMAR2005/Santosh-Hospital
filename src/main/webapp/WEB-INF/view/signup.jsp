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
	<div id="Signup"  class="fl">
	    <%if(session!=null && session.getAttribute("StatusMsg")!=null){ %>
	     <h3><%=session.getAttribute("StatusMsg") %></h3>
	     <% session.removeAttribute("StatusMsg");} %>
		<form class="fl"  >
			<table>
				<tr>
					<th><label for="username">Username : </label></th>
					<td><input type="text" id="username" name="username" required></td>
				</tr>
				<tr>
					<th><label for="phoneNo">Phone no. : </label></th>
					<td><input type="tel" name="phone" id="phoneNo" required></td>
					<td><button id="sendOTP" type="button" data-action="sendOTP" >send OTP</button>
					 <span id="timer" class="nn"></span></td>
				</tr>
				
				
					<tr id="OTPSection" class="nn">
						<th><label for="otp">OTP : </label></th>
						<td><input type="number" id="otp"></td>
						<td><button type="button" data-action="verifyOTP">Verify OTP</button><td>
					</tr>
					
					<tr  class="nn" id="passwordSection1">
						<th><label for="pass">Password : </label></th>
						<td><input type="password" id="pass" name="password" required="required" placeholder="minimum 6 digit"></td>
					</tr>	
					<tr  class="nn" id="passwordSection2">
						<th><label for="Cpass">Confirm Password : </label></th>
						<td><input type="password" id="Cpass"  required="required"></td>
					</tr>			
			</table>
			<button id="signInButton" class="nn" type="button" data-action="SignIn">Sign-In</button>
		</form>
		<span style="margin-top: 20px">if you have an account : <a href="login">login</a></span>
	</div>
	<script type="text/javascript" src="js-files/signup.js"></script>

</body>
</html>