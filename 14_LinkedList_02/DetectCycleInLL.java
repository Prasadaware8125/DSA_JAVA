public class DetectCycleInLL {

    static class Node {
        int data;
        Node next;

        Node( int data ) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    public static boolean isCycleInLL() {
        Node slow = head;
        Node fast = head;

        while( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast ) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycleInLL() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast ) {
                cycle = true;
                break;
            }
        }

        if( cycle == false ) {
            return;
        }

        slow = head;
        Node prev = null;
        while ( slow != fast ) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public static void printLL() {
        Node temp = head;
        while( temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = temp;
        System.out.println(isCycleInLL());
        removeCycleInLL();
        printLL();
    }
}
