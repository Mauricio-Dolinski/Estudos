package com.example;

public class Main {
    public static void main(String[] args) {
        char[] vet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int i = 0;
        inverte(vet, i);
        System.out.println(vet);
    }

    public static void inverte(char[] vet, int i) {
        int m = vet.length / 2;
        do {
            char aux = vet[i];
            vet[i] = vet[vet.length - i - 1];
            vet[vet.length - i - 1] = aux;
            i++;
        } while (i < m);
    }
}