# Java BitSet

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Java's [BitSet](https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html) class implements a vector of bit values (i.e.: $false$ ($0$) or $true$ ($1$)) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of $1$ is called a *set bit*.

Given $2$ BitSets, $B_1$ and $B_2$, of size $N$ where all bits in both BitSets are initialized to $0$, perform a series of $M$ operations. After each operation, print the number of *set bits* in the respective BitSets as two space-separated integers on a new line.

**Input Format**

The first line contains $2$ space-separated integers, $N$ (the length of both BitSets $B_1$ and $B_2$) and $M$ (the number of operations to perform), respectively. 	
The $M$ subsequent lines each contain an operation in one of the following forms:

* [AND](https://en.wikipedia.org/wiki/Logical_conjunction) $ \ \text{<set> <set>}$
* [OR](https://en.wikipedia.org/wiki/Logical_disjunction) $ \ \text{<set> <set>}$
* [XOR](https://en.wikipedia.org/wiki/Exclusive_or) $ \ \text{<set> <set>}$
* [FLIP](https://en.wikipedia.org/wiki/Bitwise_operation#NOT)$ \ \text{<set> <index>}$
* [SET](https://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html#set(int)) $ \ \text{<set> <index>}$

In the list above, $\text{<set>}$ is the integer $1$ or $2$, where $1$ denotes $B_1$ and $2$ denotes $B_2$. 	
$\text{<index>}$ is an integer denoting a bit's index in the BitSet corresponding to $\text{<set>}$. 

For the binary operations $AND$, $OR$, and $XOR$, operands are read from left to right and the BitSet resulting from the operation replaces the contents of the *first operand*. For example:

    AND 2 1

$B_2$ is the left operand, and $B_1$ is the right operand. This operation should assign the result of $B_2 \land B_1$ to $B_2$. 

**Constraints**

- $1 \le N \le 1000$
- $1 \le M \le 10000$

**Output Format**

After each operation, print the respective number of *set bits* in BitSet $B_1$ and BitSet $B_2$ as $2$ space-separated integers on a new line.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-13T17:02:11.923Z  

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static void performOperation(BitSet b1, BitSet b2, String operation, int value) {
        switch (operation) {
            case "AND":
                b1.and(b2);
                break;
            case "OR":
                b1.or(b2);
                break;
            case "XOR":
                b1.xor(b2);
                break;
            case "FLIP":
                b1.flip(value);
                break;
            case "SET":
                b1.set(value);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        
        while (m-->0){
            String operation = scan.next();
            int bitIdentifier = scan.nextInt();
            int value = scan.nextInt();
            
            if (bitIdentifier == 1) {
                performOperation(b1, b2, operation, value);
            } else if (bitIdentifier == 2) {
                performOperation(b2, b1, operation, value);
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        scan.close(); 
}
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-bitset/problem)