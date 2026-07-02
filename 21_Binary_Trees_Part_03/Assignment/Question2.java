// Invert Binary Tree
// Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right
// children of all non-leaf nodes interchanged
public class Question2 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void invertTree(Node root) {
        if(root == null) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
    }

    public static void inOrder(Node root) {
        if( root == null ) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        inOrder(root);
        invertTree(root);
        System.out.println();
        inOrder(root);
    }
}
