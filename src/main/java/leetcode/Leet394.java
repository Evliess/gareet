package leetcode;

import java.util.Stack;

public class Leet394 {

    //s = "3[a]2[bc]"
    //s=3[a2[c]]
    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == ']') {
                String tmp = "";
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top != '[') tmp = tmp + top;
                    else break;
                }
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    Character digit = stack.pop();
                    numStr.append(digit - '0');
                }
                int num = Integer.parseInt(numStr.reverse().toString());
                tmp = repeat(num, tmp);
                tmp = new StringBuilder(tmp).reverse().toString();
                addToStack(stack, tmp);

            } else {
                stack.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();

    }

    public static void addToStack(Stack<Character> stack, String tmp) {
        char[] chars = tmp.toCharArray();
        for (char ch : chars) {
            stack.push(ch);
        }
    }

    public static String repeat(int n, String str) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "abc3[cd]xyz";
        System.out.println(decodeString(a).equals("abccdcdcdxyz"));
        a = "2[abc]3[cd]ef";
        System.out.println(decodeString(a).equals("abcabccdcdcdef"));
        a = "3[a2[c]]";
        System.out.println(decodeString(a).equals("accaccacc"));
        a = "3[a]2[bc]";
        System.out.println(decodeString(a).equals("aaabcbc"));
        a = "3[a]10[bc]a";
        System.out.println(decodeString(a).equals("aaabcbcbcbcbcbcbcbcbcbca"));

        StringBuilder sb = new StringBuilder("ab");
    }
}
