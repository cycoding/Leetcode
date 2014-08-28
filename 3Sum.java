public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = null;
        if(num == null)
            return res;
            
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        
        for(int i = 0; i < num.length-2; i++){
            int start = i+1;
            int end = num.length-1;
            int target = 0 - num[i];
            while(start < end){
                int sum = num[start]+num[end];
                if(sum == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[start]);
                    list.add(num[end]);
                    set.add(list);
                    start++;
                    end--;
                }
                else if(sum < target)
                    start++;
                else
                    end--;
            }
        }
        res = new ArrayList<List<Integer>>(set);
        return res;
    }
}