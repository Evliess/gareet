package leetcode;
//TopologicalSort


import java.util.*;

public class TSort_Leet207 {

    //[1,0] 表示 1 依赖 0, 1 有一个入度
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> degree = new LinkedList<>();

        Map<Integer, Integer> relations = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            relations.put(i, 0); // 初始化所有课程的入度为 0
        }
        for (int[] p : prerequisites) {
            relations.put(p[0], relations.getOrDefault(p[0], 0) + 1);
        }

        for (Integer key : relations.keySet()) {
            if (relations.get(key) == 0) {
                degree.offer(key);
            }
        }

        while (!degree.isEmpty()) {
            Integer key = degree.poll();
            ans.add(key);
            for (int[] p : prerequisites) {
                //[1,0] 表示 1 依赖 0
                if (p[1] == key) {
                    //p[1] == key 将所有依赖是key的找到，入度减一
                    relations.computeIfPresent(p[0], (k, v) -> v - 1);
                    if (relations.get(p[0]) == 0) {
                        degree.offer(p[0]);
                    }
                }
            }
        }
        return numCourses == ans.size();
    }

    public static void main(String[] args) {
        int[][] p = {{1, 0}, {0, 1}};
        System.out.println(canFinish(2, p));

    }
}
