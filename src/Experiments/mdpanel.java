
package Experiments;


import Sample.HorsPool;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import database.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;

    



public class mdpanel extends JFrame{
   String tableName;
   int col;
   String[] list;
   String columnHeaderName;
   SampleDB db=new SampleDB();
   LinkedList countlist=new LinkedList();
   String userName;
   String uid;
   final JButton proceed=new JButton("Prcoceed >>>");
   JButton[] jrbs;    
   int count =0 ;
  // JList jlist=new JList();
   
   LinkedList lnList[]=new LinkedList[100];
  
   
   int c1,c2;
   String []DedicatedList;
   static Object[][] data=new Object[1000][100];
   static String [] s_colheads={"Company","Quantity","AvgPrice","Type","BuyDate","Broker"};
   static String[] s_dbnames ={"name_of_stocks","quantity","avg_price","type","buy_date","broker_name"};
   static String[] m_colheads={"SCHEME_NAME","NO_OF_UNITS","AVG_PRICE","BUY_DATE","FOLIO_NO","AGENT_CODE"};
   static String[] m_dbnames={"SCHEME_NAME","NO_OF_UNITS","AVG_PRICE","BUY_DATE","FOLIO_NO","AGENT_CODE"}; 
   static String[] b_colheads={"Commodity","Quantity","Buy_Date","Pur_Price"};
   static String[] b_dbnames={"Commodity","Quantity","BUY_DATE","PUR_PRICE"};
   static String[] p_colheads={"TYPE  ","LOCATION","PURCHASE_PRICE","PURCHASE_DATE","LATEST_VALUE"};
   static String[] p_dbnames={"TYPE  ","LOCATION","PURCHASE_PRICE","PURCHASE_DATE","LATEST_VALUE"};
   static String[] l_colheads={"TYPE  ","AMOUNT","INTEREST","EMI_START","EMI","TENURE"};
   static String[] l_dbnames={"TYPE  ","AMOUNT","INTEREST","EMI_START","EMI","TENURE"};
   static String[] f_colheads={"SCHEME_NAME  ","AMOUNT","DATES ","PERIOD","INTEREST","FOLIO_NO"};
   static String[] f_dbnames={"SCHEME_NAME  ","AMOUNT","DATES ","PERIOD","INTEREST","FOLIO_NO"};
   static String[] colheads;
   static String[] dbnames;
   static String sc0; 
   public static int rowNumber;
           
     
   public static JTable jtb;
  
   
   mdpanel ref=this;
   Stocks_Modify_Panel smp=new Stocks_Modify_Panel(ref);
   Property_Modify_Panel pmp=new Property_Modify_Panel(ref);
   Loan_Modify_Panel lmp=new Loan_Modify_Panel(ref);
   Bullion_Modify_Panel bmp=new Bullion_Modify_Panel(ref);
   FI_Modify_Panel fmp=new FI_Modify_Panel(ref);
   final MF_Modify_Panel mmp=new MF_Modify_Panel(ref);

    private JTable table;

   JButton invest; 
   public mdpanel(){ }
   public static void setTabColNames(String table)
   {
       //stocks...............
       if(table.equals("stocks_trans"))
       {
           colheads=s_colheads;
           dbnames=s_dbnames;
           //smp.setVisible(true);
       }
       
       //mutual_funds..............
       if(table.equals("mf_trans"))
       {
           colheads=m_colheads;
           dbnames=m_dbnames;
          
       }
       
        jtb=new JTable(data,colheads);
       //jtb=ref;
        
        //bullion..............
        if(table.equals("bullion_trans"))
       {
           colheads=m_colheads;
           dbnames=m_dbnames;
       }
       
        
        
        //property..................
        if(table.equals("property_trans"))
       {
           colheads=m_colheads;
           dbnames=m_dbnames;
       }
       
        
        
        //loan..........................
        if(table.equals("loan_trans"))
       {
           colheads=m_colheads;
           dbnames=m_dbnames;
       }
       
        
        
        //fixed_income................
        if(table.equals("fi_trans"))
       {
           colheads=m_colheads;
           dbnames=m_dbnames;
       }
       
       jtb=new JTable(data,colheads); 
        
       
   }
   
   public mdpanel(String title){
      
        smp.setVisible(false);
        for(int i=0;i<100;i++)
            lnList[i]=new LinkedList();
       jtb.isCellEditable(1,1);
         final mdpanel re=this;  
        
         //add events to jtb.....
       jtb.setShowGrid(false);
       jtb.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e) {
                
                if(e.getType()==TableModelEvent.UPDATE){
                    String cval=(String) jtb.getModel().getValueAt(e.getFirstRow(),e.getColumn());
                    System.out.println(jtb.getModel().getValueAt(e.getFirstRow(),e.getColumn()) ) ;
                    String colname=jtb.getModel().getColumnName(e.getColumn());
                    System.out.println("changed column is " +jtb.getModel().getColumnName(e.getColumn()));
                    String dcolname=dbnames[e.getColumn()];
                    System.out.println("column to update in DB "+dbnames[e.getColumn()]);
                    
                    //System.out.println("the updated value is "+jt.getValueAt(jt.getRowCount(),jt.getColumnCount()) );
                    System.out.println("updating.....");
                }
                if(e.getType()==TableModelEvent.DELETE){
                    System.out.println("deleted");
                   jtb.isCellEditable(1,2);
                }
            }
             
         });
         
           
         //Using selection event on JTable using mouse events..........................
         
        //Selection of mouse event on JTable is workin..................... 
         jtb.addMouseListener( new MouseAdapter()
        {
	public void mouseClicked( MouseEvent e )
	{
		try{// Left mouse click
		if ( SwingUtilities.isLeftMouseButton( e ) )
		{
			
                    // get the coordinates of the mouse click
			Point p = e.getPoint();
                        // get the row index that contains that coordinate
			rowNumber = jtb.rowAtPoint( p );
                        System.out.println(rowNumber);
                        //String colNumber=jtb.getColumnName(3);
                        //System.out.println(colNumber);
                        //int col=jtb.getColumnCount();
                        //System.out.println(col);
                        
                        //sc1-stocks_col:1...sc2-stocks_col:2...sc3-stocks_col:3..sc4-stocks_col:3
                         sc0=(String)jtb.getModel().getValueAt(rowNumber,0);
                        String sc1=(String)jtb.getModel().getValueAt(rowNumber,1);           
                        System.out.print(sc1+" ");
                        String sc2=(String)jtb.getModel().getValueAt(rowNumber,2);
                        System.out.print(sc2+" ");
                        String sc3=(String)jtb.getModel().getValueAt(rowNumber,3);
                        System.out.print(sc3+" ");
                        String sc4=(String)jtb.getModel().getValueAt(rowNumber,4);
                        System.out.print(sc4+" ");
                        String sc5=(String)jtb.getModel().getValueAt(rowNumber,5);
                        System.out.print(sc5+" ");
                        String sc6=(String)jtb.getModel().getValueAt(rowNumber,6);
                        System.out.print(sc6+" ");
                        
                       //stocks.....settings......................
                        Stocks_Modify_Panel.quant.setText(sc1);
                        Stocks_Modify_Panel.avg_price.setText(sc2);
                        Stocks_Modify_Panel.dates.setText(sc4);
                        //Stocks_Modify_Panel.jcb1.setSelectedIndex((String)sc3);
                        Stocks_Modify_Panel.broker.setText(sc5);
                        Stocks_Modify_Panel.quant.setForeground(Color.WHITE);
                        Stocks_Modify_Panel.quant.setBackground(Color.BLACK);
                        Stocks_Modify_Panel.avg_price.setFont(new Font("Quantity",Font.LAYOUT_RIGHT_TO_LEFT,13));
                        
                        //mutual_funds....settings................
                        MF_Modify_Panel.quant.setText(sc1);
                        MF_Modify_Panel.avg_price.setText(sc2);
                        MF_Modify_Panel.dates.setText(sc3);
                        MF_Modify_Panel.folio_no.setText(sc4);
                        MF_Modify_Panel.agent.setText(sc5);
                        
                        
                        //Stocks_Modify_Panel.jcb1.setSelectedIndex(2);
                        //int count=1;
                       //for(int j=0;j<50;j++)
                        //{
                                 //jtb.getModel().setValueAt(1,0,6);
                                 //jtb.setValueAt(2,1,6);
                                 //++count;
                        //}
                            mmp.setVisible(true);                       
                     /*  
                        for(int i=1;i<jtb.getColumnCount();i++)
                        {
                             a[i]=(String)jtb.getModel().getValueAt(rowNumber,i);
                            System.out.println(a[i]+" ");
                        }
                           */
			// Get the ListSelectionModel of the JTable
			//ListSelectionModel model = jtb.getSelectionModel();
 
			// set the selected interval of rows. Using the "rowNumber"
			// variable for the beginning and end selects only that one row.
			//model.setSelectionInterval( rowNumber, rowNumber );
		}
		// Right mouse click
		else if ( SwingUtilities.isRightMouseButton( e ))
		{
			/*// get the coordinates of the mouse click
			Point p = e.getPoint();
 
			// get the row index that contains that coordinate
			int rowNumber = jtb.rowAtPoint( p );
                        System.out.println(rowNumber);
 
			// Get the ListSelectionModel of the JTable
			ListSelectionModel model = jtb.getSelectionModel();
 
			// set the selected interval of rows. Using the "rowNumber"
			// variable for the beginning and end selects only that one row.
			model.setSelectionInterval( rowNumber, rowNumber );
                         */
                    JOptionPane.showMessageDialog(null,"Invalid Selection","Invalid click",JOptionPane.ERROR_MESSAGE);
		}
                }//try
                catch(Exception ie)
                {
                    System.out.println("Excp:"+ie);
                }
	}
});//Selection of mouse event on JTable is workin..................... 




         
         /*class JTable extends DefaultTableModel{
                public boolean isCellEditable(int r,int c)
                {
                    return false;
                }
         }
         
        */
        //jtb.getModel().isCellEditable(1,1);
        // jtb.setSelectionMode(1);
        this.setSize(1024,768);
        this.setVisible(true);
        this.setTitle(title);
        //this.setLocation(200,100);
        JPanel mpanel=new JPanel(new GridLayout(1,2,4,4));
        JPanel MainPanel=new JPanel();
         this.setLayout(new BorderLayout());
              
       this.setTableName("mf_trans");
       this.setColumn(3);
       System.out.println("printin all list");
       String []list=this.getList(this.tableName,this.col);
        for(int i=0;i<list.length;i++){
            list[i]=list[i].trim();
            System.out.println(list[i]);
        } 
        System.out.println("after all list");
        //take a scrollpane.....
         JPanel lpanel=new JPanel(new BorderLayout());
         JScrollPane jsp=new JScrollPane(lpanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         int row=list.length;
       
         jrbs=new JButton[list.length];
         ButtonGroup bg=new ButtonGroup();
        
        
        
       //take handler here....
        //RbuttonHandler rbh=new RbuttonHandler(this);
        ActionHandler ac=new ActionHandler(this);
        /*for(int i=0;i<list.length;i++){
            if(list[i].equals("")==false){
            jrbs[i]=new JButton(list[i]);
            //add listener to RadioButtons......
           // jrbs[i].addItemListener(rbh);//jrbs[i].addActionListener(ac);
            
            jrbs[i].addActionListener(ac);
            
            lpanel.add(jrbs[i]);
            bg.add(jrbs[i]);
            }//if
            
        }//for i
        
        */
      invest=new JButton("\n\nStockInvestments\n\n");  
      JPanel nnpanel=new JPanel(new GridLayout(3,1) );
      nnpanel.add(new JPanel());
      nnpanel.add(new JPanel());
      JPanel nspanel=new JPanel();
      nspanel.add(invest);
      nnpanel.add(nspanel);
      lpanel.add(nnpanel,BorderLayout.NORTH);
      JPanel sspanel=new JPanel(new GridBagLayout());
      sspanel.add(mmp);
      
      
      lpanel.add(sspanel,BorderLayout.CENTER);
      invest.addActionListener(ac);
        //add events to proceed....
        
        
        //proceed.setEnabled(true);
        //proceed.addActionListener(new ActionListener(){
           //public void actionPerformed(ActionEvent ae){
               
               
            smp.setVisible(true);//.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
           
           //} 
       // });
           mpanel.add(jsp);
           JScrollPane js=new JScrollPane(this.jtb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
           mpanel.add(js);
           JPanel spanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
           spanel.add(proceed);
           MainPanel.add(mpanel);
           this.getContentPane().add(mpanel,BorderLayout.CENTER);
           this.getContentPane().add(spanel,BorderLayout.SOUTH);
        
        
        //get the dedicated list now....
           //this.getDedicatedList("stocks_trans",3,2,"suma");
           /*System.out.println("in con");
           for (int i=0;i<this.lnList.length;i++){
               for(int j=0;j<this.lnList[i].size();j++){
                   System.out.println(this.lnList[i].get(j));
               }//for j
               
           }//for i
        */
           
      
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
            
        }catch(Exception ie){}
        
        
    }//con
//create handler class here dude ....
    class RbuttonHandler implements ItemListener{
        
        mdpanel ref;
        public  RbuttonHandler(mdpanel ref){
            this.ref=ref;
        }
        public void itemStateChanged(ItemEvent ie){
            
            String comp=((JRadioButton)ie.getSource()).getActionCommand();
            System.out.println("Comp is:"+" "+comp);
            ref.getDedicatedList("mf_trans",3,2,"kiran");
           // System.out.println("Dedicated list is" );
           // for(int i=0;i<arr.length;i++)
         //  {
              // System.out.println(arr[i]);
               //data[i][0]=arr[i];
              // jta.append(arr[i]+"\n");
               
         //  }
           // jlist.setListData(ref.DedicatedList);
            
        }//handler...
    }//RbuttonHandler...
    
     class ActionHandler implements ActionListener{
        
        mdpanel ref;
        public  ActionHandler(mdpanel ref){
            this.ref=ref;
        }
        public void actionPerformed(ActionEvent ae){
            
            String comp=ae.getActionCommand();
           
            ref.getDedicatedList("mf_trans",3,2,"kiran");
            
            
            
        }//handler...
    }//RbuttonHandler...
    
    
    public void setTableName(String tableName){
        this.tableName=tableName;
       
    }//setTableName()...
   
    public void setColumn(int col){
        this.col=col;
        
        
    }//setColumn()..
    
    public String[] getList(){
         list=db.getList(tableName,col);
         
         list=HorsPool.removeDuplicatesFromArray(list);
         for(int i=0;i<list.length;System.out.println(list[i++]) ) ; 
         return list;
        
    }//getList()...
    
    public String[] getList(String tableName, int col){
         list=db.getList(tableName,col);
         //convert all to uppercase dude...
         for(int i=0;i<list.length;list[i]=list[i++].toUpperCase() ) ;
         list=HorsPool.removeDuplicatesFromArray(list);
         
         //list=HorsPool.removeDuplicatesFromArray(list);
         //for(int i=0;i<list.length;System.out.println(list[i++]) ) ; 
         return list;
        
    }//getList(tableName,col)...
   
    public String getColumnHeader(){
        
        columnHeaderName=db.getColumnHeaderName(this.tableName,this.col);
        return columnHeaderName;
    }//getColumnHeaderName()
   
    public String getUserColumnHeaderName(int col){
        this.col=col;
        userName=db.getColumnHeaderName(this.tableName,this.col);
        return userName;
        
    }
    
    public Object [] getCounts(){
        
        String userName=this.getUserColumnHeaderName(7);
        System.out.println(userName);
        for(int i=0;i<this.list.length;i++){
            
            String qry="select count(*) from "+this.tableName+" where "+
                    this.columnHeaderName+"= '"+list[i]+"'";
            int count=db.getCount(qry);
            System.out.println(count);
            
            countlist.addLast(count);
        }//for i
        return (Object[])countlist.toArray();
        
        
    }//getCounts()....
    
    
    String getUserid(String uname){
         
         this.uid=db.getUserid(uname);
         return this.uid;
            
    }
    
    //c2--login name...c1--list company criteria.....
    public void getDedicatedList(String table,int c1,int c2,String uname){
       
        
  
        this.tableName=table;
        
        System.out.println("printing  in mdpanel getD");
       String []list=this.getList(table,c1);
       for(int i=0;i<list.length;System.out.println(list[i++]) );  
       
       String fcol=this.getUserColumnHeaderName(c1);
       System.out.println("printing c1 " +fcol);
       String scol=this.getUserColumnHeaderName(c2);
       System.out.println("printing c2 " +scol);
       String uid=this.getUserid(uname);
       System.out.println("printing c2 " +uid);
       
        LinkedList lsw=new LinkedList();
       
      for(int i=0;i<list.length;i++){
       String qry="select * from "+table+" where "+fcol+
               "="+"'"+list[i]+"'"+" AND "+scol+"='"+uid+"'";
             System.out.println();
            String [] ls=db.getList(qry);
            for(int j=0;j<ls.length;j++){
                //this.lnList[count].addLast(ls[j]);
                System.out.println(ls[j]);
               lsw.addLast(ls[j]);
               
            }
            
          //jlst.setListData((String[] )ls);
     
          
       }//for i
       
    for(int i=0;i<lsw.size();i++){
           String lt=(String)lsw.get(i);
           lt=lt.trim();
           String arrList[]=lt.split(" ");
           for(int j=0;j<arrList.length;j++){
               data[i][j]=arrList[j];
               //this.jtb.setValueAt(arrList[i],j,i);
           }//for j
       }//for i  
    }//getDedicatedList.... 

    
    
    
     public String[] getDedicatedList(String comp,String table,int c1,int c2,String uname){
        LinkedList lsw=new LinkedList();
        this.tableName=table;
        String []ls=new String[100];
       String []list=this.getList(table,c1);
       String fcol=this.getUserColumnHeaderName(c1); System.out.println("printing c1 " +fcol);
       String scol=this.getUserColumnHeaderName(c2); System.out.println("printing c1 " +scol);
       String uid=this.getUserid(uname); System.out.println("printing c1 " +uid);
       this.list=list;
       for(int i=0;i<list.length;i++){
          
               //System.out.println("kiran"+list[i]);
          String qry="select * from "+table+" where "+fcol+
               "="+"'"+list[i]+"'"+" AND "+scol+"='"+uid+"'";
             System.out.println();
           ls =db.getList(qry);
            for(int j=0;j<ls.length;j++){
               if(ls[j].length()!=0){
              //System.out.println(ls[j]);
                lsw.addLast(ls[j]);
               }//if
                //data[j][0]=ls[j];
           //jta.append(ls[j]);
            }
             
           
       }//for i
      
      //System.out.println((String)lsw.getFirst());
       //this.jlst.setListData(( String[]) lsw.toArray(new String[0]) );
       for(int i=0;i<lsw.size();i++){
           String lt=(String)lsw.get(i);
           lt=lt.trim();
           String arrList[]=lt.split(" ");
           for(int j=0;j<arrList.length;j++){
               data[i][j]=arrList[j];
               //this.jtb.setValueAt(arrList[i],j,i);
           }//for j
       }//for i
       return ls;
    }//getDedicatedList.... 
    
    
    public void getDedicatedList(){
       
       
        
       String []list=this.getList(this.tableName,this.c1);
       String fcol=this.getUserColumnHeaderName(this.c1);
       String scol=this.getUserColumnHeaderName(this.c2);
       String uid=this.getUserid(this.userName);
       
       for(int i=0;i<list.length;i++){
       String qry="select * from "+this.tableName+" where "+fcol+
               "="+"'"+list[i]+"'"+" AND "+scol+"='"+uid+"'";
             System.out.println();
            String []ls=db.getList(qry);
            for(int j=0;j<ls.length;j++){
                System.out.println(ls[j]);
            }
       
               
       }//for i
    }//getDedicatedList....
    
    
    public void setValues(String table,int c1,int c2,String uname){
        this.tableName=table;
        this.c1=c1;
        this.c2=c2;
        this.userName=uname;
    }
    
   public static void main(String []a ){
      // mdpanel md=new mdpanel();
      //md.setTableName("stocks_trans");
      // md.setColumn(3);
       //String list[]= md.getList();
       //md.getColumnHeader();
     //  md.getCounts();
     //  System.out.println("uid is "+md.getUserid("suma"));
      //md.getDedicatedList("stocks_trans",3,2,"suma");
       mdpanel.setTabColNames("mf_trans");
       
       
       mdpanel md=new mdpanel("bhaja");
        md.getDedicatedList("mf_trans",1,2,"guru");
      // mdpanel md=new mdpanel();
       //md.setValues("stocks_trans",3,2,"suma");
     
       
       //md.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
     
       //new mdpanel().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
   }//main
}//class