public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k > n)
            return res;
        dfs(res, 1, n, k, new ArrayList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, int low, int high, int k, ArrayList<Integer> solu){
        if(k == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(solu);
            res.add(temp);
            return;
        }
        if(low > high)
            return;
        for(int i = low; i <= high; i++){
            solu.add(i);
            // here is i+1
            dfs(res, i+1, high, k-1, solu);
            solu.remove(solu.size()-1);
        }
    }
}
