package Programmers.level2;

import java.util.ArrayList;

public class Prob17679 {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (blockClear(map))
            ;

        int answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == ' ') {
                    answer++;
                }
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        return answer;
    }

    private boolean blockClear(char[][] map) {
        ArrayList<Integer> deletePos = new ArrayList<>();

        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map[i].length - 1; j++) {
                if (map[i][j] != ' ' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j]
                        && map[i][j] == map[i + 1][j + 1]) {
                    deletePos.add(i);
                    deletePos.add(j);
                }
            }
        }

        if (deletePos.size() > 0) {
            for (int i = 0; i < deletePos.size(); i += 2) {
                map[deletePos.get(i)][deletePos.get(i + 1)] = ' ';
                map[deletePos.get(i)][deletePos.get(i + 1) + 1] = ' ';
                map[deletePos.get(i) + 1][deletePos.get(i + 1)] = ' ';
                map[deletePos.get(i) + 1][deletePos.get(i + 1) + 1] = ' ';
            }

            blockFlush(map);
        }

        return deletePos.size() > 0;
    }

    private void blockFlush(char[][] map) {
        for (int j = 0; j < map[0].length; j++) {
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i][j] == ' ') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != ' ') {
                            char tmp = map[k][j];
                            map[k][j] = map[i][j];
                            map[i][j] = tmp;
                            break;
                        }
                    }
                }
            }
        }
    }
}
