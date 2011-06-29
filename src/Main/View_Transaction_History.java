package Main;

import javax.swing.*;
import java.awt.*;

public class View_Transaction_History extends JFrame
{
        public View_Transaction_History()
        {
                
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
                Container cp=this.getContentPane();
                
                JPanel jp1=new JPanel();
                jp1.setLayout(new BorderLayout(10,10));
                JLabel jl1=new JLabel("Welcome");
                jl1.setForeground(Color.RED);
                jp1.add(jl1,BorderLayout.PAGE_START);
                
                JPanel jp2=new JPanel();
                jp2.setLayout(new GridLayout(2,5,20,0));
                jp2.add(new JButton("Sensex"));
                jp2.add(new JButton("Nifty"));
                jp2.add(new JButton("CNX Midcap"));
                jp2.add(new JButton("BSE Smallcap"));
                jp2.add(new JButton("Networth"));
                jp2.add(new JTextField(5));
                jp2.add(new JTextField(5));
                jp2.add(new JTextField(5));
                jp2.add(new JTextField(5));
                jp2.add(new JTextField(5));
                jp1.add(jp2,BorderLayout.CENTER);           
                jp1.add(new JSeparator(),BorderLayout.SOUTH); //adding Separator
                
                JPanel jp3=new JPanel();
                jp3.setLayout(new BorderLayout(20,20));
                jp3.add(new JPanel(),BorderLayout.WEST);
                jp3.add(new JPanel(),BorderLayout.EAST);
                jp3.add(new JPanel(),BorderLayout.NORTH);
                jp3.add(new JPanel(),BorderLayout.SOUTH);
                
                JTabbedPane jtb=new JTabbedPane();          //Add tabs
                jtb.addTab("View Transction Details",new StocksPanel());
                
                //jtb.setBackgroundAt(1,Color.PINK);
                
                jp3.add(jtb);
                
                cp.add(jp3);
                cp.add(jp1,BorderLayout.NORTH);
           
                this.setVisible(true);
                this.setSize(700,520);
                this.setTitle("View Transaction Details");
                this.setResizable(false);
                           
           
                
        }
        class StocksPanel extends JPanel
        {
            public StocksPanel()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Stocks Transaction Details"));
                 
                   this.add(jp4,BorderLayout.CENTER);
                   
            }              
        }
        
        class MFPanel extends JPanel
        {
            public MFPanel()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Mutual Funds Transaction Details"));
                   
                   this.add(jp4,BorderLayout.CENTER);
                   
            }
            
        }
        
        class BullionPanel extends JPanel
        {
            public BullionPanel()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Bullion Transaction Details"));
                   
                   this.add(jp4,BorderLayout.CENTER);
                                      
                   
            }
            
        }
        
        class  LoanPanel extends JPanel
        {
            public  LoanPanel()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Loan Transaction Details"));
                   
                   this.add(jp4,BorderLayout.CENTER);
                                      
                   
            }
            
        }
        
        class PropertyPanel extends JPanel
        {
            public PropertyPanel()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Property Transaction Details"));
                   
                   this.add(jp4,BorderLayout.CENTER); 
                                      
                   
            }
            
        }
        class  FIPanel extends JPanel
        {
            public  FIPanel()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Fixed Income Transaction Details"));
                   
                   
                   this.add(jp4,BorderLayout.CENTER);
                                      
                   
            }
            
        }
        
        
        public static void main(String a[])
        {
            new View_Transaction_History().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }
