package Main;


import database.SampleDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bullion extends JFrame
{
        Bullion ref=this;
        static String lname=RunProject.title;
        public Bullion()
        {
                /*this.setVisible(true);
                this.setSize(640,480);
                this.setTitle("ManageInv-Stocks");
                this.setResizable(false);*/
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
                this.setLocation(200,100);
                Container cp=this.getContentPane();
                
                JPanel jp1=new JPanel();
                jp1.setLayout(new BorderLayout(10,10));
                JLabel jl1=new JLabel("Welcome>>>"+RunProject.title);
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
                jtb.addTab("Modify",new ModPanel());
                jtb.addTab("Delete",new DelPanel());
                jtb.addTab("Sell",new SellPanel());
                
                jp3.add(jtb);
                
                cp.add(jp3);
                cp.add(jp1,BorderLayout.NORTH);
           
                this.setVisible(true);
                this.setSize(680,580);
                this.setTitle("ManageInv-Bullion");
                this.setResizable(false);
                           
           /*try
              {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                   SwingUtilities.updateComponentTreeUI(this);
              }
               catch(Exception e){System.out.println("Exception");}*/
                
                
        }
        class AddPanel extends JPanel
        {
                String qty,amt,commodity;
            public AddPanel()
            {
                   ButtonHandler bh=new ButtonHandler(this);
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(7,2,15,15)); //Sub layout 1
                   jp4.add(new JPanel());
                   jp4.add(new JPanel());
                                      
                   jp4.add(new JLabel("Commodity:"));
                   final JComboBox jcb=new JComboBox();
                   jcb.addItem("GOLD");
                   jcb.addItem("SILVER");
                   jp4.add(jcb);
                   jp4.add(new JLabel("Ouantity (in gms):"));
                   final JTextField quant=new JTextField(5);
                   jp4.add(quant);
                   jp4.add(new JLabel("Avg. Price:"));
                   final JTextField avg_price=new JTextField(5);
                   jp4.add(avg_price);
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));
                   final JTextField dates=new JTextField(5);
                   jp4.add(dates);
                   //jp4.add(new JLabel("*Gold price per 10 gms*"));
                   //jp4.add(new JLabel("*Silver price per 1000 gms*"));
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   JButton jbsave=new JButton("Save");
                   jp6.add(jbsave);
                   JButton jbcancel=new JButton("Cancel");
                   jp6.add(jbcancel);
                
                   jp5.add(jp6,BorderLayout.SOUTH);         //Adding Lay1 and Lay2 to TabbedPane Layout
                   jp5.add(jp4,BorderLayout.NORTH);
                   
                   this.add(jp5,BorderLayout.CENTER);
                   /*int h=JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS;
                   int v=JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
                   JScrollPane jsp=new JScrollPane(jp5,v,h);
                   this.add(jsp,BorderLayout.CENTER);*/
                   
                   jbsave.addActionListener(bh);
                   jbcancel.addActionListener(bh);
                   
                   
                  jbsave.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                      commodity=(String)jcb.getSelectedItem();
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
                                      
                                       SampleDB db = new SampleDB();
                                       System.out.println(commodity+"  "+qty+"  "+"   "+amt+ "   "+dates.getText()+"  ");
                                       db.admin_get_cid(lname.toLowerCase());System.out.println("Here");
                                       int val=0;
                                     
                    try {
                        val=db.admin_get_bid(commodity.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                      //System.out.println(val+"   "+db.ccid);
                                     db.admin_insert_bullion_trans(val+"",db.ccid+"",commodity,qty,dates.getText(),amt,"2/2/2","100");
                                     JOptionPane.showMessageDialog(null,"Idiot its saved","Loan_Insert",JOptionPane.INFORMATION_MESSAGE);
                               }
                                       
                                         
                               }
                            );
                            
                   
                //Add for cancel..............................................
                   jbcancel.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                   ref.setVisible(false);
                                   
                                }
                            });
                   
            }              
        }
        
        class ModPanel extends JPanel
        {
            public ModPanel()
            {
                   
                   
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
        
        class ButtonHandler implements ActionListener
        {
            AddPanel addpanel;
            public ButtonHandler(AddPanel addpanel)
            {
                this.addpanel=addpanel;
                
            }
            public void actionPerformed(ActionEvent e)
            {
                
            }
            
        }
        
        public static void main(String a[])
        {
            new Bullion().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }
