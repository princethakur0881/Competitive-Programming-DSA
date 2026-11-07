import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
 Scanner obj=new Scanner(System.in);
    int n=obj.nextInt();
    ArrayList<ArrayList<Integer>> Line=new ArrayList<>();
    for(int i=0;i<n;i++)
    {
        int d=obj.nextInt();
        ArrayList<Integer> temp=new ArrayList<>();
        for(int j=0;j<d;j++)
        {
            temp.add(obj.nextInt());
        }
        Line.add(temp);
    }

    int q=obj.nextInt();
    ArrayList<ArrayList<Integer>> query=new ArrayList<>();
    for(int i=0;i<q;i++)
    {
        ArrayList<Integer> data=new ArrayList<>();
        for(int j=0;j<2;j++)
        {
            data.add(obj.nextInt());
        }
        query.add(data);
    }

    for(int i=0;i<query.size();i++)
    {
        int x=query.get(i).get(0);
        int y=query.get(i).get(1);
        if(y<=Line.get(x-1).size())
        {
            System.out.println(Line.get(x-1).get(y-1));
        }
        else
        {
            System.out.println("ERROR!");
        }
    }
    }
}
    
