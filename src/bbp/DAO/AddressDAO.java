package bbp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bbp.DTO.BookmanagementDTO;

public class AddressDAO {

	private Connection getConnect()throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","java7","java7");
		return con;
	}

	public void insertMemberAddress() throws Exception {
		Connection con = this.getConnect();
	}
	
	
	public ArrayList<BookmanagementDTO> showUniverseBookList(String name) throws Exception {
		Connection con = this.getConnect();
		String sql = "select bookName from where schoolName=?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,name);
		ResultSet rs = pstat.executeQuery();
		ArrayList<BookmanagementDTO> result = new ArrayList<BookmanagementDTO>();
		while(rs.next()) {
			BookmanagementDTO bList = new BookmanagementDTO();
		    bList.setBookName(rs.getString("bookName"));
			result.add(bList);
		}
		con.commit();
		con.close();
		return result;
	}
	 
	public ArrayList<BookmanagementDTO> showLocalBookList(String address) throws Exception {
		Connection con = this.getConnect();
		String sql = "select bookName from  where address=? ";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,address);
		ResultSet rs = pstat.executeQuery();
		
		ArrayList<BookmanagementDTO> result = new ArrayList<BookmanagementDTO>();
		while(rs.next()) {
			BookmanagementDTO bList = new BookmanagementDTO();
			String bName = rs.getString("bookName");
			String addr = rs.getString("address");
			bList.setBookName(bName);
			bList.setBookName(addr);
			result.add(bList);
			
		}
		con.commit();
		con.close();
		return result;

	}
}

