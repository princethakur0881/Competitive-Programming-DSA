class Solution {
    public void sortIt(int[] arr) {
    int n= arr.length;
    for(int i=0;i<n;i++){
       if(arr[i]%2!=0){
            arr[i] =-arr[i];
       }
    }
    Arrays.sort(arr);
        
         for(int i=0;i<n;i++){
       if(arr[i]%2!=0){
            arr[i] =-arr[i];
       }
    }
    }
}
