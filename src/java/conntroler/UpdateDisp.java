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
public class UpdateDisp extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            try 
            {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/signup.css\"/>");
            out.println("<title>Servlet UpdateDisp</title>");            
            out.println("</head>");
            out.println("<body background=\"Images/homeback.jpg\">");
            HttpSession session = request.getSession(true);
            String uname;
            uname=session.getAttribute("username").toString();
            UserDAO ud=new UserDAO();
            User U=new User();
            U=ud.searchByUname(uname);
            if(uname!=null){
                out.println("<div id=\"id01\" class=\"modal\">");  
                out.println("<form class=\"modal-content\" action=UpdateURec method=post>");
                out.println("<center>");
                out.println("<h1><p class=\"sansserif\">User Record</p></h1>");
                out.println("</center>");
                out.println("<div class=\"container\">");  
                out.println("<label><b><p class=\"sansserif\">Name</p></b></label><td><input type=text name=fname value="+U.getFnam()+"></td>");
                out.println("<td><input type=text name=lname value="+U.getLnam()+"></td>");
                out.println("<label><b><p class=\"sansserif\">E-mail ID</p></b></label><td><input type=text name=email value="+U.getEml()+"></td>");
                out.println("<label><b><p class=\"sansserif\">Contact Number</p></b></label><td><input type=text name=contact value="+U.getCont()+"></td>");
                out.println("<label><b><p class=\"sansserif\">Date of Birth</p></b></label><td><input type=date name=dob value="+U.getDB()+"></td>");
                out.println("<label><b><p class=\"sansserif\">Old Password</p></b></label><td><input type=text name=passw value="+U.getPss()+"></td>");
                out.println("<label><b><p class=\"sansserif\">New Password</p></b></label><td><input type=text name=confpass value="+U.getUpass()+"></td>");
                out.println("<label><b><p class=\"sansserif\">Username</p></b></label><td><input type=text name=username value="+U.getUname()+"></td>");
                out.println("<td><input type=submit value=Update></td>");
               // response.sendRedirect("home1.jsp");
                
                
                out.println("</tr>");
                
                out.println("</tr>");
                out.println("</div>");
                
                out.println("</form>");
                out.println("</div>");
                out.println("</table>");
                
                
                out.println("</center>");
            
            }else
            {
            out.println("<font color=red size=8> Record Not Found</font>");    
            
            }    
            
            
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
