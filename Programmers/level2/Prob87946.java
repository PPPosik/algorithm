package Programmers.level2;

public class Prob87946 {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        return dfs(k, dungeons, visited);
    }

    private int dfs(int k, int[][] dungeons, boolean[] visited) {
        int ret = 0;

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                ret = Math.max(ret, dfs(k - dungeons[i][1], dungeons, visited) + 1);
                visited[i] = false;
            }
        }

        return ret;
    }
}
