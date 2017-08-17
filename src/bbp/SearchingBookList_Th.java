package bbp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import bbp.DAO.AddressDAO;
import bbp.DAO.BookmanagementDAO;

public class SearchingBookList_Th {
	private Socket sock = null;
	private AddressDAO addrDao = new AddressDAO();
	private BookmanagementDAO bookDao = new BookmanagementDAO();
	public void searchingBookList() {
		try {
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			String stm = dis.readUTF();
			if(stm.equals("lBook")) {
				String name = dis.readUTF();
				try {
					ArrayList bList = addrDao.showLocalBookList(name);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(stm.equals("uBook")) {
				String name = dis.readUTF();
				try {
					ArrayList bList = addrDao.showUniverseBookList(name);//AddressDAO�� ����Ʈ ������ �ڵ带 ����� ����.
				} catch (Exception e) {                                  //�� ���� ���� �ִٸ� �ű⼭ ����� �ҷ��͵� ������.
					
					e.printStackTrace();
				}
			}
			if(stm.equals("bList")) {
				String name = dis.readUTF();
//				ArrayList bList = bookDao.showBookList(name);// BookmanagementDAO���� �ҷ��� ����Ʈ(���� �ڵ� �������̶�..)
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
