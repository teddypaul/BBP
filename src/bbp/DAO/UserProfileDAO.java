package bbp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import bbp.MyInfomation;
//ȸ������ ��ɵ�
public class UserProfileDAO {

	private Connection getConnect() throws Exception{
		//����Ŭ db ���� �κ�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String local = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java7";
		String ps = "java7";
		Connection con = DriverManager.getConnection(local,id,ps);
		return con;

	}
	public int userlogin(String id , String pw) throws Exception {
		//���̵� �α���
		Connection con = this.getConnect();
		Statement stat = con.createStatement();

		String sql = "select id pw from ���̺�� where id=? and pw=?";
		PreparedStatement pstat = con.prepareStatement(sql);

		pstat.setString(1, id);
		pstat.setString(2, pw);
		int result = pstat.executeUpdate();

		con.commit();
		con.close();
		return result;
	}

	public int userduplication(String id) throws Exception{
		//���̵� �ߺ� Ȯ��
		Connection con = this.getConnect();
		Statement stat = con.createStatement();

		String sql = "select id from ���̺� �� where id=?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, id);

		int result = pstat.executeUpdate();
		return result;
	}

	public int userinput(String name, String ps) throws Exception{
		//ȸ������ �κ�
		Connection con = this.getConnect();
		Statement stat = con.createStatement();

		String sql = "insert into ���̺�� values (seq_num.nextval,?,?,sysdate)";
		//�ð� �����ִ°�
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
