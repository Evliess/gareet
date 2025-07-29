package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet406 {

    //people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            //根据身高从大到小排序，身高相等，则根据k从小到大排序
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            return p2[0] - p1[0];
        });

        List<int[]> res = new ArrayList<>();

        for (int[] r : people) {
            res.add(r[1], r);
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] p = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};


    }
}
