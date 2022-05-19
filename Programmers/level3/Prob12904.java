package Programmers.level3;

public class Prob12904 {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            int start = i - 1;
            int end = i + 1;

            while (start >= 0 && end < arr.length) {
                if (arr[start] != arr[end]) {
                    break;
                }

                answer = Math.max(answer, end - start + 1);
                start--;
                end++;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                continue;
            }

            int start = i - 2;
            int end = i + 1;

            while (start >= 0 && end < arr.length) {
                if (arr[start] != arr[end]) {
                    break;
                }

                answer = Math.max(answer, end - start + 1);
                start--;
                end++;
            }
        }

        return answer;
    }
}
