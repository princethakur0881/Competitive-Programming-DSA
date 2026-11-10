class Solution {
    public int firstElementKTime(int[] arr, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele:arr){
            if (map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele,freq+1);
            }
            else map.put(ele,1);
           if(map.get(ele)==k){
               return ele;
           }
        }
        return -1;
    }
}