public class Delete_Node {
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
    // LEETCODE 450 (MEDIUM)
    // INORDER SUCCESSOR = LEFT MOST NODE IN RIGHT SUBTREE
    public static Node delete(Node root, int val) {
        if( root.data < val ) {
            root.right = delete(root.right, val);
        } else if( root.data > val ) {
            root.left = delete(root.left, val);
        } else {    // Voila
            // Case 1: Leaf Node
            if( root.left == null && root.right == null ) {
                return null;
            }

            // Case 2: Single Child
            if( root.left == null ) {
                return root.right;
            } else if( root.right == null ) {
                return root.left;
            }

            // Case 3: Both Children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for( int i = 0 ; i < values.length ; i++ ) {
            root = insert(root, values[i]);
        }
        inorder(root);
        delete(root, 3);
        System.out.println();
        inorder(root);
    }
}
