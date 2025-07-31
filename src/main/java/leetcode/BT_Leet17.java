package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BT_Leet17 {

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty())
            return ans;
        String[] keys = new String[10];
        keys[0] = "";
        keys[1] = "abc";
        keys[2] = "def";
        keys[3] = "ghi";
        keys[4] = "jkl";
        keys[5] = "mno";
        keys[6] = "pqrs";
        keys[7] = "tuv";
        keys[8] = "wxyz";
        backtrack(digits, keys, "", 0, ans);
        return ans;
    }

    /**
     * @param digits
     * @param keys
     * @param curr
     * @param index  按键的index
     * @param ans
     */
    public static void backtrack(String digits, String[] keys, String curr, int index, List<String> ans) {
        if (curr.length() == digits.length()) {
            ans.add(curr);
            return;
        }
        //根据按键的index找到上面的字符串
        int pos = Integer.valueOf("" + digits.charAt(index));
        String posValues = keys[pos - 1];
        for (int i = 0; i < posValues.length(); i++) {
            curr = curr + posValues.charAt(i);
            backtrack(digits, keys, curr, index + 1, ans);
            curr = curr.substring(0, curr.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> ans = letterCombinations("23");
        System.out.println(ans);

        String str = "123";
        System.out.println(Integer.valueOf('1' + ""));
    }


}
