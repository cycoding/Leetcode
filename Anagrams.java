public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if(strs == null || strs.length < 2)
            return res;
        
        String[] transforms = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            int[] temp = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                temp[strs[i].charAt(j)-97]++;
            }
            StringBuffer sb = new StringBuffer();
            for(int num: temp)
                sb.append(num);
            transforms[i] = sb.toString();
        }
        
        // Arrays.sort(transforms); this sorting would destroy the positions
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < transforms.length; i++){
            ArrayList<Integer> list = null;
            if(map.get(transforms[i]) == null)
                list = new ArrayList<Integer>();
            else
                list = map.get(transforms[i]);
            list.add(i);
            map.put(transforms[i], list);
        }
        for(List<Integer> list : map.values()){
            if(list.size() > 1){
                for(int temp : list)
                    res.add(strs[temp]);
            }   
        }
        return res;
    }
}