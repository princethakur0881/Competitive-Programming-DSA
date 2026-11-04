# Java Regex

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Write a class called *MyRegex* which will contain a string pattern. You need to write a regular expression and assign it to the pattern such that it can be used to validate an IP address. Use the following definition of an IP address:<br>

    IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255. Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.

Some valid IP address:

```raw
000.12.12.034
121.234.12.12
23.45.12.56
```

Some invalid IP address:

```raw
000.12.234.23.23
666.666.23.23
.213.123.23.32
23.45.22.32.
I.Am.not.an.ip
```

In this problem you will be provided strings containing any combination of ASCII characters. You have to write a regular expression to find the valid IPs.

Just write the MyRegex class which contains a String $pattern$. The string should contain the correct regular expression.


(MyRegex class *MUST NOT* be public)



**Input Format**

 

**Constraints**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T14:08:06.773Z  

```java

   class MyRegex {
     // Regex breakdown:
    // (?:[01]?\d?\d|2[0-4]\d|25[0-5]) matches numbers from 0 to 255 with up to 2 leading zeros
    // {3} ensures the block and a dot repeat exactly 3 times
    // The final block matches the last number without a trailing dot
    String pattern = "^(?:(?:[01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}(?:[01]?\\d?\\d|2[0-4]\\d|25[0-5])$";
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-regex/problem)