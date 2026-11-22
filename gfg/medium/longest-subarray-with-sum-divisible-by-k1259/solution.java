class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
      HashMap<Integer,Integer>map =  new HashMap<>();
             long sum = 0;
             int maxLen = 0;
             map.put(0,-1);
             for(int i = 0;i<arr.length;i++){
                 sum+=arr[i];
                 int rem = (int)(((sum%k)+k)%k);
                 if(map.containsKey(rem)){
                     maxLen = Math.max(maxLen,i-map.get(rem));
                 } else{
                     map.put(rem,i);
                 }
             }
             return maxLen;
    }
}
