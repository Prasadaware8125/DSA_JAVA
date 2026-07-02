import java.util.ArrayList;

public class Convert_BST_To_Balanced_BST {
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

    public static void inorder(Node root, ArrayList<Integer> arr) {
        if( root == null ) {
            return;
        }

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static Node createBalancedBST(ArrayList<Integer> arr, int st, int end) {
        // Base Case
        if( st > end ) {
            return null;
        }

        // Find mid of the array
        int mid = (st + end ) / 2;

        // Make mid as root
        Node root = new Node(arr.get(mid));

        // Recursive call to make left subtree of root
        root.left = createBalancedBST(arr, st, mid-1);
        // Recursive call to make right subtree of root
        root.right = createBalancedBST(arr, mid+1, end);

        // Return the root
        return root;
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        return createBalancedBST(arr, 0, arr.size()-1);
    }

    public static void printInorder(Node root ) {
        if( root == null ) return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    public static int height(Node root) {
        if( root == null ) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh , rh) + 1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = null;
        for( int i = 0 ; i < arr.length ; i++ ) {
            root = insert(root, arr[i]);
        }
        int heightOfBST = height(root);
        System.out.println("Height of BST: "+ heightOfBST);
        Node balancedBST = balanceBST(root);
        int heightOfBalancedBST = height(balancedBST);
        System.out.println("Height of Balanced BST: "+ heightOfBalancedBST);
        System.out.print("Inorder on Balanced BST: ");
        printInorder(root);
    }    
}
