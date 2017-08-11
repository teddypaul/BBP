package bbp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Bbpmain extends JFrame {	
	private CardLayout cardLayout = new CardLayout();
	
	private JPanel backPanel = new JPanel(null);

	private JLabel topLable = new JLabel("WelcomeBookBank");
	private JButton loginBT = new JButton("login");
	private JButton logoutBT = new JButton("종료");
	private JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	private JButton registerBT = new JButton("책 등록");
	private JButton searchBT = new JButton("책 검색");
	private JButton localBT = new JButton("지  역");
	private JButton shcoolBT = new JButton("학  교");
	private JPanel btPanel = new JPanel();
		
	private JPanel listPanel = new JPanel();
	private JPanel registerPanel = new JPanel();
	private JPanel searchPanel = new JPanel();
	private JPanel localPanel = new JPanel();
	private JPanel shcoolPanel = new JPanel();
	private JPanel cardPanel = new JPanel();
	
	//========================================	
//	private JLabel exLabel0 = new JLabel("책목록입니다");
//	private JLabel exLabel1 = new JLabel("책등록입니다");
//	private JLabel exLabel2 = new JLabel("책 검색입니다");
//	private JLabel exLabel3 = new JLabel("지역검색");
//	private JLabel exLabel4 = new JLabel("학교검색");
	
	public void compinit(){
		this.setLayout(null);	
		
		this.topLable.setBounds(210, 10, 120, 30);
		this.loginBT.setBounds(330, 10, 60, 30);
		this.logoutBT.setBounds(390, 10, 60, 30);
		this.topPanel.add(topLable);
		this.topPanel.add(loginBT);		
		this.topPanel.add(logoutBT);
		
		this.topPanel.setBounds(0, 0, 450, 35);

		
		//========================패널 위 버튼 사이즈 설정
		Dimension btDim = new Dimension(90, 40);
		registerBT.setPreferredSize(btDim);
		searchBT.setPreferredSize(btDim);
		localBT.setPreferredSize(btDim);
		shcoolBT.setPreferredSize(btDim);
		
//		this.registerPanel.add(null);
//		this.listPanel.add(exLabel1);
//		this.searchPanel.add(exLabel2);
//		this.localPanel.add(exLabel3);
//		this.shcoolPanel.add(exLabel4);	
		
		this.registerPanel.setBounds(0, 0, 480, 800);
		this.registerPanel.setBackground(Color.ORANGE);	
		this.listPanel.setBounds(30, 190, 420, 590);
		this.listPanel.setBackground(Color.WHITE);	
		this.searchPanel.setBounds(30, 190, 420, 590);
		this.searchPanel.setBackground(Color.LIGHT_GRAY);	
		this.localPanel.setBounds(30, 190, 420, 590);
		this.localPanel.setBackground(Color.WHITE);	
		this.shcoolPanel.setBounds(30, 190, 420, 590);
		this.shcoolPanel.setBackground(Color.LIGHT_GRAY);	
		
		//버튼 패널		
		this.btPanel.add(registerBT);
		this.btPanel.add(searchBT);
		this.btPanel.add(localBT);
		this.btPanel.add(shcoolBT);		
		this.btPanel.setBounds(30, 140, 420, 45);
		
		this.cardPanel.setLayout(cardLayout);
		this.cardPanel.add(registerPanel, "0");
		this.cardPanel.add(listPanel,"1");
		this.cardPanel.add(searchPanel,"2");
		this.cardPanel.add(localPanel,"3");
		this.cardPanel.add(shcoolPanel,"4");
		this.cardPanel.setBounds(0, 0, 480, 800);
		
		this.backPanel.add(topPanel);
		this.backPanel.add(btPanel);
		this.backPanel.add(cardPanel);
		this.backPanel.setBounds(0, 0, 480, 800);
		this.add(backPanel);
	}
	
	public void eventInit(){
		this.registerBT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(cardPanel,"1");			
			}			
		});
		
		this.searchBT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "2");
			}		
		});
		
		this.localBT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "3");
			}		
		});
		
		this.shcoolBT.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "4");
			}		
		});
		
	}
	
	public void Bbpmain(){
		this.setTitle("BookBank");
		this.setSize(480,800);
		this.compinit();
		this.eventInit();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		} catch (Exception e) {}
		
		Bbpmain bm = new Bbpmain();
		bm.Bbpmain();
	}

}
