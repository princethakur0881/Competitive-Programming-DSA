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
            long x = sc.nextLong();
            long y = sc.nextLong();
            long d = sc.nextLong();
            
            // Start both alarms at their first ring time
            long timeX = x;
            long timeY = y;
            
            while (true) {
                // If Alarm 1 rings at or after Alarm 2
                if (timeX >= timeY) {
                    if (timeX - timeY <= d) {
                        System.out.println(timeX);
                        break;
                    }
                    timeY += y; // Move Alarm 2 to its next ring time
                } 
                // If Alarm 2 rings after Alarm 1
                else {
                    if (timeY - timeX <= d) {
                        System.out.println(timeY);
                        break;
                    }
                    timeX += x; // Move Alarm 1 to its next ring time
                }
            }
        }
        
        sc.close();

	}
}
