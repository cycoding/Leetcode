public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        boolean neg = false;
        num1 = num1.trim();
        num2 = num2.trim();
        if(num1.startsWith("-")){
            num1 = num1.substring(1);
            neg = !neg;
        }
        if(num2.startsWith("-")){
            num2 = num2.substring(1);
            neg = !neg;
        }
        
        //now begins to iterate mutification
        int[] n1 = new int[num1.length()];
        for(int i = 0; i < num1.length(); i++)
            n1[num1.length()-1-i] = Character.getNumericValue(num1.charAt(i));
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //since we store from least important to most important, we have to iterate num2 also inversely
        for(int j = num2.length()-1; j >=0 ; j--){
            int value = Character.getNumericValue(num2.charAt(j));
            ArrayList<Integer> res = helper(n1, value, 0);
            result.add(res);
        }
        //get a list of each multification, then we add these items
        // inflate each arraylist
        for(int i = 0; i < result.size(); i++){
        	int count = i;
        	List<Integer> list = result.get(i);
        	while(count > 0){
        		list.add(0, 0);
        		count--;
        	}
        }
        StringBuffer sb = new StringBuffer();
        int counter = result.get(result.size()-1).size();
        int carry = 0;
        int i = 0;
        while(i < counter || carry > 0){
            int sum = 0;
            for(int j = 0; j < result.size(); j++){
                sum += (i >= result.get(j).size()) ? 0 : result.get(j).get(i);
            }
            sum += carry;
            sb.append(sum%10);
            carry = sum/10;
            i++;
        }
        sb.reverse();
        if(neg)
            sb.insert(0, "-");
        return sb.toString();
    }
    public ArrayList<Integer> helper(int[] num1, int num2, int carry){
    	ArrayList<Integer> solu = new ArrayList<Integer>();
        for(int i = 0; i < num1.length || carry > 0; i++){
            int n1 = (i >= num1.length) ? 0 : num1[i];
            int sum = n1 * num2 + carry;
            solu.add(sum%10);
            carry = sum/10;
        }
        return solu;
    }
