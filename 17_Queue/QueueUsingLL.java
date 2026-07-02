public class QueueUsingLL {
    static class Node {
        int data;
        Node next;

        Node( int data ) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        public static Node head = null;
        public static Node tail = null;
    
        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public void enqueue( int data ) {
            Node newNode = new Node(data);
            if( head == null ) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public int dequeue() {
            if( isEmpty() ) {
                System.out.println("Queue is Empty!");
                return -1;
            }

            int front = head.data;
            if( head == tail ) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public int peek() {
            if( isEmpty() ) {
                System.out.println("Queue is Empty!");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
    
        while ( !q.isEmpty() ) {
            System.out.print(q.peek()+"->");
            q.dequeue();
        }
    }
}
