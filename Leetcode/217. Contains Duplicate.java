class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int value : nums)
        {
            if (!set.add(value)) return true;
        }
        return false;
    }
}