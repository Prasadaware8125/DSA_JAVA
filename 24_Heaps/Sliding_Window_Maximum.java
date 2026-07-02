import java.util.PriorityQueue;

// TC = O(NlogN)
public class Sliding_Window_Maximum {
    static class Window implements Comparable<Window> {
        int val, idx;

        public Window(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Window w2) {
            // maxHeap
            return w2.val - this.val;
        }
    }    

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<Window> pq = new PriorityQueue<>();
        for( int i = 0 ; i < k ; i++ ) {
            pq.add(new Window(nums[i], i));
        }

        res[0] = pq.peek().val;
        for(int i = k ; i < n ; i++ ) {
            while ( pq.size() > 0 && pq.peek().idx <= (i-k) ) {
                pq.remove();
            }
            pq.add(new Window(nums[i], i));
            res[i-k+1] = pq.peek().val;     // i-k+1 is the window number
        }

        return res;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 3, -1, -1, 5 ,3, 6, 7};
        // int k = 3;
        int[] arr = {1, -1};
        int k = 1;
        int[] res = maxSlidingWindow(arr, k);
        for( int i = 0 ; i < res.length ; i++ ) {
            System.out.print(res[i]+" ");
        }
    }
}
