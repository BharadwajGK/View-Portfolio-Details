package database;


import Experiments.mdpanel;
import java.io.Reader;
import java.sql.*;
import javax.sql.*;
import java.util.LinkedList;

import Sample.*;




public class SampleDB{
    
    int row_len;
    public int ssid;
    public String ccid; 
    
    
    //stocks declration........
    int  sid;
    String cid;
    String company;
    String  quantity;
    String amount;
    String type;
    String buyString;   
    String sellString;
    String sellPrice; 
    String brokers;
    String table;
    int col;
    String uid;
    
    //mf declaration.....
    int mfid;
    String mf_cid;
    String mf_scheme_name;
    String  mf_quantity;
    String mf_amount;
    String mf_agent;
    String mf_buyDate;
    String mf_sellDate;
    String mf_sellPrice;
    String mf_folio;
    
    //bullion declaration.........
    int bullionid;
    String bullion_cid;
    String bullion_commodity;
    String bullion_qty;
    String bullion_amt;
    String bullion_agent;
    String bullion_buyDate;
    String bullion_sellDate;
    String bullion_sellPrice;
    
    //loan declarations..........
    int loanid;
    String loan_cid;
    String loan_type;
    String loan_int;
    String loan_amt;
    String loan_emiDate;
    String loan_emi;
    String loan_dur;
    
    //property dedlarations................
    int pid;
    String p_cid;
    String p_type;
    String p_loc;
    String p_amt;
    String p_date;
    String p_latestvalue;
      
     public static  int admin_Search_customer(String uname) throws Exception {
        Connection conn;
        Statement stmt;
        PreparedStatement stat;
        ResultSet rs;
        
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery("select login_name from customer");
        
        while(rs.next()) {
            if(rs.getString("login_name").equals(uname)==true){
               
              return 1;
           }//if
        }
        //System.out.println("does not exists");
       
        stmt.close();
        conn.close();
       return 0;
    }//Search method
    
     public int  admin_get_sid(String cname) throws Exception {
         
         Connection conn;
         Statement stmt;
         PreparedStatement stat;
         ResultSet rs;
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        System.out.println(cname);
        rs=stmt.executeQuery("select stockid from stocks where company='"+cname+"'");
        //System.out.println("kiran");
        rs.next();
        int val= rs.getInt(1);
        stmt.close();
        conn.close();
        return val;
        
                   
         
     } //admin_get_sid
     
     //for mf...............
     public int  admin_get_mfid(String sname) throws Exception {
         
         Connection conn;
         Statement stmt;
         PreparedStatement stat;
         ResultSet rs1;
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        System.out.println(sname);
        rs1=stmt.executeQuery("select mfid from mf where scheme_name='"+sname+"'");
        System.out.println("kiran");
        rs1.next();
        int val= rs1.getInt(1);
        stmt.close();
        conn.close();
        return val;
        
                   
         
     } //admin_get_mfid
     
     //for bullion...............
     public int  admin_get_bid(String bname) throws Exception {
         
         Connection conn;
         Statement stmt;
         PreparedStatement stat;
         ResultSet rs;
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        System.out.println(bname);
        rs=stmt.executeQuery("select bullionid from bullion where commodity='"+bname+"'");
        //System.out.println("kiran");
        rs.next();
        int val= rs.getInt(1);
        stmt.close();
        conn.close();
        return val;
        
                   
         
     }//admin_bid..............
     
     
     //admin_get_lid........................
     public int  admin_get_lid(String lname) throws Exception {
         
         Connection conn;
         Statement stmt;
         PreparedStatement stat;
         ResultSet rs;
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        System.out.println(lname);
        rs=stmt.executeQuery("select loanid from loan where loan_type='"+lname+"'");
        //System.out.println("kiran");
        rs.next();
        int val= rs.getInt(1);
        stmt.close();
        conn.close();
        return val;
        
          
     }
     
     //admin_get_lid........................
     public int  admin_get_pid(String pname) throws Exception {
         
         Connection conn;
         Statement stmt;
         PreparedStatement stat;
         ResultSet rs;
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        System.out.println(pname);
        rs=stmt.executeQuery("select propertyid from property where type='"+pname+"'");
        //System.out.println("kiran");
        rs.next();
        int val= rs.getInt(1);
        stmt.close();
        conn.close();
        return val;
        
          
     }
//pid.......................
     
     //get customer id.......................
      public void admin_get_cid(String lname){
         try{
         Connection conn;
         Statement stmt;
         PreparedStatement stat;
         ResultSet rs;
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        //stmt=conn.createStatement();
        stat=conn.prepareStatement("Select custid from customer where login_name=?");
        stat.setString(1,lname);
        System.out.println(lname);
        //rs=stmt.executeQuery("select custid from customer where login_name='"+lname+"'");
        rs=stat.executeQuery();
        rs.next();
        ccid=rs.getString(1);
        System.out.println(ccid);
        
        stat.close();
        conn.close();
         }
         catch(Exception ie){
          System.out.println("some exception here "+ie); }
         
         
         
     } //admin_get_cid
      
      
    //workin.................... 
    public void admin_stocks_trans_display(){
        try{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery("select * from stocks_trans");
 
        while(rs.next()) {
           sid=rs.getInt(1);
           cid=rs.getString(2);
           company=rs.getString(3);
           quantity=rs.getString(4);
           amount=rs.getString(5);
           type=rs.getString(6);
           buyString=rs.getString(7);
           sellString=rs.getString(8);
           sellPrice=rs.getString(9);
           brokers=rs.getString(11);
                 
              
        row_len++;       
        }//while
        
        stmt.close();
        conn.close();
      }
      catch(Exception ie){
      System.out.println("some esception here "+ie);
      }
        
        
    }//admin_stocks_trans_display()
     
    
    
    //workin...................
     //admin_mf_trans_display..............
    public void admin_mf_trans_display(){
        try{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery("select * from mf_trans");
        //rs.next();
        System.out.println("10");
        //rs.next();
        while(rs.next()) {
            System.out.println("1fsfsdf");
           mfid=rs.getInt(1);System.out.println("1");System.out.println(mfid);
           mf_cid=rs.getString(2);System.out.println("2");System.out.println(mf_cid);
           mf_scheme_name=rs.getString(3);System.out.println("3");System.out.println(mf_scheme_name);
           mf_quantity=rs.getString(4);System.out.println("4");System.out.println(mf_quantity);
           mf_amount=rs.getString(5);System.out.println("5");System.out.println(mf_amount);
           mf_buyDate=rs.getString(6);System.out.println("6");System.out.println(mf_buyDate);
           mf_folio=rs.getString(7);System.out.println("7");System.out.println(mf_folio);
           mf_agent=rs.getString(8);System.out.println("8");System.out.println(mf_agent);
           mf_sellPrice=rs.getString(9);System.out.println("9");System.out.println(mf_sellPrice);
           mf_sellDate=rs.getString(10);System.out.println("0");System.out.println(mf_sellDate);
                   
        row_len++;       
        }//while
         
        //System.out.println(rs.getInt(3));
        stmt.close();
        conn.close();
      }//try
      catch(Exception ie){
      System.out.println("some exception here");
      }
        
        
    }//admin_mf_trans_display()
    
    
    
      //bullion-----display()
   
      public void admin_bullion_trans_display(){
        
        try{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();System.out.println("10");
        rs=stmt.executeQuery("select * from bullion_trans");System.out.println("10");
        //rs.next();
        System.out.println("10");
        //rs.next();
        while(rs.next()) {
            System.out.println("1fsfsdf");
           bullionid=rs.getInt(1);System.out.println("1");System.out.println(bullionid);
           bullion_cid=rs.getString(2);System.out.println("2");System.out.println(bullion_cid);
           bullion_commodity=rs.getString(3);System.out.println("3");System.out.println(bullion_commodity);
           bullion_qty=rs.getString(4);System.out.println("4");System.out.println(bullion_qty);
           bullion_buyDate=rs.getString(5);System.out.println("5");System.out.println(bullion_buyDate);
           bullion_amt=rs.getString(6);System.out.println("6");System.out.println(bullion_amt);
           bullion_sellDate=rs.getString(7);System.out.println("7");System.out.println(bullion_sellDate);
           bullion_sellPrice=rs.getString(8);System.out.println("8");System.out.println(bullion_sellPrice);
           
          
                
        row_len++;       
        }//while
         
        //System.out.println(rs.getInt(3));
        stmt.close();
        conn.close();
      }//try
      catch(Exception ie){
      System.out.println("some exception here");
      }
        
        
    }//bullion display()
    
    
      //loan_display()
      public void admin_loan_trans_display(){
        
        try{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();System.out.println("10");
        rs=stmt.executeQuery("select * from loan_trans");System.out.println("10");
        //rs.next();
        System.out.println("10");
        //rs.next();
        while(rs.next()) {
            System.out.println("1fsfsdf");
           loanid=rs.getInt(1);System.out.println("1");System.out.println(loanid);
           loan_cid=rs.getString(2);System.out.println("2");System.out.println(loan_cid);
           loan_type=rs.getString(3);System.out.println("3");System.out.println(loan_type);
           loan_amt=rs.getString(4);System.out.println("4");System.out.println(loan_amt);
           loan_int=rs.getString(5);System.out.println("5");System.out.println(loan_int);
           loan_dur=rs.getString(6);System.out.println("6");System.out.println(loan_dur);
           loan_emiDate=rs.getString(7);System.out.println("7");System.out.println(loan_emiDate);
           loan_emi=rs.getString(8);System.out.println("8");System.out.println(loan_emi);
           
          
                
        row_len++;       
        }//while
         
        //System.out.println(rs.getInt(3));
        stmt.close();
        conn.close();
      }//try
      catch(Exception ie){
      System.out.println("some exception here" +ie);
      }
          
    }//loan_display()
          
      
      public void admin_property_trans_display(){
        
        try{
        Connection conn;
        Statement stmt;
        ResultSet rs;
        PreparedStatement stat;
        
        
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();System.out.println("10");
        rs=stmt.executeQuery("select * from property_trans");System.out.println("10");
        //rs.next();
        System.out.println("10");
        //rs.next();
        while(rs.next()) {
            System.out.println("1fsfsdf");
           pid=rs.getInt(1);System.out.println("1");System.out.println(pid);
           p_cid=rs.getString(2);System.out.println("2");System.out.println(p_cid);
           p_type=rs.getString(3);System.out.println("3");System.out.println(p_type);
           p_loc=rs.getString(4);System.out.println("4");System.out.println(p_loc);
           p_amt=rs.getString(5);System.out.println("5");System.out.println(p_amt);
           p_date=rs.getString(6);System.out.println("6");System.out.println(p_date);
           p_latestvalue=rs.getString(7);System.out.println("7");System.out.println(p_latestvalue);
                    
        row_len++;       
        }//while
         
        //System.out.println(rs.getInt(3));
        stmt.close();
        conn.close();
      }//try
      catch(Exception ie){
      System.out.println("some exception here" +ie);
      }
          
    }
      
    //getlist ()
    public String[] getList(String tableName,int col) {
               LinkedList lst=new LinkedList();
       try{
         Connection conn;
        Statement stmt;
        PreparedStatement stat;
        ResultSet rs;
   
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");System.out.println("e1 " );
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");System.out.println("e2" );
        stmt=conn.createStatement();System.out.println("e3");
        rs=stmt.executeQuery("select * from "+tableName );System.out.println("e4");
        
        while(rs.next()) {
            lst.addLast(rs.getString(col) ) ;
        }//while
        
        stmt.close();
        conn.close();
       }//try
       catch(Exception ie){System.out.println("list exception ");
       }
              return (String[]) lst.toArray(new String[0]);
        
    }//getList()...
    
    
    //workin..................
    public void admin_insert_stocks_trans(String sid,String cid,String company,String quantity,String amount,String type,String buyDate,String sellDate,String sellPrice ,String brokers){
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_stocks_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            stmt=conn.prepareStatement("insert into stocks_trans values(?,?,?,?,?,?,?,?,?,?,?)");
           
            //stat=conn.createStatement();
            
            
         
            stmt.setInt(1,Integer.parseInt(sid)  );
            System.out.println("exe 1");
            stmt.setString(2,cid); System.out.println("exe 2");
            stmt.setString(3,company); System.out.println("exe 3");
            stmt.setString(4,quantity) ; System.out.println("exe 4");
            stmt.setString(5,amount); System.out.println("exe 5");
            stmt.setString(6,type); System.out.println("exe 6");
            stmt.setString(7,buyDate); System.out.println("exe 7");
            stmt.setString(8,sellDate); System.out.println("exe 8");
            stmt.setString(9,sellPrice) ; System.out.println("exe 9");
            stmt.setInt(10,++row_len); System.out.println("exe 10");
            stmt.setString(11,brokers);System.out.println("exe 11");
            stmt.executeUpdate();
            System.out.println("exe 11");
                        
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }
    
    
  //workin................  
    public void admin_insert_mf_trans(String mfid,String mf_cid,String mf_scheme_name,String mf_quantity,String mf_amount,String mf_buyDate,String mf_folio,String mf_agent,String mf_sellPrice,String sellDate)
    {
        
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_mf_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            stmt=conn.prepareStatement("insert into mf_trans values(?,?,?,?,?,?,?,?,?,?,?)");
           
            //stat=conn.createStatement();
            stmt.setInt(1,Integer.parseInt(mfid)  );System.out.println("exe 1");
            stmt.setString(2,mf_cid); System.out.println("exe 2");
            stmt.setString(3,mf_scheme_name); System.out.println("exe 3");
            stmt.setString(4,mf_quantity  ) ; System.out.println("exe 4");
            stmt.setString(5,mf_amount); System.out.println("exe 5");
            stmt.setString(6,mf_buyDate); System.out.println("exe 7");
            stmt.setString(7,mf_folio); System.out.println("exe 6");
            stmt.setString(8,mf_agent);System.out.println("exe 11");
            stmt.setString(9,mf_sellPrice) ; System.out.println("exe 9");
            stmt.setString(10,mf_sellDate); System.out.println("exe 8");
            stmt.setInt(11,++row_len); System.out.println("exe 10");
            
            stmt.executeUpdate();
            System.out.println("exe 111");
                        
           
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }
    
    //method to get the column header name ......
    
    //workin...................................
    public void admin_insert_bullion_trans(String bullionid,String bullion_cid,String bullion_commodity,String bullion_qty,String bullion_buyDate,String bullion_amt,String bullion_sellDate,String sellPrice)
    {
        
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_bullion_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            stmt=conn.prepareStatement("insert into bullion_trans values(?,?,?,?,?,?,?,?,?)");
           
            //stat=conn.createStatement();
            
            
         
            stmt.setInt(1,Integer.parseInt(bullionid)  );System.out.println("exe 1");
            stmt.setString(2,bullion_cid); System.out.println("exe 2");
            stmt.setString(3,bullion_commodity); System.out.println("exe 3");
            stmt.setString(4,bullion_qty  ) ; System.out.println("exe 4");
            stmt.setString(5,bullion_buyDate); System.out.println("exe 5");
            stmt.setString(6,bullion_amt); System.out.println("exe 7");
            stmt.setString(7,bullion_sellDate); System.out.println("exe 6");
            stmt.setString(8,bullion_sellPrice);System.out.println("exe 11");
            stmt.setInt(9,++row_len); System.out.println("exe 10");
            stmt.executeUpdate();
            System.out.println("exe 111");
                        
           
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }//bullion_trans..........................
    
    //loan_trans....................................
    public void admin_insert_loan_trans(String loanid,String loan_cid,String loan_type,String loan_amt,String loan_int,String loan_dur,String loan_emiStart,String loan_emi)
    {
        
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_loan_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            stmt=conn.prepareStatement("insert into loan_trans values(?,?,?,?,?,?,?,?,?)");
           
            //stat=conn.createStatement();
            
            
         
            stmt.setInt(1,Integer.parseInt(loanid)  );System.out.println("exe 1");
            stmt.setString(2,loan_cid); System.out.println("exe 2");
            stmt.setString(3,loan_type); System.out.println("exe 3");
            stmt.setString(4,loan_amt  ) ; System.out.println("exe 4");
            stmt.setString(5,loan_int); System.out.println("exe 5");
            stmt.setString(6,loan_dur); System.out.println("exe 7");
            stmt.setString(7,loan_emiStart); System.out.println("exe 6");
            stmt.setString(8,loan_emi);System.out.println("exe 11");
            stmt.setInt(9,++row_len); System.out.println("exe 10");
            stmt.executeUpdate();
            System.out.println("exe 111");
                        
           
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }//loan_trans.....................................
    
    
    public void admin_insert_property_trans(String pid,String p_cid,String p_type,String p_loc,String p_amt,String p_date,String p_latestvalue)
    {
        
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_property_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            stmt=conn.prepareStatement("insert into property_trans values(?,?,?,?,?,?,?,?)");
           
            //stat=conn.createStatement();
            
            
         
            stmt.setInt(1,Integer.parseInt(pid)  );System.out.println("exe 1");
            stmt.setString(2,p_cid); System.out.println("exe 2");
            stmt.setString(3,p_type); System.out.println("exe 3");
            stmt.setString(4,p_loc) ; System.out.println("exe 4");
            stmt.setString(5,p_amt); System.out.println("exe 5");
            stmt.setString(6,p_date); System.out.println("exe 6");
            stmt.setString(7,p_latestvalue);System.out.println("exe 11");
            stmt.setInt(8,++row_len); System.out.println("exe 10");
            stmt.executeUpdate();
            System.out.println("exe 111");
                        
           
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }
    //property_trans.....................
    
    
    
    
    public String getColumnHeaderName(String table,int col ){
         this.table=table;
         this.col=col;
         
        try{
        Connection conn;
        Statement stmt;
        PreparedStatement stat;
        ResultSet rs;
                      
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();//System.out.println("Excp 1");
        rs=stmt.executeQuery("select * from "+table);
        ResultSetMetaData rmd=rs.getMetaData();
        String val=rmd.getColumnName(col);
        stmt.close();
        conn.close();
        return val;
            
        }//try
        catch( Exception ie){System.out.println("getColumnHeader exception");
        }
        return " ";        
    }//method getColumnHeadeName()...
    
    
    
    public int getCount(String qry){
        
        try{
        Connection conn;
        Statement stmt;
        PreparedStatement stat;
        ResultSet rs;
        
             
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery(qry);
        rs.next();
        int c=rs.getInt(1);
        stmt.close();
        conn.close();
        return c;
        }//try
        catch(Exception ie){
            System.out.println("getCount Exception ");
            
        }
        return 0;
    }//getCount()......
   //method getCount()....
    
    public String getUserid(String uname){
         try{
        Connection conn;
        Statement stmt;
        PreparedStatement stat;
        ResultSet rs;
        
        
 
                 
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
        stmt=conn.createStatement();
        rs=stmt.executeQuery("select custid from customer where login_name='"+uname+"'");
        rs.next();
        String u= rs.getString(1);
        stmt.close();
        conn.close();
        return u;
        }
        catch(Exception ie){
            System.out.println("getCount Exception ");
            
        }
        return " ";
    }
    
    
    public String [] getList(String qry){
        
        LinkedList list=new LinkedList();
        try{
        Connection conn;
        Statement stmt;
        PreparedStatement stat;
        ResultSet rs;
                
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//System.out.println("list44");
        conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger"); //System.out.println("list");
        stmt=conn.createStatement();
             //System.out.println("list0");
        rs=stmt.executeQuery(qry);
        //System.out.println("list1");
        ResultSetMetaData rmd=rs.getMetaData();//System.out.println("list2");
        int clen=rmd.getColumnCount();System.out.println("clen is "+clen);
        Instance in=new Instance();
        
      
        while(rs.next())
        {
           for(int i=3;i<=clen;i++){
              in.printExactValue(rs.getObject(i));
                
           }//for i  
          list.addLast(in.fullstr);
         in.fullstr=" ";
        }//while....
                 
          stmt.close();
        conn.close();
        return (String [])list.toArray(new String[0]);
        
        }//try
        catch(Exception ie){
            System.out.println("getList Exception ");
            
        }//catch...
        return new String[2];
    }//getList......
    
    
    
    //................................UPDATE MODULE.....................................
    //...................................................................................
    
    public void admin_update_stocks_trans(String sid,String cid,String quantity,String amount,String type,String buyDate,String sellDate,String sellPrice ,String brokers){
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_stocks_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            //stmt=conn.prepareStatement("insert into stocks_trans values(?,?,?,?,?,?,?,?,?,?)");
           stmt=conn.prepareStatement("update stocks_trans set quantity=?, avg_price=?, type=?, buy_date=?, broker_name=? where stock_trans_id="+(mdpanel.rowNumber+1));
            //stat=conn.createStatement();
            
            
         
            //stmt.setInt(1,Integer.parseInt(sid)  );
            //System.out.println("exe 1");
            //stmt.setString(2,cid); System.out.println("exe 2");
            stmt.setString(1,quantity) ; System.out.println("exe 4");
            stmt.setString(2,amount); System.out.println("exe 5");
            stmt.setString(3,type); System.out.println("exe 6");
            stmt.setString(4,buyDate); System.out.println("exe 7");
            stmt.setString(5,brokers);System.out.println("exe 11");
            //stmt.setInt(7,++row_len); System.out.println("exe 10");
            
            stmt.executeUpdate();
            System.out.println("exe 111");
                        
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }
    //en of stocks_update..................
    
    public void admin_update_mf_trans(String mfid,String mf_cid,String mf_quantity,String mf_amount,String mf_buyDate,String mf_folio,String mf_agent,String mf_sellPrice,String sellDate)
    {
        
        try {
            String s1;
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs;
            Statement stat;
            this.admin_mf_trans_display();
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn=DriverManager.getConnection("jdbc:odbc:PIMS","scott","tiger");
            //stmt=conn.prepareStatement("insert into mf_trans values(?,?,?,?,?,?,?,?,?,?,?)");
            stmt=conn.prepareStatement("update mf_trans set no_of_units=?, avg_price=?, buy_date=?, folio_no=?, agent_code=? where mf_trans_id="+(mdpanel.rowNumber+1));
            
            //stat=conn.createStatement();
            //stmt.setInt(1,Integer.parseInt(mfid)  );System.out.println("exe 1");
            //stmt.setString(2,mf_cid); System.out.println("exe 2");
            //stmt.setString(3,mf_scheme_name); System.out.println("exe 3");
            stmt.setString(1,mf_quantity  ) ; System.out.println("exe 4");
            stmt.setString(2,mf_amount); System.out.println("exe 5");
            stmt.setString(3,mf_buyDate); System.out.println("exe 7");
            stmt.setString(4,mf_folio); System.out.println("exe 6");
            stmt.setString(5,mf_agent);System.out.println("exe 11");
            //stmt.setInt(11,++row_len); System.out.println("exe 10");
            
            stmt.executeUpdate();
            System.out.println("exe 111");
                        
           
            stmt.close();
            conn.close();
        }//try
        catch(Exception e) {
            System.out.println("some exception "+e);
        } 
    }
    
  public static void main(String[] args) {
    
      SampleDB db=new SampleDB();
      //db.admin_get_cid("guru");
      //db.admin_bullion_trans_display();
       // new SampleDB().admin_insert_mf_trans("2","2","RELIANCE","420","1233","4/4/4","456589",null,null,null);
      
     //new SampleDB().admin_insert_mf_trans("1","1","TATA","100","1200","12-APR-2009","jshd","hf66","1234","12-apr-2010","1");
}//main

    /*public void insert_stocks_trans(String string, String string0, String shares_name, String qty, String amt, String type, String dat1, String string1, String string2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }*/

   /* private void admin_insert_mf_trans(String string, String string0, String string1, String string2, String string3, String string4, Object object, Object object0, Object object1, Object object2, String string5) {
        throw new UnsupportedOperationException("Not yet implemented");
    }*/
  
}//class





/*class Sqldemo {
    
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
            stmt.executeUpString();
            
            
        } catch(Exception e) {
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
                stat=conn.prepareStatement("UPString customer SET status='false' where login_name=? and password=?");
                stat.setString(1,uname);
                stat.setString(2,pass);
                stat.executeUpString();
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
        
 /*   }//databasesearch
    
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
    */

