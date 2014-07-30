public class Solution {
    public int singleNumber(int[] A) {
        // solution 1:
        //this runs with extra memory
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for(int i : A){
        //     if(map.get(i) == null){
        //         map.put(i, 1);
        //     }
        //     else{
        //         map.put(i, map.get(i)+1);
        //     }
        // }
        // for(int key : map.keySet()){
        //     if(map.get(key) == 1)
        //         return key;
        // }
        // return 0;
        
        // solution 2:
        // use bits addition
        int sum[] = new int[32];
        for(int i : A){
            int count = 0;
            while(count < 32){
                // how to get nth bit of an integer: (i >> n-1) & 1
                sum[count] += (i >> count) & 1;
                count++;
            }
        }
        int res = 0;
        int base = 1;
        for(int j = 0; j < sum.length; j++){
            res += (sum[j]%3)*base;
            base *= 2;
        }
        return res;
    }
}
