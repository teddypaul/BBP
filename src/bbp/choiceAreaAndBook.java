package bbp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class choiceAreaAndBook extends JFrame{
	private JButton bOne = new JButton("��õ��");//���� ������ 8�� �������� ���� ��� ��ư �Ѱ��� �ѱ����� �̹����� ��������� ��ư 8�� ����
	private JButton bTwo = new JButton("������");//�ȿ� "�� �̸�"�� �ӽ÷� �־���
	private JButton bThree = new JButton("������");
	private JButton bFour = new JButton("������");
	private JButton bFive = new JButton("���ʱ�");
	private JButton bSix = new JButton("���ϱ�");
	private JButton bSeven = new JButton("���α�");
	private JButton bEight = new JButton("�߶���");
	private JPanel pane = new JPanel();

	private void eventInit() {
		this.bOne.addActionListener(new ActionListener() {//�� ��ư�� ���� ��� ���� ��ϵ�
			@Override
			public void actionPerformed(ActionEvent e) {
			}});

		this.bTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
		this.bThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
		this.bFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
		this.bFive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
		this.bSix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
		this.bSeven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
		this.bEight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}});
	}
	private void compInit() {
	//��ư�� ��ġ�� �̹����� ���Ͽ� boundlayout���� ��ƾ��ҵ�?
		this.add(bOne);
		this.add(bTwo);
		this.add(bThree);
		this.add(bFour);
		this.add(bFive);
		this.add(bSix);
		this.add(bSeven);
		this.add(bEight);
//		this.add


	}
	public void choice() {
		this.setLayout(new FlowLayout());
		this.setTitle("mapAndChoice");
		this.setSize(480,800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.eventInit();
		this.compInit();
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
		choiceAreaAndBook caab = new choiceAreaAndBook();
		caab.choice();

	}
}
