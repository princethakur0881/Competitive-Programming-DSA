class Solution {
    public int smallestSubstring(String s) {
       
       int zero=-1;
       int one=-1;
       int two=-1;
       int res,e,p;
       int len=(int)1e9;

       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)=='0')
              zero=i;
           else if(s.charAt(i)=='1')
              one=i;
           else
              two=i;

           if(zero!=-1 && one!=-1 && two!=-1)
           {
               e=Math.max(zero,Math.max(one,two));
               p=Math.min(zero,Math.min(one,two));
               len=Math.min(len,e-p+1);
           }
       }
       res=(len>=1e9)?-1:len;
       return res;
        
    }
};
