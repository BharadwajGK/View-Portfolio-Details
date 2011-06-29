package Main;

import javax.swing.*;
import java.awt.*;

public class News_Updates extends JFrame
{
        public News_Updates()
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
                jtb.addTab("Business and Earnings",new Business_Earnings());
                jtb.addTab("BSE n NSE Notices",new BSE_NSE());
                jtb.addTab("Stocks Advices",new Stocks_Advices());
                
                //jtb.setBackgroundAt(1,Color.PINK);
                
                jp3.add(jtb);
                
                cp.add(jp3);
                cp.add(jp1,BorderLayout.NORTH);
           
                this.setVisible(true);
                this.setSize(700,520);
                this.setTitle("News_Updates");
                this.setResizable(false);
                           
           
                
        }
        class Business_Earnings extends JPanel
        {
            public Business_Earnings()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Business_Earnings"));
                 
                   this.add(jp4,BorderLayout.CENTER);
                   
            }              
        }
        
        class BSE_NSE extends JPanel
        {
            public BSE_NSE()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("BSE_NSE"));
                   
                   this.add(jp4,BorderLayout.CENTER);
                   
            }
            
        }
        
        class Stocks_Advices extends JPanel
        {
            public Stocks_Advices()
            {
                   JPanel jp4=new JPanel();
                   jp4.add(new JLabel("Stocks_Advices"));
                   
                   this.add(jp4,BorderLayout.CENTER);
                                      
                   
            }
            
        }
        
        
        
        
        public static void main(String a[])
        {
            new News_Updates().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }
