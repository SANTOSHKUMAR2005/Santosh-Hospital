<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Santosh Hospital</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<link rel="stylesheet" href="css-files/header.css">
<link rel="stylesheet" href="css-files/footer.css">
<link rel="stylesheet" href="css-files/adminPage.css">
<link rel="stylesheet" href="css-files/message.css">
</head>
<body>

  <%@ include file="html-files/header.html"%>
    
    <div id="menuIcon" class="fa-solid fa-bars"></div>
    
	<%
	if (session != null && session.getAttribute("StatusMsg") != null) {
	%>
	<%@include file="html-files/message.html"%>
	<%
	session.removeAttribute("StatusMsg");
	}
	%>
	

	<!--  protecting from Unauthorized access -->
	<%
	if ( session.getAttribute("admin") == null) {
		response.sendRedirect("home");
	}
	String admin = (String) session.getAttribute("admin");
	%>
	<h1 style="margin-left: 10px">Hello <%=admin%></h1>


	<!-- Navigation Bar -->
	<div class="navbar">
		<h3 id="home">
			<a href="home" style="color: white">Home</a>
		</h3>
		<h3 id="AddDoc">Add Doctor</h3>
		<h3 id="RemoveDoc">Remove Doctor</h3>
		<h3 id="changePass">Change Admin Password</h3>
		<h3 id="addAdm">Add Admin</h3>
	</div>

	<main>
		<%
		String formType = (String) session.getAttribute("formType");
		session.removeAttribute("formType");
		%>


		<div id="doctorAddF"
			<%if (formType != null && "addDoctor".equals(formType)) {%>
			class="fl" <%} else {%> class="nn" <%}%>>
			<form action="Admin_actions" id="addDoctor" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="formType" value="addDoctor">

				<h1>Add Doctor</h1>

				<table>
					<tr>
						<th><label for="docName">name : </label></th>
						<td><input id="docName" type="text" name="doctorName"
							required></td>
					</tr>
					<tr>
						<th><label for="photo">photo : </label></th>
						<td><input id="photo" type="file" alt="photo" name="photo"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="specialization">Specialization : </label></th>
						<td><select id="specialization" name="specialization"
							required="required">
								<option value="select">select</option>
								<option value="Dermatologists">Dermatologist</option>
								<option value="Cardiologists">Cardiologists</option>
								<option value="Oncologist">Oncologist</option>
								<option value="Neurologist">Neurologist</option>
								<option value="Endocrinologist">Endocrinologist</option>
								<option value="Gastornterologist">Gastornterologist</option>
								<option value="Ophthalmologist">Ophthalmologist</option>
								<option value="Psychiatrist">Psychiatrist</option>
								<option value="Pulmonologist">Pulmonologist</option>
								<option value="Rheumatologist">Rheumatologist</option>
								<option value="Urologist">Urologist</option>
						</select></td>
					</tr>
					<tr>
						<th><label for="qualification">Qualification : </label></th>
						<td><textarea id="qualification" name="qualification"
								required="required"></textarea></td>
					</tr>
					<tr>
						<th><label for="licence">Licence no. : </label></th>
						<td><input id="licence" type="text" name="licenceNo"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="phone">phone no. : </label></th>
						<td><input id="phone" type="tel" name="phoneNo"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="cabin">Cabin no. : </label></th>
						<td><input id="cabin" type="number" name="cabinNo"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="salary">Salary : </label></th>
						<td><input id="salary" type="number" name="salary"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="consultationFee">Consultation fee : </label></th>
						<td><input id="consultationFee" type="number"
							name="consultationFee" required="required"></td>
					</tr>
				</table>

				<input type="submit" value="Add">
			</form>

		</div>

		<div id="doctorRemoveF"
			<%if (formType != null && "removeDoctor".equals(formType)) {%>
			class="fl" <%} else {%> class="nn" <%}%>>
			<form action="Admin_actions" method="post">
				<input type="hidden" name="formType" value="removeDoctor">
				 <input
					type="number" name="doctorId" placeholder="Enter doctor id"
					required
					oninvalid="this.setCustomValidity('please enter the doctor id first')"
					oninput="this.setCustomValidity('')"> <input type="submit"
					value="Delete">
			</form>
		</div>

		<div id="changeAdminPass"
			<%if (formType != null && "changeAdminPass".equals(formType)) {%>
			class="changePassword" <%} else {%> class="nn" <%}%>>
			<form action="Admin_actions" method="post">

				<input type="hidden" name="formType" value="changeAdminPass">


				<input type="text" name="newPass" placeholder="Enter new Password"
					required
					oninvalid="this.setCustomValidity('please enter a new password first')"
					oninput="this.setCustomValidity('')"> <input type="submit"
					value="Change">
			</form>
		</div>

		<div id="addAdmin"
			<%if (formType != null && "addAdmin".equals(formType)) {%> class="fl"
			<%} else {%> class="nn" <%}%>>
			<form action="Admin_actions" method="post">
				<input type="hidden" name="formType" value="addAdmin">

				<h1>Admin Details</h1>
				<table>
					<tr>
						<th><label for="AdminName">Name : </label></th>
						<td><input type="text" id="AdminName" name="AdminName"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="Password">Password : </label></th>
						<td><input id="Password" type="password" name="pass"
							required="required"></td>
					</tr>
					<tr>
						<th><label for="email">Email : </label></th>
						<td><input type="email" id="email" name="email"></td>
					</tr>
				</table>
				<input type="submit" value="Add">
			</form>


		</div>

	</main>


	<%@include file="html-files/footer.html"%>

	<script type="text/javascript" src="js-files/massege.js"></script>
	<script type="text/javascript" src="js-files/adminPage.js"></script>
</body>
</html>