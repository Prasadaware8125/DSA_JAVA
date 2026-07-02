// O(n)
public class TrappedRainWater {

    public static int trappedRainWater(int height[]) {
        int n = height.length;
        // Left max boundary - array
        int leftmax[] = new int[n];
        leftmax[0] = height[0];
        for( int i = 1 ; i < n ; i++ ) {
            leftmax[i] = Math.max(height[i] , leftmax[i-1]);
        }

        // Right max boundary - array
        int rightmax[] = new int[n];
        rightmax[n-1] = height[n-1];
        for( int i = n - 2 ; i >= 0 ; i-- ) {
            rightmax[i] = Math.max(height[i] , rightmax[i+1]);
        }

        // loop
        int trappedWater = 0;
        for( int i = 0 ; i < height.length ; i++ ) {
            int waterlevel = Math.min(leftmax[i],rightmax[i]);
            trappedWater += waterlevel - height[i];
        }

        return trappedWater;
    }
    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println("Trapped Rain Water = "+trappedRainWater(height));
    }
}
