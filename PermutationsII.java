public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null)
            return result;
        Arrays.sort(num);
        List<Integer> inside = new ArrayList<Integer>();
        inside.add(num[0]);
        result.add(inside);
        int previous = num[0];
        for(int i = 1; i < num.length; i++){
            List<List<Integer>> tempRes = new ArrayList<List<Integer>>();
            
            //if such number doesn't exist, directly insert it into any legal position
            if(num[i] != previous){
                for(List<Integer> list : result){
                    for(int j = 0; j <= list.size(); j++){
                        list.add(j, num[i]);
                        tempRes.add(new ArrayList<Integer>(list));
                        list.remove(j);
                    }
                }
                previous = num[i];
            }
            
            //if it's a duplicate, then we need to insert it into behind the last position of its duplicate
            else{
                for(int j = 0; j < result.size(); j++){
                    List<Integer> list = result.get(j);
                    int pos = 0;
                    for(int temp = 0; temp < list.size(); temp++){
                        if(list.get(temp) == previous)
                            pos = temp;
                    }
                    for(int index = pos + 1; index <= list.size(); index++){
                        list.add(index, num[i]);
                        tempRes.add(new ArrayList<Integer>(list));
                        list.remove(index);
                    }
                }
            }
            result = tempRes;
        }
        return result;
    }
}