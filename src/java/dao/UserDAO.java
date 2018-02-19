package dao;
import connection.MyCon;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UploadB;
public class UserDAO 
{
    Connection con=null;
    PreparedStatement ps=null;
    public boolean insertUrec(User U) throws Exception
    {
            con=MyCon.getConnection();
            String sql;
            sql="insert into signup values(?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, U.getFnam());
            ps.setString(2, U.getLnam());
            ps.setString(3, U.getEml());
            ps.setString(4, U.getCont());
            ps.setString(5, U.getDB());
            ps.setString(6, U.getPss());
            ps.setString(7, U.getUpass());
            ps.setString(8, U.getUname());
            if(ps.executeUpdate()>0)
                return true;
            else
                return false;
    }
    public boolean uploadUrc(UploadB B) throws Exception
    {
            con=MyCon.getConnection();
            String sql;
            sql="insert into boostore.upload (bname, bwrit, bpris, contact) values(?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, B.getBnam());
            ps.setString(2, B.getBwri());
            ps.setInt(3, B.getBpri());
            ps.setString(4, B.getCont());
            if(ps.executeUpdate()>0)
                return true;
            else
                return false;
    }
    public boolean updateUrec(User U) throws Exception
    {
    
            con=MyCon.getConnection();
            String sql;
            sql="update signup set fnam=?,lnam=?,eml=?,cont=?,db=?,pss=?,upass=?,uname=? where uname=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, U.getFnam());
            ps.setString(2, U.getLnam());
            ps.setString(3, U.getEml());
            ps.setString(4, U.getCont());
            ps.setString(5, U.getDB());
            ps.setString(6, U.getPss());
            ps.setString(7, U.getUpass());
            ps.setString(8, U.getUname());
            if(ps.executeUpdate()>0)
                return true;
            else
                return false; 
            
    }
    public User searchByUname(String uname) throws Exception
    {
             con=MyCon.getConnection();
            String sql;
            sql="select * from signup where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, uname);
            ResultSet rs = null;
            rs=ps.executeQuery();
            User U=new User();
            if(rs.next())
           {     
            U.setFnam(rs.getString(1));
            U.setLnam(rs.getString(2));
            U.setEml(rs.getString(3));
            U.setCont(rs.getString(4));
            U.setDB(rs.getString(5));
            U.setPss(rs.getString(6));
            U.setUpass(rs.getString(7));
            U.setUname(rs.getString(8));
           }
          else
            {
               U=null;
            }      
          return U;  
    }
    public User searchByBname(String bnam) throws Exception
    {
             con=MyCon.getConnection();
            String sql;
            sql="select * from upload where bname=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, bnam);
            ResultSet rs = null;
            rs=ps.executeQuery();
            User U=new User();
            if(rs.next())
           {     
            U.setBnam(rs.getString(1));
            U.setBwri(rs.getString(2));
            U.setBpri(rs.getInt(3));
            U.setCont(rs.getString(4));            
           }
          else
            {
               U=null;
            }      
          return U;  
    }
    public User newsFeed(String uname) throws Exception
    {
             con=MyCon.getConnection();
            String sql;
            sql="select * from upload where contact = (select contact from signup where username = ?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, uname);
            ResultSet rs = null;
            rs=ps.executeQuery();
            User U=new User();
            if(rs.next())
           {     
            U.setBnam(rs.getString(1));
            U.setBwri(rs.getString(2));
            U.setBpri(rs.getInt(3));
            U.setCont(rs.getString(4));            
           }
          else
            {
               U=null;
            }      
          return U;  
    }
    /*public User searchByBname(String bnam) throws Exception
    {
             con=MyCon.getConnection();
            String sql;
            sql="select * from upload where bname=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, bnam);
            ResultSet rs = null;
            rs=ps.executeQuery();
            User U=new User();
            if(rs.next())
           {     
            U.setBnam(rs.getString(1));
            U.setBwri(rs.getString(2));
            U.setBpri(rs.getInt(3));
           }
          else
            {
               U=null;
            }      
          return U;  
    }*/
    public List searchFeed() throws Exception
    {
            String sql;
            ResultSet rs=null;
            
            sql="select b.bname, b.bwrit, b.bpris, b.contact, u.fname, u.lname from upload b,signup u where b.contact=u.contact";
             con=MyCon.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            List<User> mylist=new ArrayList<User>();     
            while(rs.next())
            {
                User U=new User();
                U.setBnam(rs.getString(1));
                U.setBwri(rs.getString(2));
                U.setBpri(rs.getInt(3));
                U.setCont(rs.getString(4));    
                U.setFnam(rs.getString(5));
                U.setLnam(rs.getString(6));
                 mylist.add(U);
                 U=null;
            }  
           return mylist; 
    }


}
