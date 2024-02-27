package com.example;

public class Empregado extends Pessoa implements Comparable <Empregado> {
    double salario;

    public Empregado (double salario) {
        this.salario = salario;
    }

    public int compareTo(Empregado e) {
        
        if (this.salario > e.salario) {
            return 1;
        }
        else {
            if (e.salario > this.salario) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
