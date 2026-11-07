class Solution {
    public long countValidSubstrings(String s) {
         int n = s.length();
        // Use long to prevent integer overflow for larger string lengths
        long totalSubstrings = (long) n * (n + 1) / 2;
        long invalidSubstrings = 0;
        int lastAbcStart = -1;
        
        for (int i = 2; i < n; i++) {
            // Check if the last 3 characters form "abc"
            if (s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c') {
                lastAbcStart = i - 2;
            }
            
            // If an "abc" has been found, add the number of valid starting positions
            if (lastAbcStart != -1) {
                invalidSubstrings += (lastAbcStart + 1);
            }
        }
        
        return totalSubstrings - invalidSubstrings;
    }
}
 