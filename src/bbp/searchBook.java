package bbp;

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
	private AddressDAO address = new AddressDAO(); 
	private JTextArea area = new JTextArea();
	private JTextField searchField = new JTextField();//검색입력창
	private JButton searchButton = new JButton("Searching");//검색실행버튼
	DefaultTableModel model = new DefaultTableModel();                  
	private JTable table = new JTable(model); //검색결과를 보여줄 리스트(테이블에 담아볼까 합니다)
	private JScrollPane sc = new JScrollPane(table);//리스트를 스크롤 창으로
	private JPanel pane = new JPanel();
	private Socket sock;
	private InputStream is ;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private void socketInit() {
		//		Socket sock = new Socket("192.168.53.?",?);
		//		is = sock.getInputStream();
		//		dis = new DataInputStream(is);
		//		os = sock.getOutputStream();
		//		dos = new DataOutputStream(os);
	}

	private void eventInit() {
		this.searchButton.addActionListener(new ActionListener() {//버튼을 누를때 작동할 내용
			public void actionPerformed(ActionEvent a) {
				String address = searchField.getText();
				//				dos.writeUTF(address);
				//				dos.flush();

				ArrayList bList;
				try {
					bList = new AddressDAO().showBookList(address);
					for(int i=0 ; i<=bList.size();i++) {
						model.insertRow(i, (Vector) bList.get(i));
					}//배열에서의 문자열 비교 -- list(   final List list1 =  new ArrayList();  Collections.addAll(list1, America);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
		this.searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//검색창에서 엔터키 누를때 버튼 눌렀을 때와 같은 동작실행되게 
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
	}
	private void compInit() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,0,0,10);

		this.pane.add(searchField);
		this.searchField.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.pane.add(searchButton);
		this.searchButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.searchField.setPreferredSize(new Dimension(260,30));
		this.searchButton.setPreferredSize(new Dimension(90,30));//검색필드와 버튼의 사이즈를 넣어주고 
		c.gridy = 0; c.gridx = 0;
		this.add(pane, c);// 패널에 담아준다.//
		c.gridy = 1; c.gridx = 0;
		this.table.setAutoscrolls(true);//오토스크롤
		this.add(sc, c);
		this.sc.setPreferredSize(new Dimension(350,400));
		//		this.sc.setBackground();
		this.sc.setBorder(new BevelBorder(BevelBorder.LOWERED));
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
