class Solution {
    public long[] resultArray(int[] nums, int k) {

        int n = nums.length;
        long[] ans = new long[k];
        long[] result = new long[k];

        for (int i = 0; i < n; i++) {

            long[] newResult = new long[k];

            for (int j = 0; j < k; j++) {
                int newRemainder = (int) ((j * 1L * nums[i]) % k);
                newResult[newRemainder] += result[j];
            }

            newResult[nums[i] % k]++;
            result = newResult;
            for(int j=0; j<k; j++) ans[j]+=result[j];
        }

        return ans;
    }
}