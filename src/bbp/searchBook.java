package bbp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import bbp.DAO.AddressDAO;
//도서 검색 기능
public class searchBook extends JFrame{

	private CardLayout cardLayout = new CardLayout();
	private Bbpmain bm = new Bbpmain();
	private AddressDAO address = new AddressDAO(); 
	private JButton bLocal = new JButton("지역검색");//검색실행버튼
	private JButton bSchool = new JButton("학교검색");
	private JButton bBook = new JButton("도서검색");
	private JButton bBack = new JButton("뒤로가기");
	private JPanel bPane = new JPanel();
	private JTextField searchField = new JTextField();//검색입력창
	private JTextArea area = new JTextArea();//검색결과를 area에 담기로 했습니다.;
	private JScrollPane sc = new JScrollPane(area);//리스트를 스크롤 창으로
	private JPanel pane = new JPanel();
	private JPanel cardPane = new JPanel();
	private JPanel localPane = new JPanel();
	private JPanel schoolPane = new JPanel();
	
	private JPanel bookPane = new JPanel();
	private Socket sock;
	private InputStream is ;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private String name = null;
	private void socketInit() {
		//		Socket sock = new Socket("192.168.53.?",?);
		//		is = sock.getInputStream();
		//		dis = new DataInputStream(is);
		//		os = sock.getOutputStream();
		//		dos = new DataOutputStream(os);
	}

	private void eventInit() {
		this.bLocal.addActionListener(new ActionListener() {//지역검색 버튼을 누를때 작동할 내용
			public void actionPerformed(ActionEvent a) {
				cardLayout.show(cardPane,"1");
				name = searchField.getText();
				try {
					dos.writeUTF("lBook");
					dos.writeUTF(name);
					dos.flush();
				} catch (Exception e) {
					e.printStackTrace();
				}
				ArrayList bList;
				try {
					bList = new AddressDAO().showBookList(name);
//					final List list = new ArrayList();
//					Collections.addAll(list,bList);
					for(int i=0 ; i<=bList.size();i++) {
						Object name = bList.get(i);
//					System.out.println(name);
						//						model.insertRow(i, (Vector) bList.get(i));
					}//배열에서의 문자열 비교 -- list(final List list1 = new ArrayList(); Collections.addAll(list1, America);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});

		this.bSchool.addActionListener(new ActionListener() {//학교검색 버튼을 누를때 작동할 내용
			public void actionPerformed(ActionEvent a) {
				cardLayout.show(cardPane,"2");
				name = searchField.getText();
				try {
					dos.writeUTF("uBook");
					dos.writeUTF(name);
					dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}});
		this.bBook.addActionListener(new ActionListener() {//도서검색 버튼을 누를때 작동할 내용
			public void actionPerformed(ActionEvent a) {
				cardLayout.show(cardPane,"3");
				name = searchField.getText();
				try {
					dos.writeUTF("bList");
					dos.writeUTF("name");
					dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}});

		this.searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//검색창에서 엔터키 누를때 버튼 눌렀을 때와 같은 동작실행되게 구현하려했으나
				//버튼이 세개라 어떻게 해야할까요? 힘들것 같다;;

				String address = searchField.getText();
				String name = null;
				ArrayList addr;
				try {
					addr = new AddressDAO().showBookList(address);
					for(int i=0 ; i<=addr.size();i++) {
						name = (String) addr.get(i);
						if(address.contains(name)) {

						}}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}});
		this.bBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bm.Bbpmain();
				setVisible(true);
				dispose();
			}});
	}
	private void compInit() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,0,0,10);
		this.add(bLocal);
		this.bLocal.setBorderPainted(false);//버튼의 테두리 선을 지우고,
		this.bLocal.setBorder(new BevelBorder(BevelBorder.RAISED));//버튼을 올라와 보이도록 효과를 줌.
		this.bLocal.setPreferredSize(new Dimension(90,30));//검색필드와 버튼의 사이즈를 넣어주고 
		this.add(bSchool);
		this.bSchool.setBorderPainted(false);
		this.bSchool.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.bSchool.setPreferredSize(new Dimension(90,30));
		this.add(bBook);
		this.bBook.setBorderPainted(false);
		this.bBook.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.bBook.setPreferredSize(new Dimension(90,30));
		this.bPane.add(bLocal);
		this.bPane.add(bSchool);
		this.bPane.add(bBook);//버튼 세개를 패널에 담는다.
		c.gridy=0; c.gridx=0;
		this.add(bPane,c);
		c.gridy=1; c.gridx=0;
		this.add(searchField,c);
		this.searchField.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.searchField.setPreferredSize(new Dimension(350,30));//버튼 아래 검색창을 두고,

		this.localPane.setBackground(Color.GREEN);
		this.schoolPane.setBackground(Color.YELLOW);
		this.bookPane.setBackground(Color.PINK);
		this.localPane.setPreferredSize(new Dimension(340,490));
		this.schoolPane.setPreferredSize(new Dimension(340,490));
		this.bookPane.setPreferredSize(new Dimension(340,490));
		this.cardPane.setLayout(cardLayout);
		this.cardPane.add(localPane,"1");
		this.cardPane.add(schoolPane, "2");
		this.cardPane.add(bookPane,"3");
		this.pane.add(cardPane);//패널안에 카드 레이아웃으로 삽입
		//		this.area.setAutoscrolls(true);//오토스크롤
		c.gridy = 2; c.gridx = 0;
		this.add(pane,c);//검색결과를 불러올 패널
		this.pane.setPreferredSize(new Dimension(350,500));
		this.pane.setBorder(new BevelBorder(BevelBorder.LOWERED));
		//		this.add(sc, c);//검색창 밑에 검색결과를 불러올 area를 둔다.
		//		this.sc.setPreferredSize(new Dimension(350,500));
		//		this.sc.setBackground();
		//		this.sc.setBorder(new BevelBorder(BevelBorder.LOWERED));
		c.gridy=4; c.gridx=0;
		this.add(bBack,c);//뒤로가기 버튼 생성
		this.bBack.setBorderPainted(false);
		this.bBack.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.bBack.setPreferredSize(new Dimension(90,30));
	}
	public void searchBook() {
		this.setTitle("도서목록 검색");
		this.setSize(480,800);
		this.setResizable(false);//창 크기 고정
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.socketInit();
		this.compInit();
		this.eventInit();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		searchBook sb = new searchBook();
		sb.searchBook();
	}
}
