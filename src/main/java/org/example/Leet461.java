package org.example;

public class Leet461 {
    //异或运算，位不同则为1，否则则为0
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int count(int num) {
        int count = 0;
        while (num != 0) {
            num &= (num - 1); //依次消除最低位的1
            count++;
        }
        return count;
    }
}
