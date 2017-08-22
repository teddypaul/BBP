package bbp;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import bbp.DTO.BookmanagementDTO;

public class JListCustomRenderer extends JFrame {
   private JList<BookmanagementDTO> listBook;
   public JPanel panel = new JPanel(new BorderLayout());
//   JPanel allPanel = new JPanel();
   
   public void CustomRenderer() {
      // add main panel
      add(createMainPanel());   
      
      // set display
//      setTitle("JLIstCustomRenderer");
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setResizable(false);//창 크기 고정
//      setLocationRelativeTo(null);
//      setSize(480,800);
//      setVisible(true);
   }

   private JPanel createMainPanel() {
//      JPanel listPanel = new JPanel(new BorderLayout());
      panel.setBorder(new EmptyBorder(10, 10, 10, 10));
      
      // create list book and set to scrollpane and add to panel
      JScrollPane js;
      js = new JScrollPane(listBook = createListBooks());
      js.setPreferredSize(new Dimension(450,550));
      panel.add(js,BorderLayout.CENTER);
      return panel;      
   }

   private JList<BookmanagementDTO> createListBooks() {
      // create List model
      DefaultListModel<BookmanagementDTO> model = new DefaultListModel<>();
      
      ArrayList<BookmanagementDTO> arr = new ArrayList<BookmanagementDTO>();
      
      for (int i = 0; i < 10; i++) {
         BookmanagementDTO dto = new BookmanagementDTO();
         dto.setBookName("집"+i);
         dto.setBookSeq(""+i);
         arr.add(dto);
      }   
      
      // add item to model
      for (int i = 0; i < arr.size(); i++) {
         
         arr.get(i);
         BookmanagementDTO dto = new BookmanagementDTO();
         dto.setBookName(arr.get(i).getBookName());
         dto.setBookSeq(arr.get(i).getBookSeq());
         model.addElement(dto);
      }   
      
      // create JList with model
      JList<BookmanagementDTO> list = new JList<BookmanagementDTO>(model);
      // set cell renderer
      list.setCellRenderer(new BookRenderer());
      return list;
   }


   public static void main(String[] args) {
      JListCustomRenderer cr = new JListCustomRenderer();
      cr.CustomRenderer();

   }
}