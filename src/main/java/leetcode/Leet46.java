package leetcode;

import java.util.ArrayList;
import java.util.List;

//46. 全排列
public class Leet46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List <Integer>> answers = new ArrayList<>();
        beBack(nums, new ArrayList<>(), answers);
        return answers;
    }

    public static void beBack(int[] nums, List<Integer> path, List<List<Integer>> answers) {
        if (path.size() == nums.length) {
            answers.add(new ArrayList<>(path));
            return;
        }
        for ( int num: nums) {
            if(path.contains(num)) continue;
            path.add(num);
            beBack(nums, path, answers);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
    }
}
