class Solution {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Sink all islands connected to the boundary
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // If it's on the boundary and is land (0)
                if ((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && grid[r][c] == 0) {
                    dfs(grid, r, c);
                }
            }
        }

        // Step 2: Count remaining closed islands
        int closedIslandsCount = 0;
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (grid[r][c] == 0) {
                    closedIslandsCount++;
                    dfs(grid, r, c); // Sink the entire closed island
                }
            }
        }

        return closedIslandsCount;
    }

    private void dfs(int[][] grid, int r, int c) {
        // Base conditions for out-of-bounds or water (1)
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) {
            return;
        }

        // Mark current land as visited/water
        grid[r][c] = 1;

        // Visit 4-directionally connected neighbors
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}