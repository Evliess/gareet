package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BT_Leet17 {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        Map<String, String> dict = buildDict();
        List<String> ans = new ArrayList<>();
        backtrack(digits, 0, dict, new StringBuilder(), ans);
        return ans;
    }

    public static void backtrack(String digits, int index, Map<String, String> dict, StringBuilder path, List<String> ans) {
        if (digits.length() == path.length()) {
            ans.add(path.toString());
            return;
        }
        for (char s : dict.get(digits.charAt(index) + "").toCharArray()) {
            backtrack(digits, index + 1, dict, path.append(s), ans);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static Map<String, String> buildDict() {
        Map<String, String> dict = new HashMap<>();
        dict.put("2", "abc");
        dict.put("3", "def");
        dict.put("4", "ghi");
        dict.put("5", "jkl");
        dict.put("6", "mno");
        dict.put("7", "pqrs");
        dict.put("8", "tuv");
        dict.put("9", "wxyz");
        return dict;
    }

    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }


}
