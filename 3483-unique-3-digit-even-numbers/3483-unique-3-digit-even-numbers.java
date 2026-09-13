class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;
        boolean[] used = new boolean[900];
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                for (int k = 0; k < n; k++) {
                    if (j == k || i == k || digits[k] % 2 != 0) continue;
                    if (i < n && j < n && k < n) {
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if (!used[number-100]) count++;
                        used[number-100]=true;
                    }
                }
            }
        }
        return count;
    }
}