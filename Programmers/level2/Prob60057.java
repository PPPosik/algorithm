package Programmers.level2;

public class Prob60057 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int sliceLength = 1; sliceLength <= s.length(); sliceLength++) {
            StringBuilder compressed = new StringBuilder();
            String sliced = s.substring(0, sliceLength);
            int cnt = 1;

            for (int i = sliceLength; i <= s.length(); i += sliceLength) {
                String subStr = s.substring(i, i + sliceLength < s.length() ? i + sliceLength : s.length());
                if (sliced.equals(subStr)) {
                    cnt++;
                    continue;
                } else {
                    compressed.append(cnt == 1 ? sliced : cnt + sliced);
                    if (subStr.length() != sliceLength) {
                        compressed.append(subStr);
                    }
                    sliced = subStr;
                    cnt = 1;
                }
            }
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
