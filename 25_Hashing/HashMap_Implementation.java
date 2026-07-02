import java.util.LinkedList;
import java.util.ArrayList;

public class HashMap_Implementation {
    static class HashMap<K, V>{ // generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value= value;
            }
        }
        private int n;   // number of total nodes
        private int N;   // Size of array buckets
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings({ "unchecked", "rawtypes" })
        // HashMap Initiallization
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for( int i = 0 ; i < N ; i++ ) {
                this.buckets[i] = new LinkedList();
            }
        }

        // To find or generate bucket indext
        // O(1)
        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        // Search the linked list at bucket index for key node

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0; // data index

            for( int i = 0 ; i < ll.size() ; i++ ) {
                Node node = ll.get(i);
                if( node.key == key ) {
                    return di;  // found key (key exists)
                }
                di++;
            }

            return -1;  // if not found (key doesn't exists)
        }
        @SuppressWarnings("unchecked")  // to hide the warnings
        // O(N)
        // We use rehashing only when lambda > k (threshold)
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            N = 2*N;    // making buckets array twice of its original size
            buckets = new LinkedList[N*2];  // reinitiallizing buckets array

            // initilize LinkedList at each index of bucket array
            for( int i = 0 ; i < N ; i++ ) {
                buckets[i] = new LinkedList();
            }

            // Transfer(copy) all the nodes from old bucket array to new bucket array
            for( int i = 0 ; i < oldBuck.length ; i++ ) {
                LinkedList<Node> ll = oldBuck[i];
                for( int j = 0 ; j < ll.size() ; j++ ) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        // O(1)
        public void put(K key, V value) {
            // Getting the bucket indext from hashFuction, it is always from 0 to N
            int bi = hashFunction(key); // from 0 to 3
            // Getting the index of the node equal to key
            int di = searchInLL(key, bi);   // if not found valid index return 0

            // Key exists, update the nodes value
            if( di != -1 ) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {    // key doesn't exists, add new node to LL
                buckets[bi].add(new Node(key, value));
                // increse number of nodes in bucket
                n++;
            }

            // to check if the bucket array is full (uneven)
            // For proper HashMap lambda <= k
            double lambda = (double) n / N;
            if( lambda > 2.0 ) {    // lambda > k
                rehash();   // if uneven the rehash the HashMap (reiniliaze)
            }
        }

        // O(1)
        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if( di != -1 ) {
                return true;
            } else {
                return false;
            }
        }

        // (1)
        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if( di != -1 ) {
                Node node = buckets[bi].remove(di);
                // decrease the number of nodes as one node is removed
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        // O(1)
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if( di != -1 ) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        // O(N)
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for( int i = 0 ; i < N ; i++ ) {
                LinkedList<Node> ll = buckets[i];

                for (Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        // O(1)
        public boolean isEmpty() {
            return n == 0;
        }
    }


    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        System.out.println("Is HashMap Empty => "+hm.isEmpty());

        hm.put("India", 100);
        hm.put("Chine", 150);
        hm.put("US", 50);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);


        System.out.println("Does HashMap contains key = India => "+hm.containsKey("India"));    // True
        System.out.println("Does HashMap contains key = Japan => "+hm.containsKey("Japan"));    // False
        System.out.println("Value of key = US => "+hm.get("US"));   // 50
        System.out.println("Value of key = Japan => "+hm.get("Japan"));   // null
        System.out.println("Number of Total Nodes => "+hm.n);
        System.out.println("Remove key = US => "+hm.remove("US"));    // 50
        System.out.println("Number of Total Nodes after removing Key = US => "+hm.n);
        System.out.println("Remove key = Japan => "+hm.remove("Japan")); // null
        System.out.println("Value of key = US => "+hm.get("US"));   // null

        System.out.println("Key-Value pairs are: ");
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println("("+key+", "+hm.get(key)+")");
        }

        System.out.println("Is HashMap Empty => "+hm.isEmpty());
    }
}
