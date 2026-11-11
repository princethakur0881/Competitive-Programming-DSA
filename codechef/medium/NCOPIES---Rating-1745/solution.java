import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            String a = br.readLine().trim();
            int[] pos = new int[(int) n];
            int k = 0;
            for (int i = 0; i < n; i++)
                if (a.charAt(i) == '1') pos[k++] = i;
            long total = (long) k * m;
            if (total == 0) {
                sb.append(n * m).append("\n");
            } else if (total % 2 == 1) {
                sb.append(0).append("\n");
            } else {
                long target = total / 2;
                int r = (int) ((target - 1) % k);
                long gap;
                if (r + 1 < k) gap = pos[r + 1] - pos[r];
                else gap = n - pos[r] + pos[0];
                sb.append(gap).append("\n");
            }
        }
        System.out.print(sb);

	}
}
