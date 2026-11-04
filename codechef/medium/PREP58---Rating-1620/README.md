# PREP58 - Rating 1620

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Cycle in a linked list

You are given a linked list $A$ of size $N$.

Return the node where the cycle begins in the linked list. If there is no cycle, return NULL.

### Input:
- First line will contain $T$, number of test cases. Then the test cases follow.
- Each test case contains three lines of input.
- First line contains an integer $N$, length of the linked list $A$.
- Second line contains $A_1, A_2, \ldots A_N$, the value of the linked list nodes starting from the head for the linked list.
- Third line contains an integer denoting the index of the node where the cycle starts.

 **Note:** 

- For Java language, you need to:

Complete the function in the submit solution tab:

```
Node detectCycle(Node head){...}

```

$\$

- For C++ language, you need to:

Complete the function in the submit solution tab:

```
Node *detectCycle(Node*  head){...}

```

$\$

- For Python language, you need to:

Complete the function in the submit solution tab:

```
def detectCycle(head):

```

### Output:

The function you complete should return the required answer.

### Constraints
- $1 \leq T \leq 10$
- $1 \leq N \leq 10^5$
- $1 \leq A_i \leq 10^9$
### Sample 1:
Input
Output

```
3
2
8 5
1
2
5 9
1
3
5 6 8
2
```

```
8
5
6
```

### Explanation:

 **Test case $1$:**  The list is of the form $8 \rightleftharpoons 5$, where $8$ is the head. Thus, the cycle starts from $8$.

 **Test case $2$:**  The list is of the form $5 \rightleftharpoons 9$, where $5$ is the head. Thus, the cycle starts from $5$.

 **Test case $3$:**  The list is of the form $5\rightarrow 6 \rightleftharpoons 8$, where $5$ is the head. Thus, the cycle starts from $6$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-04T14:01:48.821Z  

```java
/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution {
    public static Node detectCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
         slow =head;
         while(slow!=fast){
             slow = slow.next;
             fast = fast.next;
         }
         return slow;
        }
        }
        
        return null;
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/PREP58)