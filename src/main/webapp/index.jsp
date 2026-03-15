<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Santosh Hospital</title>
<link rel="stylesheet" href="css-files/style.css?v=2">
<link rel="stylesheet" href="css-files/message.css">
</head>
<body>
	
	<% 
	if ( session.getAttribute("StatusMsg") != null) {
	%>
	<%@include   file="/WEB-INF/view/html-files/message.html"%>
	<%
	session.removeAttribute("StatusMsg");
	}
	%>
	

	<header id="header">
		<h1>Santosh Hospital</h1>
		<p>We Care About Your Health</p>
		<% if( session.getAttribute("username")==null) {%>
		<div id="Admin">
			<h3>Admin</h3>
			<form action="admin_verification" method="post" style="display:none;">
				<input type="password" placeholder="password" name="pass" id="pass"
					required="required">
				<br> 
				<input type="submit">
			</form>
		</div>
		<%} %>
		
			<span id="loginSpan"> <%
 if ( session.getAttribute("username") == null) {
 %>
		<h3>
			<a href="login">login</a>
		</h3> <%
 } else {
 %>
		<h3>
			<%=session.getAttribute("username")%></h3> <%
 }
 %>
	</span>


	</header>
	
	
	<nav>
		<a href="#home">Home</a> <a href="#about">About</a> <a
			href="#services">Services</a> <a href="" id="doc">Doctors</a>
	</nav>

	<div id="doctorTypes" style="display: none">
		<a href="related_doctors?type=Dermatologists">Dermatologist</a> <a
			href="related_doctors?type=Cardiologists">Cardiologists </a> <a
			href="related_doctors?type=Oncologist">Oncologist</a> <a
			href="related_doctors?type=Neurologist">Neurologist</a> <a
			href="related_doctors?type=Endocrinologist">Endocrinologist</a> <a
			href="related_doctors?type=Gastornterologist">Gastornterologist</a> <a
			href="related_doctors?type=Ophthalmologist">Ophthalmologist</a> <a
			href="related_doctors?type=Psychiatrist">Psychiatrist</a> <a
			href="related_doctors?type=Pulmonologist">Pulmonologist</a> <a
			href="related_doctors?type=Rheumatologist">Rheumatologist</a> <a
			href="related_doctors?type=Urologist">Urologist</a>

	</div>

	<section id="home" class="section">
		<h2>Welcome</h2>
		<p>suhgo w wgwruh owt gwr gowiuh giwer gwto wrwrh g wwtw ghoiuwrh
			wrpwpw hgpwu</p>
	</section>

	<section id="about" class="section light">
		<h2>About Us</h2>
		<p>
        Santosh-Hospital provides affordable and reliable healthcare
        services with advanced medical technology.
        </p>
        <b>****** Some Useful Terms ****** </b>
        <p><b>Cardiologist :</b> Heart conditions.</p>
        <p><b>Dermatologist :</b> Skin, hair, and nails.</p>
        <p><b>Endocrinologist :</b> Hormones, diabetes, thyroid.</p>
       
        <p><b>Gastroenterologist :</b> Digestive system.</p>
       
        <p><b>Neurologist :</b> Brain, spinal cord, nervous system.</p>
       
        <p><b>Oncologist :</b> Cancer treatment.</p>
       
        <p><b> Ophthalmologist :</b> Eyes, can perform surgery.</p>
       
        <p><b>Psychiatrist :</b> Mental, emotional, and behavioral health.</p>
       
        <p><b>Pulmonologist :</b> Lungs and respiratory system.</p>
       
        <p><b>Rheumatologist : </b>Joints, muscles, autoimmune diseases.</p>
       
        <p><b>Urologist :</b> Urinary tract and male reproductive system. </p>
        
	</section>

	<section id="services" class="section">
		<h2>Our Services</h2>
		<div class="services">
			<div class="card">Emergency Care</div>
			<div class="card">Outpatient</div>
			<div class="card">Diagnostics</div>
			<div class="card">Pharmacy</div>
		</div>
	</section>

	<section id="contact" class="section light">
		<h2>Contact Us</h2>
		<p>📍 Faizabad Nakachunge, Ayodhya</p>
		<p>📞 +91 9506279760</p>
		<p>✉️ SantoshHoshpital@gmail.com</p>
	</section>

	<footer>
		<p>© 2026 Santosh Hospital</p>
	</footer>

	<script type="text/javascript" src="js-files/script.js"></script>
	<script type="text/javascript" src="js-files/massege.js"></script>

</body>
</html>