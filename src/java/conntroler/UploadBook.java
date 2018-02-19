
package conntroler;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UploadB;
import model.User;
@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16177215)

public class UploadBook extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UploadBook</title>");            
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
            String bnam, bwri,cont;
            int bpri;
            bnam=request.getParameter("bname");
            bwri=request.getParameter("bwrit");
            bpri=Integer.parseInt(request.getParameter("bpris"));
            cont=request.getParameter("contact");
             UploadB B=new UploadB();
             UserDAO ud=new UserDAO();
              B.setBnam(bnam);
              B.setBwri(bwri);
              B.setBpri(bpri);
              B.setCont(cont);
             if(ud.uploadUrc(B))
             {
                 response.sendRedirect("thankyou_1.html");
             } 
             else {
                 out.println("hello");
             }
        } 
        catch (NumberFormatException | IOException e) 
        {
            out.println(e);
        } catch (Exception ex) {
            Logger.getLogger(UploadBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

