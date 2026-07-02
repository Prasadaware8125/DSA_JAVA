// Given n friend, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
public class FriendsPairingProblem {
    public static int friendsPairingProblem( int n ) {
        // Base Case
        if( n == 1 || n == 2 ) {
            return n;
        }

        // Work
        // Single
        // int fnm1 = friendsPairingProblem(n-1);
        // // Pair
        // int fnm2 = friendsPairingProblem(n-2);
        // int pairways = (n-1) * fnm2;
        // int totways = fnm1 + pairways;
        // // Return
        // return totways;

        // Simple single line
        return friendsPairingProblem(n-1) + (n-1) * friendsPairingProblem(n-2);
    }

    public static void main(String[] args) {
        System.out.println(friendsPairingProblem(3));
    }
}