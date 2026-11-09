class Solution {
    int getCount(String s, int k) {
       HashMap<Character, Integer> map = new HashMap<>();

             int i = 0, n = s.length();

             while (i < n) {
                 char ch = s.charAt(i);
                 map.put(ch, map.getOrDefault(ch, 0) + 1);

                 int j = i + 1;
                 while (j < n && s.charAt(j) == ch) {
                     j++;
                 }
                 i = j;
             }

             int count = 0;
             for (int freq : map.values()) {
                 if (freq == k) count++;
             }

             return count;
    }
}