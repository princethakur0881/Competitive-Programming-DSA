import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] frames = new int[n];
            for (int i = 0; i < n; i++) {
                frames[i] = scanner.nextInt();
            }

            int minFrames = n;
            for (int i = 0; i < n - 1; i++) {
                if (frames[i] == frames[i + 1]) {
                    minFrames--;
                }
            }

            System.out.println(minFrames);
        }
        scanner.close();
        
    }
}