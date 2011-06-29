package Main;

import database.SampleDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Experiments.mdpanel.*;

public class MutualFunds extends JFrame
{
        MutualFunds ref=this;
        static String lname;
        public MutualFunds()
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
                this.setTitle("ManageInv-MutualFunds");
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
            String scheme_name,qty,amt,fno,ano;
            public AddPanel()
            {                 
                
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(6,2,15,15));    //Sub layout 1
                   jp4.add(new JLabel("Name of the Scheme:"));
                   final JComboBox jcb=new JComboBox();
                   jcb.addItem("TATA_POWER");
                   jcb.addItem("RELIANCE_POWER");
                   jcb.addItem("ICICI");
                   jp4.add(jcb);
                   jp4.add(new JLabel("No. of Units:"));
                   final JTextField units=new JTextField(5);
                   jp4.add(units);
                   jp4.add(new JLabel("Avg. Price:"));
                   final JTextField avg_price=new JTextField(5);
                   jp4.add(avg_price);
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));
                   final JTextField dates=new JTextField(5);
                   jp4.add(dates);
                   jp4.add(new JLabel("Folio No:"));
                   final JTextField folio_no=new JTextField(5);
                   jp4.add(folio_no);
                   jp4.add(new JLabel("Agent/ARN Code:"));
                   final JTextField agent_code=new JTextField(5);
                   jp4.add(agent_code);
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   JButton jbsave=new JButton("Save");
                   jp6.add(jbsave);
                   JButton jbcancel=new JButton("Cancel");
                   jp6.add(jbcancel);
                
                   jp5.add(jp6,BorderLayout.SOUTH);         //Adding Lay1 and Lay2 to TabbedPane Layout
                   jp5.add(jp4,BorderLayout.NORTH);
                   
                   this.add(jp5,BorderLayout.CENTER);
                   
                   
                   jbsave.addActionListener(
                           new ActionListener()
                           {
                               public void actionPerformed(ActionEvent ae) 
                               {
                                      scheme_name=(String)jcb.getSelectedItem();
                                      qty=units.getText();
                                      try{
                                          Integer.parseInt(units.getText() );
                                          
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
                                      
                                      fno=folio_no.getText();//folio_no copy
                                      ano=agent_code.getText();//agent_code copy
                                             
                                       SampleDB db = new SampleDB();
                                       System.out.println(scheme_name+"  "+qty+"  "+"   "+amt+ "   "+fno+"  "+dates.getText()+"  "+ano);
                                       db.admin_get_cid(lname.toLowerCase());
                                       int val=0;
                                     
                    try {
                        val=db.admin_get_mfid(scheme_name.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                      System.out.println(val+"   "+db.ccid);
                                     //db.admin_insert_mf_trans(val+"",db.ccid+"",scheme_name,qty,amt,dates.getText(),fno,ano,null,null);
                                     JOptionPane.showMessageDialog(null,"Idiot its saved","MutualFund_Insert",JOptionPane.INFORMATION_MESSAGE);
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
                //JPanel jp6=new JPanel(new FlowLayout());
                //mdpanel md=new mdpanel("bhaja");
                /*md.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                md.getDedicatedList("mf_trans",1,2,"guru");
                Experiments.mdpanel.setTabColNames("mf_trans");
                md.setVisible(true);*/
               //Z jp6.add(md);
                   
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
            new MutualFunds().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }

