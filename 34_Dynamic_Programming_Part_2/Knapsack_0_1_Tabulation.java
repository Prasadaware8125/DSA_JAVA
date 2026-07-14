
public class Knapsack_0_1_Tabulation {
    public static int knapsack(int[] val, int[] wt, int W) {
        int n = val.length;     
        // n + 1 = number of rows for dp & W + 1 = number of columns for dp
        int[][] dp = new int[n+1][W+1];
        for( int i = 0 ; i < dp.length ; i++ ) {    // making all rows of 0th column as 0
            dp[i][0] = 0;
        }
        for( int i = 0 ; i < dp[0].length ; i++ ) {     // making all columns of 0th row as 0
            dp[0][i] = 0;
        }

        for(int i = 1 ; i < dp.length ; i++ ) {
            for(int j = 1 ; j < dp[0].length ; j++ ) {
                int value = val[i-1];   // vlaue of current item
                int weight = wt[i-1];   // weight of current item
                if( weight <= j ) {     // valid condition (current weight of is less than the capacity of knapsack)
                    int includeProfit = value + dp[i-1][j-weight];  // calculating profit including value & weight of current item
                    int excludeProfit = dp[i-1][j]; // calculating profit without include value and weight of current item
                    dp[i][j] = Math.max(includeProfit, excludeProfit);  // storing max from including and exlcuding of value and weight of current item
                } else {    // invalid condition (current weight is not less the capcity of knapsack)
                    int excludeProfit = dp[i-1][j];     // calculating the profit without including value and weight of current item
                    dp[i][j] = excludeProfit;   // storing it in dp
                }
            }
        }
        return dp[n][W];    // always last item at index n, W is the answer
    }
    public static void main(String[] args) {
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7;
        
        System.out.println("Max profit = "+knapsack(val, wt, W) );
        
    }
}
