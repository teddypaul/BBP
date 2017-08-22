package bbp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
//나의 정보

import bbp.DTO.BookmanagementDTO;
import nguyenvanquan7826.JList.BookRenderer;
import nguyenvanquan7826.JList.JListCustomRenderer;

public class MyInfomation extends JFrame{
	JButton upbook = new JButton("등록한책");
	JButton ingbook = new JButton("진행중");
	JButton endbook = new JButton("완료");

	JPanel myInfo = new JPanel();
	CardLayout cardLayout = new CardLayout();
	JPanel contentsPanel = new JPanel(cardLayout);
	JPanel registerPanel = new JPanel();
	JPanel ingPanel = new JPanel();
	JPanel endPanel = new JPanel();
//	Bbpmain bbpM = new Bbpmain();
	public void info() {

		setLayout(new FlowLayout());
		myInfo.add(upbook);      
		myInfo.add(ingbook);
		myInfo.add(endbook);
        myInfo.setPreferredSize(new Dimension(480, 750));
		registerPanel.setPreferredSize(new Dimension(400, 500));

		this.registerPanel.setBackground(Color.BLACK);
		this.ingPanel.setBackground(Color.WHITE);
		this.endPanel.setBackground(Color.LIGHT_GRAY);
		///////////////////////////////////////////////////////////////////////////////

		JListCustomRenderer listRender = new JListCustomRenderer();
		listRender.CustomRenderer();   

		registerPanel.add(listRender.panel);      
		ingPanel.add(listRender.panel);
		endPanel.add(listRender.panel);

		this.contentsPanel.add(registerPanel, "register");
		this.contentsPanel.add(ingPanel, "ing");
		this.contentsPanel.add(endPanel, "end");

		myInfo.add(contentsPanel);
		add(myInfo);
	}
	public void eventInit(){      
		upbook.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentsPanel, "register");
			}});
		ingbook.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cardLayout.show(contentsPanel, "ing");         
			}});
		endbook.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentsPanel, "end");
			}});
	}
	
	public void infoVis() {
		setSize(480, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		info();
		eventInit();
		setVisible(true);

	}
	public static void main(String[] args) {
		MyInfomation my = new MyInfomation();
		my.infoVis();
	}
}