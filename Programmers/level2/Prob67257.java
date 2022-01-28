package Programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Prob67257 {
    final char[][] priority = { { '+', '-', '*' }, { '+', '*', '-' }, { '-', '+', '*' },
            { '-', '*', '+' }, { '*', '-', '+' }, { '*', '+', '-' } };

    public long solution(String expression) {
        String[] strOperations = expression.split("[0-9]+");
        String[] strNumbers = expression.split("[^0-9]");
        char[] operations = new char[strOperations.length - 1];
        long[] operands = new long[strNumbers.length];
        long answer = 0;

        for (int i = 0; i < operations.length; i++) {
            operations[i] = strOperations[i + 1].charAt(0);
        }

        for (int i = 0; i < operands.length; i++) {
            operands[i] = Long.parseLong(strNumbers[i]);
        }

        for (char[] charArr : priority) {
            Queue<Long> queue1 = new LinkedList<Long>();
            Queue<Character> queue2 = new LinkedList<Character>();

            for (long operand : operands) {
                queue1.offer(operand);
            }

            for (char operation : operations) {
                queue2.offer(operation);
            }

            for (char c : charArr) {
                int size = queue2.size();
                long tmp = queue1.poll();

                while (size-- > 0) {
                    char op = queue2.poll();

                    if (op == c) {
                        tmp = calc(c, tmp, queue1.poll());
                    } else {
                        queue1.offer(tmp);
                        tmp = queue1.poll();
                        queue2.offer(op);
                    }
                }
                queue1.offer(tmp);
            }

            answer = Math.max(answer, Math.abs(queue1.poll()));
        }

        return answer;
    }

    private long calc(char operation, long num1, long num2) {
        long ret = 0;

        if (operation == '+') {
            ret = num1 + num2;
        } else if (operation == '-') {
            ret = num1 - num2;
        } else if (operation == '*') {
            ret = num1 * num2;
        }

        return ret;
    }
}
