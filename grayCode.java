public class Solution {
    public List<Integer> grayCode(int n) {
        // the codes below are kinda cumbersome
        // the basic idea is right, but after a deeper view we could, instead of keeping digits
        // directly add value to each number to create new result
    //     List<Integer> res = new ArrayList<Integer>();
    //     if(n == 0){
    //         res.add(0);
    //         return res;
    //     }
    //     List<List<Integer>> list = new ArrayList<List<Integer>>();
    //     List<Integer> t = new ArrayList<Integer>();
    //     t.add(0);
    //     list.add(t);
    //     t = new ArrayList<Integer>();
    //     t.add(1);
    //     list.add(t);
        
    //     for(int i = 2; i <= n; i++){
    //         List<List<Integer>> temp = new ArrayList<List<Integer>>(list);
    //         for(int j = list.size()-1; j>=0; j--){
    //             List<Integer> newList = new ArrayList<Integer>(list.get(j));
    //             newList.add(0, 1);
    //             temp.add(newList);
    //         }
    //         list = temp;
    //     }
    //     // then get all the integers
    //     for(List<Integer> l : list){
    //         int base = 1;
    //         int num = 0;
    //         for(int i = l.size() - 1; i >= 0; i--){
    //             num += l.get(i) * base;
    //             base *= 2;
    //         }
    //         res.add(num);
    //     }
    //     return res;
    // }
    
    // eaiser way:
    //     List<Integer> res = new ArrayList<Integer>();
    //     res.add(0);
    //     for(int i = 1; i <= n; i++){
    //         // this is the value we need to add for each recursion
    //         int add = 1<<(i-1);
    //         List<Integer> temp = new ArrayList<Integer>(res);
    //         for(int j = res.size()-1; j >= 0; j--)
    //             temp.add(res.get(j) + add);
    //         res = temp;
    //     }
    //     return res;
    // }
    // now we further know we don't need to use the temp array everytime,
    // since we know how many new numbers to generate depending on the current list size
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i = 1; i <= n; i++){
            // this is the value we need to add for each recursion
            int add = 1<<(i-1);
            int times = res.size();
            for(int j = times - 1; j >= 0; j--)
                res.add(res.get(j) + add);
        }
        return res;
    }
}
