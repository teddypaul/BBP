package bbp;

import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;


public class MyInfomation extends JFrame{
		private JButton upbook = new JButton("�����å");
		private JButton ingbook = new JButton("������");
		private JButton endbook = new JButton("�Ϸ�");
	
		public void info() {
			setLayout(new FlowLayout());
			add(upbook);
			add(ingbook);
			add(endbook);
			
		}
		
	public void infoVis() {
	
		setSize(480, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		info();
		setVisible(true);
			
		}
	
	public static void main(String[] args) {
		MyInfomation my = new MyInfomation();
		my.infoVis();
	}
}
