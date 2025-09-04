package org.example;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class XPowY {
    //这种解法满但是正确
    public static Integer distinct(Integer x, Integer y) {
        Set<BigInteger> results = new HashSet<>();
        // 对于每个指数 b (从 1 到 y)
        for (int b = 1; b <= y; b++) {
            // 对于每个底数 a (从 1 到 x)
            for (int a = 1; a <= x; a++) {
                results.add(BigInteger.valueOf(a).pow(b));
            }
        }
        return results.size();
    }

    public static Integer solution2(Integer x, Integer y) {
        Set<BigInteger> set = new HashSet<>();
        for (int a = 1; a <= x; a++) {
            BigInteger base = BigInteger.valueOf(a);
            for (int p = 1; p <= y; p++) {
                set.add(base.pow(p));
            }
        }
        return set.size();
    }


    //这种解法需要优化，答案不正确
    public static void solution() {
        final int MAX = 1000;
        Set<BigInteger> distinctResults = new HashSet<>();
        boolean[] isProcessed = new boolean[MAX + 1];

        for (int x = 2; x <= MAX; x++) {
            // 如果 x 已经被处理过（因为它是一个更小的数的幂），则跳过
            if (isProcessed[x]) {
                continue;
            }

            // x 是一个“根基数”，计算它所有的幂
            BigInteger baseX = BigInteger.valueOf(x);
            for (int y = 2; y <= MAX; y++) {
                distinctResults.add(baseX.pow(y));
            }

            // 标记 x 的更高次幂，以便后续跳过它们
            // 使用 long 防止 p 溢出
            long p = (long) x * x;
            while (p <= MAX) {
                isProcessed[(int) p] = true;
                p *= x;
            }
        }

        System.out.println("优化后的不重复数总数是: " + distinctResults.size());
    }


    public static void isCalculated(int x, int y, boolean[] isProcessed) {
        long p = (long) x * x;
        while (p <= y) {
            isProcessed[(int) p] = true;
            p *= x;
        }
    }


    public static void main(String[] args) {
        System.out.println(distinct(1000, 1000)); //1,2,4,8
        System.out.println(solution2(1000, 1000)); //1,2,4,8
        solution();
    }
}
