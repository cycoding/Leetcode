public class Solution {
    public int reverse(int x) {
        String num = x + "";
        boolean neg = x < 0;
        if(neg)
            num = num.substring(1);
        //then reverse the digits
        StringBuffer sb = new StringBuffer(num);
        num = sb.reverse().toString();
        // get the substring without leading 0s
        int start = 0;
        while(start < num.length()){
            if(num.charAt(start) != '0')
                break;
            start++;
        }
        num.substring(start);
        // then transform to normal string
        if(neg){
        	sb = new StringBuffer(num);
        	num = sb.insert(0, '-').toString();
        }
            
        // then check if it overflows
        String max = Integer.MAX_VALUE + "";
        String min = Integer.MIN_VALUE + "";
        if(!neg && num.length() == max.length() && num.compareTo(max) > 0)
            return Integer.MAX_VALUE;
        if(neg && num.length() == min.length() && num.compareTo(min) > 0)
            return Integer.MIN_VALUE;
        return Integer.parseInt(num);
    }
}
