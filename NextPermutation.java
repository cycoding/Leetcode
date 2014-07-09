public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length == 1)
            return;
        int high = num.length - 2;
        int end = num.length - 1;
        while(high >= 0){
            if(num[high] >= num[high + 1]){
                high--;
            }
            else{
                //find the position to change
                int pos = end;
                while(num[pos] <= num[high])
                    pos--;
                //switch numbers on pos and high
                int temp = num[high];
                num[high] = num[pos];
                num[pos] = temp;
                //sort the latter part in ascending order
                int length = end - high;
                for(int delta = 0; delta < length/2; delta++){
                    temp = num[high + 1 + delta];
                    num[high + 1 + delta] = num[end - delta];
                    num[end - delta] = temp;
                }
                return;
                
            }
        }
        Arrays.sort(num);
    }
}