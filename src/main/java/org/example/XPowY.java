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


    //这种解法需要优化，答案不正确
    public static Integer solution(Integer x, Integer y) {
        Set<BigInteger> set = new HashSet<>();
        //处理所有X^1的情况
        for (int i = 1; i <= x; i++) {
            set.add(BigInteger.valueOf(i));
        }
        //处理所有X^y的情况，其中y>=2
        for (int a = 2; a <= x; a++) {
            if (isCalculated(a)) continue;
            BigInteger base = BigInteger.valueOf(a);
            for (int p = 2; p <= y; p++) {
                set.add(base.pow(p));
            }
        }
        return set.size();
    }


    public static boolean isCalculated(int n) {
        if (n == 1) return false;
        // 检查所有可能的指数
        for (int exponent = 2; exponent <= (int) (Math.log(n) / Math.log(2)) + 1; exponent++) {
            int root = (int) Math.round(Math.pow(n, 1.0 / exponent));
            if (Math.pow(root, exponent) == n) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(distinct(20, 30)); //1,2,4,8
        System.out.println(solution(20, 30));
    }
}
