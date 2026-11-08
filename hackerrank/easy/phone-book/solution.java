//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		 HashMap<String, Integer> Phone=new HashMap<>();
    Scanner obj=new Scanner(System.in);
    int n=obj.nextInt();
    obj.nextLine();
    for(int i=0;i<n;i++)
    {
        String name=obj.nextLine();
        int number=obj.nextInt();
        obj.nextLine();
        Phone.put(name, number);
    }

    while(obj.hasNext())
    {
        String query=obj.nextLine();
        if(Phone.containsKey(query))
        {
            System.out.println(query+"="+Phone.get(query));
        }
        else
        {
            System.out.println("Not found");
        }
        }
    }
}



