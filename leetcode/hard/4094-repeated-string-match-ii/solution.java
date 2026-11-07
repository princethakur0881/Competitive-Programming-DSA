class Solution {
    public boolean repeatedStringMatch(String a, String b, int x, int y) {
                int rav = x;
        
        long lenA = a.length();
        long lenB = b.length();
        
        long totalLenA = lenA * rav;
        long totalLenB = lenB * y;
        
        // If b * y is longer than a * x, it cannot be a substring
        if (totalLenB > totalLenA) {
            return false;
        }
        
        long lcm = (lenA * lenB) / gcd((int) lenA, (int) lenB);
        long checkLength = Math.min(totalLenB, lcm);
        
        // Try every possible starting position within the first period of string a
        for (int startMod = 0; startMod < lenA; startMod++) {
            // Ensure that starting at this position doesn't exceed the total length of a * x
            if (startMod + totalLenB > totalLenA) {
                continue;
            }
            
            boolean match = true;
            for (int i = 0; i < checkLength; i++) {
                char charB = b.charAt((int) (i % lenB));
                char charA = a.charAt((int) ((startMod + i) % lenA));
                
                if (charB != charA) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                return true;
            }
        }
        
        return false;
    }
    
    // Helper method to calculate the Greatest Common Divisor (GCD)
    private int gcd(int m, int n) {
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;


    }
}