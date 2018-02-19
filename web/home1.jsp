<%-- 
    Document   : home1
    Created on : May 12, 2017, 1:14:31 AM
    Author     : Apoorav
--%>
<%
   
    response.addHeader("Cache-Control","no-store");
    response.addHeader("Pragma","no-Cache");
 // if(session.getAttribute("username") == (String) session.getAttribute("username"))
  //{
    //  response.sendRedirect("index.html");
  //}
   if(session==null)
   {
       response.sendRedirect("index.jsp");
   }
%>


<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="connection.MyCon"%>
<%@page import="model.User"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="home.css"/>
        <link href="CSS/bootstrap.min.css" type="text/css" rel="stylesheet">

<style> 
input[type=text] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    float:right;
    text-align: center;
    font-size: 16px;
    background-color: white;
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 10px 10px 10px 10px;
}
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}
</style>
</head>
<form action="Search" method="post">
    <input type="text" name="bname" placeholder="Dhundo..">
</form>
<body class="bgimg">
    
 <div class="dropdown">
     <button class="dropbtn black">
    <%
      String uname;
      uname=session.getAttribute("username").toString();
      Connection con=null;
      con=MyCon.getConnection();
      String q = "select fname from signup where username= " +"\"" +uname +"\"";
      PreparedStatement ps=null;
      ps=con.prepareStatement(q);
      ResultSet rs=null;
      rs=ps.executeQuery();
      if(rs.next()) {
      out.print(rs.getString(1));
      }
    %>
  </button>
  <div class="dropdown-content">
    <a href="UpdateDisp">Edit Profile</a>
    <a href="destroy.jsp">Log Out</a>
    
  </div>
</div>
  <center>
    <img title="BooStore" src="Images/logotest2.png" alt="BooStore" width="200" height="105" id="BooStore">
  </center>
<br>
<div class="bgimg opacity-min">
  <div class="display-middle" style="white-space:nowrap;">
      <a class="bar-item button black" href="#menu" style="text-align:center" onclick="toggleFunction()" title="Click to go Menu">WELCOME</a>
  </div>
</div>
<div class="content container padding-64" id="menu">
  <h1 style="text-align: center"><p class="sansserif">MENU</p></h1>
</div>
<a style="align:center" type="submit" onclick="window.location.href='newsfeed.jsp'" class="btn btn-primary">NEWS FEED</a>
<a style="align:center" type="submit" onclick="window.location.href='#'" class="btn btn-primary">PROFILE</a>
<a style="align:center" type="submit" onclick="window.location.href='bupload.html'" class="btn btn-primary">UPLOAD BOOK</a>
<a style="align:center" type="submit" onclick="window.location.href='#'" class="btn btn-primary">ABOUT</a>
<a style="align:center" type="submit" onclick="window.location.href='#'" class="btn btn-primary">CONTACT US</a><br><br><br><hr>
<footer class="center padding-64 opacity hover-opacity-off container"><center>
        <a href="#BooStore" class="button light-grey"><b class="fa fa-arrow-up margin-right"><b><center>To the top</center></b></b></a>
  <div class="xlarge section">
    <br><a href="#"><img class="hover-opacity" title="Facebook" src="Images/facebook.png" alt="Facebook" width="22" height="22"></a>
    <a href="https://www.instagram.com/boostore247"><img class="hover-opacity" title="Instagram" src="Images/Instagram_logo.png" alt="Instagram" width="22" height="22"></a>
  </div>
        <p>BooStore &COPY; 2017</p>
  </center>
</footer>
<script>
function toggleFunction() {
    var x = document.getElementById("menu");
    if (x.button1.indexOf("show") === -1) {
        x.button1 += " show";
    } else {
        x.button1 = x.button1.replace(" show", "");
    }
}
</script>

    <script src="js/bootstrap.min.js"></script>
</body>
</html>

