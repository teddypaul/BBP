package bbp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	 
	public ArrayList showBookList(String address) throws Exception {
		Connection con = this.getConnect();
		String sql = "select bookName from  where address=? ";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,address);
		ResultSet rs = pstat.executeQuery();
		
		ArrayList result = new ArrayList();
		while(rs.next()) {
			String bList = rs.getString("bookName");
			String addr = rs.getString("address");
			result.add(bList);
			result.add(addr);
		}
		con.commit();
		con.close();
		return result;

	}
}

