class Solution {
    // Function to check if the given array forms an arithmetic progression
    public boolean checkIsAP(int[] arr) {
       Arrays.sort(arr);

               int initialdiff = 0;
               for(int i = 0; i<(arr.length-1);i++){
                   int diff = arr[i+1] - arr[i];
                       if(i == 0){
                           initialdiff = diff;
                       }
                   if(initialdiff != diff){
                       return false;
                   }
               }
               return true;
    }
}