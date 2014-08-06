public class Solution {
    public String simplifyPath(String path) {
        path = path.trim();
        String parts[] = path.split("/");
        if(parts.length == 0)
            return "/";
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < parts.length; i++){
            if(parts[i].equals("..")){
                if(list.size() > 0)
                    list.remove(list.size()-1);
            }
            else if(parts[i].equals("."))
                continue;
            // like "/...", after spliting it would render one empty string
            else if(parts[i].length() > 0)
                list.add("/" + parts[i]);
        }
        if(list.size() == 0)
            return "/";
        StringBuffer sb = new StringBuffer();
        for(String str : list)
            sb.append(str);
        return sb.toString();
    }
}
