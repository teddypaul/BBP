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
//���� �˻� ���
public class searchBook extends JFrame{
	private AddressDAO address = new AddressDAO(); 
	private JTextArea area = new JTextArea();
	private JTextField searchField = new JTextField();//�˻��Է�â
	private JButton searchButton = new JButton("Searching");//�˻������ư
	DefaultTableModel model = new DefaultTableModel();                  
	private JTable table = new JTable(model); //�˻������ ������ ����Ʈ(���̺� ��ƺ��� �մϴ�)
	private JScrollPane sc = new JScrollPane(table);//����Ʈ�� ��ũ�� â����
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
		this.searchButton.addActionListener(new ActionListener() {//��ư�� ������ �۵��� ����
			public void actionPerformed(ActionEvent a) {
				String address = searchField.getText();
				//				dos.writeUTF(address);
				//				dos.flush();

				ArrayList bList;
				try {
					bList = new AddressDAO().showBookList(address);
					for(int i=0 ; i<=bList.size();i++) {
						model.insertRow(i, (Vector) bList.get(i));
					}//�迭������ ���ڿ� �� -- list(   final List list1 =  new ArrayList();  Collections.addAll(list1, America);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}});
		this.searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//�˻�â���� ����Ű ������ ��ư ������ ���� ���� ���۽���ǰ� 
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
		this.searchButton.setPreferredSize(new Dimension(90,30));//�˻��ʵ�� ��ư�� ����� �־��ְ� 
		c.gridy = 0; c.gridx = 0;
		this.add(pane, c);// �гο� ����ش�.//
		c.gridy = 1; c.gridx = 0;
		this.table.setAutoscrolls(true);//���佺ũ��
		this.add(sc, c);
		this.sc.setPreferredSize(new Dimension(350,400));
		//		this.sc.setBackground();
		this.sc.setBorder(new BevelBorder(BevelBorder.LOWERED));
	}
	public void searchBook() {
		this.setTitle("������� �˻�");
		this.setSize(480,800);
		this.setResizable(false);//â ũ�� ����
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
