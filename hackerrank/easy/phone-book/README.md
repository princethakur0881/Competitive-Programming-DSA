# Java Map

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a phone book that consists of people's names and their phone number. After that you will be given some person's name as query. For each query, print the phone number of that person.

**Input Format**

The first line will have an integer $n$ denoting the number of entries in the phone book. Each entry consists of two lines: a name and the corresponding phone number. <br>

After these, there will be some queries. Each query will contain a person's name. Read the queries until end-of-file.

*Constraints:*<br>
A person's name consists of only lower-case English letters and it may be in the format 'first-name last-name' or in the format 'first-name'. Each phone number has exactly 8 digits without any leading zeros.<br>

$1 \le n \le 100000$<br>
$1 \le Query \le 100000$<br>

**Output Format**

For each case, print "Not found" if the person has no entry in the phone book. Otherwise, print the person's name and phone number. See sample output for the exact format.

To make the problem easier, we provided a portion of the code in the editor. You can either complete that code or write completely on your own.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-08T17:32:07.718Z  

```java
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




```

---

[View on HackerRank](https://www.hackerrank.com/challenges/phone-book/problem)