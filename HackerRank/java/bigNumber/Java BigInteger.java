import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        
        BigInteger bigA = new BigInteger("" + a);
        BigInteger bigB = new BigInteger("" + b);

        System.out.println(bigA.add(bigB));
        System.out.println(bigA.multiply(bigB));
        
    }
}