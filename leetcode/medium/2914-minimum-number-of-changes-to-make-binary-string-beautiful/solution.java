class Solution {
    public int minChanges(String s) {
        // return (int) IntStream.range(0, s.length() / 2).filter(i -> s.charAt(2 * i) != s.charAt(2 * i + 1)).count();
           int n = s.length();
        int cnt = 0;
        for(int i = 1; i < n; i += 2) {
            int pc = s.charAt(i - 1);
            int c = s.charAt(i);
            if(c != pc) cnt++;
        }
        return cnt;
   
    }
}