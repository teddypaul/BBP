package bbp;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Bbpmain extends JFrame {   
	Bbpmain self = this;

	JLabel topLable = new JLabel("Welcome BookBank");
	JButton loginBT = new JButton(new ImageIcon("logBT.png"));
	JButton logoutBT = new JButton(new ImageIcon("logoutBT.png"));
	JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)){
		ImageIcon  icon = new ImageIcon("top.png");

		public void paintComponent(Graphics g) {
			g.drawImage(icon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}};

		JPanel unPanel = new JPanel(){
			ImageIcon  icon = new ImageIcon("under.png");
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}};   

			CardLayout cardLayout = new CardLayout();
			JPanel contentsPanel = new JPanel(cardLayout);

			JButton homeBT = new JButton(new ImageIcon("homeImage.png"));
			JButton registerBT = new JButton(new ImageIcon("register.png"));
			JButton searchBT = new JButton(new ImageIcon("search.png"));

			JPanel listPanel = new JPanel(){
				ImageIcon  icon = new ImageIcon("main.png");
				public void paintComponent(Graphics g) {
					g.drawImage(icon.getImage(), 0, 0, null);
					setOpaque(false);
					super.paintComponent(g);
				}}; 
				JPanel registerPanel = new JPanel();
				JPanel searchPanel = new JPanel();
				JPanel myInfomation = new JPanel();
				private static Socket client ;
				private InputStream is ;
				private DataInputStream dis ;
				private OutputStream os ;
				private DataOutputStream dos ;

				//======================================== 

				public void compInit(){  
					this.setLayout(null);

					topPanel.add(loginBT);
					topPanel.add(logoutBT);
					topPanel.setBounds(0, 0, 480, 40);
					add(topPanel);
					//-----------------topPanel add

					loginBT.setContentAreaFilled(false);//버튼 배경 없앰
					loginBT.setBorderPainted(false);//버튼 테두리 없앰
					loginBT.setPreferredSize(new Dimension(60,30));
					logoutBT.setContentAreaFilled(false);//버튼 배경 없앰
					logoutBT.setBorderPainted(false);//버튼 테두리 없앰
					logoutBT.setPreferredSize(new Dimension(70,30));

					homeBT.setContentAreaFilled(false);//버튼 배경 없앰
					homeBT.setBorderPainted(false);//버튼 테두리 없앰
					homeBT.setCursor(Cursor.getDefaultCursor());
					homeBT.setRolloverIcon(new ImageIcon("home2.png"));
					homeBT.setPressedIcon(new ImageIcon("home3.png"));
					//      Cursor.getPredefinedCursor (Cursor.HAND_CURSOR); 

					registerBT.setContentAreaFilled(false);//버튼 배경 없앰
					registerBT.setBorderPainted(false);//버튼 테두리 없앰
					registerBT.setFocusPainted(false);
					registerBT.setOpaque(false);
					registerBT.setRolloverIcon(new ImageIcon("register2.png"));
					registerBT.setPressedIcon(new ImageIcon("register3.png"));

					searchBT.setContentAreaFilled(false);//버튼 배경 없앰
					searchBT.setBorderPainted(false);//버튼 테두리 없앰
					searchBT.setRolloverIcon(new ImageIcon("search2.png"));
					searchBT.setPressedIcon(new ImageIcon("search3.png"));
					//----------------buttonSet      

					unPanel.add(homeBT);
					unPanel.add(registerBT);
					unPanel.add(searchBT);
					unPanel.setBackground( new Color(255,255,0,0));
					unPanel.setBounds(0, 650, 480, 120);
					add(unPanel);

					contentsPanel.setBounds(0, 40, 480, 620);
					add(contentsPanel);
					//-------------------underPanel add      
					listPanel.setBounds(0, 10, 480, 800);
					add(listPanel);

					MyInfomation myIf = new MyInfomation();
					myIf.info();
					this.registerPanel.setBackground(Color.WHITE);
					this.registerPanel.add(myIf."?");
					////////////////////////////////////////////

					this.myInfomation.setBackground(Color.WHITE);
					this.myInfomation.add(myIf."?");
					////////////////////////////////////////////

					this.searchPanel.setBackground(Color.LIGHT_GRAY);
					searchPanel.setLayout(new FlowLayout());
					searchBook bbk = new searchBook();
					bbk.compInit();

					this.searchPanel.add(bbk.mainPane);
					this.contentsPanel.add(listPanel, "list");
					this.contentsPanel.add(registerPanel, "register");
					this.contentsPanel.add(searchPanel, "search");
					this.contentsPanel.add(myInfomation, "info");
				}

				public void eventInit(){      
					this.homeBT.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							cardLayout.show(contentsPanel, "list");
						}});

					this.registerBT.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							cardLayout.show(contentsPanel, "register");         
						}});

					this.searchBT.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							cardLayout.show(contentsPanel, "search");

						}});

					this.loginBT.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							cardLayout.show(contentsPanel, "info");
							RegisterDialog rd = new RegisterDialog();
							rd.RegisterDialog_01();
						}});
					this.logoutBT.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}});
				}

				public  void Bbpmain(Socket client){
					this.client = client;
					this.setTitle("BookBank");
					this.setSize(480,800);
					this.compInit();
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
					Bbpmain bm;
					try {
						bm = new Bbpmain(client);
						bm.Bbpmain();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
}