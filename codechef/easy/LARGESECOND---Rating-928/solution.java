import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
          int largest = Integer.MIN_VALUE;
          int seclargest = Integer.MIN_VALUE;
          
          for(int i=0;i<n;i++){
              if(largest<arr[i]){
                  seclargest  =largest;
                  largest = arr[i];
              }
              else if(seclargest<arr[i] && arr[i]!=largest){
                  seclargest  = arr[i];
              }
          }
            System.out.println(seclargest+largest);
        }
        scanner.close();
    }
}
