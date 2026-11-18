class Solution {
    private int xorTillN(int n) {
           return switch (n & 3) {
               case 0 -> n;
               case 1 -> 1;
               case 2 -> n + 1;
               default -> 0;
           };
       }
    public int findXOR(int l, int r) {
        return xorTillN(r) ^ xorTillN(l-1);
        
    }
}