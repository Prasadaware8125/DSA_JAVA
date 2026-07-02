public class StackUsingLinkedList {
    static class Stack {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public Node head;   // Instance variable, not static

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int val = head.data;
            head = head.next;
            return val;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack s = new StackUsingLinkedList.Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        System.out.println(s.peek());

    }
}
