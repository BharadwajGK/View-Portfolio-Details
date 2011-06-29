package Sample;

public class Instance
{
    String str;
    int ival;
    double dval;
    public String fullstr=" ";
    java.sql.Date bdate;
    
    public void printExactValue(Object val)
    {
        if(val instanceof String)
        {
            str=(String)val; 
            fullstr+=str+" ";
        }//if
            // System.out.println("String");
        if(val instanceof Integer){
            
     
             ival=(Integer)val;//System.out.println("Int");
              fullstr+=ival+" ";
        }//if
             
        if(val instanceof Double){
            
              dval=(Double)val;//System.out.println("double");
               fullstr+=dval+" ";
        }//if
        if(val instanceof java.sql.Date){
            bdate=(java.sql.Date)val;
            fullstr+=bdate.toString()+" ";
            System.out.println(bdate);
            
        }
    }
    public static void main(String []a)
    {
        new Instance().printExactValue(new java.sql.Date(2,3,4));
        
    }
}
