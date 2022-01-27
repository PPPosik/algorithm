package Programmers.level2;

public class Prob81302 {
    final int[] dx = { 1, 0, -1, 0 };
    final int[] dy = { 0, 1, 0, -1 };

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = 1;

            if (!checkDistance(places[i])) {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private boolean checkDistance(String[] place) {
        char[][] room = new char[place.length][place[0].length()];

        for (int i = 0; i < room.length; i++) {
            room[i] = place[i].toCharArray();
        }

        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] == 'P') {
                    boolean[][] visited = new boolean[room.length][room[0].length];
                    if (!isPossible(visited, room, i, j, 0)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isPossible(boolean[][] visited, char[][] room, int y, int x, int distance) {
        visited[y][x] = true;

        for (int i = 0; i < dy.length; i++) {
            for (int j = 0; j < dx.length; j++) {
                int movedY = y + dy[i];
                int movedX = x + dx[i];

                if (0 <= movedY && movedY < room.length && 0 <= movedX && movedX < room[0].length
                        && !visited[movedY][movedX] && distance < 2) {
                    if (room[movedY][movedX] == 'P') {
                        return false;
                    } else if (room[movedY][movedX] == 'X') {
                        continue;
                    } else {
                        if(!isPossible(visited, room, movedY, movedX, distance + 1)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
