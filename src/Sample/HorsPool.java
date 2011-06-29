
package Sample;

public class HorsPool{
    public static boolean search(String p,String t){
        int n=t.length();
        int m=p.length();
        for(int i=0;i<=n-m;i++){
            int j=0;
            while(j<m && (p.charAt(j)==t.charAt(i+j)) )
                j=j+1;
            
            if(j==m){
                
                return true;
            }
           
            
        }//for
       return false;
        
    }//search
 
    public static String[] removeDuplicatesFromArray(String [] firstArray){
        //String firstArray[]={"kiran","suma","Savi","Mohan","kiran","suma" };
        String secondArray[]=new String[firstArray.length];
        for(int i=0;i<secondArray.length;i++){
            secondArray[i]=" ";
        }//for
        int next=0;
        for(int i=0;i<firstArray.length;i++){
            int found=0;
            for(int j=0;j<secondArray.length;j++){
                
                if(secondArray[j].equals(firstArray[i])==true){
                    found=1;
                }//if
            }//for j
            if(found==0){
                secondArray[next]=firstArray[i];
                next++;
            }//if
        }//for i
        
        //for(int i=0;i<secondArray.length;i++)
          //  System.out.println(secondArray[i]);
        firstArray=secondArray;
        return firstArray;
        
    }//fun
    
    
    public static boolean searchArray(String[] arr,String str){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(str)==true) return true;
        }//for i
        return false;
    }
    
    public static int searchArr(String[] arr,String str){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(str)==true) return i;
        }//for i
        return -1;
    }
    public static void main(String[]a){
        //implementing Horspools Algorithm to search a pattern in a Given Text;
        String repeated[]={"kiran","suma","suma","kiran","Savi","Mohan","Mohan","Akka","Amma","Prabha"};
        String [] unique=removeDuplicatesFromArray(repeated);
        for(int i=0;i<unique.length;i++)
            System.out.println(unique[i]);
         System.out.println(searchArray(repeated,"Mohan" ) );   
        System.out.println("suma found in array is "+searchArray(repeated,"suma"));
        
    }
}