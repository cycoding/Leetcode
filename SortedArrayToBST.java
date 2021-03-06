import java.util.Arrays;


public class SortedArrayToBST {
	public static void main(String args[]){
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		Node root = toBST(arr, 0, arr.length-1);
		Node.preOrder(root);
	}
	
	public static Node toBST(int[] arr, int start, int end){//有关数组的题目，如果和长度有关，最好带上起点和终点，防止出现数组越界等错误
		if(start > end)//非常easy的判断
			return null;
		else{
			int middle = (start + end)/2;
			Node root = new Node(arr[middle]);
			root.setLeft(toBST(arr, start, middle-1));
			root.setRight(toBST(arr, middle+1, end));
			return root;
		}
		
	}
}

same way but easier
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
    public TreeNode sortedArrayToBST(int[] num) {
        TreeNode root = arrayToBST(num, 0, num.length-1);
        return root;
    }
    public TreeNode arrayToBST(int[] num, int start, int end){
        while(start <= end){
            int mid = (start + end)/2;
            TreeNode root = new TreeNode(num[mid]);
            root.left = arrayToBST(num, start, mid-1);
            root.right = arrayToBST(num, mid+1, end);
            return root;
        }
        return null;
    }
}
