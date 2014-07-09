public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2)
            return s.length();
        
        int max = 0;
        int start = 0;
        int end = 0;
        //store the position of each character
        int[] freq = new int[256];
        Arrays.fill(freq, -1);
        
        while(end < s.length()){
            
            //meet the first duplicate character
            if(freq[s.charAt(end)] != -1){
                max = Math.max(max, end-start);
                int newStart =  freq[s.charAt(end)]+1;
                while(start < newStart){
                	freq[s.charAt(start)] = -1;
                	start++;
                }
            }
            freq[s.charAt(end)] = end;
            end++;
        }
        //if the longest subsequence is to the end of the string, then the max is not computed in the while loop
        max = Math.max(max, end-start);
        return max;
    }
}