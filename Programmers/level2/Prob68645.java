package Programmers.level2;

public class Prob68645 {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] map = new int[n][n];

        int i = -1, j = 0;
        int type = 0;
        int num = 1;
        while (n > 0) {
            int tmp = n--;
            while (tmp-- > 0) {
                if (type == 0) {
                    i++;
                } else if (type == 1) {
                    j++;
                } else if (type == 2) {
                    i--;
                    j--;
                }
                map[i][j] = num++;
            }
            type = (type + 1) % 3;
        }

        int idx = 0;
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0) {
                    answer[idx++] = map[i][j];
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }
}
