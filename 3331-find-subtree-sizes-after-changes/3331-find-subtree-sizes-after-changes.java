import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        
        // 1. Build the initial tree
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
        }
        
        // 2. Track the deepest ancestor for each character 'a'-'z'
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        
        int[] newParent = Arrays.copyOf(parent, n);
        findNewParents(0, adj, s, lastSeen, newParent);
        
        // 3. Build the updated tree from newParent
        List<List<Integer>> newAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            newAdj.get(newParent[i]).add(i);
        }
        
        // 4. Calculate final subtree sizes
        int[] ans = new int[n];
        calculateSizes(0, newAdj, ans);
        
        return ans;
    }
    
    private void findNewParents(int u, List<List<Integer>> adj, String s, int[] lastSeen, int[] newParent) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[charIdx];
        
        // If a matching ancestor exists on the current path, update parent
        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }
        
        // Set current node as the most recent occurrence of this character
        lastSeen[charIdx] = u;
        
        for (int v : adj.get(u)) {
            findNewParents(v, adj, s, lastSeen, newParent);
        }
        
        // Backtrack: restore previous ancestor before leaving this branch
        lastSeen[charIdx] = prevAncestor;
    }
    
    private int calculateSizes(int u, List<List<Integer>> newAdj, int[] ans) {
        int size = 1;
        for (int v : newAdj.get(u)) {
            size += calculateSizes(v, newAdj, ans);
        }
        ans[u] = size;
        return size;
    }
}