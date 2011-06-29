
package Main;
//import Manage_Inv;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;



public class Home extends JDialog
{
        
        Home ref=this;
        //JButton manage_inv=new TransparentButton("Manage Investment");
        JButton manage_inv=new JButton("Manage Investments");
        JButton view_port=new JButton("View Portfolio Details");
        JButton news=new JButton("News And Updates");
        JButton view_trans=new JButton("View Transaction");
        JButton back=new JButton("Back");
        JButton next=new JButton("Next");
        //JButton loan=new JButton("Loan");
        //JButton bullion=new JButton("Bullion");
        
    public Home()
        {
                this.setTitle("Home_Page");
                this.setSize(600,600);
                this.setVisible(true);
            
                this.setLayout(new BorderLayout(10,10)); //Frame Layout
                this.setLocation(200,100);
                Container cp=this.getContentPane();
                
                JPanel jp1=new JPanel();                        //Sub-1 panel
                jp1.setLayout(new BorderLayout(10,10));
                JLabel jl1=new JLabel("Welcome---->"+RunProject.title);
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
                
                JPanel jp3=new JPanel();                        //Sub-2 panel
                jp3.setLayout(new BorderLayout(20,20));
                jp3.add(new JPanel(),BorderLayout.WEST);
                jp3.add(new JPanel(),BorderLayout.EAST);
                jp3.add(new JPanel(),BorderLayout.NORTH);
                jp3.add(new JPanel(),BorderLayout.SOUTH);
                
                JPanel jp4=new JPanel();
                jp4.setLayout(new GridLayout(4,2,10,10));
                jp4.add(new JPanel());
                jp4.add(new JPanel());
                jp4.add(manage_inv);
                jp4.add(view_port);
                jp4.add(news);
                jp4.add(view_trans);
                jp4.add(new JPanel());
                jp4.add(new JPanel());
                //jp4.add(property);
                //jp4.add(loan);
                
                jp3.add(jp4);
                jp3.setBorder(BorderFactory.createTitledBorder(null,"Home_Page",TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION));
                cp.add(jp3,BorderLayout.CENTER);
                cp.add(jp1,BorderLayout.NORTH);
                
               //registering listeners for buttons................ 
                /*ButtonHandler bhandler=new ButtonHandler(this);
                manage_inv.addActionListener(bhandler);
                view_port.addActionListener(bhandler);
                news.addActionListener(bhandler);
                view_trans.addActionListener(bhandler);*/
                
                //adding action listner to manage_inv..................
                manage_inv.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new Manage_Inv().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    //ref.setVisible(false);
                    }
                });
                ////end of action listner to manage_inv..................
                
                //adding action listner to view_port..................
                view_port.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new View_Portfolio().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });
                //end of action listner to view_port..................
               
                //adding action listner to news and updates..................
                news.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new News_Updates().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });
                //end of  action listner to view_port..................
                
                //adding action listner to view_trans..................
                view_trans.addActionListener(
                        new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    new View_Transaction_History().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                    }
                });
                //end of action listener to view trans.....................
                             
            try
          {
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
          }//try
            catch(Exception e){}
               
                
           //Implenting action listener for buttons............     
                /*class ButtonHandler implements ActionListener
                {
                    Home hm;
                     ButtonHandler(Home hm)
                    {
                    this.hm=hm;
                    }

                    public void actionPerformed(ActionEvent ae)
                    {
                        if(ae.getActionCommand().equals("Manage Investment"))
                        {
                            new Mange_Inv().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                        }
                    }
                
                    
                }*/
            
            
    }//Home cons
           public static void main(String args[])
           {
               new Home().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
               
           }
          
           /*class TransparentButton extends JButton 
           {
                public TransparentButton(String text) 
                { 
                    super(text);
                    setOpaque(false); 
                } //transparent
	    
                public void paint(Graphics g) 
                { 
                    Graphics2D g2 = (Graphics2D) g.create(); 
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); 
                    super.paint(g2); 
                    g2.dispose(); 
                } //paint
            }//class*/

              
}//Home 
