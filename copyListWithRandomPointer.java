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
        // THis is the iterative BFS way
        // if(head == null)
        //     return head;
        // Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        // RandomListNode pointer = head;
        // while(pointer != null){
        //     RandomListNode node = map.get(pointer);
        //     if(node == null){
        //         node = new RandomListNode(pointer.label);
        //         map.put(pointer, node);
        //     }
        //     if(pointer.next != null){
        //         RandomListNode nextN = map.get(pointer.next);
        //         if(nextN == null){
        //             nextN = new RandomListNode(pointer.next.label);
        //             map.put(pointer.next, nextN);
        //         }
        //         node.next = nextN;
        //     }
        //     if(pointer.random != null){
        //         RandomListNode nextR = map.get(pointer.random);
        //         if(nextR == null){
        //             nextR = new RandomListNode(pointer.random.label);
        //             map.put(pointer.random, nextR);
        //         }
        //         node.random = nextR;
        //     }
        //     pointer = pointer.next;
        // }
        // return map.get(head);
        
        
        // THen we try the recursion way
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        return recursive(head, map);
    }
    public RandomListNode recursive(RandomListNode pointer, Map<RandomListNode, RandomListNode> map){
        if(pointer == null)
            return null;
        RandomListNode node = map.get(pointer);
        if(node == null){
            node = new RandomListNode(pointer.label);
            map.put(pointer, node);
            node.next = recursive(pointer.next, map);
            node.random = recursive(pointer.random, map);
        }
        return node;
    }
}