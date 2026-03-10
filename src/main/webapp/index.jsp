<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Santosh Hospital</title>
    <link rel="stylesheet" href="css-files/style.css?v=2">
</head>
<body>


<header id="header">
    <h1>Santosh Hospital</h1>
    <p>We Care About Your Health</p>
    <div id="Admin">
       <h3>Admin</h3>
       <form action="admin_verification" method="post" >
       <input type="password" placeholder="password" name="pass" id="pass" required="required"><br>
       <% if(request.getAttribute("error")!=null){ %>
       <p  id="error" style="margin: 0px;font-size: 12px; color:red;"> *invalid password</p>
       <%} %>
       <input type="submit">
       </form>
    </div>
    
 
</header>
  <span id="loginSpan">
  <%if(session==null || session.getAttribute("username")==null){ %>
   <h3> <a href="login">login</a></h3>
   <%}else{ %>
   <h3> <%=session.getAttribute("username") %></h3>
   <%} %>
  </span>
<nav>
    <a href="#home">Home</a>
    <a href="#about">About</a>
    <a href="#services">Services</a>
    <a href="" id="doc">Doctors</a>
</nav>

 <div id="doctorTypes" style="display:none">
        <a href="related_doctors?type=Dermatologists">Dermatologist</a>
        <a href="related_doctors?type=Cardiologists">Cardiologists </a>
        <a href="related_doctors?type=Oncologist">Oncologist</a>
        <a href="related_doctors?type=Neurologist">Neurologist</a>
        <a href="related_doctors?type=Endocrinologist">Endocrinologist</a>
        <a href="related_doctors?type=Gastornterologist">Gastornterologist</a>
        <a href="related_doctors?type=Ophthalmologist">Ophthalmologist</a>
        <a href="related_doctors?type=Psychiatrist">Psychiatrist</a>
        <a href="related_doctors?type=Pulmonologist">Pulmonologist</a>
        <a href="related_doctors?type=Rheumatologist">Rheumatologist</a>
        <a href="related_doctors?type=Urologist">Urologist</a>
        
    </div>

<section id="home" class="section">
    <h2>Welcome</h2>
    <p>suhgo w wgwruh owt gwr gowiuh giwer gwto wrwrh g wwtw ghoiuwrh wrpwpw hgpwu</p>
</section>

<section id="about" class="section light">
    <h2>About Us</h2>
    <pre>
        City Care Hospital provides affordable and reliable healthcare
        services with advanced medical technology.
        
        ****** Some Useful Terms ****** 
        
        Cardiologist: Heart conditions.
        Dermatologist: Skin, hair, and nails.
        Endocrinologist: Hormones, diabetes, thyroid.
        Gastroenterologist: Digestive system.
        Neurologist: Brain, spinal cord, nervous system.
        Oncologist: Cancer treatment.
        Ophthalmologist: Eyes, can perform surgery.
        Psychiatrist: Mental, emotional, and behavioral health.
        Pulmonologist: Lungs and respiratory system.
        Rheumatologist: Joints, muscles, autoimmune diseases.
        Urologist: Urinary tract and male reproductive system. 
        
        
    </pre>
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
    <p>📍 Main Road, City</p>
    <p>📞 +123 456 7890</p>
    <p>✉️ info@citycarehospital.com</p>
</section>

<footer>
    <p>© 2026 Santosh Hospital</p>
</footer>
<script type="text/javascript" src="js-files/script.js"></script>

</body>
</html>