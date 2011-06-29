package Main;

import database.SampleDB;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Loan extends JFrame
{
        Loan ref=this;
        static String lname;
        public Loan()
        {
                /*this.setVisible(true);
                this.setSize(640,480);
                this.setTitle("ManageInv-Stocks");
                this.setResizable(false);*/
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
                jtb.addTab("Add",new AddPanel());
                jtb.addTab("Modify",new ModPanel());
                jtb.addTab("Delete",new DelPanel());               
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
            
            String type,intr,amt,emi_date,e,tenure,dur;
            int opt;
            AddPanel ap;
            public AddPanel()
            {
                    
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(6,2,15,5));     //Sub layout 1
                   jp4.add(new JLabel("Type:"));
                   final JComboBox jcb=new JComboBox();
                   jcb.addItem("Home");
                   jcb.addItem("Personal");
                   jcb.addItem("Auto");
                   jcb.addItem("Education");
                   jp4.add(jcb);
                   jp4.add(new JLabel("Interest (in percents):"));
                   final JTextField interest=new JTextField(5);
                   jp4.add(interest);
                   jp4.add(new JLabel("Loan Amount:"));
                   final JTextField loan_amt=new JTextField(5);
                   jp4.add(loan_amt);
                   jp4.add(new JLabel("EMI Start Date:"));
                   final JTextField emi_start=new JTextField(5);
                   jp4.add(emi_start);
                   jp4.add(new JLabel("EMI"));
                   final JTextField emi=new JTextField(5);
                   jp4.add(emi);
                   jp4.add(new JLabel("Tenure:"));
                   //final JTextField tenure=new JTextField(5);
                   final JPanel jp7=new JPanel();
                   jp7.setLayout(new FlowLayout());
                   final JComboBox jcb1=new JComboBox();
                   jcb1.addItem("Years");
                   jcb1.addItem("Months");
                   jp7.add(jcb1);
                              
                   final JComboBox jcb2=new JComboBox();
                   for(int i=1;i<=100;i++)
                       jcb2.addItem(i);
                   jp7.add(jcb2);
                   jp4.add(jp7);
                   //jp4.add(tenure);
                  
                                               
                   
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
                                      type=(String)jcb.getSelectedItem();
                                      intr=interest.getText();
                                      try{
                                          Integer.parseInt(interest.getText() );
                                          
                                      }
                                      catch(Exception ie){
                                          JOptionPane.showMessageDialog(null,"Interest should be in  number");
                                          
                                      }
                                      
                                      amt=loan_amt.getText();
                                      
                                      try{
                                          Integer.parseInt(loan_amt.getText() );
                                          
                                      }
                                      catch(Exception ie){
                                          JOptionPane.showMessageDialog(null,"Amount should be in  number");
                                          
                                      }
                                      emi_date=emi_start.getText();
                                      e=emi.getText();
                                     
                                      tenure=(String)jcb1.getSelectedItem();
                                      opt=(Integer)jcb2.getSelectedItem();
                                      dur=opt+"-"+tenure;
                                      //System.out.println(type);
                                                                           
                                             
                                       SampleDB db = new SampleDB();
                                       System.out.println(type+"  "+intr+"  "+"   "+amt+ "   "+emi_date+"  "+e+" "+dur);
                                       db.admin_get_cid("guru");
                                       int val=0;
                                     
                    try {
                       val=db.admin_get_lid(type.toUpperCase());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                                      System.out.println(val+"   "+db.ccid);
                                     db.admin_insert_loan_trans(val+"",db.ccid+"",type,amt,intr,dur,emi_date,e);
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
                
        
        public static void main(String a[])
        {
            new Loan().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }

