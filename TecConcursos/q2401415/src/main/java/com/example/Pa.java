package com.example;

public class Pa {

    String x,y,z;

    String r="vazio";


    public Pa(String s1,String s2, String s3) throws Exception {

          x=s1;

          y=s2;

          z=s3;


          try {

                if(x==null || y==null || z==null)

                      throw new Exception();

          }

          catch(Exception e) {

                z="a";

                throw e;

          }

          finally {

                if(x==null)

                      x="***";

                if(y==null)

                      y="***";

                if(z==null)

                      z="***";

          }

    }


    public String get() {

          return r;

    }

}