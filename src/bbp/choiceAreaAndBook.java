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
	private JButton bOne = new JButton("양천구");//서울 지도를 8개 구역으로 나눌 경우 버튼 한개에 한구역의 이미지를 씌우기위해 버튼 8개 생성
	private JButton bTwo = new JButton("강서구");//안에 "구 이름"은 임시로 넣었음
	private JButton bThree = new JButton("강남구");
	private JButton bFour = new JButton("도봉구");
	private JButton bFive = new JButton("서초구");
	private JButton bSix = new JButton("성북구");
	private JButton bSeven = new JButton("종로구");
	private JButton bEight = new JButton("중랑구");
	private JPanel pane = new JPanel();

	private void eventInit() {
		this.bOne.addActionListener(new ActionListener() {//각 버튼을 누를 경우 나올 목록들
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
	//버튼의 위치는 이미지와 비교하여 boundlayout으로 잡아야할듯?
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
