class Solution {
    private static final int MOD = 1_000_000_007;

    long[] sum;       
    long[] sumSq;     
    long[] lazy;      

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        java.util.Map<Integer, Integer> lastSeen = new java.util.HashMap<>();
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prev = lastSeen.getOrDefault(val, -1);
            
            update(1, 0, n - 1, prev + 1, i);
            lastSeen.put(val, i);

            totalSum = (totalSum + sumSq[1]) % MOD;
        }

        return (int) totalSum;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long v) {
        long len = (r - l + 1);
        
        sumSq[node] = (sumSq[node] + 2 * v * sum[node] + v * v * len) % MOD;
        
        sum[node] = (sum[node] + v * len) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr);
        update(2 * node + 1, mid + 1, r, ql, qr);
        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }
}