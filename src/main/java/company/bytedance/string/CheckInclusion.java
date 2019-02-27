package company.bytedance.string;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("hello", "ooolleoooleh"));
        System.out.println(new CheckInclusion().checkInclusion("he", "ooolleoooleh"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] characters = string2Map(s1);
        int[] temp;

        //还可以优化，就一个temp，每次减一个字母，加一个字母，不过没现在代码清晰
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String sub = s2.substring(i, s1.length() + i);
            temp = string2Map(sub);
            if (Arrays.equals(characters, temp)) {
                return true;
            }
        }
        return false;
    }

    private int[] string2Map(String sub) {
        int[] characters = new int[26];

        for (int j = 0; j < sub.length(); j++) {
            char c = sub.charAt(j);
            characters[c - 'a']++;
        }
        return characters;
    }
}