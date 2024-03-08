package com.example;

public class L2 extends L1 {
    public L2 () {
        System.out.println(3);
        c += 2;
    }
    public int opA (int x, double y) {
        return a + b + c + opA(x) + opA((int) y);
    }
    public static void main (String[] args) {
        L2 o = new L2();
        System.out.println(4);
        System.out.println(o.opA(2,3));
    }
}
