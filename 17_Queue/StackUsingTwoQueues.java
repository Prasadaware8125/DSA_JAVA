import java.util.*;
import java.util.LinkedList;

public class StackUsingTwoQueues {
    static class Stack {    // Intializing stack
        // Creating two Queues 
        Queue<Integer> q1 = new LinkedList<>(); 
        Queue<Integer> q2 = new LinkedList<>();

        // To check is Stack empty or not
        // If both the queues are empty then the stack is empty too
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) {
            if( !q1.isEmpty() ) {   // If q1 is not empty then adding the elements to it
                q1.add(data);
            } else {    // else adding to q2
                q2.add(data);
            }
        }

        public int pop() {
            // Checking is stack empty or not
            if( isEmpty() ) {   
                System.out.println("Stack is empty!");
                return -1;
            }

            int top = -1;

            if( !q1.isEmpty() ) {   // if q1 is not empty then it means all the elements are present in q1
                while ( !q1.isEmpty() ) {   // while q1 doesn't become empty we will keep to remove elements from it
                    top = q1.remove();  // giving the value of removed elements of q1
                    if( q1.isEmpty() ) {    // when q1 becomes empty it means the last element of q1 is the top element of stack
                        break;
                    }
                    q2.add(top);    // adding the removed elements of q1 to q2
                }
            } else {
                while( !q2.isEmpty() ) {
                    top = q2.remove();
                    if( q2.isEmpty() ) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek() {
            if( isEmpty() ) {
                System.out.println("Stack is Empty!");
                return -1;
            }

            int top = -1;

            if( !q1.isEmpty() ) {
                while( !q1.isEmpty() ) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while( !q2.isEmpty() ) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while( !s.isEmpty() ) {
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
}
