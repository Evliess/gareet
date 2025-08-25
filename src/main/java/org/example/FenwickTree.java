package org.example;

public class FenwickTree {
    int[] tree;

    public FenwickTree(int size) {
        this.tree = new int[size + 2];
    }

    //单点更新：在index位置增加value
    public void update(int index, int num) {
        while (index < tree.length) {
            tree[index] += num;
            index += index & -index;
        }
    }

    //前缀和查询：1到index的和
    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }
        return sum;
    }

    //区间查询left到right的和
    public int rangeSum(int left, int right) {
        return query(right) - query(left - 1);
    }
}
