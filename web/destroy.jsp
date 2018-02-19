<%try{
session.invalidate();
response.sendRedirect("index.jsp");
out.clear();
}
catch(NullPointerException ex){}
%>