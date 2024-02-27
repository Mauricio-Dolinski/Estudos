package com.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Empregado vet[] = {
            new Empregado(5),
            new Empregado(3),
            new Empregado(2),
            new Empregado(4),
            new Empregado(1),
            new Empregado(7),
        };

        Arrays.sort(vet);

        for (Empregado empregado : vet) {
            System.out.println(empregado.salario);
        }
    }
}