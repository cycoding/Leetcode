public class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0)
            return "";
        if(n == 1)
            return "1";
            
        //use factorial array to store the factorial from 1 to n
        int factorial[] = new int[n];
        factorial[0] = 1;
        int i = 1;
        while(i < n){
            factorial[i] = factorial[i-1]*(i+1);
            i++;
        }
        
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(i = 1; i <= n; i++)
            num.add(i);
        
        StringBuffer sb = new StringBuffer();
        while(k > 1 && num.size() > 1){
            //has to start from k-1
            int pos = (k-1)/factorial[num.size()-2];
            // pos has pos*factorial times sequence so we are left with its substraction
            k = k - pos*factorial[num.size()-2];
            sb.append(num.get(pos));
            num.remove(pos);
        }
        for(int x:num)
            sb.append(x);
        return sb.toString();
    }
}