import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final Map<Character, Integer> ROMAN_MAP;

    static {
        ROMAN_MAP = new HashMap();
        ROMAN_MAP.put('I', 1);
        ROMAN_MAP.put('V', 5);
        ROMAN_MAP.put('X', 10);
        ROMAN_MAP.put('L', 50);
        ROMAN_MAP.put('C', 100);
        ROMAN_MAP.put('D', 500);
        ROMAN_MAP.put('M', 1000);
    }

    public int romanToInt(String s) {
        int a = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int n = ROMAN_MAP.get(s.charAt(i));
            if (4 * n < a) a -= n;
            else a += n;
        }
        return a;
    }
}