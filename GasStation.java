public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int diff = 0;
        int sum = 0;
        int startNode = 0;
        
        // if A can't reach B, then any station between A and B can't reach B, we should go with B
        for(int i = 0; i < gas.length; i++){
            diff += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                startNode = i+1;
            }
        }
        if(diff >= 0)
            return startNode;
        else
            return -1;
    }
}