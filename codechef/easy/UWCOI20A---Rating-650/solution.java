import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
Scanner sc  = new Scanner(System.in);
if(sc.hasNextInt()){
    int t = sc.nextInt();
    while(t-->0){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int largest = arr[0];
        for(int i=0;i<n;i++){
            if(largest<arr[i]){
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }
    
}

	}
}
