import java.util.HashMap;

public class Question4 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static HashMap<String, Integer> m;

    static String findDuplicateSubtree(Node root){
        if( root == null ) {
            return "";
        }

        String str = "(";

        str += findDuplicateSubtree(root.left);
        str += Integer.toString(root.data);
        str += findDuplicateSubtree(root.right);

        str += ")";

        if(m.get(str) != null && m.get(str) == 1) {
            System.out.print(root.data+" ");
        }

        if( m.containsKey(str) ) {
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }

        return str;
    }

    static void printAllDups(Node root) {
        m = new HashMap<>();
        findDuplicateSubtree(root);
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(4);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.right.left.left = new Node(3);
        // root.right.right = new Node(4);

        printAllDups(root);
    }
}
