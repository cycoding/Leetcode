public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(target < 0 || num == null)
            return result;
        Arrays.sort(num);
        ArrayList<Integer> solution = new ArrayList<Integer>();
        dfs(num, 0, target, solution, result);
        return result;
    }
    public void dfs(int[] num, int index, int target, ArrayList<Integer> solution, List<List<Integer>> result){
        if(target < 0)
            return;
        if(target == 0){
            List<Integer> sol = new ArrayList<Integer>(solution);
            result.add(sol);
            return;
        }
        int previous = -1;
        // only need to check if the number has appeared before
        while(index < num.length && num[index] <= target){
            if(num[index] == previous){
                index++;
            }
            else{
                previous = num[index];
                solution.add(num[index]);
                index++;
                dfs(num, index, target-previous, solution, result);
                solution.remove(solution.size()-1);
            }
        }
    }
}