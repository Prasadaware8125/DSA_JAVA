public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node( int data ) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;


    // Creating Methods to perform operations on linkedlist

    // addFirst : TC = O(1)
    public void addFirst( int data ) {
        // Step 1 : Create new node
        Node newNode = new Node(data);
        size++;

        // Check if list is empty
        if( head == null ) {
            head = tail = newNode;
            return;
        }

        // Step 2 : point newNode's next to head
        newNode.next = head;

        // Step 3 : make newNode as head
        head = newNode;
    }

    // addLast : TC = O(1)
    public void addLast( int data ) {
        // Step 1 : Create new Node
        Node newNode = new Node(data);
        size++;

        // Check if list is empty
        if( head == null ) {
            head = tail = null;
            return;
        }

        // Step 2 : point tail's next to newnode
        tail.next = newNode;

        // Step 3 : make newNode as tail
        tail = newNode;
    }

    // add : TC = O(n)
    public void add( int data , int index ) {
        // if index given is 0 then simply call addfirst method to add the node at head
        if( index == 0 ) {
            addFirst(data);
            return;
        }
        
        // Step 1 : Create new Node
        Node newNode = new Node(data);
        size++;

        // Check if list is empty
        if( head == null ) {
            head = tail = newNode;
            return;
        }
        

        Node temp = head;
        int i = 0;
        while( i < index-1 ) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Print LinkedList : TC = O(n)
    public void printLL() {
        if( head == null ) {
            System.out.println("Null");
        } else {
            Node temp = head;
            while( temp != null ) {
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("Null");
        }
    }

    // removeFirst : TC = O(1)
    public int removeFirst() {
        // Cover the special / corner cases
        if( size == 0 ) {
            System.out.println("Empty LL");
            return Integer.MIN_VALUE;
        } else if( size == 1 ) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // get the value of head i.e first node
        int val = head.data;
        // make head to point to next node of it
        head = head.next;
        // decrease the size of ll
        size--;
        // return the value at head / first node of ll
        return val;
    }

    // removeLast : TC = O(n)
    public int removeLast() {
        // Cover the special / corner cases
        if( size == 0 ) {
            System.out.println("Empty LL");
            return Integer.MIN_VALUE;
        } else if( size == 1 ) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for( int i = 0 ; i < size-2 ; i++ ) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    // Iterative Search : TC = O(n)
    /*Search for a key in a Linked List. Return the position where it is found.
     * If not found, return -1.
     */
    public int iterativeSearch( int key ) {
        int i = 0;
        Node temp = head;
        while( temp != null ) {
            if( temp.data == key ) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Recursive Search : TC = O(n)
    /*Search for a key in a Linked List. Return the position where it is found.
     *If not found, return -1. Use Recursion.
     */
    public int helperFunction( Node head , int key ) { // helper fuction
        if( head == null ) {
            return -1; // if key not found
        }

        if( head.data == key ) { // if key found
            return 0;
        }

        int idx = helperFunction(head.next, key); // for next 

        if( idx == -1 ) {
            return -1;
        }

        return idx+1; // if key found, add 1 to the given index
    }

    public int recursiveSearch( int key ) { // main recursive function 
        return helperFunction(head, key);
    }

    // Reverse a Linked List : TC = O(n)
    // Iterative approach
    public void reverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Find and Remove Nth node from End : TC = O(n)
    // Iterative Approach
    // Nth node from end = (size-N+1) from start
    public void deleteNthNodeFromEnd( int n ) {
        Node temp = head;
        int sz = 0;
        while( temp != null ) {
            temp = temp.next;
            sz++;
        }

        if( n == sz ) {
            head = head.next; // Remove first
            return;
        }

        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while( i < iToFind ) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    // Check if LL is a Palindrome : TC = O(n) and SC = O(1)
    /*1. Slow-fast concept
     *2. Reverse half LL
     */
    /*
     * Step 1 : Find Middle of LL i.e mid node
     * Step 2 : Reverse the second half of LL
     * Step 3 : Check if 1st half(left) == 2nd half(right)
     */

    public Node findMid( Node head ) { // helper function
        Node slow = head;
        Node fast = head;
        
        while ( fast != null && fast.next != null ) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow;
    }

    public boolean checkPalindrome() {
        if( head == null || head.next == null ) {
            return true;
        }

        // Step 1 : find mid
        Node midNode = findMid(head);

        // Step 2 : reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // head of right half LL
        Node left = head; // head of left half LL

        // Step 3 : Check left half and right half
        while( right != null ) {
            if( left.data != right.data ) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
    

    // public static void main(String[] args) {
    //     LinkedList ll = new LinkedList();
    //     System.out.println("Add First : ");
    //     ll.addFirst(3);
    //     ll.addFirst(2);
    //     ll.addFirst(1);
    //     ll.printLL();
    //     System.out.println("Add Last : ");
    //     ll.addLast(9);
    //     ll.addLast(10);
    //     ll.printLL();
    //     System.out.println("Add mid / at any index : ");
    //     ll.add(4,3);
    //     ll.add(5,4);
    //     ll.add(6,5);
    //     ll.add(7,6);
    //     ll.add(8,7);
    //     ll.printLL();
    //     System.out.println("Size of LinkedList : "+size);
    //     System.out.println("Remove First : ");
    //     ll.removeFirst();
    //     ll.printLL();
    //     ll.removeFirst();
    //     ll.printLL();
    //     System.out.println("Size of LinkedList : "+size);
    //     System.out.println("Remove Last : ");
    //     ll.removeLast();
    //     ll.printLL();
    //     ll.removeLast();
    //     ll.printLL();
    //     System.out.println("Size of LinkedList : "+size);
    //     System.out.println("Key found at index = "+ll.iterativeSearch(6));
    //     System.out.println("Key found at index = "+ll.iterativeSearch(10));
    //     System.out.println("Key found at index = "+ll.recursiveSearch(5));
    //     System.out.println("Key found at index = "+ll.recursiveSearch(9));

    //     System.out.println("Reverse a Linked List : ");
    //     ll.reverseLL();
    //     ll.printLL();

    //     System.out.println("Delete Nth node from end : ");
    //     ll.deleteNthNodeFromEnd(3);
    //     ll.printLL();

    //     // Check if LL is a Palindrome
    //     System.out.println("Check LL is a Palindrome : ");
    //     System.out.println(ll.checkPalindrome());        
    // }

    // Linked List Part 2 

    // Find if Linked list is cyclic or not
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

    // if ll is cyclic then make it linear
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

    // Merge Sort O(nlogn)
    public static Node mergeSort(Node head) {
        if( head == null || head.next == null ) {
            return head;
        }

        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);


    }

    public static Node getMid(Node head) {
        Node slow = head, fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (head1!=null && head2!=null) {
            if( head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else { 
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1!=null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next; 
        }

        while (head2!=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next; 
        }

        return dummyNode.next;
    }

    // Zig-Zag Linked List
    public static void zigZap(Node head) {

        Node mid = getMid(head);
        
        Node curr = mid;
        Node prev = null;
        Node nex;

        while( curr != null ) {
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }

        Node rightHead = prev;
        Node leftHead = head;

        Node nextL,nextR;

        while (leftHead != null && rightHead != null ) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            rightHead = nextR;
            leftHead = nextL;
        }

        
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);

        LinkedList.head = mergeSort(LinkedList.head);
        // System.out.println(ll);
        ll.printLL();
        zigZap(head);
        ll.printLL();
    }
}
