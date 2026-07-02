public class CircularQueueUsingArrays {
    static class Queue {
        static int arr[];
        int size;
        static int rear;
        static int front;
        
        Queue( int n ) {
            arr = new int[n];
            size = n;
            rear = front = -1;
        }

        public boolean isEmpty() {
            return rear == -1 && front == -1; 
        }

        public boolean isFull() {
            return (rear+1) % size == front;
        }

        public void enqueue( int data ) {
            if( isFull() ) {
                System.out.println("Queue is Full!");
                return;
            }  

            if( front == -1 ) {
                front = 0;
            }

            rear = ( rear + 1 ) % size;
            arr[rear] = data;
        }

        public int dequeue() {
            if ( isEmpty() ) {
                System.out.println("Queue is Empty!");
                return -1;
            }
            int result = arr[front];
            if( rear == front ) {
                rear = front = -1;
            } else {
                front = ( front + 1 ) % size;
            }

            return result;
        }

        public int peek() {
            if ( isEmpty() ) {
                System.out.println("Queue is Empty!");
                return -1;
            }

            return arr[front];
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
        q.enqueue(6);
        System.out.println("Length : "+q.size);

        System.out.println("Dequeued : "+q.dequeue());
        
        q.enqueue(6);
        System.out.println("Length : "+q.size);

        System.out.print("Queue Elements : ");
        while( !q.isEmpty() ) {
            System.out.print(q.peek()+"->");
            q.dequeue();
        }
    }
}
