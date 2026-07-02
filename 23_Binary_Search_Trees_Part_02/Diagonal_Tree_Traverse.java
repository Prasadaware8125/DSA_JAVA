// Its is practice question
// GFG
// Medium
// TC = O(N)
// SC = O(N)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Diagonal_Tree_Traverse {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void traverse(Node root, ArrayList<Integer> res, Queue<Node> q) {
        if( root == null ) return;

        if( root.left != null ) {
            q.add(root.left);
        }
        res.add(root.data);
        if( root.right != null ) {
            traverse(root.right, res, q);
        }

        if( q.isEmpty() ) {
            return;
        } else {
            Node leftNode = q.remove();
            traverse(leftNode, res, q);
        }
    }

    public static ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        traverse(root, res, q);
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        ArrayList<Integer> res = diagonal(root);
        System.out.println(res);
    }
}
