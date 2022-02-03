package Programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class Prob42746 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] tmp = new String[numbers.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(tmp, new Comparator<String>() {
            public int compare(String o1, String o2) {
                while (o1.length() < 4) {
                    o1 += o1;
                }

                while (o2.length() < 4) {
                    o2 += o2;
                }

                o1 = o1.substring(0, 4);
                o2 = o2.substring(0, 4);

                char[] c1 = o1.toCharArray();
                char[] c2 = o2.toCharArray();

                for (int i = 0; i < 4; i++) {
                    if (c1[i] == c2[i]) {
                        continue;
                    } else if (c1[i] < c2[i]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }

                return 0;
            };
        });

        for (String str : tmp) {
            answer.append(str);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
