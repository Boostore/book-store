<%-- 
    Document   : logout
    Created on : May 24, 2017, 1:43:10 AM
    Author     : Apoorav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <%
            //session.setAttribute("username", null); //it just assigns null to attribute
            session.invalidate();
            out.println("<script language='JavaScricpt'>alert('Logout Sussfully...');</script>");
            response.sendRedirect("index.html");
           // response.sendRedirect("index.html");
        %>
    </body>
</html>
