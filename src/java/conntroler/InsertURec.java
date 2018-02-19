package conntroler;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class InsertURec extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertURec</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
            
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        
        try
        {   
             String fnam, lnam, eml, cont, db, pss, upass, uname;
             fnam=request.getParameter("fname");
             lnam=request.getParameter("lname");
             eml=request.getParameter("email");
             cont=request.getParameter("contact");
             db=request.getParameter("dob");
             pss=request.getParameter("passw");
             upass=request.getParameter("confpass");
             uname=request.getParameter("username");
             User U=new User();
              U.setFnam(fnam);
              U.setLnam(lnam);
              U.setEml(eml);
              U.setCont(cont);
              U.setDB(db);
              U.setPss(pss);
              U.setUpass(upass);
              U.setUname(uname);
             UserDAO us=new UserDAO();
             if(us.insertUrec(U)) {
                response.sendRedirect("thankyou.html");
             } else {
             }             
        }
        catch(Exception e)
        {
           out.println(e);
        }    
             
             
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}