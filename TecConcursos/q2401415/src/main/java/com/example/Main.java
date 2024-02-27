package com.example;

public class Main {
    public static void main(String[] args) {
        Pa o=null;

 
            try {

                  o=new Qb("a"," ","c");

            }

            catch (Exception e) {

                  System.out.print("***Erro***");

            }

            finally {

                  if(o!=null)

                        System.out.print(o.get());

            }
    }
}