package com.trivedi.learning.ds;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int i = 0;
        int j = 0;
        int peri = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    peri += 4;

                    if (i > 0 && grid[i -1][j] == 1) {
                        peri -= 2;
                    }

                    if (j > 0 && grid[i][j-1] == 1) {
                        peri -= 2;
                    }
                }
            }

        }
        return peri;


    }

    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[0][0] = 0;
        grid[0][1] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        System.out.println(islandPerimeter(grid));
    }
}
