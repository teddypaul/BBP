package bbp;



import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

public class BulletinBoard extends JDialog{
	//Ŭ�������� �޼���� (�޼��� �θ��� ����ǰ�)

	private JLabel title = new JLabel("���� :");
	private JButton buttonPurchase = new JButton("����");
	private JButton buttonBasket = new JButton("���ϱ�");
	private JTable table = new JTable();
	private JScrollPane scroll = new JScrollPane(table);	
	private DefaultTableModel model = new DefaultTableModel();

	private JPanel panelDescription = new JPanel();
	private JButton buttonTest2 = new JButton("�׽�Ʈ��2");



	public void compInit(){
		this.setLayout(null);

		this.title.setBounds(10,0,30,30);
		this.add(title);

		this.buttonPurchase.setBounds(220,400,80,30);
		this.buttonBasket.setBounds(300,400,80,30);
		this.add(buttonPurchase);
		this.add(buttonBasket);



		//			this.panelDescription.add(buttonTest2);
		//			this.panelDescription.setBounds(100,200,100,100);



	}

	public void eventInit(){

	}

	public BulletinBoard(){
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.compInit();

		this.setVisible(true);
		this.setTitle("�Ǹ� å ����");



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
		new BulletinBoard();
	}

}
