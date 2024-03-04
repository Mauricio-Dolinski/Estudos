import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "";
        if (scan.hasNext())
            s = scan.nextLine();
        scan.close();
        
        int n = 0;
        
        String[] lines = s.trim().split("[ !,?._'@]+");
        if (!s.isEmpty())
            n = lines.length;
        
        System.out.println(n);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}