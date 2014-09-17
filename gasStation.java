public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if A can't reach B, then any site in [A, B] can't make B, we should start from B
        // this should be one direction
        if(gas == null || cost == null)
            return -1;
        int residual = 0;
        int station = 0;
        // since station would always get a value, we should keep record of global residual value to check if we could make it or not
        int global = 0;
        for(int i = 0; i < gas.length; i++){
            residual += gas[i] - cost[i];
            global += gas[i] - cost[i];
            if(residual < 0){
                station = i+1;
                residual = 0;
            }
        }
        if(global < 0)
            return -1;
        return station;
    }
}
