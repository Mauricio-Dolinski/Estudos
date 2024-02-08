import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] charArray = s.toCharArray();
        int lenght = 0;

        //iterate through string s
        for (char c : charArray) {
            //map each char as key and value as the count
            int prevvalue = map.getOrDefault(c, 0);
            int value = prevvalue+1;
            if (value == 2){
                lenght += 2;
                value = 0;
            }
            map.put(c, (value));
        }
            
        if (map.containsValue(1)) lenght += 1;
        
        return lenght;
    }
}