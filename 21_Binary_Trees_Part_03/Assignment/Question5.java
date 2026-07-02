public class Question5 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int diameterSum = Integer.MIN_VALUE;
    public static int dfs(Node root) {
        if( root == null ) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);

        // if left or right sum is negative then make it 0
        if( leftSum < 0 ) leftSum = 0;
        if( rightSum < 0 ) rightSum = 0;

        diameterSum = Math.max(diameterSum, leftSum + rightSum + root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }
    public static int maxPathSum(Node root) {
        dfs(root);
        return diameterSum;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("Maximum Path Sum = "+maxPathSum(root));
    }
}
