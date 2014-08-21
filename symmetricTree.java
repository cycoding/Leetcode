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
        if(root == null)
            return true;
        return symetric(root.left, root.right);
    }
    public boolean symetric(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null || left.val != right.val)
            return false;
        // then we compare left node of left with right node of right, this is the essence of symetric
        return symetric(left.left, right.right) && symetric(left.right, right.left);
    }
}
