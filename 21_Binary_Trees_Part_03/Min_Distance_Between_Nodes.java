public class Min_Distance_Between_Nodes {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // finding lowest common ancestor
    public static Node lca(Node root, int n1, int n2) {
        if( root == null || root.data == n1 || root.data == n2 ) {
            return root;
        }
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if( rightLca == null ) {
            return leftLca;
        }
        if( leftLca == null ) {
            return rightLca;
        }
        
        return root;
    }

    // finding distance from lowest common ancestor to nodes n1 and n2
    public static int lcaDis(Node root, int n) {
        if( root == null ) return -1;
        if( root.data == n ) {
            return 0;
        }
        // left and right tree traverse
        int leftLcaD = lcaDis(root.left, n);
        int rightLcaD = lcaDis(root.right, n);

        // if both left and right subtree tree returns -1, it means the curr node is not their ancestor
        if( leftLcaD == -1 && rightLcaD == -1 ) {
            return -1;
        } else if( leftLcaD == -1 ) {
            return rightLcaD+1;
        } else {
            return leftLcaD+1;
        }
    }

    public static int minDis(Node root, int n1, int n2) {
        if( root == null ) {
            return -1;
        }
        // finding common ancestor of nodes n1 and n2
        Node lca = lca(root, n1, n2);
        // calculating distance from common ancestor to node n1
        int dist1 = lcaDis(lca, n1);
        // calculating distance from common ancestor to node n2
        int dist2 = lcaDis(lca, n2);

        return dist1 + dist2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Minimum distance between "+4+" and "+5+" = "+minDis(root, 4, 5));
    }
}
