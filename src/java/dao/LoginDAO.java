package dao;
import connection.MyCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginDAO 
{
   public static boolean checkLogin(String uname,String upass) throws Exception
   {
         Connection con=null;
         PreparedStatement ps=null;
         ResultSet rs=null;
         con=MyCon.getConnection();
         String sql;
         sql="select * from signup where username=? and confpass=?";
         ps=con.prepareStatement(sql);
         ps.setString(1, uname);
         ps.setString(2, upass);
         rs=ps.executeQuery();
         if(rs.next())
            return true;
         else
             return false;
   }       
}