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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.empty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            else{
                temp = stack.pop();
                result.add(temp.val);
                temp = temp.right;
            }
            // codes below would get stuck into dead loop since we will keep track of the left children of a node again and again
            // temp = stack.peek();
            // if(temp.left != null){
            //     stack.push(temp.left);
            // }
            // else{
            //     result.add(temp.val);
            //     stack.pop();
            //     if(temp.right != null){
            //         stack.push(stack.right);
            //     }
            // }
        }
        return result;
    }
}
