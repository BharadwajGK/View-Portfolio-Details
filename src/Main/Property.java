package Main;


import database.SampleDB;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Property extends JFrame
{
    
        Property ref=this;
        static String lname=RunProject.title;
        public Property()
        {
                /*this.setVisible(true);
                this.setSize(640,480);
                this.setTitle("ManageInv-Stocks");
                this.setResizable(false);*/
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
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
        class AddPanel extends JPanel
        {
                String l_val,pur_amt,location,type;
            public AddPanel()
            {
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(6,2,15,15)); //Sub layout 1
                   jp4.add(new JLabel("Type:"));
                   final JComboBox jcb=new JComboBox();
                   jcb.addItem("RESIDENTIAL");
                   jcb.addItem("COMMERCIAL");
                   jcb.addItem("LAND");
                   jp4.add(jcb);
                   jp4.add(new JLabel("Location:"));
                   final JTextField loc=new JTextField(5);
                   jp4.add(loc);
                   jp4.add(new JLabel("Purchase Price:"));
                   final JTextField pur_price=new JTextField(5);
                   jp4.add(pur_price);
                   jp4.add(new JLabel(" Purchase Date [dd/mm/yyyy]"));
                   final JTextField pur_date=new JTextField(5);
                   jp4.add(pur_date);
                   jp4.add(new JLabel("Latest Value"));
                   final JTextField latest_value=new JTextField(5);
                   jp4.add(latest_value);
                                      
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   JButton jbsave=new JButton("Save");
                   jp6.add(jbsave);
                   //JButton jbcancel=new JButton("Cancel");
                  // jp6.add(jbcancel);
                
                   jp5.add(jp6,BorderLayout.SOUTH);         //Adding Lay1 and Lay2 to TabbedPane Layout
                   jp5.add(jp4,BorderLayout.NORTH);
                   
                   this.add(jp5,BorderLayout.CENTER);
                   
                   jbsave.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                      type=(String)jcb.getSelectedItem();
                                      location=loc.getText();
                                      pur_amt=pur_price.getText();
                                      
                                      try{
                                          Integer.parseInt(pur_price.getText() );
                                          
                                      }
                                      catch(Exception ie){
                                          JOptionPane.showMessageDialog(null,"Amount should be in  number");
                                          
                                      }
                                                 
                                      
                                        l_val=latest_value.getText();
                                             
                                       SampleDB db = new SampleDB();
                                       System.out.println(type+"  "+location+"  "+"   "+pur_amt+ "   "+l_val+"  "+pur_date.getText()+"  ");
                                       db.admin_get_cid("guru");
                                       int val=0;
                                     
                    try {
                        val=db.admin_get_pid(type.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                   System.out.println(val+"   "+db.ccid);
                                   db.admin_insert_property_trans(val+"",db.ccid+"",type,location,pur_amt,pur_date.getText(),l_val);
                                   JOptionPane.showMessageDialog(null,"Idiot its saved","Loan_Insert",JOptionPane.INFORMATION_MESSAGE);
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
        
        public static void main(String a[])
        {
            new Property().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }

