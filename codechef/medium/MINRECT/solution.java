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
            int m = sc.nextInt();
            
            int minRow = n, maxRow = -1;
            int minCol = m, maxCol = -1;
            
            for (int i = 0; i < n; i++) {
                String rowStr = sc.next();
                for (int j = 0; j < m; j++) {
                    if (rowStr.charAt(j) == '1') {
                        // Update the bounding box boundaries
                        if (i < minRow) minRow = i;
                        if (i > maxRow) maxRow = i;
                        if (j < minCol) minCol = j;
                        if (j > maxCol) maxCol = j;
                    }
                }
            }
            
            // Calculate height and width of the bounding box
            int height = maxRow - minRow + 1;
            int width = maxCol - minCol + 1;
            
            // Output the minimum area
            System.out.println(height * width);
        }
        
        sc.close();

	}
}
