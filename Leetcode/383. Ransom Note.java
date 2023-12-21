class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mapMagazineChar = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            mapMagazineChar.put(c, mapMagazineChar.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!mapMagazineChar.containsKey(c) || mapMagazineChar.get(c) == 0) {
                return false;
            }
            mapMagazineChar.put(c, mapMagazineChar.get(c) - 1);
        }

        return true;
    }
}