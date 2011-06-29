package Main;

import javax.swing.*;
import java.awt.*;

public class FIView extends JFrame 
{
    public FIView()
    {           
                this.setVisible(true);
                this.setSize(640,480);
                this.setTitle("ViewPortfolio-Loan");
                //this.setResizable(false);
                
                this.setLayout(new BorderLayout(10,10));         //Frame Layout
                Container cp=this.getContentPane();
                
                JPanel jp1=new JPanel();
                jp1.setLayout(new BorderLayout(10,10));
                JLabel jl1=new JLabel("Welcome");
                jl1.setForeground(Color.RED);
                jp1.add(jl1,BorderLayout.PAGE_START);
                
                JPanel jp2=new JPanel();
                jp2.setLayout(new GridLayout(2,5,15,0));
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
                JTabbedPane jtb=new JTabbedPane();
                jtb.addTab("View Loan",new ViewFI());
                jp3.add(jtb);
                
                cp.add(jp3);
                cp.add(jp1,BorderLayout.NORTH);
                
                /*try
                {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                   SwingUtilities.updateComponentTreeUI(this);
                 }
                 catch(Exception e){System.out.println("Exception");}*/
                
    }
    public class ViewFI extends JPanel
    {
        public ViewFI()
        {
            JPanel jp4=new JPanel();                    //TabbedPane Layout
            jp4.setLayout(new GridLayout(1,3,10,10));
            JPanel jp5=new JPanel();                    //SUB layout-1 in TabbedPane 
            jp5.setLayout(new GridLayout(10,0,5,5));
            jp5.add(new JRadioButton("NSC"));
            jp5.add(new JRadioButton("FD"));
                        
            jp4.add(jp5);
            jp4.add(new JPanel());
                      
            JPanel jp6=new JPanel();                    //Sub layout-2 in TabbedPane
            jp6.setLayout(new FlowLayout());
            jp6.add(new JButton("View Loan Details"));
            jp4.add(jp6);
                       
            this.add(jp4);
                       
        }
    }
    
    public static void main(String a[])
    {
        new FIView().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




