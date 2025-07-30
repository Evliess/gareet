package leetcode;

import java.util.*;

public class Leet49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null) return ans;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] pattern = new int[26];
            for (char ch : str.toCharArray()) {
                pattern[ch - 'a']++;
            }
            String key = Arrays.toString(pattern);
            if (!map.keySet().contains(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
        }
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(strs);

        Integer[] str = new Integer[]{12};
        System.out.println(Arrays.toString(str));
    }
}
