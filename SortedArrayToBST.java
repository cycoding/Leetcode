import java.util.Arrays;


public class SortedArrayToBST {
	public static void main(String args[]){
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		Node root = toBST(arr, 0, arr.length-1);
		Node.preOrder(root);
	}
	
	public static Node toBST(int[] arr, int start, int end){//�й��������Ŀ������ͳ����йأ���ô��������յ㣬��ֹ��������Խ��ȴ���
		if(start > end)//�ǳ�easy���ж�
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
