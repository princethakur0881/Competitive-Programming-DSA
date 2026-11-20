class Solution {
    public int minFlips(String s) {
      int n = s.length();
              int opr1 = 0 , opr2 = 0;
              char currChar1 = '0' , currChar2 = '1';

              for(int i = 0 ; i < n ; i++){
                  char ch = s.charAt(i);
                  if(ch != currChar1) opr1++;
                  if(ch != currChar2) opr2++;

                  char tempChar = currChar1;
                  currChar1 = currChar2;
                  currChar2 = tempChar;
              }
              return Math.min(opr1 , opr2);
    }
}