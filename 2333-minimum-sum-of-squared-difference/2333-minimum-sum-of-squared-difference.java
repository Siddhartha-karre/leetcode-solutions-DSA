
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int k = k1 + k2;
        int maxDiff = 0;

        for (int i = 0; i < nums1.length; i++) {
            maxDiff = Math.max(maxDiff,
                Math.abs(nums1[i] - nums2[i]));
        }

        int[] freq = new int[maxDiff + 1];

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            int count = freq[d];

            if (count == 0) continue;

            int operations = Math.min(k, count);

            freq[d] -= operations;
            freq[d - 1] += operations;
            k -= operations;
        }

        long result = 0;

        for (int d = 1; d < freq.length; d++) {
            if(freq[d]==0) continue;
            result += (long) d * d * freq[d];
        }

        return result;
    }
}
