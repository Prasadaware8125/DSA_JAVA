public class Print_In_Range {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert( Node root, int val ) {
        if( root == null ) {
            return new Node(val);
        }

        if( val < root.data ) {
            root.left = insert(root.left, val);
        } else  {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root ) {
        if( root == null ) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // TC = O(N)
    // LEETCODE 938 (EASY)
    public static void printInRange(Node root, int k1, int k2) {
        if( root == null ) return;

        if( k1 <= root.data && root.data <= k2 ) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if( k2 < root.data ) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for( int i = 0 ; i < values.length ; i++ ) {
            root = insert(root, values[i]);
        }
        // inorder(root);
        printInRange(root, 5, 12);
    }
}
