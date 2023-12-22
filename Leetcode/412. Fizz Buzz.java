class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        int i = 1;
        while(i <= n){
            if (i % 3 == 0 && i % 5 == 0){
                answer.add("FizzBuzz");
            }
            else if (i % 3 == 0){
                answer.add("Fizz");
            }
            else if (i % 5 == 0){
                answer.add("Buzz");
            }
            else {
                answer.add(i + "");
            }
            i++;
        }
        return answer;
    }
}