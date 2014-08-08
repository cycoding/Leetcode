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
    public boolean isSymmetric(TreeNode root) {
        //in-order traversal couldn't solve this problem because the tree depth is not the same!
        //this is a clever way of recursive!
        if(root == null)
            return true;
        return isSym(root.left, root.right);
    }
    public boolean isSym(TreeNode left, TreeNode right){
        if(right == null && left == null)
            return true;
        if(right == null || left == null)
            return false;
        if(right.val == left.val)
            return isSym(left.left, right.right) && isSym(left.right, right.left);
        return false;
    }
}