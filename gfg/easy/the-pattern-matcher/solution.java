class Solution {
    public boolean findPattern(String s) {
       int i = 0;
            int n = s.length();

            while (i < n) {

                int xCount = 0;
                int yCount = 0;

                // Count consecutive x's
                while (i < n && s.charAt(i) == 'x') {
                    xCount++;
                    i++;
                }

                // There must be at least one x
                if (xCount == 0) {
                    return false;
                }

                // Count consecutive y's
                while (i < n && s.charAt(i) == 'y') {
                    yCount++;
                    i++;
                }

                // Both counts must be equal
                if (xCount != yCount) {
                    return false;
                }
            }

            return true;
    }
}
