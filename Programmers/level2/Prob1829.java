package Programmers.level2;

public class Prob1829 {
    final int[] dx = { 1, -1, 0, 0 };
    final int[] dy = { 0, 0, 1, -1 };

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[picture.length][picture[0].length];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, dfs(picture, visited, i, j));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private int dfs(int[][] picture, boolean[][] visited, int y, int x) {
        if (visited[y][x]) {
            return 0;
        }
        visited[y][x] = true;

        int areaSize = 1;
        for (int i = 0; i < dx.length; i++) {
            int movedX = x + dx[i];
            int movedY = y + dy[i];

            if (0 <= movedY && movedY < visited.length && 0 <= movedX && movedX < visited[0].length
                    && !visited[movedY][movedX] && picture[y][x] == picture[movedY][movedX]) {
                areaSize += dfs(picture, visited, movedY, movedX);
            }
        }

        return areaSize;
    }
}
