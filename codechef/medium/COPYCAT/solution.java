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
            
            // Find the 0-based index of the last '0' in the string
            int lastZeroIndex = s.lastIndexOf('0');
            
            int operations = 0;
            // Count all '1's that appear before this last '0'
            for (int i = 0; i < lastZeroIndex; i++) {
                if (s.charAt(i) == '1') {
                    operations++;
                }
            }
            
            System.out.println(operations);
        }
        
        sc.close();

	}
}
