public class Transform_To_Sum_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumTree(Node root) {
        if( root == null ) {
            return 0;
        }

        // calculate sum of left and right subtree
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);

        // store value of curr node
        int data = root.data;
        // add leftSum and rightSum to curr node
        root.data = leftSum + rightSum;
        // return curr node value and data(original node value before adding left and right sum)
        return root.data + data;
    }

    // printing the tree 
    public static void inorder(Node root) {
        if( root == null ) {
            return;
        }
        System.out.print(root.data+" ");
        inorder(root.left);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        inorder(root);
        sumTree(root);
        System.out.println();
        inorder(root);
    }
}
