public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //if we put all numbers in hashmap first, then if target=6 and i=3 getting wrong output
        for(int i = 0; i < numbers.length; i++){ 
            if(map.get(target-numbers[i]) != null){
                int index = map.get(target-numbers[i]);
                result[0] = Math.min(i + 1, index+1);
                result[1] = Math.max(i + 1, index+1);
            }
            else {
                map.put(numbers[i], i);
            }
        }
        return result;
    }
}