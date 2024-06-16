import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summarizingLong;
import static java.util.stream.Collectors.toList;
import java.util.Collection;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
    String result = s.chars()
            .mapToObj(c -> (char) c)
            .reduce("", (str, c) -> {
                if (str.length() > 0 && str.charAt(str.length() - 1) == c) {
                    return str.substring(0, str.length() - 1);
                } else {
                    return str + c;
                }
            }, (str1, str2) -> str1 + str2);
    return result.isEmpty() ? "Empty String" : result;
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
