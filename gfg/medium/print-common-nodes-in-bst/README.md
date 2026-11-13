# Common Nodes in Two BSTs

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the roots  **r1**  and  **r2** of two Binary Search Trees (BST), find all nodes that are present in both trees i.e. the intersection nodes of the two BSTs.

Return the common node values in sorted order.

 **Examples:** 

```
Input: r1 = [5, 1, 10, 0, 4, 7, N, N, N, N, N, N, 9], r2 = [10, 7, 20, 4, 9, N, N]  

Output: [4, 7, 9, 10]
Explanation: The values present in both BSTs are 4, 7, 9, and 10. Hence, the answer is [4, 7, 9, 10].
```

```
Input: r1 = [10, 2, 11, 1, 3, N, N], r2 = [2, 1, 3]

Output: [1, 2, 3]
Explanation: The values 1, 2, and 3 are present in both BSTs. Hence, the answer is [1, 2, 3].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-13T16:47:50.250Z  

```java
/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
       ArrayList<Integer> result = new ArrayList<>();
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();

            while (true) {
                while (r1 != null) {
                    s1.push(r1);
                    r1 = r1.left;
                }
                while (r2 != null) {
                    s2.push(r2);
                    r2 = r2.left;
                }

                if (s1.isEmpty() || s2.isEmpty()) {
                    break;
                }

                Node top1 = s1.peek();
                Node top2 = s2.peek();

                if (top1.data == top2.data) {
                    result.add(top1.data);
                    s1.pop();
                    s2.pop();
                    r1 = top1.right;
                    r2 = top2.right;
                } else if (top1.data < top2.data) {
                    s1.pop();
                    r1 = top1.right;
                } else {
                    s2.pop();
                    r2 = top2.right;
                }
            }

            return result;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-common-nodes-in-bst/1)