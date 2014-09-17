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
    public void flatten(TreeNode root) {
        // in discussion, there is one good solution: linking the rightmost node of a node's left subtree to this node's right pointer
        // pre-order traverse tree
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode temp = dummy;
        
        while(!stack.empty()){
            TreeNode node = stack.pop();
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
            dummy.left = null;
            dummy.right = node;
            dummy = node;
        }
        temp.right = null;
    }
}
