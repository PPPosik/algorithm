package Programmers.level2;

import java.util.Stack;

public class Prob76502 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArr = s.toCharArray();
        int answer = 0;

        int idx = 0;
        while (idx < charArr.length) {
            for (int i = idx; i < charArr.length; i++) {
                tmp(stack, charArr[i]);
            }

            for (int i = 0; i < idx; i++) {
                tmp(stack, charArr[i]);
            }

            if (stack.isEmpty()) {
                answer++;
            } else {
                stack.clear();
            }

            idx++;
        }

        return answer;
    }

    private void tmp(Stack<Character> stack, char c) {
        if (stack.isEmpty()) {
            stack.push(c);
            return;
        }

        if (c == '}' && stack.peek() == '{') {
            stack.pop();
        } else if (c == ']' && stack.peek() == '[') {
            stack.pop();
        } else if (c == ')' && stack.peek() == '(') {
            stack.pop();
        } else {
            stack.push(c);
        }
    }
}
