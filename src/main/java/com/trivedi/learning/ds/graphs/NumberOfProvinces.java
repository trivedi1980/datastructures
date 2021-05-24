package com.trivedi.learning.ds.graphs;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {
        boolean[][] visited = new boolean[isConnected.length][isConnected[0].length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, isConnected, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs (int row, int col, int[][] isConnected, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < isConnected[col].length; i++) {
            if (!visited[col][i] && isConnected[col][i] == 1) {
                bfs(col, i, isConnected, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(arr));
    }
}
