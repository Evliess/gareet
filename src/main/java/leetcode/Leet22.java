package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet22 {

    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backTrack(n, answer, "", 0, 0);
        return answer;
    }

    public static void backTrack(int n, List<String> ans, String cur, int left, int right) {
        if (cur.length() == 2 * n) {
            ans.add(cur);
            return;
        }

        if (left < n) {
            cur += "(";
            backTrack(n, ans, cur, left + 1, right);
            cur = cur.substring(0, cur.length() - 1);
        }

        if (right < left) {
            cur += ")";
            backTrack(n, ans, cur, left, right + 1);
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }


}
