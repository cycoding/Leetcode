public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        boolean next = false;
        List<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        ArrayList<String> line = new ArrayList<String>();
        int i = 0;
        int remain = L;
        
        while(i < words.length){
            if(next){
                lines.add(line);
                line = new ArrayList<String>();
                next = false;
                remain = L;
            }
            if(words[i].length() <= remain){
                line.add(words[i]);
                remain -= words[i].length() + 1;
                i++;
                if(i < words.length && words[i].length() > remain)
                    next = true;
            }
            else
                next = true;
        }
        if(line.size() > 0)
        	lines.add(line);
        //after this, lines contain each line of words, now we need to justify their output
        for(i = 0; i < lines.size(); i++){
            line = lines.get(i);
            StringBuffer sb = new StringBuffer();
            if(line.size() == 1 || i == lines.size() -1) {
                for(String str: line){
                    sb.append(str);
                    if(sb.length() < L - 1)
                    	sb.append(" ");
                }
                for(int temp = sb.length(); temp < L; temp++)
                    sb.append(" ");
            }
            else {
                int gap[] = new int[line.size() - 1];
                int len = 0;
                for(String word : line)
                    len += word.length();
                int gapSize = (L - len)/gap.length;
                Arrays.fill(gap, gapSize);
                if((L - len)%gap.length != 0){
                	int first = L - len - gapSize*gap.length;
                	for(int temp = 0; temp < first; temp++)
                		gap[temp] += 1;
                }
                int j = 0;
                for(int temp = 0; temp < line.size(); temp++){
                    sb.append(line.get(temp));
                    if(temp < line.size() - 1){
                        int gapThis = gap[j];
                        while(gapThis > 0){
                            sb.append(" ");
                            gapThis--;
                        }
                        j++;
                    }
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
