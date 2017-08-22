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
   private JLabel pw = new JLabel("��й�ȣ  :");
   private JLabel pwCheck = new JLabel("��й�ȣ Ȯ�� :");
   private JLabel incorrectpwMessage = new JLabel("��й�ȣ��ġ����");
   private JLabel name = new JLabel("�̸� :");
   private JLabel birth1 = new JLabel("���� :");
   private JLabel birth2 = new JLabel("/");
   private JLabel birth3 = new JLabel("/");
   private JLabel address = new JLabel("�ּ� :");
   private JLabel city = new JLabel("* �� �̸��� �Է��ϼ���");
   private JLabel school = new JLabel("�б� :");
   private JLabel schoolName = new JLabel("* �б� �̸��� �Է��ϼ���");
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
   private JButton addressSearchButton = new JButton("�ּҰ˻�");
   private JTextField addressField2 = new JTextField();
   private JTextField schoolField = new JTextField();
   private JTextField schoolAddressField1 = new JTextField();
   private JTextField schoolAddressField2 = new JTextField();
   private JButton schoolSearchButton = new JButton("�б��˻�");
   private JTextField phoneField = new JTextField();
   private JTextField emailField1 = new JTextField(20);
   private JTextField emailField2 = new JTextField(20);
   private JComboBox emailCombo = new JComboBox();
   private JButton idCheckButton = new JButton("�ߺ�ID�˻�");
   private JButton register = new JButton("����");
   private JButton previous = new JButton("����");
   private JDialog jDialog = new JDialog();

   MemberDAO dao = new MemberDAO();
   int dialogMode = NEW_MODE;

   private void compInit() {
      panel.setLayout(null);
      // ���̵�
      id.setBounds(40, 28, 150, 30);
      idField.setBounds(140, 28, 120, 30);
      idCheckButton.setBounds(270, 28, 120, 30);
      this.add(id);
      this.add(idField);
      this.add(idCheckButton);
      // ID�ߺ�üũ
      idCheckButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // �����ͺ��̽��� ���̵� �����ϴ� ���
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
                  JOptionPane.showMessageDialog(jDialog, "����� �� ���� ���̵��Դϴ�!");
               }
               // �����ͺ��̽��� ���� ���̵��� ���
               else {
                  JOptionPane.showMessageDialog(jDialog, "��� ������ ���̵��Դϴ�!");
               }
            } catch (Exception ae) {
               System.out.println(ae);
            }
}});
      // ��й�ȣ
      pw.setBounds(40, 84, 150, 30);
      pwField.setBounds(140, 84, 240, 30);
      pwField.setEchoChar('*');
      pwField.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
      pwField.setBackground(Color.YELLOW);
      pwField.setForeground(Color.BLUE);
      // pwField.setToolTipText("10�ڸ� �̳��� ��й�ȣ�� �����ϼž� �մϴ�");
      this.add(pw);
      this.add(pwField);

      // ��й�ȣȮ��
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
               incorrectpwMessage.setText("��й�ȣ�� ��ġ�մϴ�");
            } else {
               incorrectpwMessage.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
            }
         }

         @Override
         public void keyPressed(KeyEvent e) {
            // do something when a key has been pressed
         }
      });

      // �̸�
      name.setBounds(40, 196, 150, 30);
      nameField.setBounds(140, 196, 240, 30);
      this.add(name);
      this.add(nameField);

      // ����
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

      // �ּ�(�̿ϼ�)
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

      // �б�(�̿ϼ�)
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

      // ��ȭ
      phone.setBounds(40, 532, 150, 30);
      phoneField.setBounds(140, 532, 240, 30);
      this.add(phone);
      this.add(phoneField);

      // �̸���
      email.setBounds(40, 588, 150, 30);
      emailField1.setBounds(140, 588, 80, 30);
      emailAt.setBounds(220, 588, 150, 30);
      emailField2.setBounds(233, 588, 80, 30);
      emailCombo.setBounds(320, 588, 90, 30);
      this.emailCombo.addItem("����");
      this.emailCombo.addItem("naver.com");
      this.emailCombo.addItem("daum.net");
      this.emailCombo.addItem("gmail.com");
      this.emailCombo.addItem("�����Է�");
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

      // ���Թ�ư
      register.setBounds(84, 630, 80, 30);
      this.add(register);
      // ���������� �̺�Ʈ(�̿ϼ�)
      register.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();

            // ID�� �߸� �Է�������
            if (idField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "���̵� �Է����ּ���!");
               idField.requestFocus();
            } else if (idField.getText().trim().length() > 20) {
               JOptionPane.showMessageDialog(jDialog, "���̵�� 20�� �̳��� �Է��ؾ� �մϴ�!");
               idField.requestFocus();
            } else if (dialogMode == NEW_MODE && this.idCheck(idField.getText())) {
               JOptionPane.showMessageDialog(jDialog, "�̹� ���ǰ� �ִ� ���̵��Դϴ�!");
               idField.setText(null);
               idField.requestFocus();
               // ��й�ȣ�� �߸� �Է�������
            } else if (pwField.getPassword().length == 0) {
               JOptionPane.showMessageDialog(jDialog, "��й�ȣ�� �Է����ּ���!");
               pwField.requestFocus();
            } else if (pwField.getPassword().length > 30) {
               JOptionPane.showMessageDialog(jDialog, "��й�ȣ�� 30�� �̳��� �Է��ؾ� �մϴ�!");
               pwField.requestFocus();
            } else if (e.getActionCommand().equals("��й�ȣ�� Ȯ���ϼ���")) {
               String pwOrig = new String(pwField.getPassword()); // ��й�ȣ
                                                      // �ΰ�
                                                      // �Է¹���
               String pwConf = new String(pwCheckField.getPassword());
               if (!pwOrig.equals(pwConf)) { // ��й�ȣ �ΰ� ��ġ �Ǵ��� Ȯ��
                  JOptionPane.showMessageDialog(jDialog, "��й�ȣ�� ���� �ʽ��ϴ�");
               }
               // �̸� �Է¾�������
            } else if (nameField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "�̸��� �Է����ּ���!");
               nameField.requestFocus();
            } else if (nameField.getText().trim().length() > 20) {
               JOptionPane.showMessageDialog(jDialog, "�̸� 20�� �̳��� �Է��ؾ� �մϴ�!");
               nameField.requestFocus();
               // ���� �Է¾�������
            } else if (birthField1.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "���⿬���� �Է����ּ���!");
               birthField1.requestFocus();
            } else if (birthField1.getText().trim().length() > 5) {
               JOptionPane.showMessageDialog(jDialog, "���⿬���� 4�� �̳��� �Է��ؾ� �մϴ�!");
               birthField1.requestFocus();
            } else if (birthField2.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "���� ���� �Է����ּ���!");
               birthField2.requestFocus();
            } else if (birthField2.getText().trim().length() > 2) {
               JOptionPane.showMessageDialog(jDialog, "���� ���� 2�� �̳��� �Է��ؾ� �մϴ�!");
               birthField2.requestFocus();
            } else if (birthField3.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "���� ���� �Է����ּ���!");
               birthField3.requestFocus();
            } else if (birthField3.getText().trim().length() > 2) {
               JOptionPane.showMessageDialog(jDialog, "���� ���� 2�� �̳��� �Է����ּ���!");
               birthField3.requestFocus();
               // �ּ� �Է¾�������
            } else if (addressField1.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "�ּҸ� �Է����ּ���!");
               addressField1.requestFocus();
               // �б��̸� �Է¾�������
            } else if (schoolField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "�б��̸��� �Է����ּ���!");
               schoolField.requestFocus();
               // ��ȭ��ȣ �Է¾�������
            } else if (phoneField.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "��ȭ��ȣ�� �Է����ּ���!");
               phoneField.requestFocus();
               // �̸��� �Է¾�������
            } else if (emailField1.getText().trim().length() == 0) {
               JOptionPane.showMessageDialog(jDialog, "�̸��ϸ� �Է����ּ���!");
               emailField1.requestFocus();
            }
            // ������ ���� ���
            else {
               if (obj == register) {
                  dto.setUserid(idField.getText()); // �Էµ� ���̵� ������ dto�� ����                                          // ����
                  dto.setUserpw(pwField.getText()); // �Էµ� ��й�ȣ�� ������ dto�� ����                        // ����
                  dto.setUsername(nameField.getText()); // �Էµ� �̸��� ������ dto�� ��
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
                     int a = MemberDAO.userInput(dto); // dto�� DAO�� �ѱ�.
                     if (a > 0) {
                        JOptionPane.showMessageDialog(jDialog, "������ ���ϵ帳�ϴ�!");

                        dispose(); // �ݱ�
                     }

                  } catch (Exception e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }

               }
               // ���� ���̵��� ���
               else {
                  JOptionPane.showMessageDialog(jDialog, "�Է� �������� ������ �߻��߽��ϴ�!");
               }

            }
         }

         private boolean idCheck(String text) {
            // TODO Auto-generated method stub
            return false;
         }
      });

      // ������ư
      previous.setBounds(252, 630, 80, 30);
      this.add(previous);
      previous.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose(); // ȸ������â �ݱ�
         }
      });

   }

   public void RegisterDialog_01() {
      this.setTitle("ȸ������");
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