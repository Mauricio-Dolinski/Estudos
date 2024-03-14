package com.example;

public class Main {
    public static void main(String[] args) {
        int v1[] = {10, 20, 30, 40, 50};
        int v2[] = { 5, 10, 15, 20};
        int v3[] = new int [v1.length + v2.length];
        int p1 = 0, p2 = 0, p3 = 0;
        
        intercala(v1, p1, v2, p2, v3, p3);

        for (int i : v3) {
            System.out.println("" + i);
        }
        
    }


    public static void intercala (int v1[], int p1, int v2[], int p2, int v3[], int p3) {
        if (p1 == v1.length && p2 == v2.length)
            return;
        if (p1 < v1.length)
            if (p2 < v2.length)
                if (v1[p1] < v2[p2]){
                    v3[p3++] = v1[p1++];
                    intercala(v1, p1, v2, p2, v3, p3);
                }
                else {
                    v3[p3++] = v2[p2++];
                    intercala(v1, p1, v2, p2, v3, p3);
                }
            else {
                v3[p3++] = v1[p1++];
                intercala(v1, p1, v2, p2, v3, p3);
            }
        else if (p2 < v2.length) {
            v3[p3++] = v2[p2++];
            intercala(v1, p1, v2, p2, v3, p3);
        }
            
    }

    public static void intercala1(int v1[], int p1, int v2[], int p2, int v3[], int p3) {
        if (p1 == v1.length && p2 == v2.length)
            return;
        else if (p1 == v1.length) {
            v3[p3++] = v2[p2++];
            intercala1(v1, p1, v2, p2, v3, p3);
        }
        else if (p2 == v2.length) {
            v3[p3++] = v1[p1++];
            intercala1(v1, p1, v2, p2, v3, p3);
        }
        else if(v1[p1] < v2[p2]) {
            v3[p3++] = v1[p1++];
            intercala1(v1, p1, v2, p2, v3, p3);
        }
        else {
            v3[p3++] = v2[p2++];
            intercala(v1, p1, v2, p2, v3, p3);
        }
    }
}