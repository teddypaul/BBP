package bbp;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
//소비자로부터 책구매
public class BulletinBoard_Customer extends JDialog{

	private JLabel title = new JLabel("제목 :");
	private JButton buttonPurchase = new JButton("구매");
	private JButton buttonBasket = new JButton("찜하기");
	private JTable table = new JTable();
	private JScrollPane scroll = new JScrollPane(table);	
	private DefaultTableModel model = new DefaultTableModel();

	private JPanel panelDescription = new JPanel();
	private JButton buttonTest2 = new JButton("테스트용2");

	private JLabel pic;
	private String imgPath = "C:/Users/Kim/Downloads/eclipse-jee-neon-3-win32-x86_64/사진 모음/books.png";
	private ImageIcon originalIcon = new ImageIcon(imgPath);
	private Image originalImg = originalIcon.getImage();
	private Image changedImg = originalImg.getScaledInstance(350, 100, Image.SCALE_SMOOTH);
	private ImageIcon Icon = new ImageIcon(changedImg);
	
	public void compInit(){
		this.setLayout(null);

		this.title.setBounds(10,0,30,30);
		this.add(title);

		this.buttonPurchase.setBounds(235,620,80,30);
		this.buttonBasket.setBounds(315,620,80,30);
		this.add(buttonPurchase);
		this.add(buttonBasket);

		pic = new JLabel(Icon);
		pic.setBounds(30, 60, 330, 100);
		this.add(pic);


		//			this.panelDescription.add(buttonTest2);
		//			this.panelDescription.setBounds(100,200,100,100);



	}

	public void eventInit(){

	}

	public BulletinBoard_Customer(){
		this.setSize(420, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.compInit();

		this.setVisible(true);
		this.setTitle("판매 책 정보");



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
		new BulletinBoard_Customer();
	}

}

