package bbp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import bbp.DAO.AddressDAO;
import bbp.DTO.BookmanagementDTO;
//���� �˻� ���
public class searchBook<BSchool> extends JFrame{

	private CardLayout cardLayout = new CardLayout();
	private JToggleButton bLocal = new JToggleButton("�����˻�");//�˻������ư
	private JToggleButton bSchool = new JToggleButton("�б��˻�");
	private JToggleButton bBook = new JToggleButton("�����˻�");
	ButtonGroup bg = new ButtonGroup();
	private JButton bBack = new JButton("�ڷΰ���");
	private JPanel bPane = new JPanel();
	private JTextField searchField = new JTextField();//�˻��Է�â
	DefaultListModel<BookmanagementDTO> model = new DefaultListModel<>();
	private JList<BookmanagementDTO> bookList = new JList(model);
	public JPanel infoPane = new JPanel();
	public JLabel infoLabel = new JLabel();
	public JLabel image = new JLabel();
	public JTextField infoFld = new JTextField(); 
	private JPanel cardPane = new JPanel();
	private JPanel localPane = new JPanel();
	private JPanel schoolPane = new JPanel();
	private JPanel bookPane = new JPanel();
	private JScrollPane sc = new JScrollPane(bookList);//����Ʈ�� ��ũ�� â���� layPane 
	public JPanel mainPane = new JPanel();
	private Socket sock;
	private InputStream is ;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	private String name = null;
	private String stm ;
	private void socketInit()throws Exception {
		Socket sock = new Socket("192.168.53.184",10001);
		is = sock.getInputStream();
		dis = new DataInputStream(is);
		os = sock.getOutputStream();
		dos = new DataOutputStream(os);
	}
	public void eventInit() {
		this.bLocal.addActionListener(new ActionListener() {//�����˻� ��ư�� ������ �۵��� ����
			public void actionPerformed(ActionEvent a) {
				cardLayout.show(cardPane,"local");
				name = searchField.getText();
				stm = "lbook";
				try {
					dos.writeUTF("lBook");
					dos.writeUTF(name);
					dos.flush();

					ObjectInputStream ois = new ObjectInputStream(is);
					ArrayList<BookmanagementDTO> bList = 
							(ArrayList<BookmanagementDTO>)ois.readObject();
					for(int i=0 ; i <= bList.size() ; i++ ) {
						BookmanagementDTO dto = new BookmanagementDTO();
						dto.setBookName(bList.get(i).getBookName());
						dto.setBookSeq(bList.get(i).getBookSeq());
						model.addElement(dto);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}});
		this.bSchool.addActionListener(new ActionListener() {//�б��˻� ��ư�� ������ �۵��� ����
			public void actionPerformed(ActionEvent a) {
				cardLayout.show(cardPane,"school");
				name = searchField.getText();
				stm = "ubook";
				try {
					dos.writeUTF("uBook");
					dos.writeUTF(name);
					dos.flush();

					ObjectInputStream ois = new ObjectInputStream(is);
					ArrayList<BookmanagementDTO> bList = 
							(ArrayList<BookmanagementDTO>)ois.readObject();
					for(int i=0 ; i <= bList.size() ; i++ ) {
						BookmanagementDTO dto = new BookmanagementDTO();
						dto.setBookName(bList.get(i).getBookName());
						dto.setBookSeq(bList.get(i).getBookSeq());
						model.addElement(dto);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
		this.bBook.addActionListener(new ActionListener() {//�����˻� ��ư�� ������ �۵��� ����
			public void actionPerformed(ActionEvent a) {
				cardLayout.show(cardPane,"book");
				name = searchField.getText();
				stm = "bBook";
				try {
					dos.writeUTF("bList");
					dos.writeUTF(name);
					dos.flush();

					ObjectInputStream ois = new ObjectInputStream(is);
					ArrayList<BookmanagementDTO> bList = 
							(ArrayList<BookmanagementDTO>)ois.readObject();
					for(int i=0 ; i <= bList.size() ; i++ ) {
						BookmanagementDTO dto = new BookmanagementDTO();
						dto.setBookName(bList.get(i).getBookName());
						dto.setBookSeq(bList.get(i).getBookSeq());
						model.addElement(dto);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
		this.searchField.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent k) { //�˻�â���� ����Ű ������ ��ư ������ ���� ���� ���۽���ǰ� 

				if(k.getKeyCode() == k.VK_ENTER) {
					String name = searchField.getText();
					System.out.println(stm);
					if(stm.equals("lBook")) {
						try {
							dos.writeUTF("lBook");
							dos.writeUTF(name);
							dos.flush();

							ObjectInputStream ois = new ObjectInputStream(is);
							ArrayList<BookmanagementDTO> bList = 
									(ArrayList<BookmanagementDTO>)ois.readObject();
							for(int i=0 ; i <= bList.size() ; i++ ) {
								BookmanagementDTO dto = new BookmanagementDTO();
								dto.setBookName(bList.get(i).getBookName());
								dto.setBookSeq(bList.get(i).getBookSeq());
								model.addElement(dto);
							}
						}
						catch (Exception e) {
							e.printStackTrace();
						}}
					if(stm.equals("uBook")) {
						try {
							dos.writeUTF("uBook");
							dos.writeUTF(name);
							dos.flush();

							ObjectInputStream ois = new ObjectInputStream(is);
							ArrayList<BookmanagementDTO> bList = 
									(ArrayList<BookmanagementDTO>)ois.readObject();
							for(int i=0 ; i <= bList.size() ; i++ ) {
								BookmanagementDTO dto = new BookmanagementDTO();
								dto.setBookName(bList.get(i).getBookName());
								dto.setBookSeq(bList.get(i).getBookSeq());
								model.addElement(dto);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}}
					if(stm.equals("bBook")) {
						try {
							dos.writeUTF("bList");
							dos.writeUTF(name);
							dos.flush();

							ObjectInputStream ois = new ObjectInputStream(is);
							ArrayList<BookmanagementDTO> bList = 
									(ArrayList<BookmanagementDTO>)ois.readObject();
							for(int i=0 ; i <= bList.size() ; i++ ) {
								BookmanagementDTO dto = new BookmanagementDTO();
								dto.setBookName(bList.get(i).getBookName());
								dto.setBookSeq(bList.get(i).getBookSeq());
								model.addElement(dto);
							}
						}	 catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {

			}
			@Override
			public void keyReleased(KeyEvent e) {


			}});
		this.bBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}});
	}
	public void compInit() {
		this.setLayout(new FlowLayout());
		//		GridBagConstraints c = new GridBagConstraints();
		Dimension bDms = new Dimension(90,30);
		Border bevelR = new BevelBorder(BevelBorder.RAISED);
		Border bevelL = new BevelBorder(BevelBorder.LOWERED);
		//		c.insets = new Insets(10,0,0,10);
		bg.add(bLocal);
		bg.add(bSchool);
		bg.add(bBook);
		this.add(bLocal);
		this.bLocal.setBorderPainted(false);//��ư�� �׵θ� ���� �����,
		this.bLocal.setBorder(bevelR);//��ư�� �ö�� ���̵��� ȿ���� ��.
		this.bLocal.setPreferredSize(bDms);//�˻��ʵ�� ��ư�� ����� �־��ְ� 
		this.add(bSchool);
		this.bSchool.setBorderPainted(false);
		this.bSchool.setBorder(bevelR);
		this.bSchool.setPreferredSize(bDms);
		this.add(bBook);
		this.bBook.setBorderPainted(false);
		this.bBook.setBorder(bevelR);
		this.bBook.setPreferredSize(bDms);
		this.bPane.add(bLocal);
		this.bPane.add(bSchool);
		this.bPane.add(bBook);//��ư ������ �гο� ��´�.
		//		c.gridy=1; c.gridx=0;
		this.add(bPane);
		//		c.gridy=2; c.gridx=0;
		this.add(searchField);
		this.searchField.setBorder(bevelL);
		this.searchField.setPreferredSize(new Dimension(350,30));//��ư �Ʒ� �˻�â�� �ΰ�,

		this.localPane.setBackground(Color.GREEN);
		this.schoolPane.setBackground(Color.YELLOW);
		this.bookPane.setBackground(Color.PINK);
		this.localPane.setPreferredSize(new Dimension(340,490));
		this.schoolPane.setPreferredSize(new Dimension(340,490));
		this.bookPane.setPreferredSize(new Dimension(340,490));
		this.cardPane.setLayout(cardLayout);
		this.cardPane.add(localPane,"local");
		this.cardPane.add(schoolPane,"school");
		this.cardPane.add(bookPane,"book");
		//		this.layPane.add(cardPane);//�гξȿ� ī�� ���̾ƿ����� ����
		this.cardPane.setPreferredSize(new Dimension(350,500));
		this.cardPane.setBorder(bevelL);

		this.sc.setAutoscrolls(true);//���佺ũ��
		this.sc.setVerticalScrollBarPolicy(	ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.sc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//		c.gridy = 3; c.gridx = 0;
		//		this.add(sc);//�˻������ �ҷ��� �г�
		this.sc.setPreferredSize(new Dimension(350,500));
		this.sc.setBorder(bevelL);
		//		c.gridy=4; c.gridx=0;
		this.add(bBack);//�ڷΰ��� ��ư ����
		this.bBack.setBorderPainted(false);
		this.bBack.setBorder(bevelR);
		this.bBack.setPreferredSize(bDms);
		//		this.infoPane.setPreferredSize(new Dimension(300,100));
		//		this.infoPane.add(infoLabel);
		//		this.infoPane.add(infoFld);
		//		this.infoPane.add(image);
		//		this.add(infoPane);
		this.mainPane.add(bPane);
		this.mainPane.add(searchField);
		this.mainPane.add(sc);
		this.mainPane.add(bBack);
		this.mainPane.setPreferredSize(new Dimension(400,650));
		this.add(mainPane);
	}
	public void searchBook() {
		this.setTitle("������� �˻�");
		this.setSize(480,800);
		this.setResizable(false);//â ũ�� ����
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//		this.socketInit();
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

		}
		searchBook sb = new searchBook();
		sb.searchBook();
	}
}
