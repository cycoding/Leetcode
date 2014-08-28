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

        // seems like the pre-order traverse of a BT

        if(root == null)

            return;

        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        TreeNode prev = null;

        while(!stack.empty()){

            TreeNode temp = stack.pop();

            if(temp.right != null)

                stack.push(temp.right);

            if(temp.left != null)

                stack.push(temp.left);

            if(prev != null){

                prev.left = null;

                prev.right = temp;

            }

            prev = temp;

        }

    }

}
