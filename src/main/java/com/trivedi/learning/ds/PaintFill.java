package com.trivedi.learning.ds;

public class PaintFill {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{0, 0, 0}, {0, 1, 1}};
        grid = floodFill(grid, 1,1, 1);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        paintFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void paintFill(int[][] grid, int i, int j, int color, int oldColor) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != oldColor) return;
        if (grid[i][j] == color) return;

        // update the cell color
        grid[i][j] = color;

        paintFill(grid, i-1, j, color, oldColor); // top
        paintFill(grid, i, j-1, color, oldColor); // left
        paintFill(grid, i, j+1, color, oldColor); // right
        paintFill(grid, i+1, j, color, oldColor); // bottom
    }
}
