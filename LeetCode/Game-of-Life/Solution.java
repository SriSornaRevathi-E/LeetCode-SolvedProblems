1class Solution {
2
3    public void gameOfLife(int[][] board) {
4
5        int m = board.length;
6        int n = board[0].length;
7
8        int[][] copy = new int[m][n];
9
10        // 8 directions
11        int[] rowDir =
12            {-1,-1,-1,0,0,1,1,1};
13
14        int[] colDir =
15            {-1,0,1,-1,1,-1,0,1};
16
17        for(int i=0; i<m; i++) {
18
19            for(int j=0; j<n; j++) {
20
21                int live = 0;
22
23                // Count neighbors
24                for(int k=0; k<8; k++) {
25
26                    int r = i + rowDir[k];
27                    int c = j + colDir[k];
28
29                    if(r>=0 && r<m &&
30                       c>=0 && c<n &&
31                       board[r][c] == 1) {
32
33                        live++;
34                    }
35                }
36
37                // Apply rules
38                if(board[i][j] == 1) {
39
40                    if(live == 2 || live == 3) {
41                        copy[i][j] = 1;
42                    } else {
43                        copy[i][j] = 0;
44                    }
45
46                } else {
47
48                    if(live == 3) {
49                        copy[i][j] = 1;
50                    }
51                }
52            }
53        }
54
55        // Copy back
56        for(int i=0; i<m; i++) {
57            for(int j=0; j<n; j++) {
58                board[i][j] = copy[i][j];
59            }
60        }
61    }
62}