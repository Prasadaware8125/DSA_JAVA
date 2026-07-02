import java.util.ArrayList;

public class Heap_Operations {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // O(longN)
        public void add(int data) {
            // add at last idx
            arr.add(data);

            // x is child index
            int x = arr.size()-1;
            // par is parent index
            int par = ( x - 1 ) / 2;
            
            // O(logN)
            // if we want to make maxHeap make '<' as '>'
            while( arr.get(x) < arr.get(par) ) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                
                x = par;
                par = (x-1)/2;
            }
        }
        
        public int peek() {
            return arr.get(0);
        }
        
        private void heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx =i;
            
            // if we want to make maxHeap make '<' as '>'
            if( left < arr.size() && arr.get(minIdx) > arr.get(left) ) {
                minIdx = left;
            }
            // if we want to make maxHeap make '<' as '>'
            if( right < arr.size() && arr.get(minIdx) > arr.get(right) ) {
                minIdx = right;
            }

            if( minIdx != i ) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // O(logN)
        public int remove() {
             
            int data = arr.get(0);
            // Step 1: Swap first and last elements
            int first = 0;
            int last = arr.size()-1;
            int temp = arr.get(first);
            arr.set(first, arr.get(last));
            arr.set(last, temp);

            // Step 2: Remove/ Delete last element
            arr.remove(arr.size()-1);

            // Step 3: Heapyfy
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while( !h.isEmpty() ) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
