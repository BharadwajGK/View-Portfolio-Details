
package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;


public class View_Portfolio extends JDialog
{
        JButton stocks_view=new JButton("View Stocks and Shares");
        JButton mf_view=new JButton("View Mutual Funds");
        JButton fixed_view=new JButton("View Fixed Income");
        JButton property_view=new JButton("View Property");
        JButton loan_view=new JButton("View Loan");
        JButton bullion_view=new JButton("View Bullion");
        
        public View_Portfolio()
        {
           //this.setTitle("Home_Page");
          // this.setSize(600,600);
          // this.setVisible(true);
            
            
                this.setTitle("View_portfolio_Details");
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
                jp4.add(stocks_view);
                jp4.add(bullion_view);
                jp4.add(mf_view);
                jp4.add(fixed_view);
                jp4.add(property_view);
                jp4.add(loan_view);
                
                jp3.add(jp4);
                jp3.setBorder(BorderFactory.createTitledBorder("View_Portfolio_Details"));
                cp.add(jp3,BorderLayout.CENTER);
                cp.add(jp1,BorderLayout.NORTH);
                
                //Adding action listner to stocks.....................
                stocks_view.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new StockView().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });   
                //end of action listner to stocks.....................
                
                //Adding action listner to mf.....................
                mf_view.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new MutualFundsView().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });   
                //end of action listner to mf.....................
                
                //Adding action listner to fixed.....................
                fixed_view.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new FIView().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });   
                //end of action listner to fixed.....................
                
                //Adding action listner to bullion.....................
                bullion_view.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new BullionView().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });   
                //end of action listner to bullion.....................
                
                //Adding action listner to loan.....................
                loan_view.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new LoanView().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });   
                //end of action listner to loan.....................
                
                //Adding action listner to property.....................
                property_view.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new PropertyView().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });   
                //end of action listner to property.....................
                
           try
          {
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
          }catch(Exception e){}
               
            
            
            
        }   
           public static void main(String args[])
           {
               new View_Portfolio().setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
               
           }
          
           
        
            
}

