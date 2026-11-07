# Java List

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

For this problem, we have $2$ types of queries you can perform on a [List](https://docs.oracle.com/javase/7/docs/api/java/util/List.html):

1. Insert $y$ at index $x$:<br>
	<pre>Insert
    x y</pre>
    
2. Delete the element at index $x$:<br>
	<pre>Delete
    x</pre>

Given a list, $L$, of $N$ integers, perform $Q$ queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers. 

 

**Input Format**

The first line contains an integer, $N$ (the initial number of elements in $L$).	
The second line contains $N$ space-separated integers describing $L$.	
The third line contains an integer, $Q$ (the number of queries).	
The $2Q$ subsequent lines describe the queries, and each query is described over two lines:	

* If the first line of a query contains the String **Insert**, then the second line contains two space separated integers $x \ y$, and the value $y$ must be inserted into $L$ at index $x$. 	
* If the first line of a query contains the String **Delete**, then the second line contains index $x$, whose element must be deleted from $L$.           
         
**Constraints**  

- $ 1 \le N \le 4000 $<br>
- $ 1 \le Q \le 4000 $<br>
- Each element in  is a *32-bit integer*.

         

**Output Format**

Print the updated list $L$ as a single line of space-separated integers.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T16:08:22.075Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-list/problem)