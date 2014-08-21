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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        depth(root);
        return balanced(root.left, root.right);
    }
    public boolean balanced(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null){
            if(right.val > 1)
                return false;
            return true;
        }
        if(right == null){
            if(left.val > 1)
                return false;
            return true;
        }
        if(Math.abs(left.val - right.val) > 1)
            return false;
        return balanced(left.left, left.right) && balanced(right.left, right.right);
        
    }
    public int depth(TreeNode node){
        if(node == null)
            return 0;
        if(node.left == null && node.right == null){
            node.val = 1;
            return 1;
        }
        node.val = Math.max(depth(node.left), depth(node.right)) + 1;
        return node.val;
    }
}
