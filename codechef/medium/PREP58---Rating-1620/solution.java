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