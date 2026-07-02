// Find k-th smallest element in BST
// We have the root of a binary search tree and K as input, find Kth smallest element in BST.
//  8
// / \
// 5 11
// / \ \
// 3 6 20
// Sample Input 1 : k=3
// Sample Output 1 : 8
// Sample Input 2 : k=5
// Sample Output 2 : 5 

// LEETCODE (230)
// MEDIUM
// O(N)

import java.util.Scanner;

public class Q3 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int count;
    public static int val;

    public static void find(Node root, int k) {
        if( root == null ) {
            return;
        }

        find(root.left, k);
        count++;
        if( count == k ) {
            val = root.data;
            return;
        }
        find(root.right, k);
    }

    public static int kthSmallest(Node root, int k) {
        count = 0;
        val = -1;
        find(root, k);
        return val;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        root.right = new Node(22);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int k = sc.nextInt();
        System.out.println(k+" Smallest element is: "+kthSmallest(root, k));
        sc.close();
    }
}
