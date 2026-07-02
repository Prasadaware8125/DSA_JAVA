public class Sorted_Array_To_Balanced_BST {
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

    public static Node createBalancedBST(int[] arr, int st, int end) {
        // Base Case
        if( st > end ) {
            return null;
        }

        // Find mid of the array
        int mid = (st + end ) / 2;

        // Make mid as root
        Node root = new Node(arr[mid]);

        // Recursive call to make left subtree of root
        root.left = createBalancedBST(arr, st, mid-1);
        // Recursive call to make right subtree of root
        root.right = createBalancedBST(arr, mid+1, end);

        // Return the root
        return root;
    }

    public static void inorder(Node root) {
        if( root == null ) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = createBalancedBST(arr, 0, arr.length-1);
        inorder(root);
    }
}
