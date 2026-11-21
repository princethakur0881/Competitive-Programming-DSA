# Find Subtree Sizes After Changes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a tree rooted at node 0 that consists of `n` nodes numbered from `0` to `n - 1`. The tree is represented by an array `parent` of size `n`, where `parent[i]` is the parent of node `i`. Since node 0 is the root, `parent[0] == -1`.

You are also given a string `s` of length `n`, where `s[i]` is the character assigned to node `i`.

We make the following changes on the tree  **one**  time  **simultaneously**  for all nodes `x` from `1` to `n - 1`:

- Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
- If node y does not exist, do nothing.
- Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.

Return an array `answer` of size `n` where `answer[i]` is the  **size**  of the subtree rooted at node `i` in the  **final**  tree.

 

Original
Java
 **Example 1:** 

 **Input:**  parent = [-1,0,0,1,1,1], s = "abaabc"

 **Output:**  [6,3,1,1,1,1]

 **Explanation:** 

The parent of node 3 will change from node 1 to node 0.

 **Example 2:** 

 **Input:**  parent = [-1,0,4,0,1], s = "abbba"

 **Output:**  [5,2,1,1,1]

 **Explanation:** 

The following changes will happen at the same time:

- The parent of node 4 will change from node 1 to node 0.
- The parent of node 2 will change from node 4 to node 1.

 

 **Constraints:** 

- n == parent.length == s.length
- 1 <= n <= 105
- 0 <= parent[i] <= n - 1 for all i >= 1.
- parent[0] == -1
- parent represents a valid tree.
- s consists only of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 129 ms (beats 76.74%)  
**Memory:** 194 MB (beats 93.02%)  
**Submitted:** 2026-11-21T18:07:35.222Z  

```java
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
         int n = parent.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int x = 0; x < n; x++)
            children.add(new ArrayList<>());
        for (int x = 1; x < n; x++)
            children.get(parent[x]).add(x);
        int[] size = new int[n], above = new int[n], last = new int[26];  // last[c]: the deepest node with letter c on the path from the root
        Arrays.fill(size, 1);
        Arrays.fill(last, -1);
        Deque<Integer> stack = new ArrayDeque<>(List.of(0));  // x enters x, ~x leaves it: no recursion, so no stack overflow on a deep tree
        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (x >= 0) {
                int c = s.charAt(x) - 'a';
                above[x] = last[c];  // the closest ancestor with the same letter, or -1
                last[c] = x;
                stack.push(~x);  // leave x after all its children
                for (int child : children.get(x))
                    stack.push(child);
            } else {
                x = ~x;
                last[s.charAt(x) - 'a'] = above[x];
                if (x > 0)  // the root has no parent
                    size[above[x] >= 0 ? above[x] : parent[x]] += size[x];
            }
        }
        return size;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-subtree-sizes-after-changes/)