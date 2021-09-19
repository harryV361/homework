package com.lee.jvm;

/**
 * @author lizhe
 */
public class Hello {

    public static void main(String[] args) {


        int i = 2, j = 5;

        final long add = add(i, j);
        final int subtract = subtract(i, j);
        final double multiply = multiply(i, j);
        final double divide = divide(i, j);

        for (int k = 0; k < 10; k++) {
            if(k>5){
               System.out.println(k);
            }
        }
    }

    private static long add(int i, int j) {
        return i + j;
    }

    private static int subtract(int i, int j) {
        return i - j;
    }

    private static double multiply(int i, int j) {
        return i * j;
    }

    private static double divide(double i, int j) {
        return i / j;
    }
}
