package Programmers.level3;

public class Prob64062 {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = -1;

        for (int n : stones) {
            right = Math.max(right, n);
        }

        if (stones.length == k) {
            return right;
        }

        return binSearch(stones, k, left, right);
    }

    private boolean isPossible(int[] stones, int k, int target) {
        int jump = 0;

        for (int n : stones) {
            if (n - target < 0) {
                jump++;
            } else {
                jump = 0;
            }

            if (k <= jump) {
                return false;
            }
        }

        return true;
    }

    private int binSearch(int[] stones, int k, int left, int right) {
        int mid = (left + right) / 2;
        boolean flag = isPossible(stones, k, mid);
        System.out.println(left + " " + right + " " + mid + " " + flag);

        if (flag) {
            if (left == mid) {
                return mid;
            }

            return binSearch(stones, k, mid, right);
        } else {
            return binSearch(stones, k, left, mid);
        }
    }
}
