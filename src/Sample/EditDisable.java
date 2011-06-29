package Sample;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class EditDisable{
  JTable table;
  public static void main(String[] args) {
    new EditDisable();
  }

  public EditDisable(){
    JFrame frame = new JFrame("Disabling User Edit in a JTable!");
    JPanel panel = new JPanel();
    String data[][] = {{"Vinod","Computer","3"},
                       {"Rahul","History","2"},
                       {"Manoj","Biology","4"},
                       {"Sanjay","PSD","5"}};
    String col [] = {"Name","Course","Year"};
    DefaultTableModel model = new DefaultTableModel(data,col);
    
    table = new JTable(model)
    {
      public boolean isCellEditable(int r, int c)
      {
        return false;   //Disallow the editing of any cell
      }
       
    };
    
    JTableHeader header = table.getTableHeader();
   // header.setBackground(Color.yellow);
    JScrollPane pane = new JScrollPane(table);
    panel.add(pane);
    frame.add(panel);
    frame.setSize(500,150);
    frame.setUndecorated(true);
    frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
