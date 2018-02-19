/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conntroler;
import dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Apoorav
 */
public class login extends HttpServlet {

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
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<body>");
            
            HttpSession session = request.getSession(true);
            
            String uname,upass;
             uname=request.getParameter("username");
             upass=request.getParameter("confpass");
             //out.println("Username"+uname);
             //out.println("Password"+upass);
             boolean x = LoginDAO.checkLogin(uname, upass);
             out.println(""+x);
            if(x==true){
                 session.setAttribute("username", uname);
                //session.setAttribute("pass", upass);
              //response.sendRedirect("header.jsp");
                response.sendRedirect("home1.jsp");
        }  
        else{  
            out.print("<script> alert(\"Incorrect Username/Password\");</script>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        } 
             /*boolean x = LoginDAO.checkLogin(uname, upass);
             out.println(""+x);
            if(x==true)
                  response.sendRedirect("home1.jsp");
            else
            response.sendRedirect("index.html"); */   
             
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
           out.println(e);
        }    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
