public class Size_Of_Largest_BST_In_BT {
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

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int size, int min, int max, int sum) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    public static int maxBSTSize = 0;
    public static int maxSumOfBST = 0;
    public static Info largestBST(Node root) {
        if( root == null ) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        int sum = root.data + leftInfo.sum + rightInfo.sum;

        // if( root.data <= leftInfo.max || root.data >= rightInfo.min ) {
        //     return new Info(false, size, min, max, sum);
        // }

        if( leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.data && root.data < rightInfo.min) {
            maxBSTSize = Math.max( maxBSTSize, size );
            maxSumOfBST = Math.max(maxSumOfBST, sum);
            return new Info(true, size, min, max, sum);
        }

        return new Info(false, size, min, max, sum);
    }
    
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        /*
                     50
                   /   \
                  30    60
                 / \    / \
                5  20  45  70
                          /  \
                         65  80
                
                Binary Tree
        */

        /*
                    60
                    / \
                  45  70
                      /  \
                     65  80
                
                Expected BST
                Size = 5
                  
        */

        Info getMaxBST = largestBST(root);
        System.out.println("Size of largest BST: "+maxBSTSize);
        System.out.println("Sum of largest BST: "+maxSumOfBST);
    }
}
