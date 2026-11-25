class Solution {
    public ArrayList<Integer> fibonacciNumbers(int n) {
      if(n==1){
               ArrayList<Integer> result=new ArrayList<>();
              result.add(0);
              return result;
          }if(n==2){
               ArrayList<Integer> result=new ArrayList<>();
              result.add(0);
              result.add(1);
              return result;
          }
          ArrayList<Integer>result=fibonacciNumbers(n-1);

          int size= result.size();
          int next=result.get(size-1)+result.get(size-2);
          result.add(next);
          return result;
        
    }
}