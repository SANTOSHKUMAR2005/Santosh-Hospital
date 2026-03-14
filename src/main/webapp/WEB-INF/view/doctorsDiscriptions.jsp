<%@page import="java.util.ArrayList"%>
<%@page import="com.dto.DocBasicInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css-files/doctorsDiscription.css?v=2">
<link rel="stylesheet" href="css-files/header.css?v=2">
<link rel="stylesheet" href="css-files/footer.css?v=2">
<title>Santosh Hospital</title>
</head>
<body>


	<%@include file="html-files/header.html"%>

	<%
	if (session != null && session.getAttribute("StatusMsg") != null) {
	%>
	<h2 style="color: red"><%=session.getAttribute("StatusMsg")%></h2>
	<%
	session.removeAttribute("StatusMsg");
	}
	%>
    
	<div id="homeDiv">
		<a href="index.jsp" style="color: white">Home</a>
		<% if(session==null || session.getAttribute("doctors")==null){
			response.sendRedirect("index.jsp");
			}
		String dipartment = (String) session.getAttribute("docType");
		ArrayList<DocBasicInfo> doctors = (ArrayList<DocBasicInfo>) session.getAttribute("doctors");
		%>
		<div id="docType">
			<h2><%=dipartment%></h2>
		</div>
	</div>

	<main>
		<div id="mainDiv">
			<%
			for (DocBasicInfo doctor : doctors) {
			%>
			<div id="cart">
				<div>
					<div id="photo">
						<img id="profilePic" alt="img"
							src="image?id=<%=doctor.getDoctor_id()%>"
							style="height: 100%; width: 100%; border-radius: 50%; object-fit: cover">
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
	</main>
	<!--  
   <footer>
    <p>© 2026 Santosh Hospital</p>
</footer>
   -->

	<%@ include file="html-files/footer.html"%>

</body>
</html>