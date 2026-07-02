public class QueueUsingArrays {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue( int n ) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        // O(1)
        public void enqueue( int data ) {
            if( rear == size-1) {
                System.out.println("Queue is full!");
                return;
            }
            arr[++rear] = data;
        }

        // O(1)
        public int dequeue() {
            if( isEmpty() ) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int front = arr[0];
            for( int i = 0 ; i < rear ; i++ ) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }


        // O(1)
        public int peek() {
            if( isEmpty() ) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        // q.enqueue(6);

        while( !q.isEmpty() ) {
            System.out.println(q.peek());
            q.dequeue();
        }
    }
}
