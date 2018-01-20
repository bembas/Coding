package com.company;

import java.util.Arrays;

public class Generator {

    public static Scaling Generate(int n) {

        double[] c = new double[n];
        for (int i = 0; i < n; i++)
            c[i] = (int) ((Math.random() * 400) - 200);//generating numbers from -200 to 200 (range=400).

        System.out.println("c :" + Arrays.toString(c));


        double[][] A = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = (int) ((Math.random() * 1000) - 500);//generating numbers form -500 to 500.
                if (A[i][j] == 0)
                    A[i][j] = (int) ((Math.random() * 1000)+1);
            }
        }
        System.out.println("A :" + Arrays.deepToString(A).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


        double[] b = new double[n];
        for (int i = 0; i < n; i++)
            b[i] = (int) ((Math.random() * 400) - 200);//generating numbers from -200 to 200 (range=400).


        System.out.println("b :" + Arrays.toString(b));

        return (new Scaling(n, c, A, b));
    }
}
