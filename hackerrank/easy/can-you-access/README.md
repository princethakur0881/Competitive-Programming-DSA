# Java Reflection - Attributes

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given a class *Solution* and an inner class *Inner.Private*. The main method of class *Solution* takes an integer $num$ as input. The *powerof2* in class *Inner.Private* checks whether a number is a power of $2$. You have to call the method *powerof2* of the class *Inner.Private* from the *main* method of the class *Solution*.

**Constraints**   
$ 1 \le num \le 2^{30}$

**Input Format**

 

**Output Format**

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-16T15:22:32.034Z  

```java


public class Solution {

        public static void main(String[] args){
      Class<?> student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method method : methods) {
            methodList.add(method.getName());
        }
        
        Collections.sort(methodList);
        
        for (String name : methodList) {
            System.out.println(name);
        }
        }

    }

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/can-you-access/problem)