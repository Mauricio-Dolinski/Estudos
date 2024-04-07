import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n1 = Integer.parseInt(in.nextLine());
        int n2 = Integer.parseInt(in.nextLine());
        int n3 = Integer.parseInt(in.nextLine());
        int n4 = Integer.parseInt(in.nextLine());
        int n5 = Integer.parseInt(in.nextLine());
        
    
        Prime ob=new Prime();
        ob.checkPrime(n1);
        ob.checkPrime(n1,n2);
        ob.checkPrime(n1,n2,n3);
        ob.checkPrime(n1,n2,n3,n4,n5);    
        
        in.close();
        
        try {
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());
                
            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

class Prime {
    
    void checkPrime(int... numbers) {
        String result = "";
        for (int num : numbers) {
            if(isPrime(num)){
                if (result.isEmpty()) result += num;
                else result += " " + num;
            }
        }
        System.out.println(result);
    }
    
    boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
