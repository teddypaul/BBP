package bbp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import bbp.DAO.MemberDAO;
import bbp.DTO.MemberDTO;

public class RegisterDialog extends JDialog {

   public final int NEW_MODE = 1;
   MemberDTO dto = new MemberDTO();
   private RegisterDialog self = this;
   protected static JFrame registerGUI = new JFrame();
   private JPanel panel = new JPanel();
   private JLabel id = new JLabel("ID :");
   private JLabel pw = new JLabel("비밀번호  :");
   private JLabel pwCheck = new JLabel("비밀번호 확인 :");
   private JLabel incorrectpwMessage = new JLabel("비밀번호일치여부");
   private JLabel name = new JLabel("이름 :");
   private JLabel birth1 = new JLabel("생일 :");
   private JLabel birth2 = new JLabel("/");
   private JLabel birth3 = new JLabel("/");
   private JLabel address = new JLabel("주소 :");
   private JLabel city = new JLabel("* 시 이름만 입력하세요");
   private JLabel school = new JLabel("학교 :");
   private JLabel schoolName = new JLabel("* 학교 이름만 입력하세요");
   private JLabel phone = new JLabel("Phone No. :");
   private JLabel email = new JLabel("Email :");
   private JLabel emailAt = new JLabel("@");
   private JTextField idField = new JTextField();
   private JPasswordField pwField = new JPasswordField();
   private JPasswordField pwCheckField = new JPasswordField();
   private JTextField nameField = new JTextField();
   private JTextField birthField1 = new JTextField();
   private JTextField birthField2 = new JTextField();
   private JTextField birthField3 = new JTextField();
   private JTextField addressField1 = new JTextField();
   private JButton addressSearchButton = new JButton("주소검색");
   private JTextField addressField2 = new JTextField();
   private JTextField schoolField = new JTextField();
   private JTextField schoolAddressField1 = new JTextField();
   private JTextField schoolAddressField2 = new JTextField();
   private JButton schoolSearchButton = new JButton("학교검색");
   private JTextField phoneField = new JTextField();
   private JTextField emailField1 = new JTextField(20);
   private JTextField emailField2 = new JTextField(20);
   private JComboBox emailCombo = new JComboBox();
   private JButton idCheckButton = new JButton("중복ID검사");
   private JButton register = new JButton("가입");
   private JButton previous = new JButton("이전");
   private JDialog jDialog = new JDialog();

   MemberDAO dao = new MemberDAO();
   int dialogMode = NEW_MODE;

   private void compInit() {
      panel.setLayout(null);
      // 아이디
      id.setBounds(40, 28, 150, 30);
      idField.setBounds(140, 28, 120, 30);
      idCheckButton.setBounds(270, 28, 120, 30);
      this.add(id);
      this.add(idField);
      this.add(idCheckButton);
      // ID중복체크
      idCheckButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // 데이터베이스에 아이디가 존재하는 경우
            Connection con = null;
            String value1 = idField.getText();
            try {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               String local = "jdbc:oracle:thin:@localhost:1521:xe";
               String dbid = "java7";
               String ps = "java7";
               con = DriverManager.getConnection(local, dbid, ps);
               Statement stat = con.createStatement();
               ResultSet rs = stat.executeQuery("select id from bookbank where id like '" + '%' + value1 + '%' + "'");
               if (rs.next()) {
                  JOptionPane.showMessageDialog(jDialog, "사용할 수 없는 아이디입니다!");
               }
               // 데이터베이스에 없는 아이디인 경우
               else {
                  JOptionPane.showMessageDialog(jDialog, "사용 가능한 아이디입니다!");
               }
            } catch (Exception ae) {
               System.out.println(ae);
            }
}});
      // 비밀번호
      pw.setBounds(40, 84, 150, 30);
      pwField.setBounds(140, 84, 240, 30);
      pwField.setEchoChar('*');
      pwField.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
      pwField.setBackground(Color.YELLOW);
      pwField.setForeground(Color.BLUE);
      // pwField.setToolTipText("10자리 이내의 비밀번호를 생성하셔야 합니다");
      this.add(pw);
      this.add(pwField);

      // 비밀번호확인
      pwCheck.setBounds(40, 140, 150, 30);
      pwCheckField.setBounds(140, 140, 240, 30);
      pwCheckField.setEchoChar('*');
      pwCheckField.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
      pwCheckField.setBackground(Color.YELLOW);
      pwCheckField.setForeground(Color.BLUE);
      incorrectpwMessage.setBounds(140, 170, 240, 30);
      this.add(pwCheck);
      this.add(pwCheckField);
      this.add(incorrectpwMessage);

      pwCheckField.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent e) {
         }

         @Override
         public void keyReleased(KeyEvent e) {
            String pw = new String(pwField.getPassword());
            String pwch = new String(pwCheckField.getPassword());
            if (pw.equals(pwch)) {
               incorrectpwMessage.setText("비밀번호가 일치합니다");
            } else {
               incorrectpwMessage.setText("비밀번호가 일치하지 않습니다");
            }
         }

         @Override
         public void keyPressed(KeyEvent e) {
            // do something when a key has been pressed
         }
      });

      // 이름
      name.setBounds(40, 196, 150, 30);
      nameField.setBounds(140, 196, 240, 30);
      this.add(name);
      this.add(nameField);

      // 생일
      birth1.setBounds(40, 252, 150, 30);
      birth2.setBounds(183, 252, 150, 30);
      birth3.setBounds(233, 252, 150, 30);
      birthField1.setBounds(140, 252, 40, 30);
      birthField2.setBounds(190, 252, 40, 30);
      birthField3.setBounds(240, 252, 40, 30);
      this.add(birth1);
      this.add(birth2);
      this.add(birth3);
      this.add(birthField1);
      this.add(birthField2);
      this.add(birthField3);

      // 주소(미완성)
      address.setBounds(40, 308, 150, 30);
      addressField1.setBounds(140, 308, 120, 30);
      addressSearchButton.setBounds(270, 308, 80, 30);
      city.setBounds(140, 336, 170, 30);
      addressField2.setBounds(140, 364, 240, 30);
      this.add(address);
      this.add(addressField1);
      this.add(addressSearchButton);
      this.add(city);
      this.add(addressField2);

      // 학교(미완성)
      school.setBounds(40, 420, 150, 30);
      schoolField.setBounds(140, 420, 120, 30);
      schoolSearchButton.setBounds(270, 420, 80, 30);
      schoolName.setBounds(140, 448, 170, 30);
      schoolAddressField1.setBounds(140, 476, 60, 30);
      schoolAddressField2.setBounds(210, 476, 190, 30);
      this.add(school);
      this.add(schoolField);
      this.add(schoolSearchButton);
      this.add(schoolName);
      this.add(schoolAddressField1);
      this.add(schoolAddressField2);

      // 전화
      phone.setBounds(40, 532, 150, 30);
      phoneField.setBounds(140, 532, 240, 30);
      this.add(phone);
      this.add(phoneField);

      // 이메일
      email.setBounds(40, 588, 150, 30);
      emailField1.setBounds(140, 588, 80, 30);
      emailAt.setBounds(220, 588, 150, 30);
      emailField2.setBounds(233, 588, 80, 30);
      emailCombo.setBounds(320, 588, 90, 30);
      this.emailCombo.addItem("선택");
      this.emailCombo.addItem("naver.com");
      this.emailCombo.addItem("daum.net");
      this.emailCombo.addItem("gmail.com");
      this.emailCombo.addItem("직접입력");
      emailCombo.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            Object a = e.getItem();
            emailField2.setText(String.valueOf(a));
         }
      });
      this.emailCombo.setSelectedIndex(0);
      this.add(email);
      this.add(emailField1);
      this.add(emailAt);
      this.add(emailField2);
      this.add(emailCombo);

      // 가입버튼
      register.setBounds(84, 630, 80, 30);
      this.add(register);
      // 가입했을때 이벤트(미완성)
      register.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();

            // ID를 잘못 입력했을때
            if (idField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "아이디를 입력해주세요!");
               idField.requestFocus();
            } else if (idField.getText().trim().length() > 20) {
               JOptionPane.showMessageDialog(jDialog, "아이디는 20자 이내로 입력해야 합니다!");
               idField.requestFocus();
            } else if (dialogMode == NEW_MODE && this.idCheck(idField.getText())) {
               JOptionPane.showMessageDialog(jDialog, "이미 사용되고 있는 아이디입니다!");
               idField.setText(null);
               idField.requestFocus();
               // 비밀번호를 잘못 입력했을때
            } else if (pwField.getPassword().length == 0) {
               JOptionPane.showMessageDialog(jDialog, "비밀번호를 입력해주세요!");
               pwField.requestFocus();
            } else if (pwField.getPassword().length > 30) {
               JOptionPane.showMessageDialog(jDialog, "비밀번호는 30자 이내로 입력해야 합니다!");
               pwField.requestFocus();
            } else if (e.getActionCommand().equals("비밀번호를 확인하세요")) {
               String pwOrig = new String(pwField.getPassword()); // 비밀번호
                                                      // 두개
                                                      // 입력받음
               String pwConf = new String(pwCheckField.getPassword());
               if (!pwOrig.equals(pwConf)) { // 비밀번호 두개 매치 되는지 확인
                  JOptionPane.showMessageDialog(jDialog, "비밀번호가 맞지 않습니다");
               }
               // 이름 입력안했을때
            } else if (nameField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "이름을 입력해주세요!");
               nameField.requestFocus();
            } else if (nameField.getText().trim().length() > 20) {
               JOptionPane.showMessageDialog(jDialog, "이름 20자 이내로 입력해야 합니다!");
               nameField.requestFocus();
               // 생일 입력안했을때
            } else if (birthField1.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "생년연도를 입력해주세요!");
               birthField1.requestFocus();
            } else if (birthField1.getText().trim().length() > 5) {
               JOptionPane.showMessageDialog(jDialog, "생년연도는 4자 이내로 입력해야 합니다!");
               birthField1.requestFocus();
            } else if (birthField2.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "생년 월을 입력해주세요!");
               birthField2.requestFocus();
            } else if (birthField2.getText().trim().length() > 2) {
               JOptionPane.showMessageDialog(jDialog, "생년 월은 2자 이내로 입력해야 합니다!");
               birthField2.requestFocus();
            } else if (birthField3.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "생년 일을 입력해주세요!");
               birthField3.requestFocus();
            } else if (birthField3.getText().trim().length() > 2) {
               JOptionPane.showMessageDialog(jDialog, "생년 일은 2자 이내로 입력해주세요!");
               birthField3.requestFocus();
               // 주소 입력안했을때
            } else if (addressField1.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "주소를 입력해주세요!");
               addressField1.requestFocus();
               // 학교이름 입력안했을때
            } else if (schoolField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "학교이름을 입력해주세요!");
               schoolField.requestFocus();
               // 전화번호 입력안했을때
            } else if (phoneField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "전화번호를 입력해주세요!");
               phoneField.requestFocus();
               // 이메일 입력안했을때
            } else if (emailField1.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "이메일를 입력해주세요!");
               emailField1.requestFocus();
            }
            // 오류가 없는 경우
            else {
               if (obj == register) {
                  dto.setUserid(idField.getText()); // 입력된 아이디를 가져와 dto에 저장                                          // 저장
                  dto.setUserpw(pwField.getText()); // 입력된 비밀번호를 가져와 dto에 저장                        // 저장
                  dto.setUsername(nameField.getText()); // 입력된 이름을 가져와 dto에 저
                  String birth = birthField1.getText() + birthField2.getText() + birthField3.getText();
                  dto.setUserbirth(birth);
                  String address = addressField1.getText() + addressField2.getText();
                  dto.setUseraddress(address);
                  String university = schoolField.getText() + schoolAddressField1.getText()
                        + schoolAddressField2.getText();
                  dto.setUseruniversity(university);
                  dto.setUserphonenumber(phoneField.getColumns());
                  String email = emailField1.getText() + emailField2.getText();
                  dto.setUseremail(email);

                  try {
                     int a = MemberDAO.userInput(dto); // dto를 DAO에 넘김.
                     if (a > 0) {
                        JOptionPane.showMessageDialog(jDialog, "가입을 축하드립니다!");

                        dispose(); // 닫기
                     }

                  } catch (Exception e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }

               }
               // 없는 아이디인 경우
               else {
                  JOptionPane.showMessageDialog(jDialog, "입력 과정에서 오류가 발생했습니다!");
               }

            }
         }

         private boolean idCheck(String text) {
            // TODO Auto-generated method stub
            return false;
         }
      });

      // 이전버튼
      previous.setBounds(252, 630, 80, 30);
      this.add(previous);
      previous.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose(); // 회원가입창 닫기
         }
      });

   }

   public void RegisterDialog_01() {
      this.setTitle("회원가입");
      this.setSize(420, 700);
      this.setLayout(null);
      this.setResizable(false);
      this.setLocationRelativeTo(null);
      this.compInit();
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

		}
      RegisterDialog e = new RegisterDialog();
      e.RegisterDialog_01();
   }
}