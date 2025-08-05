

public class MinFallingPath {
        public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return 0;
        }
        // DP array to store the minimum path sum to each cell
        int[][] dp = new int[len][len];
        for (int j = 0; j < len; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill the DP table row by row
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int minPathFromAbove = dp[i-1][j];
                if (j > 0) {
                    minPathFromAbove = Math.min(minPathFromAbove, dp[i-1][j-1]);
                }
                if (j < len - 1) {
                    minPathFromAbove = Math.min(minPathFromAbove, dp[i-1][j+1]);
                }
                dp[i][j] = matrix[i][j] + minPathFromAbove;
            }
        }
        int minsum = Integer.MAX_VALUE;
        for (int j = 0; j < len; j++) {
            minsum = Math.min(minsum, dp[len - 1][j]);
        }
        return minsum;
    }
}
