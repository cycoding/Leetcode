public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        if(s == null || dict == null || s.length() == 0 || dict.size() == 0) 
            return res;
        //use boolean array to represent if [i][j] is a word
        boolean[][] word = new boolean[s.length()][s.length()];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        //like the solution for wordbreakI except that every time we record the position which could split [0][i]
        for(int i = 0; i < s.length(); i++)
            for(int j = i; j < s.length(); j++){
                String temp = s.substring(i, j+1);
                if(dict.contains(temp))
                    word[i][j] = true;
                if(word[i][j] && (i==0 || i > 0 && word[0][i-1])){
                    word[0][j] = true;
                    List<Integer> prev = null;
                    if(map.get(j) == null)
                        prev = new ArrayList<Integer>();
                    else
                        prev = map.get(j);
                    prev.add(i);
                    map.put(j, prev);
                }
            }
        if(!word[0][s.length()-1])
            return res;
        dfs(s, s.length()-1, map, new ArrayList<String>(), res);
        
        return res;
    }
    public void dfs(String s, int index, Map<Integer, List<Integer>> map, List<String> list, List<String> res){
        if(index < 0){
            StringBuffer sb = new StringBuffer();
            for(int i = list.size()-1; i >= 0; i--)
                sb.append(list.get(i)).append(" ");
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        List<Integer> prev = map.get(index);
        for(Integer pos : prev){
            list.add(s.substring(pos, index+1));
            dfs(s, pos-1, map, list, res);
            list.remove(list.size()-1);
        }
    }
}
