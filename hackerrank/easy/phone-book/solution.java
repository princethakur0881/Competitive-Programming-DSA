import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
     Scanner obj=new Scanner(System.in);
    ArrayList<Integer> list=new ArrayList<>();
    int n=obj.nextInt();

    for(int i=0;i<n;i++)
    {
        //int a=obj.nextInt();
        list.add(obj.nextInt());
    }
    int q=obj.nextInt();
    //obj.nextLine();
    for(int i=0;i<q;i++)
    {
        String query=obj.next();
        if(query.equals("Insert"))
        {
            int x=obj.nextInt();
            int y=obj.nextInt();

            list.add(x, y);
            //obj.nextLine();
        }
        else if(query.equals("Delete"))
        {
            int x=obj.nextInt();
            list.remove(x);
        }
    }
    for(int i:list){
        System.out.print(i+" ");
    }
}
}
