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
        
   <div id="homeDiv">
     <a href="index.jsp" style="color:white">Home</a>
     <% 
     String dipartment= request.getParameter("docType"); 
     %>
     <div id="docType"><h2><%= dipartment %></h2></div>
   </div>
   
  <main>
   <div id="mainDiv">
   <%
     for(int i=1;i<=5;i++){
   %>
     <div id="cart">
       <div >
       <div id="photo"></div>
       <span>
          <h2 id="docNane" >Dr. Santosh Kumar</h2>
       </span>
       </div>
       <div id="discription">
        <pre>helfkjfj h   rh pihfpih rh iruhf hr fpyvdfqepf per
             fh fahf perye qrehf ehf pr 
             ger puq erfp  erf aj fl erer</pre>
       </div>
       <div id="btn">
           <button type="submit">Book Appointment</button>
       </div>
       
    </div>
   <%} %>
   </div>
  </main>
  <!--  
   <footer>
    <p>© 2026 Santosh Hospital</p>
</footer>
   -->
   
   <%@ include file="html-files/footer.html" %>
   
</body>
</html>