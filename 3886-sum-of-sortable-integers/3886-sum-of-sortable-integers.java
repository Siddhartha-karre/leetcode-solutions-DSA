import java.util.Arrays;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        // 1. Precompute prefix maximums
        int[] prefMax = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        // 2. Precompute suffix minimums
        int[] suffMin = new int[n + 1];
        Arrays.fill(suffMin, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        // 3. Precompute prefix drop/descent counts
        // prefDrop[i] stores count of j in [1..i] where nums[j-1] > nums[j]
        int[] prefDrop = new int[n];
        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1] + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int totalSum = 0;

        // Check all potential divisors k of n
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean isSortable = true;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                // Count adjacent strictly decreasing pairs in block [start, end]
                int internalDrops = prefDrop[end] - prefDrop[start];

                // Check circular drop connecting the last element back to the first element
                if (nums[end] > nums[start]) {
                    internalDrops++;
                }

                // Block can be rotated to sorted order iff total circular drops <= 1
                if (internalDrops > 1) {
                    isSortable = false;
                    break;
                }

                // Ensure max element of current block <= min element of remaining elements
                if (prefMax[end + 1] > suffMin[end + 1]) {
                    isSortable = false;
                    break;
                }
            }

            if (isSortable) {
                totalSum += k;
            }
        }

        return totalSum;
    }
}