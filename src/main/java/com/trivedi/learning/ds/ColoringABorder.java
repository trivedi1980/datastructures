package com.trivedi.learning.ds;

import java.util.Arrays;

public class ColoringABorder {
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int[][] n = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        colorBorder(grid, r0, c0, grid[r0][c0], n);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private static void colorBorder(int[][] grid, int r, int c, int oldColor, int[][] n) {
        grid[r][c] = -oldColor;
        int count = 0;
        for (int i = 0; i < n.length; i++) {
            int x = r - n[i][0];
            int y = c - n[i][1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || Math.abs(grid[x][y]) != oldColor) {
                continue;
            }
            count++;
            if (grid[x][y] == oldColor) colorBorder(grid, x, y, oldColor, n);
        }
        if (count == 4) {
            grid[r][c] = oldColor;
        }
    }

    public static void main(String[] args) {
        // [[1,1,1],[1,1,1],[1,1,1]]
        // 1
        // 1
        // 2
        int[][] res = colorBorder(new int[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 1, 1, 2);
        for (int[] i :
                res) {
            System.out.println(Arrays.toString(i));
        }
    }
}
