package company.bytedance;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("hello", "ooolleoooleh"));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> characters = string2Map(s1);
        Map<Character, Integer> temp;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String sub = s2.substring(i, s1.length() + i);
            temp = string2Map(sub);
            if (temp.size() != characters.size()) {
                continue;
            }
            for (Character c : characters.keySet()) {
                if (!temp.containsKey(c) || !characters.get(c).equals(temp.get(c))) {
                    break;
                }
            }
            return true;

        }
        return false;
    }

    private Map<Character, Integer> string2Map(String sub) {
        Map<Character, Integer> characters = new HashMap<>();

        for (int j = 0; j < sub.length(); j++) {
            char c = sub.charAt(j);
            if (!characters.containsKey(c)) {
                characters.put(c, 0);
            }
            characters.put(c, characters.get(c) + 1);
        }
        return characters;
    }
}