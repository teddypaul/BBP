package bbp.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bbp.DTO.BookmanagementDTO;

//책관리 기능들
public class BookmanagementDAO {
	private Connection getConnect() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","java7","java7");
		return con;
	}
//	public int uploadBook(BookmanagementDTO bookdto) throws Exception{
//		Connection con = this.getConnect();
//		ArrayList<BookmanagementDTO> arr = new ArrayList<BookmanagementDTO>();
//
//		Statement stat = con.createStatement();
//
//		PreparedStatement pstat = con.prepareStatement(
//				"insert into book values ('ergh77', bookseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)");
//		//pstat.setString(1, bookdto.getUserid());
//		pstat.setString(1, bookdto.getTitle());
//		File a = new File("C:/Users/Kim/Downloads/eclipse-jee-neon-3-win32-x86_64/사진 모음/books.png");
//		FileInputStream fis = new FileInputStream(a);
//		pstat.setBinaryStream(2, fis);
//		pstat.setString(3, bookdto.getBookname());
//		pstat.setString(4, bookdto.getBooknum());
//		pstat.setString(5, bookdto.getBookindex());
//		pstat.setString(6, bookdto.getBookexchange());
//		pstat.setString(7, bookdto.getBookquality());
//		pstat.setString(8, bookdto.getBookaddress());
//		pstat.setString(9, bookdto.getBookuniversity());
//		pstat.setInt(10, bookdto.getBookprice());
//		pstat.setInt(11, bookdto.getCheckstat());
//
//		int result = pstat.executeUpdate();
//		con.commit();
//		fis.close();
//		con.close();
//		return result;
//	}

	public ArrayList<BookmanagementDTO> showBookList(String name) throws Exception {
		Connection con = this.getConnect();
		String sql = "select * from book where bookName like '%?%'";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,name);
		ResultSet rs = pstat.executeQuery();
		ArrayList<BookmanagementDTO> result = new ArrayList<BookmanagementDTO>();
		while(rs.next()) {
			BookmanagementDTO bList = new BookmanagementDTO();
			bList.setBookName( rs.getString("bookName"));
			bList.setBookSeq(rs.getString("bookSeq"));
			result.add(bList);
		}
		con.commit();
		con.close();
		return result;
	}
	public ArrayList<BookmanagementDTO> showUniverseBookList(String name) throws Exception {
		Connection con = this.getConnect();
		String sql = "select * from book where bookUniversity like '%?%'";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,name);
		ResultSet rs = pstat.executeQuery();
		ArrayList<BookmanagementDTO> result = new ArrayList<BookmanagementDTO>();
		while(rs.next()) {
			BookmanagementDTO bList = new BookmanagementDTO();
			bList.setBookName(rs.getString("bookName"));
			bList.setBookSeq(rs.getString("bookSeq"));
			result.add(bList);
		}
		con.commit();
		con.close();
		return result;
	}
	public ArrayList<BookmanagementDTO> showLocalBookList(String address) throws Exception { 		
		Connection con = this.getConnect();
		String sql = "select * from book where bookAddress like '%?%' ";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1,address);
		ResultSet rs = pstat.executeQuery();

		ArrayList<BookmanagementDTO> result = new ArrayList<BookmanagementDTO>();
		while(rs.next()) {
			BookmanagementDTO bList = new BookmanagementDTO();
			bList.setBookName(rs.getString("bookName"));
			bList.setBookName(rs.getString("bookSeq"));
		
			result.add(bList);
			System.out.println(result);
		}
		con.commit();
		con.close();
		return result;
}
}
