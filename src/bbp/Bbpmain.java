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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Bbpmain extends JFrame {   
   private Bbpmain self = this;

   private JLabel topLable = new JLabel("Welcome BookBank");
   private JButton loginBT = new JButton("login");
   private JButton logoutBT = new JButton("종료");
   private JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   
   private CardLayout cardLayout = new CardLayout();
   private JPanel contentsPanel = new JPanel(cardLayout);
   
   private JButton homeBT = new JButton("Home");
   private JButton registerBT = new JButton("책 등록");
   private JButton searchBT = new JButton("책 검색");
   private JPanel btPanel = new JPanel();
      
   private JPanel listPanel = new JPanel();
   private JPanel registerPanel = new JPanel();
   private JPanel searchPanel = new JPanel();
      
   private JButton backBT1 = new JButton("<");
   private JButton backBT2 = new JButton("<");
   //========================================   
   
   public void compinit(){      
      this.topPanel.add(topLable);
      this.topPanel.add(loginBT);
      this.topPanel.add(logoutBT);
      this.add(topPanel, BorderLayout.NORTH);
            
      Dimension btDim = new Dimension(90, 40);
      homeBT.setPreferredSize(btDim);
      registerBT.setPreferredSize(btDim);
      searchBT.setPreferredSize(btDim);
      this.btPanel.add(homeBT);
      this.btPanel.add(registerBT);
      this.btPanel.add(searchBT);
      
      this.listPanel.add(btPanel);
//      this.listPanel.setBackground(Color.BLACK);
      this.registerPanel.setBackground(Color.WHITE);
      this.registerPanel.add(backBT1);
      this.searchPanel.setBackground(Color.LIGHT_GRAY);
      this.searchPanel.add(backBT2);
      
      this.contentsPanel.add(listPanel, "list");
      this.contentsPanel.add(registerPanel, "register");
      this.contentsPanel.add(searchPanel, "search");
      
      this.add(contentsPanel);
   }
   
   public void eventInit(){      
      this.homeBT.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentsPanel, "list");
         }      
      });
      
      this.registerBT.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent arg0) {
            cardLayout.show(contentsPanel, "register");         
         }         
      });
      
      this.searchBT.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentsPanel, "search");

         }      
      });
      
      this.backBT1.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentsPanel, "list");
         }      
      });
      
      this.backBT2.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
            cardLayout.show(contentsPanel, "list");
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