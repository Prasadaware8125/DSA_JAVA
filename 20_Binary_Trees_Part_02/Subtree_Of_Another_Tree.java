public class Subtree_Of_Another_Tree {

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

    public static boolean identical(Node node, Node subRoot) {      // Auxillary function to check 
        // if both node and subRoot are then return true
        if( node == null && subRoot == null ) {
            return true;
        } else if( node == null || subRoot == null || node.data != subRoot.data ) {     // if one of the node is null or the data of node doesn't matches then return false
            return false;
        }

        // check for left subtree of main tree with left subtree of the subtree
        if( !identical(node.left, subRoot.left)) {
            return false;
        }
        if( !identical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if( root == null ) {
            return false;
        }

        // if data is same of root and subRoot then go for checking whole subtree is identical or not
        if( root.data == subRoot.data ) {
            if(identical(root,subRoot)) {
                return true;
            }
        }

        // left and right tree traversal
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public static void main(String[] args) {
        // one tree
        /*
                    1
                  /   \
                 2     3
                / \     \
               4   5     6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);


        // another tree
        /*
                    2
                   / \
                  4   5
        */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}