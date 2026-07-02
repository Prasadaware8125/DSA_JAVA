public class DoubleLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if( head == null ) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }

    // remove - removeFirst
    public static int removeFirst() {
        if( head == null ) {
            return -1;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public static void printLL() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void reverseDLL() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        printLL();
        // System.out.println(size);
        // removeFirst();
        // printLL();
        // System.out.println(size);
        // removeFirst();
        // printLL();
        // System.out.println(size);
        dll.reverseDLL();
        printLL();
        
    }
    
}
