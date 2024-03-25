package com.example;

public class Main {
    public static void main(String[] args) {
        int dec = 12;

        System.out.println(converteA(dec));
        System.out.println(converteE(dec));
    }

    public static long converteA(int dec) {
        if (dec == 0)
            return dec;
        long r = converteA(dec / 2);
        return dec % 2 + r * 10;
    }

    public static long converteE(int dec) {
        long bin = 0;
        for (long fat = 1; dec > 0; fat*=10) {
            int r = dec % 2;
            dec = dec / 2;
            bin += r* fat;
        }
        return bin;
    }
}