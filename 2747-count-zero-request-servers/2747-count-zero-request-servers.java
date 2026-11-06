import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        
        // Store queries with their original indices: [query_time, original_index]
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        // Sort logs by time
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        
        // Sort queries by query time
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        
        int[] ans = new int[m];
        int[] count = new int[n + 1]; // Server IDs are 1-indexed
        int activeServers = 0;
        
        int left = 0;
        int right = 0;
        int logLen = logs.length;
        
        for (int i = 0; i < m; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIdx = sortedQueries[i][1];
            int startTime = queryTime - x;
            
            // Expand the right boundary: Add logs that occur <= queryTime
            while (right < logLen && logs[right][1] <= queryTime) {
                int serverId = logs[right][0];
                if (count[serverId] == 0) {
                    activeServers++;
                }
                count[serverId]++;
                right++;
            }
            
            // Shrink the left boundary: Remove logs that occur < startTime
            while (left < logLen && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                count[serverId]--;
                if (count[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }
            
            // Servers with 0 requests = total servers - active unique servers
            ans[originalIdx] = n - activeServers;
        }
        
        return ans;
    }
}