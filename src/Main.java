
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import bbp.RegisterDialog;

public class Main extends JFrame{
   
   private Main self = this;
   private JLabel fila;
   protected static JFrame loginGUI = new JFrame();
   private JPanel panel = new JPanel();
   private JLabel id = new JLabel("ID : ");
   private JLabel pw = new JLabel("Password : ");
   private JTextField idField = new JTextField(10);
   private JPasswordField pwField = new JPasswordField(10);
   private JButton loginButton = new JButton("로그인");
   private JButton registerButton = new JButton("회원가입");
   private JButton findButton = new JButton("ID/PW 찾기");
   
   private void compInit(){
         
      id.setBounds(40, 324, 150, 30);
      idField.setBounds(140, 324, 240, 30);
      pw.setBounds(40, 396, 150, 30);
      pwField.setBounds(140,396,240,30);
      loginButton.setBounds(40, 468, 80, 30);
      registerButton.setBounds(160, 468, 80, 30);
      findButton.setBounds(280, 468, 100, 30);
      this.add(id);
      this.add(idField);
      this.add(pw);
      this.add(pwField);
      this.add(loginButton);
      this.add(registerButton);
      this.add(findButton);
      
      this.registerButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new RegisterDialog().RegisterDialog_01();
         }
      });
      
      
   }
   
   public void Main_01(){
//      im = new ImageIcon("My-Very-Own-Book-Logo-Stack.png");
//      this.setIconImage(im.getImage());
//      Toolkit tk = Toolkit.getDefaultToolkit();
//      Dimension di = tk.getScreenSize();
//      Dimension di1 = this.getSize();
      
      this.setSize(420,700);
      this.setLayout(null);
      this.setResizable(false);
      this.setLocationRelativeTo(null);
      this.compInit();
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true);
   }
   
   
   
   public static void main(String[] args) throws Exception {
      try {
          for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (Exception e) {
          
      }
      Main e = new Main();
      e.Main_01();
   }

   
}

