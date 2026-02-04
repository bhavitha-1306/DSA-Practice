class Solution {
    // This function returns the floor value of the square root of a number
    public int mySqrt(int x) {
        // Handle small numbers directly
        if (x < 2) return x;

        // Initialize binary search range
        int left = 1, right = x / 2, ans = 0;

        // Perform binary search
        while (left <= right) {
            // Find middle point
            long mid = left + (right - left) / 2;

            // Check if mid*mid is less than or equal to x
            if (mid * mid <= x) {
                // Store mid as potential answer
                ans = (int) mid;
                // Move to right half
                left = (int) mid + 1;
            } else {
                // Move to left half
                right = (int) mid - 1;
            }
        }

        // Return final answer
        return ans;
    }

    // Function to find N-th root of M using binary search
    public int nthRoot(int n, int m) {
        // Set low and high for binary search
        int low = 1, high = m;

        // Start binary search
        while (low <= high) {
            // Calculate mid
            int mid = (low + high) / 2;

            // Store result of mid^n
            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= mid;
                if (ans > m) break;
            }

            // If mid^n equals m
            if (ans == m) return mid;

            // If mid^n is less than m
            if (ans < m) low = mid + 1;

            // If mid^n is more than m
            else high = mid - 1;
        }

        // Return -1 if not found
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Sqrt of 8: " + s.mySqrt(8));
        System.out.println("Sqrt of 36: " + s.mySqrt(36));
        System.out.println("Sqrt of 28: " + s.mySqrt(28));
        System.out.println("3rd root of 27: " + s.nthRoot(3, 27));
        System.out.println("4th root of 69: " + s.nthRoot(4, 69));
    }
}
