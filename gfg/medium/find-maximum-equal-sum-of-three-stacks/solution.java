class Solution {
    
             public boolean solve(int sum[] ,  int target){
                   int l = 0 ;
                   int h = sum.length-1;

                   while(l <= h){
                       int mid = (l + h)/2;

                       if(sum[mid] == target)
                       return true;

                       else if(sum[mid] > target){
                           l = mid+1;
                       }
                       else h = mid-1;
                   }

                   return false;
               }
               public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                                      ArrayList<Integer> s3) {
                   // code here
                   int sum1[] = new int[s1.size()];
                   int sum2[] =  new int[s2.size()];
                   int target = 0;
                   int max = 0 ;



                   for(int i = s1.size()-1 ; i>=0 ; i--){
                       if(i == s1.size()-1){
                            sum1[i] = s1.get(i);
                            continue;
                       }
                        sum1[i] = s1.get(i) + sum1[i+1];
                   }


                    for(int i = s2.size()-1 ; i>=0 ; i--){
                       if(i == s2.size()-1){
                            sum2[i] = s2.get(i);
                            continue;
                       }
                        sum2[i] = s2.get(i) + sum2[i+1];
                   }

                   for(int i = s3.size()-1 ; i>=0 ; i--){
                        target += s3.get(i);
                       if(solve(sum1,target) && solve(sum2,target))
                       max =Math.max(target,max);
                   }

                   return max;
    }
}