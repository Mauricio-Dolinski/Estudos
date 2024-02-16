class Solution {
    public boolean isIsomorphic(String s, String t) {
        //initialize a HashMap
        HashMap hmap = new HashMap<Character, Character>();

        // iterate through the characters in the strings
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // if the current character in s has already been mapped
            if (hmap.containsKey(c1)) {
                // check that the mapped character is the same as the current character in t
                if ((char) hmap.get(c1) != c2) {
                    return false;
                }
            } else {
                // check that the current character in t has not been mapped to another character in s
                if (hmap.containsValue(c2)) {
                    return false;
                }
                // if the current character in s has not been mapped, add a mapping to the hash map
                hmap.put(c1, c2);
            }
        }
        return true;
    }
}