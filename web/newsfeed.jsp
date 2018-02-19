<%-- 
    Document   : newsfeed
    Created on : May 15, 2017, 2:13:26 AM
    Author     : Apoorav
--%>
<%
  response.addHeader("Cache-Control", "no-store");
  response.addHeader("Pragma", "no-cache");
  if(session.getAttribute("username") == null)
  {
      response.sendRedirect("index.html");
  }
%>


<%@page import="model.UploadB"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UserDAO"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="home.css"/>
        <link rel="stylesheet" type="text/css" href="CSS/signup.css"/>
        <link href="CSS/bootstrap.min.css" type="text/css" rel="stylesheet">
        <link href="CSS/style.css" rel="stylesheet">
        <style> .card {    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.5);   align: center;    transition: 0.3s;    width: 40%;    background-color: whitesmoke;}.card:hover {    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);}.container {    padding: 2px 16px;} 
            .modal {
    display: url("back1.jpg");
    border-radius: 20px;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgb(0,0,0);
    background-color: rgba(0,0,0,0.4);
    padding-top: 60px;
}
.modal-content {
    background-color: white;
    margin: 10% auto 15% auto;
    border: 1px solid #888;
    width: 60%;
}
        </style>
    </head>
    <body class="bgimg">
<center>
<img title="BooStore" src="Images/logotest2.png" alt="BooStore" width="300" height="170">
</center>
    <center><h1>News Feed</h1></center>
        <%
         List<User>mylist=new ArrayList<User>();
            
             UserDAO sd=new UserDAO();
              mylist=sd.searchFeed();
              
              for(User U:mylist)
              {
                String bnam, fnam, lnam, bwri, cont;
                int bpri;
                bnam = U.getBnam();
                bwri = U.getBwri();
                bpri = U.getBpri();                
                cont = U.getCont();
                fnam = U.getFnam();
                lnam = U.getLnam();
                //out.println("<center>");
                //out.println("<div class=\"carousel-inner\">");
                //out.println("<div class=\"active\">");
                //out.println("<div class=\"carousel-caption\">");
                out.println("<div class=\"card\">");
                out.println("<div class=\"container\">");
                out.println("<h3>Posted By : </h3><td>"+fnam+" "+lnam+"</td>");
                out.println("<h3>Book Name : </h3><td>"+bnam+"</td><br>");
                out.println("<h3>Book Writer : </h3><td>"+bwri+"</td><br>");
                out.println("<h3>Book Price : </h3><td>"+bpri+"</td><br>");
                out.println("<h3>Contact Number : </h3><td>"+cont+"</td><br>");
                out.println("</div>");
                out.println("</div>");
                //out.println("</div>");
                //out.println("</center>");m());
                 out.println("<br>");
              }        
            
        %>
    <script src="js/bootstrap.min.js"></script>
        
    </body>
</html>
