class Solution {
    public int findKthSmall(int[] arr, int k) {
      Arrays.sort(arr);
           int j=arr.length+k;
           int b=0;
           for(int i=1;i<=j;i++){
               if(b<arr.length && arr[b]==i){
                   b++;
               }
               else{
                   k--;
               }
               if(k==0){
                   return i;
               }
           }
           return -1;
    }
}