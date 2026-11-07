import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
    // Return true if you can win the game; otherwise, return false.
        return playTurn(0, leap, game);
    }

    private static boolean legal(int pos, int mod, int[] game) {
        int idx = pos + mod;
        return (idx >= 0 && idx < game.length 
            && game[idx] == 0);
    }

    private static boolean help(int pos, int mod, int leap, int[] game) {
        return ((legal(pos, mod, game)) 
            && playTurn((pos + mod), leap, game));
    }

    private static boolean playTurn(int pos, int leap, int[] game) {
        if (pos >= (game.length - 1) || (pos + leap) >= game.length) { 
            return true; 
        } else { 
            game[pos] = -1; 
        }
        
        return (help(pos, leap, leap, game)) 
            || (help(pos, 1, leap, game)) 
            || (help(pos, -1, leap, game));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
            
        scan.close();
    }
}
