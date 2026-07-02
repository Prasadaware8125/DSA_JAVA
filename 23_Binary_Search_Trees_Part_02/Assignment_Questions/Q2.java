// Find the closest element in Binary Search Tree
// We have a binary search tree and a target node K. The task is to find the node with minimum
// absolute difference with given target value K.
// GFG
// MEDIUM
// O(N)

public class Q2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int closest;

    public static void diff(Node root, int k) {
        if( root == null ) {
            return;
        }

        diff(root.left, k);
        int check = Math.abs( root.data - k );
        closest = Math.min( closest, check );
        diff(root.right, check);
    }
    public static int midDiff(Node root, int k) {
        closest = Integer.MAX_VALUE;
        diff(root, k);
        return closest;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);

        root.right = new Node(9);
        root.right.right = new Node(10);


        System.out.println(midDiff(root, 9));
    }
}
