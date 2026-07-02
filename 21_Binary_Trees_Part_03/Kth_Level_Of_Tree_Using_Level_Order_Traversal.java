import java.util.*;
public class Kth_Level_Of_Tree_Using_Level_Order_Traversal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void kthLevel(Node root, int k) {
        if( root == null ) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        int count = 1;
        q.add(root);
        q.add(null);

        while (q.isEmpty() == false) {
            Node curr = q.remove();
            if( curr == null ) {
                count++;
                if( q.isEmpty() ) {
                    return;
                }
                q.add(null);
                // if we get the level k then print all remaining elements of q until it gives null
                if( count == k ) {
                    while (q.peek() != null ) {
                        System.out.print(q.remove().data+" ");
                    }
                    return;
                }
                // add left and child to q if they are not null
            } else {
                if( curr.left != null ) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7); 
        kthLevel(root, 2);
        
    }
}