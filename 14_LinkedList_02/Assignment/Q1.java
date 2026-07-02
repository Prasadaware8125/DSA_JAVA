// import java.util.LinkedList;
public class Q1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static Node findIntersection(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;

        while( a != b ) {

            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;

        }
        return a;

    }
    public static void main(String[] args) {
        // LinkedList headA = new LinkedList();
        // headA.addLast(4);
        // headA.addLast(5);
        // headA.addLast(6);
        // headA.addLast(7);
        
        // LinkedList headB = new LinkedList();
        // headB.addLast(1);
        // headB.addLast(2);
        // headB.addLast(3);
        // headB.addLast(6);
        // headB.addLast(7);

        // // Node newNode = new Node(6);
        // // Node newn = new Node(7);

        // // newNode.next = newn;

        // // headA.next = newNode;

        Node headA,headB;
        headA = new Node(10);
        headB = new Node(3);

        Node newNode = new Node(6);
        headB.next = newNode;

        newNode = new Node(9);
        headB.next.next = newNode;

        newNode = new Node(15);
        headA.next = newNode;
        headB.next.next.next = newNode;

        newNode = new Node(30);
        headA.next.next = newNode;

        headA.next.next.next = null;

        Node interSection = findIntersection(headA, headB);

        if( interSection == null ) {
            System.out.println("No Intersection.");
        } else {
            System.out.println("Intersection Point : "+interSection.data);
        }

    }
}