class Solution {
    static ArrayList<Integer> removeDuplicate(int arr[]) {
     LinkedHashSet<Integer> nums = new LinkedHashSet<>();

             for(int k : arr){
                 nums.add(k);
             }

             ArrayList<Integer> list = new ArrayList<>(nums);
             return list;
        
    }
}