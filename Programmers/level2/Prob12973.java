package Programmers.level2;

import java.util.Stack;

public class Prob12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size() == 0 ? 1 : 0;
    }
}
