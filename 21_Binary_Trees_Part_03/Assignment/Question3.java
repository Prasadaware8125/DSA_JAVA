public class Question3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node removeLearNode(Node root, int target) {
        if( root == null ) return null;

        root.left = removeLearNode(root.left, target);
        root.right = removeLearNode(root.right, target);

        if( root.left == null && root.right == null && root.data == target ) {
            return null;
        }

        return root;
    }

    public static void inOrder(Node root) {
        if( root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(20);
        root.left.left = new Node(20);
        root.left.right = new Node(20);
        root.right.right = new Node(30);
        root.left.left.left = new Node(20);
        root.left.left.right = new Node(20);
        root.right.right.left = new Node(40);
        root.left.left.right = new Node(20);

        inOrder(root);
        System.out.println();
        removeLearNode(root, 20);
        inOrder(root);
    }
}
