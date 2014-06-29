/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode result = null;
        if(node == null)
            return result;
        return dfs(node, new HashMap<Integer, UndirectedGraphNode>());
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        UndirectedGraphNode root = map.get(node.label);
        if(root != null) // if this node has been visited, we simply return it
            return root;
        else{
            root = new UndirectedGraphNode(node.label);// if not, we create this node and add its neighbors
            map.put(node.label, root);
        }
            

        // if(node.neighbors.size() == 0)
        //     return root;
        // if(node.neighbors.get(node.neighbors.size()-1).label == node.label){
        //     int i = 0;
        //     while(i < node.neighbors.size()){
        //         root.neighbors.add(root);
        //         i++;
        //     }
        //    return root;
        // }
        // this would get into infinite loop because for every node we met, no matter it is visited or not, we would
        // go through the codes above. so for {0, 1 # 1, 2, 2, 3 # 2, 2, 3} it would get stuck with 2. the exit condition is wrong
        // the whole codes above are in fact redundant, destroying the recursive usage of dfs
        
        for(UndirectedGraphNode neighbor : node.neighbors){
            root.neighbors.add(dfs(neighbor, map));
        }
        return root;
    }
}