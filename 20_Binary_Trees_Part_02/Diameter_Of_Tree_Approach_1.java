public class Diameter_Of_Tree_Approach_1 {
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

    public static int height(Node root) {   // calculating height of the tree
        if( root == null ) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int diameter(Node root) {
        if( root == null ) {
            return 0;
        }

        int leftDia = diameter(root.left);  // calculate left subtree diameter
        int leftHig = height(root.left);    // calculate left subtree height

        int rightDia = diameter(root.right);    // calculate right subtree diameter
        int rightHig = height(root.right);      // calculate right subtree height

        int selfDia = leftHig + rightHig + 1;   // calculate the diameter which includes the root node in it

        return Math.max(selfDia, Math.max(leftDia, rightDia));  // return max diam from self, left subtree and right subtree
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Maximum diameter of the tree = "+diameter(root));
    }
}