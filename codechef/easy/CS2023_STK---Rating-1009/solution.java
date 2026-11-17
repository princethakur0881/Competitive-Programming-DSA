import java.util.Scanner;

public class Main {
     public static int calculateStreak(int[] arr, int n) {
        int streak = 0, maxStreak = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                streak++;
                maxStreak = Math.max(maxStreak, streak);
            } else {
                streak = 0;
            }
        }
        return maxStreak;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            int omStreak = calculateStreak(a, n);
            int addyStreak = calculateStreak(b, n);

            if (omStreak > addyStreak) {
                System.out.println("OM");
            } else if (omStreak < addyStreak) {
                System.out.println("ADDY");
            } else {
                System.out.println("DRAW");
            }
        }

        scanner.close();
        // Your code goes here
    }
}
