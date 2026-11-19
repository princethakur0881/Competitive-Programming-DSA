class Solution {
    public boolean isPowerofTwo(int n) {
      int res = 0;
          String s1 = "";
          while(n!=0) {
              res = n%2;
              n/=2;
              s1+= res;
          }
          int c =0;
          for(int i =0;i < s1.length();i++) {
              if(s1.charAt(i) == '1')
                 c++;
          }
             if(c==1)
                  return true;
             else
                 return false;
        
    }
}