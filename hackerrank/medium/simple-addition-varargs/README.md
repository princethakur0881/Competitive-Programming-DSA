# Java Priority Queue

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a class *Solution* and its *main* method in the editor. <br>Your task is to create the class *Add* and the required methods so that the code prints the *sum of the numbers* passed to the function *add*.  

**Note:** Your *add* method in the *Add* class must print the *sum* as given in the *Sample Output*


**Input Format**

There are six lines of input, each containing an integer.

**Output Format**

There will be only four lines of output. Each line contains the sum of the *integers* passed as the parameters to *add* in the *main* method.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-14T16:00:35.028Z  

```java

import java.util.Comparator;
import java.util.PriorityQueue;
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}
class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>(11, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (Double.compare(s2.getCGPA(), s1.getCGPA()) != 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }
                if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                }
                return Integer.compare(s1.getID(), s2.getID());
            }
        });

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }

        return remainingStudents;
    }
}


```

---

[View on HackerRank](https://www.hackerrank.com/challenges/simple-addition-varargs/problem)