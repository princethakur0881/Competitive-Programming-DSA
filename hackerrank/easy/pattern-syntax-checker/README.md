# Pattern Syntax Checker

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Using __Regex__, we can easily match or search for patterns in a text. Before searching for a pattern, we have to specify one using some well-defined syntax.

In this problem, you are given a pattern. You have to check whether the syntax of the given pattern is valid.

**Note**: In this problem, a regex is only valid if you can compile it using the  [Pattern.compile](http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html#compile%28java.lang.String%29) method.

**Input Format**

The first line of input contains an integer $N$, denoting the number of test cases. The next $N$ lines contain a string of any printable characters representing the pattern of a regex.

**Constraints**

 

**Output Format**

For each test case, print ``Valid`` if the syntax of the given pattern is correct. Otherwise, print ``Invalid``. Do not print the quotes.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T15:18:52.560Z  

```java
import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases-->0){
            String pattern = in.nextLine();
              try {
                Pattern.compile(pattern);
                System.out.println("Valid");
                } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
                }
        }
	}
}




```

---

[View on HackerRank](https://www.hackerrank.com/challenges/pattern-syntax-checker/problem)