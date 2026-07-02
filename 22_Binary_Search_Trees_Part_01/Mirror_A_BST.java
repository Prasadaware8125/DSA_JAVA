public class Mirror_A_BST {
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

    public static void inorder(Node root) {
        if( root ==  null ) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // Approach 1
    public static void mirror(Node root) {
        if( root == null ) return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }
    public static Node mirrorBST(Node root) {
        mirror(root);
        return root;
    }

    // Approach 2
    // TC = O(N)
    // LEETCODE 226 (EASY)
    public static Node createMirror(Node root) {
        if( root == null ) {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};   // Valid
        // int[] values = {1, 1, 1, 1};    // Invalid
        Node root = null;

        for( int i = 0 ; i < values.length ; i++ ) {
            root = insert(root, values[i]);
        }
        // inorder(root);
        // System.out.println();
        // Node mirroredBST = mirrorBST(root);
        // inorder(root);

        inorder(root);
        System.out.println();
        Node mirror = createMirror(root);
        inorder(mirror);
    }
}
