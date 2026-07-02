// Range Sum of BST
// We have a Binary Search Tree consisting of N nodes and two positive integers L and R, the
// task is to find the sum of values of all the nodes that lie in the range [L, R]..
// TC = O(N)
// LEETCODE 938
// Easy
public class Q1 {   
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
            return new Node(val);
        }

        if( val < root.data ) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static int sum = 0;

    public static void rangeSum(Node root, int k1, int k2) {
        if( root == null ) return;

        if( k1 <= root.data && root.data <= k2 ) {
            rangeSum(root.left, k1, k2);
            sum += root.data;
            rangeSum(root.right, k1, k2);
        } else if( k2 < root.data ) {
            rangeSum(root.left, k1, k2);
        } else {
            rangeSum(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int[] values = {3, 5, 6, 8, 11, 20};
        Node root = null;
        for( int i = 0 ; i < values.length ; i++ ) {
            root = insert(root, values[i]);
        }

        rangeSum(root, 6, 11);
        System.out.println("Sum: "+sum);

    }
}
