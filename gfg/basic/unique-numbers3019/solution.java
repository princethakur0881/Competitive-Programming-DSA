class solution {
    ArrayList<Integer> uniqueNumbers(int l, int r) {
      ArrayList<Integer> result = new ArrayList<>();

             for (int i=l; i<=r; i++) {
                 if (hasUniqueDigits(i)) {
                     result.add(i);
                 }
             }
             return result;
         }

         private static boolean hasUniqueDigits(int n) {
             int[] digits = new int[10];
             while(n>0) {
                 int digit = n%10;
                 if (digits[digit] > 0) {
                     return false;
                 }
                 digits[digit]++;
                 n = n/10;
             }
             return true;
    }
}