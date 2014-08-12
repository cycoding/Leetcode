public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return res;
        dfs(s, new ArrayList<String>(), res);
        return res;
    }
    public void dfs(String s, List<String> solution, List<List<String>> res){
        if("".equals(s)){
            res.add(new ArrayList<String>(solution));
            return;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(isPanlin(sb.toString())){
                solution.add(sb.toString());
                dfs(s.substring(i+1), solution, res);
                //always remember to reverse what we have done to the solution
                solution.remove(solution.size()-1);
            }
        }
    }
    public boolean isPanlin(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}