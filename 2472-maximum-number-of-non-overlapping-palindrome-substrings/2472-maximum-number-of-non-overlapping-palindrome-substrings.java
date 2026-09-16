class Solution {
    private int solve(String s, int n, int k, boolean[][] isPalindrome, int[]dp){
        if(n<k) return 0;
        if(dp[n]!=-1) return dp[n];
        dp[n] = solve(s, n-1, k, isPalindrome, dp);
        int j=n-1;
        for(int i=0; j-i+1>=k; i++){
            if(isPalindrome[i][j]) dp[n]=Math.max(dp[n], 1+solve(s, i, k, isPalindrome, dp));
        }
        return dp[n];
    }
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
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
        return solve(s, n, k, isPalindrome, dp);
    }
}