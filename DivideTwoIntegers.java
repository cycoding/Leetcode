public class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = false;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            neg = true;
        //in case of overflow, swith them to long.
        long dend = Math.abs((long) dividend);
        long dor = Math.abs((long) divisor);
        int res = 0;
        
        //every number could be written into: dividend = divisor*1 + divisor*2 + divisor*4 + ...
        //instead of everytime subtracting a divisor, which is linear time,we could subtract its mutiplication
        //but be aware, inner while loop would exit when dividen < n * divisor, but this is not the final result
        //we have to make sure the exit condition is dividend smaller than divisor
        while(dend >= dor){
            long temp = dor;
            int i = 0;
            //this exit means dividend smaller than divisor*2^i
            while(dend >= temp){
                dend -= temp;
                res += 1 << i;
                //every time increase the divisor by two
                temp = temp << 1;
                i++;
            }
        }
        return neg ? (0-res) : res;
    }
}