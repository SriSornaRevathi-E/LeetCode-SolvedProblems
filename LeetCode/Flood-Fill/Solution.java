1class Solution {
2    public void backtrack(int[][] image, int row, int col, int color, int newColor) {
3        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color) {
4            return;
5        }
6        image[row][col] = newColor;
7        backtrack(image, row + 1, col, color, newColor);
8        backtrack(image, row - 1, col, color, newColor);
9        backtrack(image, row, col + 1, color, newColor);
10        backtrack(image, row, col - 1, color, newColor);
11    }
12    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
13        int originalColor = image[sr][sc];
14        if (originalColor == newColor){
15            return image;
16        }
17        backtrack(image, sr, sc, originalColor, newColor);
18        return image;
19    }
20}