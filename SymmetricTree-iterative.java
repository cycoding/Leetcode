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
        //iterative way
        //we have to use a separate list to store value
        if(root == null)
            return true;
        List<TreeNode> parent = new ArrayList<TreeNode>();
        List<TreeNode> child = null;
        List<String> values = null;
        parent.add(root);
        while(parent.size() > 0){
            child  = new ArrayList<TreeNode>();
            values = new ArrayList<String>();
            for(TreeNode node : parent){
                if(node.left != null){
                    child.add(node.left);
                    values.add(node.left.val + "");
                }
                else
                    values.add("#");
                if(node.right != null){
                    child.add(node.right);
                    values.add(node.right.val + "");
                }
                else
                    values.add("#");
            }
            if(!isSym(values))
                return false;
            parent = child;
        }
        return true;
    }
    public boolean isSym(List<String> list){
        for(int i = 0; i < list.size()/2; i++){
            if(!list.get(i).equals(list.get(list.size()-i-1)))
                return false;
        }
        return true;
    }
}