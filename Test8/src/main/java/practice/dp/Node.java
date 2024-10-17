package practice.dp;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbours;

    public Node() {
        this.val = 0;
        this.neighbours = new ArrayList<Node>();
    }

    public Node(int val) {
        this.val = 0;
        this.neighbours = new ArrayList<Node>();
    }

    public Node(int val, List<Node> neighbours) {
        this.val = val;
        this.neighbours = neighbours;
    }


}
