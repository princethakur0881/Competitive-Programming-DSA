class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
     
         if(s.trim().isEmpty() || queries.length==0){
             return new ArrayList<>();
         }

         ArrayList<Integer> list=new ArrayList<>();

         int[] prefix=new int[s.length()+1];

         for(int i=0;i<s.length();i++){
             prefix[i+1]=prefix[i]+(isVowel(s.charAt(i))?1:0);
         }

      

         for(int[] query:queries){
             int left=query[0];
             int right=query[1];

             int vowelCount=prefix[right+1]-prefix[left];
        

             list.add(vowelCount);
         }

        
         return list;
     }

     public static boolean isVowel(char c){
         return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
     }
}