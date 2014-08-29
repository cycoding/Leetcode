public class Solution {
    public List<List<Integer>> permute(int[] num) {
        // BFS method
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return res;
        List<Integer> list = new ArrayList<Integer>();
        list.add(num[0]);
        res.add(list);
        for(int i = 1; i < num.length; i++){
            List<List<Integer>> tempRes = new ArrayList<List<Integer>>();
            for(List<Integer> l : res){
                for(int pos = 0; pos <= l.size(); pos++){
                    List<Integer> temp = new ArrayList<Integer>(l);
                    temp.add(pos, num[i]);
                    tempRes.add(temp);
                }
            }
            res = tempRes;
        }
        return res;
        
        // List<List<Integer>> result = new ArrayList<List<Integer>>();
        // if(num == null)
        //     return result;
        // List<Integer> inside = new ArrayList<Integer>();
        // inside.add(num[0]);
        // result.add(inside);
        // for(int i = 1; i < num.length; i++){
        //     List<List<Integer>> tempRes = new ArrayList<List<Integer>>();
        //     for(List<Integer> list : result){
        //         inside = new ArrayList<Integer>(list);
        //         for(int j = 0; j <= inside.size(); j++){
        //             inside.add(j, num[i]);
        //             // be sure to create a new array instead of the previous one because java passes the memeory instead of value
        //             tempRes.add(new ArrayList<Integer>(inside));
        //             inside.remove(j);
        //         }
        //     }
        //     result = tempRes;
        // }
        // return result;
    }
}