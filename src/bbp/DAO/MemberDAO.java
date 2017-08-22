package bbp.DAO;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import bbp.DTO.MemberDTO;

public class MemberDAO {
   public static void main(String[] args) {

   }

   public static int userInput(MemberDTO dto) throws Exception {

      Connection con = null;
      Statement stat = null;

      String userid = dto.getUserid();
      String userpw = dto.getUserpw();
      String username = dto.getUsername();
      int userphonenumber = dto.getUserphonenumber();
      String useremail = dto.getUseremail();
      String useruniversity = dto.getUseruniversity();
      String useraddress = dto.getUseraddress();
      int userclass = dto.getUserclass();
      String usermail = dto.getUsermail();
      String userbirth = dto.getUserbirth();
      
      
      String sql = "INSERT INTO bookbank(id, pw, name, phonenumber, "
               + "email, university, address, userclass, mymail, birth) VALUES"
               + "(?, ?, ?, ?, ?, ?, ?, ?, '2000', 'mail')";

         Class.forName("oracle.jdbc.driver.OracleDriver");
         String local = "jdbc:oracle:thin:@localhost:1521:xe";
         String dbid = "java7";
         String ps = "java7";
         con = DriverManager.getConnection(local, dbid, ps);
         
         PreparedStatement pstat = con.prepareStatement(sql);
         
         pstat.setString(1, userid);
         pstat.setString(2, userpw);
         pstat.setString(3, username);
         pstat.setInt(4, userphonenumber);
         pstat.setString(5, useremail);
         pstat.setString(6, useruniversity);
         pstat.setString(7, useraddress);
         pstat.setString(8, userbirth);
         
         int result = pstat.executeUpdate();
         
         con.commit();
         con.close();

         return result;
      
   }   
}