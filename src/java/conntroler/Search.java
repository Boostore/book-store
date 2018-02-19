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
import model.User;

/*
 *
 * @author Apoorav
 */
public class Search extends HttpServlet {

    /*
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
            try{
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"home.css\"/>");
            out.println("<style> .card {    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);   align: center;    transition: 0.3s;    width: 40%;    background-color: cyan;}.card:hover {    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);}.container {    padding: 2px 16px;} </style>");
            out.println("</head>");
            out.println("<body class=\"bgimg\">");
            String bnam;
            bnam= request.getParameter("bname");
            UserDAO ud=new UserDAO();
            User U=new User();
            U=ud.searchByBname(bnam);
            if(U==null)
            out.println("<font color=red size=8> Record Not Found</font>");    
            else
            {
                String bwri, cont;
                int bpri;
                bnam = U.getBnam();
                bwri = U.getBwri();
                bpri = U.getBpri();                
                cont = U.getCont();
                out.println("<center><h2 class=\"black\">Search Results...</h2><center>");
                out.println("<form action=UploadBook method=post>");
                out.println("<div class=\"card\">");
                out.println("<div class=\"container\">");
                out.println("<b>Book Name : </b><td>"+bnam+"</td><br>");
                out.println("<b>Book Writer : </b><td>"+bwri+"</td><br>");
                out.println("<b>Book Price : </b><td>"+bpri+"</td><br>");
                out.println("<b>Contact Number : </b><td>"+cont+"</td><br>");
                out.println("</div>");
                out.println("</div>");
                out.println("</form>");
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
