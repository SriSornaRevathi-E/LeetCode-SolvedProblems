1class Solution {
2    public int maximumDetonation(int[][] bombs) {
3        int n = bombs.length;
4
5        // 1. Create graph
6        List<List<Integer>> graph = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            graph.add(new ArrayList<>());
9        }
10        // 2. Build graph
11        for (int i = 0; i < n; i++) {
12            long x1 = bombs[i][0];
13            long y1 = bombs[i][1];
14            long r1 = bombs[i][2];
15
16            for (int j = 0; j < n; j++) {
17                if (i == j) continue;
18
19                long x2 = bombs[j][0];
20                long y2 = bombs[j][1];
21
22                long dx = x1 - x2;
23                long dy = y1 - y2;
24
25                if (dx * dx + dy * dy <= r1 * r1) {
26                    graph.get(i).add(j);
27                }
28            }
29        }
30        // 3. run DFS from each bomb
31        int max = 0;
32        for (int i = 0; i < n; i++) {
33            boolean[] visited = new boolean[n];
34            max = Math.max(max, dfs(graph, visited, i));
35        }
36        return max;
37    }
38    private int dfs(List<List<Integer>> graph, boolean[] visited, int node) {
39        visited[node] = true;
40        int count = 1;
41        for (int nei : graph.get(node)) {
42            if (!visited[nei]) {
43                count += dfs(graph, visited, nei);
44            }
45        }
46        return count;
47    }
48}