package leetcode;

public class DP_Leet221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxSide = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                //此处容易忘记更新maxSide
                maxSide = 1;
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                //此处容易忘记更新maxSide
                maxSide = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }

}
