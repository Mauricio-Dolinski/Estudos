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
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        int maximumHourglassSum = 0;
        final int size = arr.size();
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                int hourglassSum = 0;
                for (int k = -1; k <= 1; k++) {
                    hourglassSum += arr.get(i-1).get(j+k);
                }
                hourglassSum += arr.get(i).get(j);
                for (int k = -1; k <= 1; k++) {
                    hourglassSum += arr.get(i+1).get(j+k);
                }
                if(i == 1 && j == 1){
                    maximumHourglassSum = hourglassSum;
                }
                if (hourglassSum > maximumHourglassSum){
                    maximumHourglassSum = hourglassSum;
                }
            }
        }
        return maximumHourglassSum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
