
package Experiments;

public class Sampledate {
    
    
    public static void main(String [] args){
        String date="2/2/2";
        String  dateArr[]=date.split("/");
        int f=0;
       
            for(int i=0;i<dateArr.length;i++){
                
                try{
                   int val=Integer.parseInt(dateArr[i]);
                }
                catch(Exception ie){
                    f=1;
                }
                
            }//for i
            
        
        if(f==1)
             System.out.println("invalid date");
    }//main
} 