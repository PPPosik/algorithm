package Programmers.level3;

public class Prob42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        for(int[] puddle: puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        map[0][0] = 1;
        
        return func(map, n - 1, m - 1);
    }

    private int func(int[][] map, int y, int x) {
        if (y < 0 || x < 0 || map[y][x] == -1) {
            return 0;
        } else if (map[y][x] != 0) {
            return map[y][x];
        }

        map[y][x] = (func(map, y - 1, x) + func(map, y, x - 1)) % 1000000007;
        return map[y][x];
    }
}
