package com.company;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        //Generator with rank=n of the matrix A ,c ,b
        //Generator.Generate(30).Scalingtechnique();
        //Generator.Generate(20).ScalingGeometricMean();



        //parser for reading files LP01.txt and LP02.txt.
        FileReader fr = new FileReader("LP01.txt");
        Scanner sc = new Scanner(fr);
        String text = sc.next();
        int n = 0;
        int a = 0;
        for (int b = 0; b < text.length(); b++) {
            char digit = text.charAt(b);
            if (Character.isDigit(digit)) {
                a = b;
                b = text.length();
            }
        }
        n = Integer.parseInt(text.substring(a, text.length()));
        sc.next();
        sc.next();
        sc.nextLine();

        double[][] A = new double[n][n];
        double[] b = new double[n];
        double[] c = new double[n];


        for (int j = 0; j < n; j++) {
            String[] split = sc.nextLine().split(",");
            for (int i = 0; i < split.length; i++) {
                A[j][i] = (Double.parseDouble(split[i]));

            }
        }

        sc.nextLine();
        sc.nextLine();


        for (int k = 0; k < n; k++) {
            String string = sc.nextLine();
            b[k] = (Double.parseDouble(string));
        }

        sc.nextLine();
        sc.nextLine();

        String[] split2 = sc.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            c[i] = (Double.parseDouble(split2[i]));
        }
        sc.close();


        Scaling ob = new Scaling(n, c, A, b);

        //solving the problem with the Scaling technique (equilibration technique).
          ob.Scalingtechnique();


        // Solving the problem with Geometric mean
         //ob.ScalingGeometricMean();


    }
}
