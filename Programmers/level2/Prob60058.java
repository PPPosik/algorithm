package Programmers.level2;

import java.util.Stack;

public class Prob60058 {
    public String solution(String p) {
        if (p.length() == 0) {
            return "";
        }

        int cnt = 0;
        int idx = 0;
        for (char c : p.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }
            idx++;

            if (cnt == 0) {
                break;
            }
        }

        String u = p.substring(0, idx);
        String v = p.substring(idx);
        System.out.println(u + " ///// " + v);

        Stack<Character> stack = new Stack<Character>();
        for (char c : u.toCharArray()) {
            if (c == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.empty()) {
            return u + solution(v);
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            for (char c : u.substring(1, u.length() - 1).toCharArray()) {
                if (c == '(') {
                    sb.append(')');
                } else {
                    sb.append('(');
                }
            }

            return sb.toString();
        }
    }
}
