import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	  Scanner sc = new Scanner(System.in);
        
      
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int firstOdd = -1;
            int lastOdd = -1;
            int oddCount = 0;
            
      
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                
                if (num % 2 != 0) {
                    oddCount++;
                    if (firstOdd == -1) {
                        firstOdd = i; 
                    }
                    lastOdd = i; 
                }
            }
            
  
            if (oddCount % 2 == 0) {
                System.out.println(n);
            } 
           
            else {
                int option1 = lastOdd;        
                int option2 = n - 1 - firstOdd; 
                
                System.out.println(Math.max(option1, option2));
            }
        }
        
        sc.close();

	}
}
