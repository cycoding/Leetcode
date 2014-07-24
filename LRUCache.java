public class LRUCache {
    class Node {
        int key;
        int val;
        Node prev = null;
        Node next = null;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Map<Integer, Node> map = null;
    int capacity = 0;
    Node head = null;
    Node tail = null;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.get(key) != null){
            Node node = map.get(key);
            
            if(head == node)
                head = head.next;
            else{
                node.prev.next = node.next;
                if(node.next != null)
                    node.next.prev = node.prev;
            }
            
            if(head == null){
                head = node;
                tail = head;
            }
            else{
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        Node node = null;
        if(map.get(key) != null){
            node = map.get(key);
            node.val = value;
            
            if(head == node)
                head = head.next;
            else{
                node.prev.next = node.next;
                if(node.next != null)
                    node.next.prev = node.prev;
            }
        }
        else{
            if (map.size() == this.capacity){
                int del = head.val;
                map.remove(del);
                head = head.next;
            }
            node = new Node(key, value);
        }
        if(head == null){
            head = node;
            tail = head;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
        map.put(key, node);
    }
}
