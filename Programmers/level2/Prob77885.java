package Programmers.level2;

public class Prob77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String reverseBinary = getReverseBinary(numbers[i]);

            answer[i] = getNextNumber(reverseBinary);
        }

        return answer;
    }

    private long getNextNumber(String str) {
        if (str.charAt(0) == '0') {
            str = "1" + str.substring(1);
        } else {
            int idx = 0;
            while (++idx < str.length() && str.charAt(idx) == '1');
            str = str.substring(0, idx - 1) + "01" + (idx < str.length() ? str.substring(idx + 1) : "");
        }

        long ret = 0;
        int pow = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                ret += Math.pow(2, pow);
            }
            pow++;
        }

        return ret;
    }

    private String getReverseBinary(long number) {
        StringBuilder sb = new StringBuilder();

        if (number == 0) {
            return "0";
        }

        while (number > 0) {
            sb.append(number % 2);
            number /= 2;
        }

        return sb.toString();
    }
}
