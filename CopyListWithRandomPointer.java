/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        RandomListNode result = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cur = head;
        while(cur != null){
            if(map.get(cur) == null){
                result = new RandomListNode(cur.label);
                map.put(cur, result);
            }
            else
                result = map.get(cur);
                
            if(cur.next == null)
                result.next = null;
            else if(map.get(cur.next) == null){
                result.next = new RandomListNode(cur.next.label);
                map.put(cur.next, result.next);
            }
            else
                result.next = map.get(cur.next);
                
            if(cur.random == null)
                result.random = null;
            else if(map.get(cur.random) == null){
                result.random = new RandomListNode(cur.random.label);
                map.put(cur.random, result.random);
            }
            else
                result.random = map.get(cur.random);
                
            cur = cur.next;
            result = result.next;
        }
        return map.get(head);
    }
}