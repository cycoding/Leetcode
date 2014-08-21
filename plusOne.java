public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return digits;
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            if(carry == 0)
                break;
            int sum = digits[i] + carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        if(carry > 0){
            int[] temp = new int[digits.length + 1];
            temp[0] = carry;
            System.arraycopy(digits, 0, temp, 1, digits.length);
            digits = temp;
        }
        return digits;
    }
}
