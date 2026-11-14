# Java Priority Queue

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

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
**Submitted:** 2026-11-14T16:00:31.717Z  

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

[View on HackerRank](https://www.hackerrank.com/challenges/java-priority-queue/problem)