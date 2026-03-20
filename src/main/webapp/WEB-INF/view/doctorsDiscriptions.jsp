
<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.DocBasicInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css-files/doctorsDiscription.css">
<link rel="stylesheet" href="css-files/header.css">
<link rel="stylesheet" href="css-files/footer.css">
<link rel="stylesheet" href="css-files/message.css">
<title>Santosh Hospital</title>
</head>
<body>

<%@include file="html-files/header.html"%>
    
 <%
	if (session.getAttribute("StatusMsg") != null) {
	%>
	<%@include file="html-files/message.html"%>

	<%
	session.removeAttribute("StatusMsg");
	}
	%>

	

	
	<div id="homeDiv">
		<p><a href="home" style="color: white">Home</a></p>
		<% if(session==null || session.getAttribute("doctors")==null){
			session.setAttribute("StatusMsg", "Internal Error !");
			response.sendRedirect("home");
			}
		String dipartment = (String) session.getAttribute("docType");
		ArrayList<DocBasicInfo> doctors = (ArrayList<DocBasicInfo>) session.getAttribute("doctors");
		%>
		<div id="docType">
			<p><%=dipartment%></p>
		</div>
	</div>

	<main>
	<%if(doctors.size()>0){ %>
		<div id="mainDiv">
			<%
			for (DocBasicInfo doctor : doctors) {
			%>
			<div id="cart">
				<div>
					<div id="photo">
						<img id="profilePic" alt="img"
							src="image?id=<%=doctor.getDoctor_id()%>"
							style="">
					</div>
					<span>
						<h2 id="docNane"><%=doctor.getDoctor_name()%></h2>
					</span>
				</div>
				<div id="discription">
					<pre><%=doctor.getQualifications()%>
        <pre>
       
				</div>
				<div id="btn">
					<button type="button">
						<a href="bookAppointment?doctorId=<%=doctor.getDoctor_id()%>">Book
							Appointment</a>
					</button>
				</div>

			</div>
			<%
			}
			%>
		</div>
	<%}else{ %>
	<h4>Sorry! We have not this type of Doctors</h4>
	<%} %>
	</main>


	<%@ include file="html-files/footer.html"%>
	
	<script type="text/javascript" src="js-files/massege.js"></script>

</body>
</html>