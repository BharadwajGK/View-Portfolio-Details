package Main;

import database.SampleDB;
import java.awt.event.*;
import java.sql.Date;
import javax.swing.*;
import java.awt.*;

public class Stocks extends JFrame
{
    
    Stocks ref=this;
    static String lname; 
        public Stocks()
        {
                /*this.setVisible(true);
                this.setSize(640,480);
                this.setTitle("ManageInv-Stocks");
                this.setResizable(false);*/
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
                Container cp=this.getContentPane();
                
                JPanel jp1=new JPanel();
                jp1.setLayout(new BorderLayout(10,10));
                JLabel jl1=new JLabel("Welcome----->"+RunProject.title);
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
                jtb.addTab("Add",new AddPanel());
                
                jtb.addTab("Modify",new Mpanel() );
                jtb.addTab("Delete",new DelPanel());
                jtb.addTab("Sell",new SellPanel());
                
                jp3.add(jtb);
                
                cp.add(jp3);
                cp.add(jp1,BorderLayout.NORTH);
           
                this.setVisible(true);
                this.setSize(640,520);
                this.setTitle("ManageInv-Stocks");
                this.setResizable(false);
                           
           /*try
              {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                   SwingUtilities.updateComponentTreeUI(this);
              }
               catch(Exception e){System.out.println("Exception");
             */   
                
        }
        class Mpanel extends JPanel{
            
            public Mpanel(){
                
             this.setLayout(new BorderLayout());
             JPanel npanel=new JPanel(new BorderLayout());
             JPanel spanel=new JPanel(new FlowLayout());
             
                
                
                
            }//con
            
        }//Mpanel
        class AddPanel extends JPanel
        {           String shares_name,date[],type,brokers;
                    
                    String qty;
                    String amt;
            public AddPanel()
            {
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(6,2,15,15));    //Sub layout 1
                   jp4.add(new JLabel("Name of the Shares:"));
                   final JComboBox jcb=new JComboBox();
                   jcb.addItem("INFOSYS");
                   jcb.addItem("SBI");
                   
                  
                   jp4.add(jcb);
                  
                   
                   jp4.add(new JLabel("Ouantity:"));
                  final JTextField quant=new JTextField(5);
                   jp4.add(quant);
                   
                           
                   jp4.add(new JLabel("Avg. Price:"));
                   final JTextField avg_price=new JTextField(5);
                   jp4.add(avg_price);
                   
                   
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));
                   final JTextField dates=new JTextField(5);
                   jp4.add(dates);
                   
                 
                   jp4.add(new JLabel("Type"));
                   final JComboBox jcb1=new JComboBox();
                   jcb1.addItem("BSE");
                   jcb1.addItem("NSE");
                   jp4.add(jcb1);
                   
              
                   jcb1.addItemListener(
                           new ItemListener()
                   {
                       public void itemStateChanged(ItemEvent ae)
                       {
                           type=(String)ae.getItem();
                           //System.out.println(type);
                       }
                   });
               
                   
                   jp4.add(new JLabel("Broker Name/Company:"));
                   final JTextField broker=new JTextField(5);
                   jp4.add(broker);
                   
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   final JButton jbsave=new JButton("Save");
                   jp6.add(jbsave);
                   
                 
                   jbsave.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                      shares_name=(String)jcb.getSelectedItem();
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
                                       db.admin_get_cid(lname.toLowerCase());
                                       int val=0;
                                     
                    try {
                        val=db.admin_get_sid(shares_name.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                      System.out.println(val+"   "+db.ccid);
                                      db.admin_insert_stocks_trans(val+"",db.ccid+"",shares_name,qty,amt,type,dates.getText(),"2/2/2","100",brokers);
                                      JOptionPane.showMessageDialog(null,"Idiot its saved","Stocks_Insert",JOptionPane.INFORMATION_MESSAGE);
                               }
                                       
                                         
                               }
                            );
                    // end of jbsave..........................................
                            
                   final JButton jbcancel=new JButton("Cancel");
                   jp6.add(jbcancel);
                //Add for cancel..............................................
                   jbcancel.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                   ref.setVisible(false);
                                   
                                }
                            });
                   jp5.add(jp6,BorderLayout.SOUTH);         //Adding Lay1 and Lay2 to TabbedPane Layout
                   jp5.add(jp4,BorderLayout.NORTH);
                   
                   this.add(jp5,BorderLayout.CENTER);
                   
            }              
        }
        
        class ModPanel extends JDialog
        {
            public ModPanel()
            {
                   JPanel jp7=new JPanel();
                   JPanel jp8=new JPanel();         
                   jp8.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp7.setLayout(new GridLayout(6,2,15,15));    //Sub layout 1
                   jp7.add(new JLabel("Ouantity:"));
                   jp7.add(new JTextField(5));
                   jp7.add(new JLabel("Avg. Price:"));
                   jp7.add(new JTextField(7));
                   jp7.add(new JLabel("Date [dd/mm/yyyy]"));
                   jp7.add(new JTextField(10));
                   jp7.add(new JLabel("Type"));
                   JComboBox jcb=new JComboBox();
                   jcb.addItem("BSE");
                   jcb.addItem("NSE");
                   jp7.add(jcb);
                   jp7.add(new JLabel("Broker Name/Company:"));
                   jp7.add(new JTextField(10));
                   
                   JPanel jp9=new JPanel();                 
                   jp9.setLayout(new FlowLayout());         //Sub layout 2
                   jp9.add(new JButton("Save"));
                   jp9.add(new JButton("Cancel"));
                
                   jp8.add(jp9,BorderLayout.SOUTH);         //Adding Lay1 and Lay2 to TabbedPane Layout
                   jp8.add(jp7,BorderLayout.NORTH);
                   
                   this.getContentPane().add(jp8,BorderLayout.CENTER);
                   
                   
            }
            
        }
        
        class DelPanel extends JPanel
        {
            public DelPanel()
            {
                                      
                   
            }
            
        }
        
        class SellPanel extends JPanel
        {
            public SellPanel()
            {
                                      
                   
            }
            
        }
        
        public static void main(String a[])
        {
            new Stocks().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }
