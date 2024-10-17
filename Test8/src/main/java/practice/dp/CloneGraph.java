package practice.dp;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        cloneGraph(new Node());
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    private static Node cloneGraph(Node node, Map map) {
        if (map.containsKey(node)) {
            return (Node) map.get(node.val);
        }
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node neighbour : node.neighbours) {
            copy.neighbours.add(cloneGraph(neighbour, map));
        }
        return copy;
    }
}
