class Solution {
    public int minTime(int n, int s1, int s2) {
       int low=0,high=Math.min(s1,s2)*n;
            while(low<high)
            {
                int mid = low+(high-low)/2;
                int d=mid/s1 + mid/s2;
                if(d>=n)
                    high=mid;
                else
                    low = mid+1;

            }
            return low;
    }
}