package Programmers.level1;

import java.util.Stack;

public class Prob64061 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for (int x : moves) {
            for (int y = 0; y < board.length; y++) {
                if (board[y][x - 1] == 0) {
                    continue;
                }

                if (!bucket.empty() && bucket.peek() == board[y][x - 1]) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(board[y][x - 1]);
                }

                board[y][x - 1] = 0;
                break;
            }
        }

        bucket.clear();

        return answer;
    }
}
