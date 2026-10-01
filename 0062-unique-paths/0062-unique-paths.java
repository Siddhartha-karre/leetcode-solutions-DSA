class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        prev[0]=1;
        for(int row=0; row<m; row++){
            int[] curr=new int[n];
            curr[0]=1;
            for(int col=0; col<n; col++){
                if(row==0 && col==0) continue;
                int left =0, up =0;
                if(row-1>=0) up = prev[col];
                if(col-1>=0) left = curr[col-1];
                curr[col]=up+left;
            }
            prev=curr;
        }
        return prev[n-1];
    }
}