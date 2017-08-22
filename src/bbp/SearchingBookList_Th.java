package bbp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import bbp.DAO.AddressDAO;
import bbp.DAO.BookmanagementDAO;
import bbp.DTO.BookmanagementDTO;

public class SearchingBookList_Th {
	private Socket sock = null;
//	private AddressDAO addrDao = new AddressDAO();
	
	public void searchingBookList() {
		try {
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = sock.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			String stm = dis.readUTF();
			if(stm.equals("lBook")) {
				String address = dis.readUTF();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(os);
					BookmanagementDAO bookDao = new BookmanagementDAO();
					ArrayList<BookmanagementDTO> bList = bookDao.showLocalBookList(address);
					oos.writeObject(bList);
					oos.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(stm.equals("uBook")) {
				String name = dis.readUTF();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(os);
					ArrayList<BookmanagementDTO> bList = new ArrayList<BookmanagementDTO>();
					BookmanagementDAO bookDao = new BookmanagementDAO();
					bList = bookDao.showUniverseBookList(name);//AddressDAO에 리스트 생성할 코드를 만들어 놨다.
					oos.writeObject(bList);
					oos.flush();
//					for(BookmanagementDTO tmp : bList) {
//						System.out.println(tmp.getBookName());
//						}
					} catch (Exception e) {//더 나은 곳이 있다면 거기서 목록을 불러와도 좋을듯.
					e.printStackTrace();
				}
			}
			if(stm.equals("bList")) {
				String name = dis.readUTF();
				try {
				
					ObjectOutputStream oos = new ObjectOutputStream(os);
					BookmanagementDAO bookDao = new BookmanagementDAO();
					ArrayList<BookmanagementDTO> bList = bookDao.showBookList(name);
					oos.writeObject(bList);
					oos.flush();
//					for(BookmanagementDTO tmp : bList) {
//					dos.writeUTF(tmp.getBookName());
//					dos.flush();
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
