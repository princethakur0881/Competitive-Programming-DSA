# Java Arraylist

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Sometimes it's better to use dynamic size arrays. Java's  [Arraylist](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) can provide you this feature. Try to solve this problem using Arraylist.<br>

You are given $n$ lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in $y^{th}$ position of $x^{th}$ line. <br>

Take your input from System.in.

**Input Format**<br>
The first line has an integer $n$. In each of the next $n$ lines there will be an integer $d$ denoting number of integers on that line and then there will be $d$ space-separated integers. In the next line there will be an integer $q$ denoting number of queries. Each query will consist of two integers $x$ and $y$.

**Constraints**<br>

* $1<=n<=20000$
* $0<=d<=50000$
* $1<=q<=1000$
* $1<=x<=n$

Each number will fit in signed integer.<br>
Total number of integers in $n$ lines will not cross $10^5$.<br>

**Output Format**<br>
In each line, output the number  located in $y^{th}$ position of $x^{th}$ line. If there is no such position, just print "ERROR!"



**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T16:01:15.930Z  

```java
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
    

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-arraylist/problem)