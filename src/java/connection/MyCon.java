
package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MyCon 
{
    public static Connection con=null;
    
    static
    {
      try
     {
        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("driver load ");
     }
     catch(ClassNotFoundException e)
     {
         System.out.println(e);
     }    
    }

    public static Connection getConnection()
    {
       try
         {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BooStore","root","root");
             System.out.println("database load ");
         }
         catch(SQLException e)
         {
            System.out.println(e);
          }    
          return con;      
      }
}
