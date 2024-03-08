package com.example;

public class Main {

    public double m01 (double a, double b) {
        try {
            if (a < 0)
                throw new Err01();
            if (b < 0)
                throw new Err02();
            if (b == 0)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("b igual a zero"); 
        }  
        
        return a / b;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.m01 (8.0, 4.0));
    }
}