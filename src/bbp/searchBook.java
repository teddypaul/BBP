package bbp;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
//���� �˻� ���
public class searchBook extends JFrame{
	private JTextArea area = new JTextArea();
	private JTextField searchField = new JTextField();//�˻��Է�â
	private JButton searchButton = new JButton("searching");//�˻������ư
	DefaultTableModel model = new DefaultTableModel();                  
	private JTable table = new JTable(model); //�˻������ ������ ����Ʈ(���̺� ��ƺ��� �մϴ�)
	private JScrollPane sc = new JScrollPane(table);//����Ʈ�� ��ũ�� â����
	private JPanel pane = new JPanel();
	private void eventInit() {
		this.searchButton.addActionListener(new ActionListener() {//��ư�� ������ �۵��� ����
			@Override
			public void actionPerformed(ActionEvent e) {

		}});
		this.searchField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//�˻�â���� ����Ű ������ ��ư ������ ���� ���� ���۽���ǰ� 
			
			}
		});
		}
	private void compInit() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10,0,0,10);
		
		this.pane.add(searchField);
		this.pane.add(searchButton);
		this.searchField.setPreferredSize(new Dimension(250,30));
		this.searchButton.setPreferredSize(new Dimension(90,30));//�˻��ʵ�� ��ư�� ����� �־��ְ� 
		c.gridy = 0; c.gridx = 0;
		this.add(pane, c);// �гο� ����ش�.//
		c.gridy = 1; c.gridx = 0;
		this.table.setAutoscrolls(true);//���佺ũ��
		this.add(sc, c);
		this.sc.setPreferredSize(new Dimension(350,400));
		
   }
	public void searchBook() {
		this.setTitle("������� �˻�");
		this.setSize(480,800);
		this.setResizable(false);//â ũ�� ����
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.compInit();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}
		searchBook sb = new searchBook();
		sb.searchBook();

	}

}
