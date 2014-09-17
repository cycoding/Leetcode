public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return res;
        boolean[][] palin = new boolean[s.length()][s.length()];
        // dp to fill in the palin array
        for(int i = 0; i < s.length(); i++)
            for(int j = 0; j+i < s.length(); j++){
                if(i == 0)
                    palin[j][i+j] = true;
                else if(i == 1)
                    palin[j][i+j] = s.charAt(j) == s.charAt(i+j);
                else
                    palin[j][i+j] = s.charAt(j) == s.charAt(i+j) ? palin[j+1][i+j-1] : false;
            }
            
        // dfs to output all results
        dfs(res, palin, s, 0, new ArrayList<String>());
        return res;
    }
    public void dfs(List<List<String>> res, boolean[][] palin, String s, int pos, ArrayList<String> solu){
        if(pos == s.length()){
            ArrayList<String> temp = new ArrayList<String>(solu);
            res.add(temp);
            return;
        }
        // from starting pos, find all palindromes
        for(int i = pos; i < s.length(); i++){
            if(palin[pos][i]){
                solu.add(s.substring(pos, i+1));
                dfs(res, palin, s, i+1, solu);
                solu.remove(solu.size()-1);
            }
        }
    }
}
