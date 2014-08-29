/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public int sumNumbers(TreeNode root) {
    // this method is more complex, in fact we don't need to return all the numbers, we just need to add each number at leaf node
    //     if(root == null)
    //         return 0;
    //     List<String> numStrings = new ArrayList<String>();
    //     numbers(root, numStrings, "");
    //     int sum = 0;
    //     for(String str : numStrings){
    //         sum += Integer.parseInt(str);
    //     }
    //     return sum;
    // }
    // public void numbers(TreeNode root, List<String> list, String cur){
    //     cur += root.val + "";
    //     if(root.left == null && root.right == null){
    //         list.add(cur);
    //         return;
    //     }
    //     if(root.left != null)
    //         numbers(root.left, list, cur);
    //     if(root.right != null)
    //         numbers(root.right, list, cur);
    //     return;
    // }
    public int sumNumbers(TreeNode root) {
        // if(root == null)
        //     return 0;
        return numbers(root, "");
        
    }
    public int numbers(TreeNode root, String cur){
        if(root == null)
            return 0;
        cur += root.val + "";
        int sum = 0;
        if(root.left == null && root.right == null){
            sum = Integer.parseInt(cur);
            return sum;
        }
        if(root.left != null)
            sum += numbers(root.left, cur);
        if(root.right != null)
            sum += numbers(root.right, cur);
        return sum;
    }
}