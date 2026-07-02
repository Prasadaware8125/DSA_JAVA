import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Top_View_Of_Tree {
    // to implement tree
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

    // to store node and horizontal distance of node from from center in queue
    static class Info {
        Node node;
        int hd;     // horizontal distance
        
        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {

        // Level Order
        Queue<Info> q = new LinkedList<>();
        // to track the nodes visited
        HashMap<Integer, Node> map = new HashMap<>();
        
        // for printing
        int min = 0, max = 0;
        // adding root node in q as it is initial/ center
        q.add(new Info(root, 0));
        q.add(null);

        // traversing until q becomes empty
        while (!q.isEmpty()) {
            // getting the elements of q in fifo order
            Info curr = q.remove();
            if( curr == null ) {
                if( q.isEmpty() ) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // if map doesn't contain the node
                // i.e it haven't meat the node then add to map
                if( !map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                // traverse for left part of tree
                if( curr.node.left != null ) {
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                // traverse for right part of tree
                if( curr.node.right != null ) {
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        // Printing the top view of tree
        for( int i = min ; i <= max ; i++ ) {
            System.out.print(map.get(i).data+" ");
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

        topView(root);
    }
}