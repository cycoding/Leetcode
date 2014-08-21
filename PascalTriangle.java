public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows < 1)
            return res;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> prev = res.get(i-1);
            List<Integer> cur = new ArrayList<Integer>();
            for(int j = 0; j <= prev.size(); j++){
                if(j == 0 || j == prev.size())
                    cur.add(1);
                else
                    cur.add(prev.get(j-1) + prev.get(j));
            }
            res.add(cur);
        }
        return res;
    }
}
