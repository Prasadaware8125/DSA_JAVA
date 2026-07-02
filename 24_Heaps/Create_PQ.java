import java.util.Comparator;
import java.util.PriorityQueue;
public class Create_PQ {

    static class Student implements Comparable<Student>{
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
        // Important for priority
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        };
    }
    public static void main(String[] args) {
        // Comparator.reverseOrder() to reverse the priority
        PriorityQueue<Student> pq = new PriorityQueue<>();

        // O(logn)
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while ( !pq.isEmpty() ) {
            System.out.println(pq.peek().name+" -> "+ pq.peek().rank);  // O(1)
            pq.remove();    // O(logn)
        }
    }
}
