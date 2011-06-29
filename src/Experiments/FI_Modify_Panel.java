package Experiments;

import Sample.HorsPool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import database.*;
import java.util.*;


public class FI_Modify_Panel extends JPanel{
    
     String shares_name,date[],type,brokers;
                    Date dat1;
                    String qty;
                    String amt;
  public final  mdpanel md;
  FI_Modify_Panel ref=this;
  final JTextField interest=new JTextField(5);
  final JTextField folio=new JTextField(5);
    final JTextField amount=new JTextField(5);
     final JTextField dates=new JTextField(5);
      final JTextField agent=new JTextField(5);
         final JComboBox jcb1=new JComboBox(); final JButton jbcancel=new JButton("Cancel");
         
    public FI_Modify_Panel(mdpanel md){
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
                   jp4.add(new JLabel("Interest:"));
                   
                   jp4.add(interest);
                   
                           
                   jp4.add(new JLabel("Amount:"));
                 
                   jp4.add(amount);
                   
                   
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));
                  
                   jp4.add(dates);
                   
                   jp4.add(new JLabel("Folio"));
                  
                   jp4.add(folio);
                              
                   
                   
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   final JButton jbsave=new JButton("Confrim");
                   jp6.add(jbsave);
                   
                   
                  
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
        new FI_Modify_Panel(new mdpanel());//.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        
    }//main

    
    
}


