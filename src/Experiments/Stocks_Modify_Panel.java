

package Experiments;

import Sample.HorsPool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import database.*;
import java.util.*;
import Main.*;


public class Stocks_Modify_Panel extends JPanel{
    
    static String lname=RunProject.title;
    
     String shares_name,date[],type,brokers;
                    Date dat1;
                    String qty;
                    String amt;
  public final  mdpanel md;
  Stocks_Modify_Panel ref=this;
  static JTextField quant=new JTextField(5);
    static JTextField avg_price=new JTextField(5);
     static JTextField dates=new JTextField(5);
      static JTextField broker=new JTextField(5);
         static JComboBox jcb1=new JComboBox(); final JButton jbcancel=new JButton("Cancel");
         
    public Stocks_Modify_Panel(mdpanel md){
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
                   jp4.add(new JLabel("Ouantity:"));
                   
                   jp4.add(quant);
                   
                           
                   jp4.add(new JLabel("Avg. Price:"));
                 
                   jp4.add(avg_price);
                   
                   
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));
                  
                   jp4.add(dates);
                   
                 
                   jp4.add(new JLabel("Type"));
                
                   jcb1.addItem("BSE");
                   jcb1.addItem("NSE");
                   jp4.add(jcb1);
                   
                   jp4.add(new JLabel("Broker Name/Company:"));
                  
                   jp4.add(broker);
                   
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   final JButton jbsave=new JButton("Confirm");
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
                                      
                                      
                                     
                                      type=(String)jcb1.getSelectedItem();
                                      brokers=broker.getText();
                                             
                                       SampleDB db = new SampleDB();
                                       System.out.println(shares_name+"  "+qty+"  "+"   "+amt+ "   "+type+"  "+dates.getText()+"  "+brokers);
                                       db.admin_get_cid("guru");
                                       int val=0;
                                     
                    try {
                        val=db.admin_get_sid(mdpanel.sc0.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                      System.out.println(val+"   "+db.ccid);
                                      db.admin_update_stocks_trans(val+"",db.ccid+"",qty,amt,type,dates.getText(),null,null,brokers);
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
                   });//confirm action listener
                   
                   
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
        new Stocks_Modify_Panel(new mdpanel());//.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
    }//main

    
    
}