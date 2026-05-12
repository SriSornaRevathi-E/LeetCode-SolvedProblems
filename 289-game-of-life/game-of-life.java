class Solution {

    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];

        // 8 directions
        int[] rowDir =
            {-1,-1,-1,0,0,1,1,1};

        int[] colDir =
            {-1,0,1,-1,1,-1,0,1};

        for(int i=0; i<m; i++) {

            for(int j=0; j<n; j++) {

                int live = 0;

                // Count neighbors
                for(int k=0; k<8; k++) {

                    int r = i + rowDir[k];
                    int c = j + colDir[k];

                    if(r>=0 && r<m &&
                       c>=0 && c<n &&
                       board[r][c] == 1) {

                        live++;
                    }
                }

                // Apply rules
                if(board[i][j] == 1) {

                    if(live == 2 || live == 3) {
                        copy[i][j] = 1;
                    } else {
                        copy[i][j] = 0;
                    }

                } else {

                    if(live == 3) {
                        copy[i][j] = 1;
                    }
                }
            }
        }

        // Copy back
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = copy[i][j];
            }
        }
    }
}