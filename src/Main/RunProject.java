
package Main;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.sql.*;



public class RunProject extends JFrame{
    
    RunProject ref=this;
    JTextField jtf=new JTextField();
    JPasswordField jpw=new JPasswordField();
    JButton login=new JButton("Login");
    JButton reg=new JButton("Register");
    public static String title;
    public RunProject(){
       this.setTitle("Personal Investment Portfolio Management System");
       this.setSize(1024,768);
       this.setVisible(true);
       this.setLayout(new GridBagLayout());
       
       
       
       
       
       JPanel cpanel=new JPanel(new GridLayout(3,3,6,6));
      // cpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10) ) ;
       //cpanel.setBorder(BorderFactory.createTitledBorder("Login"));
       cpanel.add(new JLabel("UserName               "));
       cpanel.add(jtf);
       cpanel.add(new JLabel("PassWord                "));
       cpanel.add(jpw);
       cpanel.add(login);
       cpanel.add(reg);
              
       ButtonHandler bhandler=new ButtonHandler(this);
       login.addActionListener(bhandler);
       reg.addActionListener(bhandler);
       
       this.getContentPane().add(cpanel);
       
       try{
           
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                   SwingUtilities.updateComponentTreeUI(this);
           
       }catch(Exception ie){}
        
    }//con

    
    //define ButtonHandler......
    
    
    class ButtonHandler implements ActionListener{
        
        RunProject rp;
        public ButtonHandler(RunProject rp){
            this.rp=rp;
        }//con
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==rp.reg){
               new AdminPage().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);   
            }
            int f1=0,f2=0,f3=0;
            if(ae.getSource()==rp.login){
                if(jtf.getText().equals("")==true){
                    f1=1;
                    JOptionPane.showMessageDialog(null,"UserName Missing","UserNameError",JOptionPane.ERROR_MESSAGE);
                }
                if(jpw.getText().equals("")==true){
                    f2=1;
                    JOptionPane.showMessageDialog(null,"Password Missing","PasswordError",JOptionPane.ERROR_MESSAGE);
                }
                                
                        try {
                             if(RunProject.databaseSearch(jtf.getText(),jpw.getText())==0){
                                 f3=1;
                              JOptionPane.showMessageDialog(null,"Not a Valid User","LoginError",JOptionPane.ERROR_MESSAGE);
                             }
                             
                             } catch (Exception ex) {}
        
                              if(f1==0 &&f2==0 && f3==0){
                        Stocks.lname=title=jtf.getText();
                        MutualFunds.lname=title=jtf.getText();
                        
                        new Home().setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
                        ref.setVisible(false);
                              }//if
            }//if login
            
        }//event
        
    }//ButtonHandler...
    
     public static int databaseSearch(String uname,String pass) throws Exception {
        
        
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery("select login_name,password from customer ");
        int f=0;
        
        while(rs.next()) {
            String str1=rs.getString(1);
            String str2=rs.getString(2);
            
            if(str1.equals(uname) && str2.equals(pass)) {
               
                return 1;
            }//if
            
        }//while
        return 0;
     }//search
    
    public static void main(String []a ){
        
        new RunProject().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            
            
            
            if(RunProject.databaseSearch("bhaja","dasdasdasd")==1)
                System.out.println("Exists");
            else
                System.out.println("NotExists");
        } catch (Exception ex) {
           // ex.printStackTrace();
        }
        
    }
}