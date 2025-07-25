package leetcode;

import java.util.Arrays;

public class GREEDY_Leet_621 {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || n < 0) return 0;
        char[] counts = new char[26];
        for (char ch : tasks) {
            int idx = ch - 'A';
            counts[idx]++;
        }
        Arrays.sort(counts);
        int maxCount = counts[25];
        int idleSlots = (maxCount - 1) * n;
        for (int i = 24; i >= 0 && counts[i] > 0; i--) {
            idleSlots -= Math.min(maxCount - 1, counts[i]);
        }
        return tasks.length + Math.max(0, idleSlots);
    }
}
