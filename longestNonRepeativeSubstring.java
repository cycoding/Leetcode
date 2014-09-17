public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // ==> THis is a simple way, o(n)
        // if(s == null || s.length() == 0)
        //     return 0;
        // int res = 0;
        // int start = 0;
        // int[] times = new int[256];
        // Arrays.fill(times, -1);
        // for(int i = 0; i < s.length(); i++){
        //     char cur = s.charAt(i);
        //     if(times[cur] >= start){
        //         res = Math.max(res, i - start);
        //         // during the forwarding of start, we should recover the times array
        //         start = times[cur] + 1;
        //         // in fact here we don't need to reset the former half to -1, only record the start value is enough
        //     }
        //     times[cur] = i;      
        // }
        // return Math.max(res, s.length()-start);
    
        // This is o(2n): this is a two pointer problem
        if(s == null || s.length() == 0)
            return 0;
        int res = 0;
        int start = 0;
        int[] times = new int[256];
        Arrays.fill(times, -1);
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(times[cur] != -1){
                res = Math.max(res, i - start);
                // during the forwarding of start, we should recover the times array
                int newstart = times[cur] + 1;
                // in fact here we don't need to reset the former half to -1, only record the start value is enough
                while(start < newstart){
                    times[s.charAt(start)] = -1;
                    start++;
                }
            }
            times[cur] = i;      
        }
        return Math.max(res, s.length()-start);
    }
}
