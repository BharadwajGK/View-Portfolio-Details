
package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;


public class Manage_Inv extends JDialog
{
        
        Manage_Inv ref=this;
        JButton stocks=new JButton("Stocks and Shares");
        JButton mf=new JButton("Mutual Funds");
        JButton fixed=new JButton("Fixed Income");
        JButton property=new JButton("Property");
        JButton loan=new JButton("Loan");
        JButton bullion=new JButton("Bullion");
        
        public Manage_Inv()
        {
           //this.setTitle("Home_Page");
          // this.setSize(600,600);
          // this.setVisible(true);
            
            
                this.setTitle("Manage_Investments");
                this.setSize(600,600);
                this.setVisible(true);
            
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
                this.setLocation(200,100);
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
                jp1.add(new JSeparator(),BorderLayout.SOUTH);
                
                JPanel jp3=new JPanel();
                jp3.setLayout(new BorderLayout(20,20));
                jp3.add(new JPanel(),BorderLayout.WEST);
                jp3.add(new JPanel(),BorderLayout.EAST);
                jp3.add(new JPanel(),BorderLayout.NORTH);
                jp3.add(new JPanel(),BorderLayout.SOUTH);
                
                JPanel jp4=new JPanel();
                jp4.setLayout(new GridLayout(3,2,10,10));
                jp4.add(stocks);
                jp4.add(bullion);
                jp4.add(mf);
                jp4.add(fixed);
                jp4.add(property);
                jp4.add(loan);
                
                jp3.add(jp4);
                jp3.setBorder(BorderFactory.createTitledBorder("Manage_Investments"));
                cp.add(jp3,BorderLayout.CENTER);
                cp.add(jp1,BorderLayout.NORTH);
                
                //Adding action listner to stocks.....................
                stocks.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new Stocks().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    ref.setVisible(false);
                    }
                });  
                //end of action listener of stocks.......................
                
                //Adding action listner to mf's.....................
                mf.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new MutualFunds().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    ref.setVisible(false);
                    }
                });  
                //end of action listener of mf's.......................
                
                //adding of action listener of bullion.......................
                bullion.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new Bullion().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    ref.setVisible(false);
                    }
                });  
                //end of action listener of bullion.......................
                
                //adding of action listener of fixed.......................
                fixed.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new FixedIncome().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    ref.setVisible(false);
                    }
                });  
                //end of action listener of Fixed.......................
                
                //adding of action listener of property.5.......................
                property.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new Property().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    ref.setVisible(false);
                    }
                });  
                //end of action listener of property.5.......................
                
                //adding of action listener of loan.6.......................
                loan.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new Loan().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    ref.setVisible(false);
                    }
                });  
                //end of action listener of loan.6.......................
                
           try
          {
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
          }catch(Exception e){}
               
            
            
            
        }   
           public static void main(String args[])
           {
               new Manage_Inv().setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
               
           }
          
           
        
            
}
