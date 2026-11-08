class Solution {
    public int countServers(int[][] grid) {
        Map<Integer, Integer> freq = new HashMap<>();
        int servers =0, m=grid.length, n=grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) {
                    freq.put(i, freq.getOrDefault(i, 0)+1);
                    freq.put(j+m, freq.getOrDefault(j+m, 0)+1);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    if(freq.getOrDefault(i, 0)>=2 || freq.getOrDefault(j+m, 0)>=2) servers++;
                }
            }
        }
        return servers;
    }
}