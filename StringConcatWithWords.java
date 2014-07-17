public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if(S == null || L == null || L.length == 0 || S.length() == 0)
            return res;
        
        //map stores string in dict and their number of times
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String str : L){
            int i = 0;
            if(map.get(str) != null)
                i = map.get(str);
            map.put(str, ++i);
        }
        
        //every time get a substring of L length and split them into words of equal length
        //use another map to store all these words
        //then check if this map is same to the dict map
        //a way of early termination is when finding word not in dict, terminate
        int length = L.length * L[0].length();
        for(int i = 0; i <= S.length() - length; i++){
            int len = i;
            Map<String, Integer> words = new HashMap<String, Integer>();
            while(len < i + length){
                String temp = S.substring(len, len + L[0].length());
                int count = 0;
                if(map.get(temp) == null)
                    break;
                if(words.get(temp) != null)
                    count = words.get(temp);
                words.put(temp, ++count);
                len += L[0].length();
            }
            //check if two hashmap have same mapping
            if(map.equals(words))
                res.add(i);
        }
        return res;
    }
}
