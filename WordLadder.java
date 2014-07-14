public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        //USE BFS INSTEAD OF DFS
        if(start == null || end == null || dict == null)
            return 0;
        //visited to store all visited words in dict
        Set<String> visited = new HashSet<String>();
        //this is a list of words in one level of BFS
        List<String> list = new ArrayList<String>();
        int length = 0;
        list.add(start);
        
        while(list.size() > 0){
            length++;
            List<String> child = new ArrayList<String>();
            StringBuffer sb = null;
            
            //iterate every word in one level, if found the end, return its length
            //if not, transform it to every possible word and store it if unvisited
            for(String str : list){
                if(str.equals(end))
                    return length;
                for(int i = 0; i < str.length(); i++){
                    for(int ch = 'a'; ch <= 'z'; ch++){
                        sb = new StringBuffer(str);
                        if(ch != sb.charAt(i)){
                            sb.setCharAt(i, (char)ch);
                            if(dict.contains(sb.toString()) && !visited.contains(sb.toString())){
                                visited.add(sb.toString());
                                child.add(sb.toString());
                            }
                        }
                    }
                }
            }
             
            list = child;
        }
        return 0;
        
    }
}