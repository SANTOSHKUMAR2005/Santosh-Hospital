<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css-files/header.css">
<link rel="stylesheet" href="css-files/footer.css">
<link rel="stylesheet" href="css-files/adminPage.css" >
</head>
<body>
   <%@ include file="html-files/header.html" %>
      
    <!-- Navigation Bar -->
    <div class="navbar">
        <h3 id="home" ><a href="index.jsp" style="color:white">Home</a></h3>
        <h3 id="AddDoc" >Add Doctor</h3>
        <h3 id="RemoveDoc">Remove Doctor</h3>
        <h3 id="changePass">Change Admin Password</h3>
        <h3 id="changeAdm">Change Admin</h3>
    </div>
<main>

   <div class="nn" id="doctorAddF" >
        <form action="add_doctor_servlet" id="addDoctor" method="post" enctype="multipart/form-data">
             <h1> Add Doctor</h1>
             <% 
             String msg=(String)request.getAttribute("msg");
             if(msg!=null){
              if(msg.equals("inserted")) {%>
             <p style="color :green"> Data Inserted</p>
             <%} else{%>
             <p style="color:red"> <%=msg %></p>
             <%} }%>
           <table>
            <tr>
                <th><label for="docName">name : </label></th>
                <td><input id="docName" type="text" name="doctorName" required></td>
            </tr>
            <tr>
                <th><label for="photo">photo : </label></th>
                <td><input id="photo" type="file" alt="photo" name="photo" required="required"> </td>
            </tr>
            <tr>
                <th><label for="specialization">Specialization : </label></th>
                <td> <select id="specialization" name="specialization" required="required">
                        <option value="select"> select </option>
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
                      </select>
                </td>
            </tr>
            <tr>
                <th><label for="qualification">Qualification : </label></th>
                <td> <textarea id="qualification" name="qualification" required="required"></textarea></td>
            </tr>
            <tr>
                <th><label for="licence">Licence no. : </label></th>
                <td><input id="licence" type="text" name="licenceNo" required="required"></td>
            </tr>
            <tr>
                <th> <label for="phone">phone no. : </label></th>
                <td><input id="phone"  type="tel" name="phoneNo" required="required"></td>
            </tr>
            <tr>
                <th>  <label for="cabin">Cabin no. : </label></th>
                <td><input id="cabin" type="number" name="cabinNo" required="required"></td>
            </tr>
            <tr>
                <th> <label for="salary">Salary : </label></th>
                <td>  <input id="salary" type="number" name="salary" required="required" ></td>
            </tr>
            <tr>
                <th><label for="consultationFee">Consultation fee : </label></th>
                <td><input id="consultationFee" type="number" name="consultationFee" required="required"></td>
            </tr>
           </table>
       
            <input type="submit" value="Add">
        </form>

   </div>
    
    <div class="nn" id="doctorRemoveF">
         <form action="">
            <input type="number" placeholder="Enter doctor id">
            <input type="submit" value="Delete">
         </form>
    </div>
    
    <div class="nn" id="changeAdminPass">
         <form action="">
            <input type="text" placeholder="Enter new Password">
            <input type="submit" value="Change">
         </form>
    </div>

    <div class="nn" id="changeAdmin">
           <form action="" method="post">
            <h1>Admin Details</h1>
             <table>
                <tr>
                    <th><label for="AdminName">Name : </label></th>
                    <td><input type="text" id="AdminName"></td>
                </tr>
                <tr>
                    <th><label for="Password">Password : </label></th>
                    <td><input id="Password" type="password"></td>
                </tr>
                <tr>
                    <th><label for="phone">phone no. : </label></th>
                    <td><input type="tel" id="phone"> </td>
                </tr>
             </table>
                 <input type="submit" value="change">
           </form>
        

    </div>

</main>
      
      
   <%@include file="html-files/footer.html" %>
   
 <script type="text/javascript" src="js-files/adminPage.js"></script>
</body>
</html>