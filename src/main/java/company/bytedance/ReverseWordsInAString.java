package company.bytedance;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例:
 * <p>
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * <p>
 * 说明:
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String result = "";
        for (int i = words.length - 1; i > 0; i--) {
            result += words[i] + " ";
        }

        return result + words[0];
    }
}
