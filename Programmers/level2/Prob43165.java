package Programmers.level2;

public class Prob43165 {
    private boolean[] visited;
    private int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.visited = new boolean[numbers.length];
        this.numbers = numbers.clone();
        this.target = target;

        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx >= numbers.length) {
            return checkTarget() ? 1 : 0;
        }

        int ret = 0;

        visited[idx] = true;
        ret += dfs(idx + 1);

        visited[idx] = false;
        ret += dfs(idx + 1);

        return ret;
    }

    private boolean checkTarget() {
        int target = 0;

        for (int i = 0; i < numbers.length; i++) {
            target += visited[i] ? numbers[i] : -numbers[i];
        }

        return this.target == target;
    }
}
