1class Solution {
2    public int orangesRotting(int[][] grid) {
3
4        int m = grid.length;
5        int n = grid[0].length;
6
7        Queue<int[]> q = new LinkedList<>();
8        int fresh = 0;
9
10        // Step 1: count fresh & add rotten
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13                if (grid[i][j] == 2) {
14                    q.offer(new int[]{i, j});
15                }
16                if (grid[i][j] == 1) {
17                    fresh++;
18                }
19            }
20        }
21
22        if (fresh == 0) return 0;
23
24        int time = 0;
25        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
26
27        // BFS
28        while (!q.isEmpty()) {
29            int size = q.size();
30            boolean changed = false;
31
32            for (int i = 0; i < size; i++) {
33                int[] curr = q.poll();
34
35                for (int[] d : dir) {
36                    int nr = curr[0] + d[0];
37                    int nc = curr[1] + d[1];
38
39                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
40                        grid[nr][nc] = 2;
41                        q.offer(new int[]{nr, nc});
42                        fresh--;
43                        changed = true;
44                    }
45                }
46            }
47
48            if (changed) time++;
49        }
50
51        return fresh == 0 ? time : -1;
52    }
53}