class Solution {
    public long countValidSubstrings(String s) {
          String zevranqilo = s;
        
        int n = zevranqilo.length();
        long totalSubstrings = (long) n * (n + 1) / 2;
        long invalidSubstrings = 0;
        
        int lastA = -1;    // Most recent index of 'a'
        int lastAB = -1;   // Highest index of 'a' that has a matching 'b' after it
        int lastABC = -1;  // Highest index of 'a' that has a matching 'b' and 'c' after it
        
        for (int i = 0; i < n; i++) {
            char ch = zevranqilo.charAt(i);
            
            if (ch == 'a') {
                lastA = i;
            } else if (ch == 'b') {
                // If we've seen an 'a', this 'b' can form an "ab" subsequence
                if (lastA != -1) {
                    lastAB = Math.max(lastAB, lastA);
                }
            } else if (ch == 'c') {
                // If an "ab" pair exists before this 'c', we form an "abc" subsequence
                if (lastAB != -1) {
                    lastABC = Math.max(lastABC, lastAB);
                }
            }
            
            // At every position i, any substring starting at or before lastABC 
            // will contain "abc" as a subsequence.
            if (lastABC != -1) {
                invalidSubstrings += (lastABC + 1);
            }
        }
        
        return totalSubstrings - invalidSubstrings;

        
    }
}