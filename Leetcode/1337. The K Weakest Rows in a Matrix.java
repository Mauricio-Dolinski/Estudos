class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //initiate variables output int[k]
        int[] result = new int[k];
        int m = mat.length;
        int[] sum = new int[m];
        int n = 0;

        //go on row i
        for (int i = 0; i < m; i++) {
            n = mat[i].length;
            //go on second collunm j 
            for (int j = 0; j < n; j++) {
                //add to sum mat
                sum[i] += mat[i][j];
            }
        }

        //check witch row is weaker and put in result
        int num = 0;     
        int[] tempSum = Arrays.copyOf(sum, m);

        //itterate thought k and find the smallest
        while (num < k)
        {
            int weaker = n+1;
            int tempPlace = 0;
            
            int i = 0;
            for (i = 0; i < m; i++) {
                if (tempSum[i] < weaker) {
                    weaker = tempSum[i];
                    tempPlace = i;
                }
            }
            tempSum[tempPlace] = n+1;
            result[num] = tempPlace;
            num++;
        }

        return result;
    }
}