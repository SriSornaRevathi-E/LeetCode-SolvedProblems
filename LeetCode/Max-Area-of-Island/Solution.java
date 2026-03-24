1class Solution {
2
3    public int backtrack(int[][] grid, int row, int col) {
4        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
5            return 0;
6        }
7        grid[row][col] = 0;
8        return 1
9                + backtrack(grid, row + 1, col)
10                + backtrack(grid, row - 1, col)
11                + backtrack(grid, row, col + 1)
12                + backtrack(grid, row, col - 1);
13    }
14
15    public int maxAreaOfIsland(int[][] grid) {
16        if (grid.length == 0) return 0;
17
18        int row = grid.length;
19        int col = grid[0].length;
20        int area = 0;
21
22        for (int i = 0; i < row; i++) {
23            for (int j = 0; j < col; j++) {
24
25                if (grid[i][j] == 1) {
26                    int count = backtrack(grid, i, j);
27                    area = Math.max(area, count);
28                }
29            }
30        }
31
32        return area;
33    }
34}