package practice.trees;


public class InOrderTraversal {

    // Function to perform inorder traversal
    // of the tree and store values in 'arr'

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        // Recursively traverse the left subtree
        inOrder(root.leftChild);

        inOrder(root.rightChild);

    }

    // Main function
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);

        inOrder(root);
        System.out.println();
    }
}
