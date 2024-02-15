class Solution {
    public int[] twoSum(int[] nums, int target) {
        //create a hashmap to store the distance of the numbers to target
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        //iterate though nums
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //find the distance from target
            int distance = target-num;
            
            //check whether distance is already a key in map
            if (!map.containsKey(distance)) {
                //pupulate the hashmap
                map.put(num, i);
            } else {
                //if it's a key already found the result
                result[0] = (int) map.get(distance);
                result[1] = i;
                break;
            }
        }
        return result;
    }
}