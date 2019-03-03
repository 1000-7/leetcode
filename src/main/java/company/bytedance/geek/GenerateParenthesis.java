package company.bytedance.geek;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
    
    public void generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateOneByOne("", result, n, n);
        System.out.println(result);
    }
    
    private void generateOneByOne(String s, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            generateOneByOne(s + "(", result, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(s + ")", result, left, right - 1);
        }
    }
    
}
