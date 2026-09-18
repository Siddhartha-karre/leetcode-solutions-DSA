class Solution {
    private int[] getInterval(String s, int first, int last, int[] start, int[] end) {
        for (int i = first; i <= last; i++) {
            if (first > start[s.charAt(i) - 'a'])
                return null;
            last = Math.max(last, end[s.charAt(i) - 'a']);
        }
        return new int[] { first, last };
    }

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] start = new int[26];
        Arrays.fill(start, -1);
        int[] end = new int[26];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (start[ch - 'a'] == -1)
                start[ch - 'a'] = i;
            end[ch - 'a'] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != start[s.charAt(i) - 'a'])
                continue;
            int[] currInt = getInterval(s, i, end[s.charAt(i) - 'a'], start, end);
            if (currInt != null)
                intervals.add(currInt);
        }
        List<String> result = new ArrayList<>();
        if (intervals.isEmpty()) return result;
        Collections.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] prevInt = intervals.get(0);
        result.add(s.substring(prevInt[0], prevInt[1] + 1));
        for (int i = 1; i < intervals.size(); i++) {
            int[] currInt = intervals.get(i);
            if (currInt[0] > prevInt[1]) {
                result.add(s.substring(currInt[0], currInt[1] + 1));
                prevInt = currInt;
            }
        }

        return result;
    }
}