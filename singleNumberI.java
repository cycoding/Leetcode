public class Solution {
    public int singleNumber(int[] A) {
        // this problem could also be easily solved by using xor since A XOR A = 0
        // 1 xor 1 = 0, 0 xor 1 = 1; 0 xor 1 = 1
        int[] bits = new int[32];
        
        for(int i = 0; i < bits.length; i++)
            for(int j = 0; j < A.length; j++){
                // get jth bit of a number: (N >> j) & 1
                bits[i] += (A[j] >> i) & 1;
            }
        
        int res = 0;
        int base = 1;
        for(int i = 0; i < bits.length; i++){
            res += (bits[i]%2)*base;
            base *= 2;
        }
        return res;
    }
}
