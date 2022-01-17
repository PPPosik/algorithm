package Programmers.level1;

public class Prob67256 {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = new int[4][3];
        Pair leftPos = new Pair(0, 3);
        Pair rightPos = new Pair(2, 3);
        StringBuilder answer = new StringBuilder("");

        for (int i = 0; i < 9; i++) {
            keypad[i / 3][i % 3] = i + 1;
        }
        keypad[3][0] = -1;
        keypad[3][1] = 0;
        keypad[3][2] = -2;

        for (int target : numbers) {
            Pair targetPos = getTargetPos(keypad, target);
            int leftDist = getDist(targetPos, leftPos);
            int rightDist = getDist(targetPos, rightPos);
            char movedHand = compareDist(targetPos, leftDist, rightDist, hand);

            if (movedHand == 'R') {
                movedHand(targetPos, rightPos);
            } else {
                movedHand(targetPos, leftPos);
            }

            answer.append(movedHand);
        }

        return answer.toString();
    }

    public void movedHand(Pair targetPos, Pair handPos) {
        handPos.setPos(targetPos.getX(), targetPos.getY());
    }

    public char compareDist(Pair targetPos, int leftDist, int rightDist, String hand) {
        if (!hand.equals("right") && !hand.equals("left")) {
            return 'X';
        }

        if (targetPos.getX() == 0) {
            return 'L';
        } else if (targetPos.getX() == 2) {
            return 'R';
        } else {
            if (leftDist > rightDist) {
                return 'R';
            } else if (leftDist < rightDist) {
                return 'L';
            } else {
                if (hand.equals("right")) {
                    return 'R';
                } else {
                    return 'L';
                }
            }
        }
    }

    public int getDist(Pair targetPos, Pair handPos) {
        if (targetPos.getX() == -1 || targetPos.getY() == -1) {
            return -1;
        }

        return Math.abs(targetPos.getX() - handPos.getX()) + Math.abs(targetPos.getY() - handPos.getY());
    }

    public Pair getTargetPos(int[][] keypad, int target) {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] == target) {
                    return new Pair(j, i);
                }
            }
        }

        return new Pair(-1, -1);
    }

    class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setPos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
