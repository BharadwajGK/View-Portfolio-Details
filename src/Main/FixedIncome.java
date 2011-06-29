package Main;

import javax.swing.*;
import java.awt.*;

public class FixedIncome extends JFrame
{
        public FixedIncome()
        {
                /*this.setVisible(true);
                this.setSize(640,480);
                this.setTitle("ManageInv-Stocks");
                this.setResizable(false);*/
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
                Container cp=this.getContentPane();
                
                JPanel jp1=new JPanel();                            //Frame Sub layout-1
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
                jp1.add(new JSeparator(),BorderLayout.SOUTH);       //adding Separator
                
                JPanel jp3=new JPanel();                                   //Frame Sub layout-2
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
                //jtb.setBackgroundAt(1,Color.PINK);
                
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
            public AddPanel()
            {
                   JPanel jp4=new JPanel();
                   JPanel jp5=new JPanel();         
                   jp5.setLayout(new BorderLayout(10,10));      //TabbedPane Layout
                   jp4.setLayout(new GridLayout(6,2,15,15));    //Sub layout 1
                   jp4.add(new JLabel("Name of the Scheme:"));
                   JTextField scheme_name=new JTextField(5);
                   jp4.add(scheme_name);
                   jp4.add(new JLabel("Interest:"));
                   JTextField interest=new JTextField(5);
                   jp4.add(interest);
                   jp4.add(new JLabel("Amount:"));
                   JTextField amt=new JTextField(5);
                   jp4.add(amt);
                   jp4.add(new JLabel("Date [dd/mm/yyyy]"));
                   JTextField dates=new JTextField(5);
                   jp4.add(dates);
                   jp4.add(new JLabel("Type"));
                   JComboBox jcb=new JComboBox();
                   jcb.addItem("FD");
                   jcb.addItem("NSC");
                   jcb.addItem("Bonds");
                   jcb.addItem("Other");
                   jp4.add(jcb);
                   jp4.add(new JLabel("Folio No:"));
                   JTextField folio_no=new JTextField(5);
                   jp4.add(folio_no);
                   
                   JPanel jp6=new JPanel();                 
                   jp6.setLayout(new FlowLayout());         //Sub layout 2
                   jp6.add(new JButton("Save"));
                   jp6.add(new JButton("Cancel"));
                
                   jp5.add(jp6,BorderLayout.SOUTH);         //Adding Lay1 and Lay2 to TabbedPane Layout
                   jp5.add(jp4,BorderLayout.NORTH);
                   
                   this.add(jp5,BorderLayout.CENTER);
                   
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
            new FixedIncome().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    
        
        
 }
