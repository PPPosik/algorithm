package Programmers.level2;

import java.util.Stack;

public class Prob84512 {
    public int solution(String word) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        while (true) {
            if (stack.size() < 5) {
                stack.push(0);
            } else {
                while (stack.peek() == 4) {
                    stack.pop();
                }
                stack.push(stack.pop() + 1);
            }

            answer++;

            String s = stackToString(stack);
            if (s.equals(word) || s.equals("UUUUU")) {
                break;
            }
        }

        return answer;
    }

    private String stackToString(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();

        for (Integer c : stack) {
            if (c == 0) {
                sb.append('A');
            } else if (c == 1) {
                sb.append('E');
            } else if (c == 2) {
                sb.append('I');
            } else if (c == 3) {
                sb.append('O');
            } else if (c == 4) {
                sb.append('U');
            }
        }

        return sb.toString();
    }
}
