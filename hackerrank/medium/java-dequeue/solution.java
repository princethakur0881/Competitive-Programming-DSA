    import java.util.*;
    public class test {
        public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
            Deque deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();

            int[] freq = new int[10000001];
            int unique=0;
            int maxUnique=0;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
               
                freq[num]++;
                deque.addLast(num);
                if(freq[num]==1)unique++;
                
                if(deque.size()==m){
                    if(unique>maxUnique)maxUnique=unique;
                    int removed = (int)deque.removeFirst();
                    freq[removed]--;
                    if (freq[removed] == 0) {
                        unique--;
                    }
                    
                }
            }
            
            System.out.println(maxUnique); 

           
        }
    }



