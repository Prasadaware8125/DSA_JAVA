// Medium
// Leetcode (652)
// TC = O(n)
// SC = O(n)
import java.util.*;
public class Find_Duplicate_Subtree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static String find(Node root, ArrayList<Node> res, Map<String, Integer> map) {
        if( root == null ) {
            return "#";
        }

        String left = find(root.left, res, map);
        String right = find(root.right, res, map);

        String curr = left + "," + right + "," + root.data;

        if( map.containsKey(curr)) {
            if( map.get(curr) == 1 ) {
                res.add(root);
            }
            map.put(curr, map.get(curr)+1);
        } else {
            map.put(curr, 1);
        }

        return curr;
    }

    public static ArrayList<Node> findDuplicateSubtrees(Node root) {
        ArrayList<Node> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        find(root, res, map);
        return res;
    }

    public static void inOrder(Node root) {
        if( root == null ) {
            return;
        }
        System.out.print(root.data+" ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);

        root.right = new Node(3);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
    
        ArrayList<Node> res = findDuplicateSubtrees(root);
        for( int i = 0 ; i < res.size() ; i++ ) {
            inOrder(res.get(i));
            System.out.println();
        }
    }
}
