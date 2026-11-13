# Java BitSet

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. - [Wikipedia](https://en.wikipedia.org/wiki/Priority_queue)
***

In this problem we will test your knowledge on [Java Priority Queue](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html). 

There are a number of students in a school who wait to be served. Two types of events, *ENTER* and *SERVED*, can take place which are described below.

- *ENTER*: A student with some priority enters the queue to be served.
- *SERVED*: The student with the highest priority is served (removed) from the queue.

A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

1. The student having the highest *Cumulative Grade Point Average* (CGPA) is served first. 
2. Any students having the *same CGPA* will be served by name in ascending case-sensitive alphabetical order. 
3. Any students having the *same CGPA and name* will be served in ascending order of the id.

Create the following two classes:

- The *Student* class should implement:
	- The constructor `Student(int id, String name, double cgpa)`.
    - The method `int getID()` to return the id of the student.
    - The method `String getName()` to return the name of the student.
    - The method `double getCGPA()` to return the CGPA of the student.
- The *Priorities* class should implement the method `List<Student> getStudents(List<String> events)` to process all the given events and return all the students yet to be served in the priority order.

**Input Format**

The first line contains an integer, $n$, describing the total number of events. Each of the $n$ subsequent lines will be of the following two forms:

- `ENTER name CGPA id`: The student to be inserted into the priority queue.
- `SERVED`: The highest priority student in the queue was served.

The locked stub code in the editor reads the input and tests the correctness of the *Student* and *Priorities* classes implementation.

**Constraints**

- $2 \le n \le 1000$
- $0 \le CGPA \le 4.00$
- $1 \le id \le 10^{5}$
- $2 \le |name| \le 30$

**Output Format**

The locked stub code prints the names of the students yet to be served in the priority order. If there are no such student, then the code prints `EMPTY`.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-13T17:02:14.400Z  

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

[View on HackerRank](https://www.hackerrank.com/challenges/java-priority-queue/problem)