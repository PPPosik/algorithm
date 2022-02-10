package Programmers.level2;

public class Prob1844 {
    private final int[] dx = { 1, 0, -1, 0 };
    private final int[] dy = { 0, 1, 0, -1 };
    private final int DEFAULT_VALUE = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = dfs(maps, visited, 0, 0);

        return answer == DEFAULT_VALUE ? -1 : answer;
    }

    private int dfs(int[][] maps, boolean[][] visited, int y, int x) {
        if (y == maps.length - 1 && x == maps[0].length - 1) {
            return 1;
        }
        visited[y][x] = true;

        int ret = DEFAULT_VALUE;

        for (int i = 0; i < dy.length; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (0 <= newY && newY < maps.length && 0 <= newX && newX < maps.length) {
                if (maps[newY][newX] == 1 && !visited[newY][newX]) {
                    ret = Math.min(ret, dfs(maps, visited, newY, newX));
                    visited[newY][newX] = false;
                    System.out.println("(" + newY + ", " + newX + ") " + ret);
                }
            }
        }

        return ret == DEFAULT_VALUE ? ret : ret + 1;
    }
}
