class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length, n=grid[0].length, servers = 0;
        int[] rowCount = new int[m], colCount = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    if(rowCount[i]>1 || colCount[j]>1) servers++;
                }
            }
        }

        return servers;
    }
}