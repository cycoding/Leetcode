public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n == 0)
            return res;
        dfs(n, 0, 0, "", res);
        return res;
    }
    // core idea: we always have ( more or equal to )
    // 1: if we have equal number of ( and ), then the next should be (
    // 2: if we have more ( than ), then we could add ( or )
    public void dfs(int target, int left, int right, String solu, List<String> res){
        if(left > target || right > target)
            return;
        if(left == right && left == target){
            res.add(solu);
            return;
        }
        StringBuffer sb = new StringBuffer(solu);
        if(left >= right){
            sb.append("(");
            dfs(target, left+1, right, sb.toString(), res);
            sb.setLength(sb.length()-1);
        }
        if(left > right){
            sb.append(")");
            dfs(target, left, right+1, sb.toString(), res);
        }
    }
}