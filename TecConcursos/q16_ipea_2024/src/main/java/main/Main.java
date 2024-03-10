package main;
import persistencia.*;

public class Main {
    public static void main(String[] args) {
        try {
            Exportadora exportadora = new Exportadora();
            exportadora.exportar("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}