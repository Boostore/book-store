/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conntroler;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Apoorav
 */
public class UpdateURec extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter(); 
            try
            {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateURec</title>");            
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession(true);
            session.setAttribute("username", request.getParameter("username"));
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
             UserDAO ud=new UserDAO();
            if(ud.updateUrec(U))
                response.sendRedirect("thankyou_1.html");
           else
              out.println("Record Not updated");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
          out.println(e);
        }  
    }
}   