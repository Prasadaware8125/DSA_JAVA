import java.util.Scanner;

public class Disjoint_Set_Union {
    static int n = 7;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for( int i = 0 ; i < n ; i++ ) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if( x == par[x] ) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if( rank[parA] == rank[parB] ) {
            par[parB] = parA;
            rank[parA]++;
        } else if( rank[parB] < rank[parA] ) {
            par[parB] = parA;
        } else if( rank[parB] > rank[parA] ) {
            rank[parA] = parB;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            init();
            while (true) {
                System.out.println("1 -> Union");
                System.out.println("2 -> Find");
                System.out.print("Enter choice : ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter 1st number : ");
                        int first = sc.nextInt(); 
                        System.out.print("Enter 2nd number: ");
                        int second = sc.nextInt();
                        union(first, second);
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Enter number to search : ");
                        int num = sc.nextInt();
                        System.out.println("Parent of "+num+" is "+find(num));
                        break;
                    default:
                        break;
                }
            }
        }
    }
}