package Experiments;

import Sample.HorsPool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import database.*;
import java.util.*;


public class MF_Modify_Panel extends JPanel{
    
     String shares_name,date[],ano,brokers;
                    Date dat1;
                    String qty;
                    String amt;
                    String fno;
  public final  mdpanel md;
  MF_Modify_Panel ref=this;
  static JTextField quant=new JTextField(5);
  static JTextField folio_no=new JTextField(5);
    static JTextField avg_price=new JTextField(5);
     static JTextField dates=new JTextField(5);
      static JTextField agent=new JTextField(5);
         static JComboBox jcb1=new JComboBox(); final JButton jbcancel=new JButton("Cancel");
         
    public MF_Modify_Panel(mdpanel md){
        this.md=md;
        md.proceed.setEnabled(false);
        
       //this.setTitle("Stocks_Modify");
       this.setSize(600,400);
       this.setLocation(200,200);
       this.setLayout(new BorderLayout());
       
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(6,6,15,15));    //Sub layout 1
                   jp4.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
                   jp4.add(new JLabel("No of Units:"));                   
                   jp4.add(quant);       
                   
                   jp4.add(new JLabel("Avg. Price:"));                 
                   jp4.add(avg_price);                   
                   
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));                  
                   jp4.add(dates);
                   
                    jp4.add(new JLabel("Agent Code:"));                  
                   jp4.add(agent);                   
                   
                   jp4.add(new JLabel("Folio No:"));                  
                   jp4.add(folio_no);                   
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   final JButton jbsave=new JButton("Confrim");
                   jp6.add(jbsave);
                   
                    //Confirm action listener.................................
                   jbsave.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                      qty=quant.getText();
                                      try{
                                          Integer.parseInt(quant.getText() );
                                          
                                      }
                                      catch(Exception ie){
                                          JOptionPane.showMessageDialog(null,"Quantity should be in  number");
                                          
                                      }
                                      
                                      amt=avg_price.getText();
                                      
                                      try{
                                          Integer.parseInt(avg_price.getText() );
                                          
                                      }
                                      catch(Exception ie){
                                          JOptionPane.showMessageDialog(null,"Amount should be in  number");
                                          
                                      }
                                      ano=agent.getText();
                                      fno=folio_no.getText();
                                             
                                       SampleDB db = new SampleDB();
                                       System.out.println(qty+"  "+"   "+amt+ "   "+ano+"  "+dates.getText()+"  "+fno);
                                       db.admin_get_cid("guru");
                                       int val=0;
                                     
                    try {
                        val=db.admin_get_mfid(mdpanel.sc0.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                      System.out.println(val+"   "+db.ccid);
                                      db.admin_update_mf_trans(val+"",db.ccid+"",qty,amt,dates.getText(),fno,ano,null,null);
                                      JOptionPane.showMessageDialog(null,"Idiot its Updated","Stocks_Insert",JOptionPane.INFORMATION_MESSAGE);
                                      
                                }
                                       
                                         
                               }
                            );
                    // end of jbsave..........................................
                   
                   
                  
                   jp6.add(jbcancel);
                   jbcancel.addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent ae){
                          ref.setVisible(false);
                         
                      } 
                   });
                   
                   
                   this.add(jp4,BorderLayout.CENTER);
                      this.add(jp6,BorderLayout.SOUTH);
       
       
       
       
       
       
       
       //this.setVisible(true);
       try{
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           SwingUtilities.updateComponentTreeUI(this);
           
       }catch(Exception ie){
           
       }
        
        
    }//
    
    public static void main(String [] args){
        new MF_Modify_Panel(new mdpanel());//.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
    }//main

    
    
}