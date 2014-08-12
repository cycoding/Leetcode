public class Solution {
    // this solution can't get rid of two subarrays at the same time
    public double findMedianSortedArrays(int A[], int B[]) {
	        //transform to the question of finding the kth smallest element in two sorted array
	        int aLen = A.length;
	        int bLen = B.length;
	        if((aLen + bLen)%2 != 0)
	            return (double)findKthSmallest(A, B, (aLen+bLen)/2+1, 0, aLen, 0, bLen);
	        else
	            return (double)(findKthSmallest(A, B, (aLen+bLen)/2, 0, aLen, 0, bLen)
	                    + findKthSmallest(A, B, (aLen+bLen)/2+1, 0, aLen, 0, bLen))/2;
	    }
	    public int findKthSmallest(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd){
	        int alen = aEnd-aStart;
	        int blen = bEnd-bStart;
	        
	        //special case
	        if(alen <= 0)
	            return B[bStart + k-1];
	        if(blen <= 0)
	            return A[aStart + k-1];
	        if(k == 1)
	            return Math.min(A[aStart], B[bStart]);
	            
	        //check relationship
	        int amid = (aStart + aEnd)/2;
	        int bmid = (bStart + bEnd)/2;
	        
	        if(A[amid] <= B[bmid]){
	            //now for amid and bmid we have alen/2+1+blen/2 numbers
	            if(alen/2 + blen/2 + 1 < k)
	                return findKthSmallest(A, B, k-alen/2-1, amid+1, aEnd, bStart, bEnd);
	            else
	                return findKthSmallest(A, B, k, aStart, aEnd, bStart, bmid);
	        }
	        else {
	            if(alen/2 + blen/2 + 1 < k)
	                return findKthSmallest(A, B, k-blen/2-1, aStart, aEnd, bmid+1, bEnd);
	            else
	                return findKthSmallest(A, B, k, aStart, amid, bStart, bEnd);
	        }
	    }
}