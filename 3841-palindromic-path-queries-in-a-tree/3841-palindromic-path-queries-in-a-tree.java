import java.util.*;

class Solution {
    private int[] head, to, next;
    private int edgeCount;
    
    private int[] parent, depth, heavy, chainHead, pos, invPos;
    private int curPos;
    private int[] bit;
    private int n;

    private void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        
        // 1. Array-based Adjacency List (Avoids List<Integer>[] GC overhead)
        head = new int[n];
        Arrays.fill(head, -1);
        to = new int[2 * edges.length];
        next = new int[2 * edges.length];
        edgeCount = 0;

        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        chainHead = new int[n];
        pos = new int[n];
        invPos = new int[n];
        Arrays.fill(heavy, -1);

        // 2. Heavy-Light Decomposition
        dfs1(0, -1, 0);
        curPos = 0;
        dfs2(0, 0);

        // 3. $O(N)$ Fenwick Tree Construction using Prefix XORs
        bit = new int[n + 1];
        int[] originalMasks = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int u = invPos[i];
            originalMasks[i + 1] = 1 << (s.charAt(u) - 'a');
        }
        
        for (int i = 1; i <= n; i++) {
            bit[i] ^= originalMasks[i];
            int parentIdx = i + (i & -i);
            if (parentIdx <= n) {
                bit[parentIdx] ^= bit[i];
            }
        }

        // 4. Process Queries
        List<Boolean> result = new ArrayList<>(queries.length);

        for (String q : queries) {
            char type = q.charAt(0);
            if (type == 'u') { // "update u c"
                // Fast manual char parsing from fixed offsets
                int space1 = q.indexOf(' ', 7);
                int u = fastParseInt(q, 7, space1);
                char c = q.charAt(space1 + 1);

                int bitPos = pos[u] + 1;
                int currentMask = queryBitRange(bitPos, bitPos);
                int newMask = 1 << (c - 'a');

                if (currentMask != newMask) {
                    updateBit(bitPos, currentMask ^ newMask);
                }
            } else { // "query u v"
                int space1 = q.indexOf(' ', 6);
                int u = fastParseInt(q, 6, space1);
                int v = fastParseInt(q, space1 + 1, q.length());

                int mask = queryPath(u, v);
                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }

    private int dfs1(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1;
        int maxSubtree = 0;

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];
            if (v != p) {
                int subtreeSize = dfs1(v, u, d + 1);
                size += subtreeSize;
                if (subtreeSize > maxSubtree) {
                    maxSubtree = subtreeSize;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    private void dfs2(int u, int h) {
        chainHead[u] = h;
        pos[u] = curPos;
        invPos[curPos] = u;
        curPos++;

        if (heavy[u] != -1) {
            dfs2(heavy[u], h);
        }

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];
            if (v != parent[u] && v != heavy[u]) {
                dfs2(v, v);
            }
        }
    }

    private void updateBit(int idx, int val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    private int queryBit(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum ^= bit[idx];
        }
        return sum;
    }

    private int queryBitRange(int l, int r) {
        return queryBit(r) ^ queryBit(l - 1);
    }

    private int queryPath(int u, int v) {
        int res = 0;
        while (chainHead[u] != chainHead[v]) {
            if (depth[chainHead[u]] < depth[chainHead[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }
            res ^= queryBitRange(pos[chainHead[u]] + 1, pos[u] + 1);
            u = parent[chainHead[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        res ^= queryBitRange(pos[u] + 1, pos[v] + 1);
        return res;
    }

    private int fastParseInt(String s, int start, int end) {
        int res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }
}