package Programmers.level3;

import java.util.Stack;

public class Prob81303 {
    public String solution(int n, int k, String[] cmd) {
        boolean[] deleted = new boolean[n];
        Stack<Integer> deleteLog = new Stack<>();
        int move = k;

        for (String s : cmd) {
            String[] parsed = s.split(" ");

            if (parsed[0].equals("U")) {
                move -= Integer.parseInt(parsed[1]);
                // k = moveUp(deleted, k, Integer.parseInt(parsed[1]));
            } else if (parsed[0].equals("D")) {
                move += Integer.parseInt(parsed[1]);
                // k = moveDown(deleted, k, Integer.parseInt(parsed[1]));
            } else {
                if (k > move) {
                    k = moveUp(deleted, k, k - move);
                } else {
                    k = moveDown(deleted, k, move - k);
                }

                if (parsed[0].equals("C")) {
                    deleteLog.push(k);

                    int nextK = moveDown(deleted, k, 1);
                    if (k == nextK) {
                        k = moveUp(deleted, k, 1);
                    } else {
                        k = nextK;
                    }

                    deleted[deleteLog.peek()] = true;
                } else if (parsed[0].equals("Z")) {
                    if (!deleteLog.isEmpty()) {
                        deleted[deleteLog.pop()] = false;
                    }
                }

                move = k;
            }
            System.out.println(parsed[0] + " " + k);
        }

        StringBuilder answer = new StringBuilder();
        for (boolean b : deleted) {
            answer.append(b ? 'X' : 'O');
        }

        return answer.toString();
    }

    private int moveUp(boolean[] deleted, int idx, int delta) {
        int ret = idx;

        while (delta > 0 && idx > 0) {
            idx--;

            if (!deleted[idx]) {
                delta--;
                ret = idx;
            }
        }

        return ret;
    }

    private int moveDown(boolean[] deleted, int idx, int delta) {
        int ret = idx;

        while (delta > 0 && idx < deleted.length - 1) {
            idx++;

            if (!deleted[idx]) {
                delta--;
                ret = idx;
            }
        }

        return ret;
    }
}
