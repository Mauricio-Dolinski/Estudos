class Solution {
    public boolean isSubsequence(String s, String t) {
        //initialize
        char c1;
        int foundAt = 0;

        //iterate though char of string s
        for (int i = 0; i < s.length(); i++) {
            c1 = s.charAt(i);

            //iterate though char of string t starting at foundAt
            while (foundAt < t.length() && t.charAt(foundAt) != c1) foundAt++;
            if (foundAt == t.length()) return false;
            foundAt++;
        }
        return true;
    }
}