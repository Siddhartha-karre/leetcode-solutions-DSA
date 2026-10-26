class Solution {
    public int countIslands(int[][] grid, int k) {
        int m=grid.length, n=grid[0].length;
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]!=0){
                    if(dfs(grid, i, j)%k==0) count++;
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, int row, int col){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0) return 0L;

        long val=grid[row][col];
        grid[row][col]=0;
        return val+ dfs(grid, row-1, col)+dfs(grid, row+1, col)+dfs(grid, row, col-1) + dfs(grid, row, col+1);
    }
}