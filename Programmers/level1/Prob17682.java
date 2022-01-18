package Programmers.level1;

public class Prob17682 {
    public int solution(String dartResult) {
        String[] operations = new String[3];
        int[] numbers = new int[3];
        int idx = 0;
        int answer = 0;

        for (String result : dartResult.split("[0-9]")) {
            if (result.length() > 0) {
                operations[idx++] = result;
            }
        }

        idx = 0;
        for (String result : dartResult.split("[^0-9]")) {
            if (result.length() > 0) {
                numbers[idx++] = Integer.parseInt(result);
            }
        }

        boolean isStar = false;
        for (int i = 2; i >= 0; i--) {
            int value = numbers[i];

            value = calcBonus(value, operations[i]);

            if (isStar) {
                isStar = false;
                value = calcStar(value);
            }

            if (operations[i].contains("#")) {
                value = calcMinus(value);
            } else if (operations[i].contains("*")) {
                isStar = true;
                value = calcStar(value);
            }

            answer += value;
        }

        return answer;
    }

    private int calcBonus(int value, String operations) {
        char bonus = operations.charAt(0);

        if (bonus == 'S') {
            ;
        } else if (bonus == 'D') {
            value = value * value;
        } else if (bonus == 'T') {
            value = value * value * value;
        }

        return value;
    }

    private int calcMinus(int value) {
        return -1 * value;
    }

    private int calcStar(int value) {
        return 2 * value;
    }
}
