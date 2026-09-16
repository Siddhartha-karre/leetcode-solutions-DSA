class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1)
            return n;
        int[][] dp = new int[n + 1][n + 1];
        boolean[][] isPalindrome = new boolean[n][n];
        for(int l=1; l<=n; l++){
            for(int i=0; i+l<=n; i++){
                int j=i+l-1;
                if(i==j) isPalindrome[i][j]=true;
                else if(i+1==j) isPalindrome[i][j]=(s.charAt(i)==s.charAt(j));
                else{
                    isPalindrome[i][j]=(s.charAt(i)==s.charAt(j)) && isPalindrome[i+1][j-1];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (isPalindrome[i][j]) {
                    int take = 1 + ((j+k<=n)?dp[j + 1][j + k]:0);
                    int grow = dp[i][j + 1];
                    int slide = dp[i + 1][j + 1];

                    dp[i][j] = Math.max(take, Math.max(grow, slide));
                } else {
                    int grow = dp[i][j + 1];
                    int slide = dp[i + 1][j + 1];

                    dp[i][j] = Math.max(dp[i][j], Math.max(grow, slide));
                }
            }
        }
        return dp[0][k-1];
    }
}