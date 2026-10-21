class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Check if string is already sorted
        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;
        
        // For length 2, since we cannot select the entire string (proper substring requirement),
        // an unsorted string of length 2 can never be sorted.
        if (n == 2) return -1;
        
        char minChar = 'z';
        char maxChar = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        // If min character is already at index 0 or max character is at index n - 1,
        // we can sort the remaining substring in 1 operation.
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // Count occurrences of maxChar and minChar
        int maxCount = 0;
        int minCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == maxChar) maxCount++;
            if (s.charAt(i) == minChar) minCount++;
        }
        
        // Case where maximum is strictly at the start and minimum is strictly at the end,
        // with no other occurrences of maxChar at start/minChar at end.
        if (s.charAt(0) == maxChar && s.charAt(n - 1) == minChar && maxCount == 1 && minCount == 1) {
            return 3;
        }
        
        // In all other cases, it takes 2 operations.
        return 2;
    }
}