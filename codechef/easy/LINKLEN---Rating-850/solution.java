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