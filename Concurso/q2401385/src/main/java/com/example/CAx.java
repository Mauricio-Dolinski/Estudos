package com.example;

public class CAx {
    protected int a; // a == 2
  
        protected int b; // b == 9
      
        
      
   
        public CAx() {

            a*=2;   // a = 1 * 2 == 2
            b*=3;   // b = 2 * 3 == 6
   
        }
  
   
        {
            a=1;

            b=2;

        }
  
   
        public int op1(int x) {  //2

                  // -1 + 4 + 9 == 12    
              return op2(x)+op3(x)+b;
  
        }
  
   
        public int op2(int x) { 
            System.out.println("DOES NOT RUN");
              return x+a;
  
        }
  
   
        public static int op3(int x) {
                  //2*2 == 4
              return x*2;
  
        }
}
