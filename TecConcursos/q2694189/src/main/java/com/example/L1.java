package com.example;

public class L1 {
    int a=1, b=1, c=1;

    public L1() {
        System.out.println(2);
        a *= 2;
        b *= 2;
        c *= 2;
    }

    public int opA(int x, int y) {
        System.out.println(5);
        return a + b + c - opA(x) + opA(y);
    }
    public int opA(int x) {
        return x + 5;
    }
    {
        System.out.println(1);
        a++;
        b--;
    }
}
