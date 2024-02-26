package com.example;

public class CBy extends CAx {
  
    protected int a; // a == 3


    public CBy() {
          a+=3;  //a = 0 + 3 == 3
          b+=3;  //b = 6 + 3 == 9;
          
    }


    public int op2(int x) {
                 //2 - 3 == -1
          return x-a;

    }


    public static int op3(int x) {
        System.out.println("DOES NOT RUN");
          return x*3;

    }

}