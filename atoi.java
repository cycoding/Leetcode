public class Solution {
    public int atoi(String str) {
        if(str == null || str.length() == 0)
            return 0;
        //first trim this string to get rid of spaces
        String valid = str.trim();
        
        //then decide if this string is a negative number
        boolean neg = false;
        if(valid.startsWith("-")){
            neg = true;
            valid = valid.substring(1);
        }
        else if(valid.startsWith("+"))
            valid = valid.substring(1);
            
        //get all numbers after a possible number sign
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(i < valid.length() && (valid.charAt(i) >= '0' && valid.charAt(i) <= '9')){
            sb.append(valid.charAt(i));
            i++;
        }
        
        // delete all zeros in the beginning of this substring
        String num = sb.toString();
        while(num.startsWith("0"))
            num = num.substring(1);
        if(num.equals(""))
            return 0;
        
        //now we are trying to convert this substring, which contains only numbers, to integer
        String max = new String(Integer.MAX_VALUE + "");
	    String min = new String(Integer.MIN_VALUE + "");
	        if(!neg){
	        	if(num.length() < max.length() || (num.length() == max.length() && num.compareTo(max) <= 0))
	        		return Integer.parseInt(num);
	        	else
	        		return Integer.MAX_VALUE;
	        }
	        else {
	        	num = sb.insert(0, '-').toString();
	        	if(num.length() < min.length() || (num.length() == min.length() && num.compareTo(min) <= 0))
	        		return Integer.parseInt(num);
	        	else
	        		return Integer.MIN_VALUE;
	        }
    }
}