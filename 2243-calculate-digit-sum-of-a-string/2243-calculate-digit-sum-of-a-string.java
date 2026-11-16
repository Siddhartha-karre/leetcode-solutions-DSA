class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        if(n<=k) return s;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
            if ((i + 1) % k == 0) {
                sb.append(sum);
                sum = 0;
            }
        }

        if(n%k != 0) sb.append(sum);
        return digitSum(sb.toString(), k);
    }
}