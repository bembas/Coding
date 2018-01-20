package com.company;

import java.util.Arrays;


class Scaling {

    private int n;
    private double[] c;
    private double[][] A;
    private double[] b;


    public Scaling(int n, double[] c, double[][] A, double[] b) {
        this.n = n;
        this.c = c;
        this.A = A;
        this.b = b;

    }


    public Scaling Scalingtechnique() {
        double max = 0;
        double[] maxcol = new double[n];
        double[] maxrow = new double[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (Math.abs(A[i][j]) > max)
                    max = Math.abs(A[i][j]);// trexei ton pinaka A gia na brei to maximum arithmo se apoluti timh stis sthles!
            }

            System.out.println("The highest maximum is: " + max);
            if (max != 0) {
                maxcol[j] = 1 / max;//ftiaxno ton colmax
                max = 0;
            } else
                System.out.println("Cant make division with 0 !!");//minhma ama to max einai to stoixeio 0 !
        }

        System.out.println("maxcol :" + Arrays.toString(maxcol));

        // Pollaplasiazo ton colmax me ton c kai ton A.
        for (int j = 0; j < n; j++) {
            c[j] = c[j] * maxcol[j];
            for (int i = 0; i < n; i++)
                A[i][j] = A[i][j] * maxcol[j];
        }
        System.out.println("c :" + Arrays.toString(c));
        System.out.println("A :" + Arrays.deepToString(A).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(A[i][j]) > max)
                    max = Math.abs(A[i][j]);// brisko to maximum se apoluti timh gia tis grammes tou pinaka A.
            }
            if (max != 1 && max != 0)
                maxrow[i] = 1 / max; //ftiaxno to rowmax pinaka
            else
                maxrow[i] = 0; // an to max den einai 1(h 0 giati dn tha mporei na ginei diairesh) tote ston pinaka maxrow tha mpei to stoixeio 0!

            max = 0; //mhdenizo ksana to max gia tin nea grammh tou pinaka A.
        }
        System.out.println("maxrow :" + Arrays.toString(maxrow));

        //Pollaplasiazo ton maxrow me tous pinakes A kai b.
        for (int i = 0; i < n; i++) {
            if (maxrow[i] != 0) {
                b[i] = b[i] * maxrow[i];
                for (int j = 0; j < n; j++)
                    A[i][j] = A[i][j] * maxrow[i];
            }
        }
        //Solution
        System.out.println("The Solution with the scaling technique is:");
        System.out.println("c :" + Arrays.toString(c));
        System.out.println("b :" + Arrays.toString(b));
        System.out.println("A :" + Arrays.deepToString(A).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        return (new Scaling(n, c, A, b));

    }


    //Mia methodo i opoia trexei ton pinaka A kai briskei to minimum stoixeio tou.
    public double min() {
        double min = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (A[i][j] > min)
                    min = Math.abs(A[i][j]);
            }
        }
        return min;
    }

    public Scaling ScalingGeometricMean() {
        double max = 0;
        double min = min();//Orizo to minimum to mikrotero stoixeio tou Pinaka A
        double[] mincol = new double[n];
        double[] maxcol = new double[n];
        double[] mcols = new double[n];


        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (Math.abs(A[i][j]) > max)
                    max = Math.abs(A[i][j]);//Brisko to maximum se apoluti timh apo tis stiles tou pinaka A
                if (Math.abs(A[i][j]) < min)
                    min = Math.abs(A[i][j]);//Brisko to minimum se apoluti timh apo tis stiles tou pinaka A(to min to exo orisei hdh tin mikroterh timh olou tou pinaka opote dn exo problima)
            }

            System.out.println("The max in the columns is: " + max);
            System.out.println("The min in the columns is: " + min);
            //Pernao ta max kai ta min stous pinakes tous
            if (max != 0) {
                maxcol[j] = max;
                max = 0;
            } else
                System.out.println("Cant make division with 0 !!");


            if (min != 0) {
                mincol[j] = min;
                min = min();
            } else
                System.out.println("Cant make division with 0 !!");


            mcols[j] = (double) (1 / Math.sqrt(maxcol[j] * mincol[j]));//upologizo ton pinaka geometrikou mesou

        }
        System.out.println("mcols :" + Arrays.toString(mcols));

        //Pollaplasiazo ton mcols me ton c kai ton A.
        for (int j = 0; j < n; j++) {
            c[j] = c[j] * mcols[j];
            for (int i = 0; i < n; i++)
                A[i][j] = A[i][j] * mcols[j];
        }
        System.out.println("c :" + Arrays.toString(c));
        //entolh gia na kanei print ton pinaka A mesa se agules.
        System.out.println("A :" + Arrays.deepToString(A).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


        double[] mrows = new double[n];
        double[] minrow = new double[n];
        double[] maxrow = new double[n];
        //idia diadikasia gia tis grammes tou pinaka A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(A[i][j]) > max)
                    max = Math.abs(A[i][j]);
                if (Math.abs(A[i][j]) < min)
                    min = Math.abs(A[i][j]);
            }

            System.out.println("The max in the rows is: " + max);
            System.out.println("The min in the rows is: " + min);
            if (max != 0) {
                maxrow[i] = max;
                max = 0;
            } else
                System.out.println("Cant make division with 0 !!");


            if (min != 0) {
                minrow[i] = min;
                min = min();
            } else
                System.out.println("Cant make division with 0 !!");


            mrows[i] = (double) (1 / Math.sqrt(maxrow[i] * minrow[i]));

        }
        System.out.println("mrows :" + Arrays.toString(mrows));

        for (int i = 0; i < n; i++) {
            b[i] = b[i] * mrows[i];
            for (int j = 0; j < n; j++)
                A[i][j] = A[i][j] * mrows[i];

        }
        //Solution
        System.out.println("The Solution with the technique of Geometric Mean is : ");
        System.out.println("c :" + Arrays.toString(c));
        System.out.println("b :" + Arrays.toString(b));
        System.out.println("A :" + Arrays.deepToString(A).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));


        return (new Scaling(n, c, A, b));
    }


}
