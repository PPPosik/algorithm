package Programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prob67259 {
    final int[] dx = { 1, 0, -1, 0 };
    final int[] dy = { 0, -1, 0, 1 };

    public int solution(int[][] board) {
        int[][][] dp = new int[board.length][board.length][4];

        for (int[][] arr : dp) {
            for (int[] ar : arr) {
                Arrays.fill(ar, Integer.MAX_VALUE);
            }
        }

        bfs(board, dp);

        int answer = Integer.MAX_VALUE;
        for (int n : dp[board.length - 1][board.length - 1]) {
            answer = Math.min(answer, n);
        }

        return answer;
    }

    private void bfs(int[][] board, int[][][] dp) {
        Queue<Node> queue = new LinkedList<>();

        dp[0][0][0] = 0;
        dp[0][0][3] = 0;
        queue.offer(new Node(0, 0, 0));
        queue.offer(new Node(0, 0, 3));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newY = node.y + dy[i];
                int newX = node.x + dx[i];

                if (Math.abs(node.direction - i) != 2 && 0 <= newX && newX < board.length && 0 <= newY
                        && newY < board.length && board[newY][newX] == 0) {
                    int value = dp[node.y][node.x][node.direction] + getCost(node.direction, i);
                    if (dp[newY][newX][i] > value) {
                        dp[newY][newX][i] = value;
                        queue.offer(new Node(newY, newX, i));
                    }
                }
            }
        }
    }

    class Node {
        int y;
        int x;
        int direction;

        public Node(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }

    private int getCost(int before, int after) {
        return Math.abs(after - before) % 2 == 0 ? 100 : 600;
    }
}
