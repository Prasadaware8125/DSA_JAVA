import java.util.ArrayList;

public class Merge_Two_BSTs {
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

    public static Node buildBalancedBST(ArrayList<Integer> list, int st, int end ) {
        if( st > end ) {
            return null;
        }

        int mid = (st + end ) / 2;

        Node root = new Node(list.get(mid));

        root.left = buildBalancedBST(list, st, mid-1);
        root.right = buildBalancedBST(list, mid+1, end);

        return root;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int i = 0, j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < arr1.size() && j < arr2.size() ) {
            if( arr1.get(i) < arr2.get(j)) {
                list.add(arr1.get(i));
                i++;
            } else {
                list.add(arr2.get(j));
                j++;
            }
        }

        while (i < arr1.size() ) {
            list.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size() ) {
            list.add(arr2.get(j));
            j++;
        }

        return list;
    }

    public static void inorder(Node root, ArrayList<Integer> arr) {
        if( root == null ) return;

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public static Node mergeTwoBSTs(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        inorder(root1, arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        inorder(root2, arr2);

        ArrayList<Integer> list = merge(arr1, arr2);
        Node root = buildBalancedBST(list, 0, list.size()-1);

        return root;
    }

    public static void printTree(Node root) {
        if( root == null ) {
            return;
        }

        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }
    
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        /*
                    2
                   / \
                  1   4
        */

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        
        printTree(root1);
        System.out.println();
        printTree(root2);
        System.out.println();
        Node root = mergeTwoBSTs(root1, root2);
        printTree(root);
    }
}