package bbp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import bbp.MyInfomation;
//회원가입 기능들
public class UserProfileDAO {

	private Connection getConnect() throws Exception{
		//오라클 db 접속 부분
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String local = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java7";
		String ps = "java7";
		Connection con = DriverManager.getConnection(local,id,ps);
		return con;

	}
	public int userlogin(String id , String pw) throws Exception {
		//아이디 로그인
		Connection con = this.getConnect();
		Statement stat = con.createStatement();

		String sql = "select id pw from 테이블명 where id=? and pw=?";
		PreparedStatement pstat = con.prepareStatement(sql);

		pstat.setString(1, id);
		pstat.setString(2, pw);
		int result = pstat.executeUpdate();

		con.commit();
		con.close();
		return result;
	}

	public int userduplication(String id) throws Exception{
		//아이디 중복 확인
		Connection con = this.getConnect();
		Statement stat = con.createStatement();

		String sql = "select id from 테이블 명 where id=?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);

		int result = pstat.executeUpdate();
		return result;
	}

	public int userinput(String name, String ps) throws Exception{
		//회원가입 부분
		Connection con = this.getConnect();
		Statement stat = con.createStatement();

		String sql = "insert into 테이블명 values (seq_num.nextval,?,?,sysdate)";
		//시간 보내주는거
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, name);
		pstat.setString(2, ps);
		int result = pstat.executeUpdate();
		con.commit();
		con.close();
		return result;
	}

	public static void main(String[] args) {

	}
}
