class Solution {
    int n;
    long MOD = 1_000_000_007;

    private boolean check(int len, int base, int[] nums) {

        long power = 1;
        long hash = 0;

        for (int i = 0; i < len - 1; i++) {
            power = (power * base) % MOD;
        }

        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i < len; i++) {
            hash = (hash * base + nums[i]) % MOD;
        }

        freq.put(hash, 1);

        for (int i = len; i < n; i++) {

            hash = (hash - nums[i - len] * power % MOD + MOD) % MOD;

            hash = (hash * base + nums[i]) % MOD;

            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int val : freq.values()) {
            if (val == 1)
                return true;
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        this.n = nums.length;

        int base = nums[0];
        for (int num : nums)
            base = Math.max(base, num);
        base += 1;

        int low = 1, high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (check(mid, base, nums)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}