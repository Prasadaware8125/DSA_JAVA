// Two Sum BSTs
// Given a BST, transform it into a greater sum tree where each node contains sum of all nodes
// greater than that node.

// Sample Input 1 :
// 5
// / \
// 3 7
// / \ / \
// 2 4 6 8
// 10
// / \
// 6 15
// / \ / \
// 3 8 11 18
// x = 16
// Sample Output 1 : 3
// The pairs are:
// (5, 11), (6, 10) and (8, 8)

// Medium
// GFG Pair sum

import java.util.ArrayList;

public class Q4 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inOrder(Node root, ArrayList<Integer> arr) {
        if( root == null ) return;

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    public static ArrayList<Integer> mergeLists(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int i = 0; 
        int j = 0;

        ArrayList<Integer> list = new ArrayList<>();

        while ( i < arr1.size() && j < arr2.size() ) {
            if( arr1.get(i) < arr2.get(j) ) {
                list.add(arr1.get(i));
                i++;
            } else {
                list.add(arr2.get(j));
                j++;
            }
        }
        while ( i < arr1.size() ) {
            list.add(arr1.get(i));
            i++;
        }
        while ( j < arr2.size() ) {
            list.add(arr2.get(j));
            j++;
        }

        return list;
    }

    public static ArrayList<ArrayList<Integer>> twoSumBSTs(Node root1, Node root2, int target) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        inOrder(root1, arr1);
        inOrder(root2, arr2);

        ArrayList<Integer> list = mergeLists(arr1, arr2);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int i = 0, j = list.size()-1;

        while ( i < j ) {
            int sum = list.get(i) + list.get(j);
            if( sum == target ) {
                ArrayList<Integer> li = new ArrayList<>();
                li.add(list.get(i));
                li.add(list.get(j));
                res.add(li);
                i++;
                j--;
            } else if( sum < target ) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        root1.right = new Node(7);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);


        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);

        root2.right = new Node(15);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        ArrayList<ArrayList<Integer>> res = twoSumBSTs(root1, root2, 16);
        for( int i = 0 ; i < res.size() ; i++ ) {
            ArrayList<Integer> li = res.get(i);
            for( int j = 0 ; j < li.size() ; j++ ) {
                System.out.print(li.get(j)+" ");
            }
            System.out.println();
        }
    }
}
