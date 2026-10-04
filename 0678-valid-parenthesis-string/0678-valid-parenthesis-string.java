class Solution {
    private int check(int index, String s, int cnt, int[][] dp){
        if(index>=s.length()) return (cnt==0)?1: 0;
        if(dp[index][cnt]!=-1) return dp[index][cnt];
        if(s.charAt(index)=='(') return dp[index][cnt] = check(index+1, s, cnt+1, dp);
        if(s.charAt(index)==')') {
            if(cnt<=0) return 0;
            return dp[index][cnt] = check(index+1, s, cnt-1, dp);
        }
        int leftP=0, rightP=0, empty=0;
        leftP=check(index+1, s, cnt+1, dp);
        if(cnt>0) rightP=check(index+1, s, cnt-1, dp);
        empty=check(index+1, s, cnt, dp);
        return dp[index][cnt] = (leftP | rightP) | empty;
    }
    public boolean checkValidString(String s) {
        int n=s.length();
        int[][] dp = new int[n][n+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return (check(0, s, 0, dp)==1)? true: false;
    }
}