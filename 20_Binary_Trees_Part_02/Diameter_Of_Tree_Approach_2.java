public class Diameter_Of_Tree_Approach_2 {
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

    // Creating class to store height and diameter in object
    static class Info {
        int ht;
        int diam;

        Info(int diam, int ht) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    // Calculating height and diamter in single function which reduces tc by giving ht and diam at once in object
    public static Info diameter(Node root) {
        if( root == null ) {
            return new Info(0, 0);
        }

        // calling recursively to left and right part of tree
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        // Calculating diameter of the tree 
        int diam = Math.max( leftInfo.ht + rightInfo.ht + 1, Math.max( leftInfo.diam, rightInfo.diam));
        // Calculating height of the tree
        int ht = Math.max( leftInfo.ht, rightInfo.ht ) + 1;

        // Return object containg diameter and height
        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Maximum diameter of the tree = "+diameter(root).diam);
    }
}