import java.util.*;

public class Lowest_Common_Ancestor_Approach_1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if( root == null ) {
            return false;
        }
        // first add the root to path
        path.add(root);
        // if curr node data and n equal then true 
        if( root.data == n ) {
            return true;
        }
        // else traverse to left and right subtree
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // if node n exists in any subtree then return true
        if( foundLeft || foundRight ) {
            return true;
        }
        // else remove the last added node i.e curr node from path
        path.remove(path.size()-1);
        return false;
    }
    // lca
    public static Node lca(Node root, int n1,int n2) {
        // if initial root is null then tree doesn't exits so return -1
        if( root == null ) {
            return new Node(-1);
        }
        // Created 2 arraylists to store the path of nodes n1, n2
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // to store the path getPath is fuction is called individually for nodes n1 and n2
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        // finding the lowest common path from path1 and path2
        int i = 0;
        for(; i<path1.size() && i< path2.size() ; i++ ) {
            if( path1.get(i) != path2.get(i) ) {
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(lca(root, 4, 7).data);
    }
}
