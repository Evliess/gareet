package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
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
