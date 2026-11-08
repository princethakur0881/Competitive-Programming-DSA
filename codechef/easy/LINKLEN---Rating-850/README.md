# LINKLEN - Rating 850

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

### Find the Length of the Linked List

You are given a singly  **linked list**.
Your task is to find the  **number of nodes**  present in the linked list.

The linked list nodes are provided in the form of integer values.

## Function Declaration
### Function Name

$getLength$ — This function calculates and returns the total number of nodes in a given singly linked list.

### Parameters

$head$: A pointer to the  **first node**  of the singly linked list.

- If $head$ is $NULL$, the list is empty.
- Each node contains an integer value and a pointer to the next node.
### Return Value

Returns an integer representing the  **number of nodes**  present in the linked list starting from $head$.

- Returns $0$ if the list is empty.

`The input and output formats provided below are only for testing with custom inputs.`

## Constraints:
- $1 \le T \le 100$
- $0 \le N \le 10^{5}$
- $\text{Sum of all } N \text{ across test cases} \le 10^{6}$
- $\text{Linked list element constraints:}$
- $\quad \text{Each element is an integer}$
- $\quad -10^{9} \le \text{value} \le 10^{9}$
### Input Format

The first line contains an integer $T$, the number of test cases.

For each test case:

- The first line contains an integer $N$, the number of nodes in the linked list.
- The second line contains $N$ space-separated integers representing the linked list elements.
### Output Format

For each test case, print a single line containing the  **length of the linked list**.

### Sample 1:
Input
Output

```
3
5
1 2 3 4 5
2
8 6
1
9

```

```
5
2
1

```

### Explanation:

 **Test 1** : Linked list = `[1, 2, 3, 4, 5]` -> 5 nodes

 **Test 2** : Linked list = `[8, 6]` -> 2 nodes

 **Test 3** : Linked list = `[9]` -> 1 node

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-08T17:20:41.989Z  

```java
public static int getLength(Node head) {
    
    int size =0;
    if(head==null){
        return 0;
    }
     Node curr = head;
     while(curr!=null){
         size++;
         curr = curr.next;
     }
     return size;
 }
```

---

[View on CodeChef](https://www.codechef.com/problems/LINKLEN)