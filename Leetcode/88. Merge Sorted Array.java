import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //initialize new array , nums1.length == m + n,  nums2.length == n
        int j = m;

        //check if array is not empty
        if (n > 0 && m > 0){
            //iterate m+n times, checking wich one is lower
            for (int i = 0; i < n; i++)
            {
                nums1[j] = nums2[i];
                j++;
            }
            Arrays.sort(nums1);
        }
        else if (m == 0 && n > 0)
        {
            for (int i = 0; i < n; i++)
            {
                nums1[i] = nums2[i];
            }
        }
    }
}