class Solution {
    public List<Integer> findDuplicates(int[] arr) {
     HashSet<Integer> seen = new HashSet<>();
               HashSet<Integer> duplicates = new HashSet<>();
               List<Integer> result = new ArrayList<>();

               // Step 1: Find all numbers that appear more than once
               for (int num : arr) {
                   if (!seen.add(num)) {
                       duplicates.add(num); // If it's already seen, it's a duplicate
                   }
               }

               // Step 2: Collect the duplicates in the order of their FIRST appearance
               HashSet<Integer> addedToResult = new HashSet<>();
               for (int num : arr) {
                   if (duplicates.contains(num) && !addedToResult.contains(num)) {
                       result.add(num);
                       addedToResult.add(num); // Ensure each duplicate is only added once
                   }
               }

               // Step 3: Handle the base case if no duplicates exist
               if (result.isEmpty()) {
                   result.add(-1);
               }

               return result;

    }
}