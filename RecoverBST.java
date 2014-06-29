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
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
            
        TreeNode pred1 = null;
        TreeNode cur1 = null;
        TreeNode pred2 = null;
        TreeNode cur2 = null;
        TreeNode pred = null;
        TreeNode cur = root;
        TreeNode prev = null;
        
        //this while loop is the procedures of morris traversal
        while(cur != null){
            //if we go to the left-most node, simply output its value
            if(cur.left == null){
                pred = cur;
                cur = cur.right;
            }
            //if not, we have two conditions, either to change its predecessor or to output its value
            else {
                prev = cur.left;
                while(prev.right != null && prev.right != cur)
                    prev = prev.right;
                //the first time we visit this node, so we find its predecessor
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                //second time, so we output its value
                else {
                    prev.right = null;
                    pred = cur;
                    cur = cur.right;
                }
            }
            if(pred != null && cur != null && pred.val > cur.val){
                if(pred1 == null){
                    pred1 = pred;
                    cur1 = cur;
                }
                else{
                    pred2 = pred;
                    cur2 = cur;
                }
            }
        }
        //now we have all the two or one mistaken nodes, it's time to swap them back
        int temp = 0;
        if(pred1 != null && cur2 != null){
            temp = pred1.val;
            pred1.val = cur2.val;
            cur2.val = temp;
        }
        else{
            temp = pred1.val;
            pred1.val = cur1.val;
            cur1.val = temp;
        }
    } 
}