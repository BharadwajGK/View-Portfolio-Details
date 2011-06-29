package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class CreateUser1 extends JDialog {
    private JLabel nameL,ageL,emailL,contactL,addressL;
    private JTextField nameTF,ageTF,emailTF,contactTF,addressTF;
    public JButton createB,cancelB,deactivateB;
//static int rowCount=0;
    
    String uname,pass;
    public CreateUser1(String uname,String pass ) {
        //super("Create User Account");
        this.uname=uname;
        this.pass=pass;
        nameL=new JLabel("First Name:");
       // lNameL=new JLabel("Last Name:");
        ageL=new JLabel("Age:");
        
        emailL=new JLabel("Email-Id:");
        contactL=new JLabel("Phone:");
        addressL=new JLabel("Address:");   
        //login_nameL=new JLabel("Assign Username:");
        //passwordL=new JLabel("Assign Password:");
        
        nameTF=new JTextField(30);
        //lNameTF=new JTextField(30);
        ageTF=new JTextField(3);
        contactTF=new JTextField(13);
        emailTF=new JTextField(50);
        addressTF=new JTextField(50);
        //login_nameTF=new JTextField(15);
        //passwordTF=new JTextField(15);;
        
        JPanel npanel =new JPanel(new GridLayout(7,2,10,10));
        JPanel spanel=new JPanel(new FlowLayout());
        
        npanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
//set north panel.....
        ButtonHandler BHandler=new ButtonHandler(this);
        createB=new JButton("Create");
        createB.addActionListener(BHandler);
        
        cancelB=new JButton("Cancel");
        cancelB.addActionListener(BHandler);
        deactivateB=new JButton("Deactivate");
        deactivateB.addActionListener(BHandler);
        
        
        Container pane= getContentPane();
        pane.setLayout(new BorderLayout());
        
        pane.add(npanel,BorderLayout.CENTER);
        pane.add(spanel,BorderLayout.SOUTH);
        
        ageL.setLocation(40,200);
        contactL.setLocation(60,200);
        emailL.setLocation(50,200);
        addressL.setLocation(70,200);
        //login_nameL.setLocation(80,200);
        //passwordL.setLocation(90,200);
        
        
        npanel.add(nameL);
        npanel.add(nameTF);
        
        
       // npanel.add(lNameL);
       // npanel.add(lNameTF);
        
        npanel.add(ageL);
        npanel.add(ageTF);
        
        
        npanel.add(contactL);
        npanel.add(contactTF);
        
        
        npanel.add(emailL);
        npanel.add(emailTF);

        npanel.add(addressL);
        npanel.add(addressTF);
        
        
        //npanel.add(login_nameL);
        //npanel.add(login_nameTF);
        
        
        //npanel.add(passwordL);
        //npanel.add(passwordTF);
        
        
        
        
        spanel.add(createB);
        spanel.add(cancelB);
        spanel.add(deactivateB);
        
        setVisible(true);
        this.setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
            
        }catch(Exception ie){}
        
    }
    
    public static void main(String args[]) {
        CreateUser1 c=new CreateUser1("kiran","kiran");
        
        
    }
    
    
//Creating button handler
   class ButtonHandler implements ActionListener
            
    {
        CreateUser1 cu;
        ButtonHandler(CreateUser1 cu){
            this.cu=cu;
            
        }
        public void actionPerformed(ActionEvent e){
            String name=   nameTF.getText();
            //String lname=lNameTF.getText();
            String age=ageTF.getText();
            String contact=contactTF.getText();
            String email=emailTF.getText();
            String address=addressTF.getText();
            //String uname=login_nameTF.getText();
            //String pass=passwordTF.getText();
            if(e.getActionCommand().equals("Create")) {
                
                if(name.equals("")||age.equals("")||contact.equals("")||email.equals("")||address.equals(""))
                    JOptionPane.showMessageDialog(cu,"Some field missing","ERROR",JOptionPane.ERROR_MESSAGE);
                else {
                    int f=0;
                    /*try {
                        if(Sqldemo.Search(uname)==1) {
                            f=1;
                            JOptionPane.showMessageDialog(cu,"User name already exists","ERROR",JOptionPane.ERROR_MESSAGE);
                        }//if
                    }catch(Exception ex1){}*/
                    int a=0,p=0;
                    
                    try {
                        a=Integer.parseInt(age);
                        p=Integer.parseInt(contact);
                        Sqldemo.databaseInsert(uname,pass,name,age,contact,email,address);
                        if(f==0)
                            JOptionPane.showMessageDialog(cu,"User account has been successfully created");
                        
                    } catch(NumberFormatException ne) {
                        JOptionPane.showMessageDialog(cu,"Age,phone should be number values","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            }//if
            else if(e.getActionCommand().equals("Cancel")){
                cu.setVisible(false);
            } 
if(e.getSource()==deactivateB){   try {
                    if(Sqldemo.databaseSearch(uname,pass)==1)
                        
                        JOptionPane.showMessageDialog(cu,"User account has been deactivated","WARNING",JOptionPane.WARNING_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(cu,"User account cannot be deactivated","WARNING",JOptionPane.WARNING_MESSAGE);
                }catch(Exception ex){System.out.println("search");}

               

            }//if
        }
        
    }
    
}


//database class
class Sqldemo {
    
    public static void databaseInsert(String uname,String pass,String name,String age,String phone,String email,String address)
    {
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            stmt=conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
            
            stat=conn.createStatement();
            rs=stat.executeQuery("select custid from customer ");
            int count=0;
            while(rs.next())
                count++;
            
            stmt.setString(1,(count+1)+"");
            stmt.setString(2,name);
            stmt.setString(7,uname);
            stmt.setString(4,email);
            stmt.setInt(3,Integer.parseInt(age));
            stmt.setInt(5,Integer.parseInt(phone));
            stmt.setString(6,address);
            stmt.setString(8,pass);
            stmt.setString(9,"true");
            stmt.executeUpdate();
            
            
        } catch(Exception e) {
            System.out.println("Cust enter excp");
        }
        
    }
    
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
                System.out.println(str1+str2);
                stat=conn.prepareStatement("UPDATE customer SET status='false' where login_name=? and password=?");
                stat.setString(1,uname);
                stat.setString(2,pass);
                stat.executeUpdate();
                return 1;
            }//if
            
        }//while
        return 0;
/*if(f==1)
{
System.out.println("User deactivated");
}//if
else
{
System.out.println("Cannot be deactivated");
}//else*/
        
    }//databasesearch
    
    public static int Search(String uname) throws Exception {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery("select login_name from customer ");
        while(rs.next()) {
            if(rs.getString(1).equals(uname)==true)
                return 1;
        }
        return 0;
    }//Search method
}//class
