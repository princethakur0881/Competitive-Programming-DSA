import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            char lastChar = s.charAt(n - 1);
            
            if (lastChar == '0') {
                // If it ends in '0', the final string must be all '0's.
                // Count all '1's that need to be overwritten.
                int countOnes = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        countOnes++;
                    }
                }
                System.out.println(countOnes);
            } else {
                // If it ends in '1', find the optimal split point to maximize kept characters.
                int maxKept = 0;
                
                for (int i = 0; i < n; i++) {
                    int zerosBefore = 0;
                    int onesAfter = 0;
                    
                    // Count '0's before index i
                    for (int j = 0; j < i; j++) {
                        if (s.charAt(j) == '0') {
                            zerosBefore++;
                        }
                    }
                    
                    // Count '1's from index i to the end
                    for (int j = i; j < n; j++) {
                        if (s.charAt(j) == '1') {
                            onesAfter++;
                        }
                    }
                    
                    int currentKept = zerosBefore + onesAfter;
                    if (currentKept > maxKept) {
                        maxKept = currentKept;
                    }
                }
                
                System.out.println(n - maxKept);
            }
        }
        
        sc.close();

	}
}
