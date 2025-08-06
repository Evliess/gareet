package leetcode;

/**
 * 初始化一个动态规划数组 dp，其中 dp[i] 表示 i 个节点能组成的BST数量
 * <p>
 * 设置基本情况：
 * <p>
 * dp[0] = 1（空树算一种情况）
 * <p>
 * dp[1] = 1（只有一个节点只有一种BST）
 * <p>
 * 对于每个 i 从2到n：
 * <p>
 * 计算以每个 j (1 ≤ j ≤ i) 为根节点时的BST数量
 * <p>
 * 累加所有可能的 j 的情况：dp[i] += dp[j-1] * dp[i-j]
 * <p>
 * 最终返回 dp[n] 作为结果
 */
public class DP_Leet96 {

    public int numTrees(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //这里是累加和
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
