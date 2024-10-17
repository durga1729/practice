package practice.trees;

// Java implementation of a O(n) time
// method for Zigzag order traversal

import java.util.*;

// Binary Tree node
class Node {
    int data;
    Node leftChild;
    Node rightChild;

    Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node rootNode;

    Stack<Node> currentLevel = new Stack<>();
    Stack<Node> nextLevel = new Stack<>();

    public void printZigZagTraversal() {
        boolean leftToRight = true;
        currentLevel.push(rootNode);


        while (!currentLevel.isEmpty()) {
            Node n = currentLevel.pop();
            System.out.print (n.data);
            System.out.print(" ");
            if (leftToRight) {
                if (n.leftChild != null) {
                    nextLevel.push(n.leftChild);
                }

                if (n.rightChild != null) {
                    nextLevel.push(n.rightChild);
                }
            } else {
                if (n.rightChild != null) {
                    nextLevel.push(n.rightChild);
                }

                if (n.leftChild != null) {
                    nextLevel.push(n.leftChild);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> tmp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tmp;
            }
        }
    }
}

public class ZigZagTreeTraversal {

    // driver program to test the above function
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.rootNode = new Node(1);
        tree.rootNode.leftChild = new Node(2);
        tree.rootNode.rightChild = new Node(3);
        tree.rootNode.leftChild.leftChild = new Node(7);
        tree.rootNode.leftChild.rightChild = new Node(6);
        tree.rootNode.rightChild.leftChild = new Node(5);
        tree.rootNode.rightChild.rightChild = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();
    }
}


