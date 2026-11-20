import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            Queue<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                q.add(sc.nextInt());
            }

            boolean isAmanTurn = true;

            // Keep playing until only 1 stone is left
            while (q.size() > 1) {
                if (isAmanTurn) {
                    // Aman: Move 1 to bottom, throw 1 away
                    q.add(q.poll());
                    q.poll();
                } else {
                    // Akshat: Move 2 to bottom, throw 1 away
                    q.add(q.poll());
                    q.add(q.poll());
                    q.poll();
                }
                // Switch turns
                isAmanTurn = !isAmanTurn;
            }

            // If N is even, N-1 moves happened -> Aman (1) played last
            // If N is odd, N-1 moves happened -> Akshat (0) played last
            int lastPlayer = (n % 2 == 0) ? 1 : 0;

            System.out.println(lastPlayer + " " + q.peek());
        }

	}
}
