// package Java_Revision.Binary Search Trees (Part 1);

public class Build_Binary_Search_Tree {
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

    public static Node insert(Node root, int val) {
        if( root == null ) {
            root = new Node(val);
            return root;
        }

        if( val < root.data ) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorderTraversals(Node root) {
        if( root == null ) return;
        inorderTraversals(root.left);
        System.out.print(root.data+" ");
        inorderTraversals(root.right);
    }

    public static boolean search(Node root, int key) {      // O(H)
        if( root == null ) return false;
        if( root.data == key ) return true;
        if( key < root.data ) return search(root.left, key);
        else return search(root.right, key);
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 1, 3, 4, 2, 7};
        Node root = null;
        for( int i = 0 ; i < values.length ; i++ ) {
            root = insert(root, values[i]);
        }
        // inorderTraversals(root);
        if( search(root, 4)) System.out.println("Found");
        else System.out.println("Not found");
    }
}
