package com.trivedi.learning.ds.dp.tab;

import java.util.Arrays;

public class GridTraveller {
    public static void main(String[] args) {
        System.out.println(gridTraveller(3,3));
    }

    private static int gridTraveller(int m, int n) {
        int[][] tab = new int[m+1][n+1];
        tab[1][1] = 1;
        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j+1 <= n)
                    tab[i][j+1] += tab[i][j];
                if (i+1 <=m)
                    tab[i+1][j] += tab[i][j];
            }
        }

        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(tab[i]));
        }

        return tab[m][n];
    }
}
