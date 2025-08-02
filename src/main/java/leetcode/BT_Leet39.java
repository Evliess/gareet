package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//39. 组合总和
public class BT_Leet39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backTrack(candidates, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void backTrack(int[] candidates, int target, int pos, List<Integer> path, List<List<Integer>> answer) {
        if (target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            path.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, path, answer);
            path.remove(path.size() - 1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(ans);
    }


}
