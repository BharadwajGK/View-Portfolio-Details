
package Main;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import database.*;


public class AdminPage extends JDialog{
    
    AdminPage ref=this;
     String AdminUserNames[]={"snyper","divya","sudha","akash","guru"};
    String AdminPassWord ="scicom";
    JTextField jtf=new JTextField(20);
    JPasswordField jpw=new JPasswordField(20); 
    JButton ok=new JButton("OK");
    JTextField jtfu=new JTextField(20);
    JPasswordField jpwu=new JPasswordField(20);
    JButton check=new JButton("Check");
    JButton clear=new JButton("Clear");
    JButton proceed=new JButton("Proceed >>>");
    String newUser,newUserPass;
    
    public AdminPage(){
        this.setTitle("AdminPage");
        this.setSize(600,700);
        this.setLocation(250,0);
        this.setVisible(true);
        this.setLayout(new GridLayout(2,1,0,0));
        
        JPanel npanel=new JPanel(new GridBagLayout());
        JPanel spanel=new JPanel(new GridBagLayout());

        
        
        npanel.setBorder(BorderFactory.createTitledBorder(null,"AdminInfo",TitledBorder.CENTER,TitledBorder.CENTER,new Font("Times New Roman",Font.PLAIN,14),Color.BLUE));
        spanel.setBorder(BorderFactory.createTitledBorder(null,"AssignUserName",TitledBorder.CENTER,TitledBorder.CENTER,new Font("Times New Roman",Font.PLAIN,14),Color.BLUE));
        
        JPanel nnpanel=new JPanel(new BorderLayout());
        JPanel ncpanel=new JPanel(new GridLayout(2,2,6,6));
        ncpanel.add(new JLabel("AdminUserName"));
        ncpanel.add(jtf);
        ncpanel.add(new JLabel("AdminPassWord"));
        ncpanel.add(jpw);
        
        nnpanel.add(ncpanel,BorderLayout.CENTER);
        
        JPanel nspanel=new JPanel(new FlowLayout());
        nspanel.add(ok);
        //addActionListener to ok......
        ok.addActionListener(
                new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String adminName=jtf.getText();
                String adminPass=jpw.getText();
                int match=0;
                for(int i=0;i<AdminUserNames.length;i++){
                    if(AdminUserNames[i].equals(adminName) && adminPass.equals(AdminPassWord)){
                        jtfu.setEditable(true);
                        jpwu.setEditable(true);
                        check.setEnabled(true);
                        clear.setEnabled(true);
                        match=1;
                        break;
                    }//if check.setEnabled(false);
                    
                }//for i
                if(match==0){
                    JOptionPane.showMessageDialog(null,"The username or password\n you entered is incorrect ","AdminLoginError",JOptionPane.ERROR_MESSAGE);
                    
                }
                
            }
        }
    );
        
        nnpanel.add(nspanel,BorderLayout.SOUTH);
        
       npanel.add(nnpanel);
       
       
       
       
       JPanel sspanel=new JPanel();
        sspanel.setLayout(new BorderLayout());
        JPanel snpanel=new JPanel(new GridLayout(3,2,6,6));
        snpanel.add(new JLabel("UserName"));
        snpanel.add(jtfu); jtfu.setEditable(false);
        snpanel.add(new JLabel("Password"));
        snpanel.add(jpwu); jpwu.setEditable(false);
        snpanel.add(check); check.setEnabled(false); 
        //check event...................
        check.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               newUser=jtfu.getText();
               newUserPass=jpwu.getText();
                try {
                    if(SampleDB.admin_Search_customer(newUser)==0){
                        proceed.setEnabled(true);
                        
                    }//if newUser does not present.....
                    else
                    {
                        JOptionPane.showMessageDialog(null,"UserName not available\n Please choose other UserName","Invalid UserName",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    System.out.println("Some Exception");
                   // ex.printStackTrace();
                }//if newUser does not present.....
               
           } 
        });
        snpanel.add(clear); clear.setEnabled(false);
        clear.addActionListener(
                new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                jtfu.setText("");
                jpwu.setText("");
            }
        });
        sspanel.add(snpanel,BorderLayout.CENTER);
        JPanel ssspanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        ssspanel.add(proceed); proceed.setEnabled(false);
        
        //proceed event.....
        proceed.addActionListener(
                new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ref.setVisible(false);
                new CreateUser1(newUser,newUserPass).setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                
            }
        });
        
        
        
        sspanel.add(ssspanel,BorderLayout.SOUTH);
        
       
       spanel.add(sspanel);
            
        
        this.getContentPane().add(npanel);
        this.getContentPane().add(spanel);
        
        
     try{
           
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                   SwingUtilities.updateComponentTreeUI(this);
           
       }catch(Exception ie){}
    
    }
    
    
    
    public static void main(String []a ){
        
        
        new AdminPage().setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
}