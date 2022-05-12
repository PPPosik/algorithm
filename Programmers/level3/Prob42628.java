package Programmers.level3;

import java.util.Collections;
import java.util.LinkedList;

public class Prob42628 {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();

        for (String operation : operations) {
            if (operation.charAt(0) == 'I') {
                int value = Integer.parseInt(operation, 2, operation.length(), 10);
                enqueue(list, value);
            } else if (operation.equals("D 1")) {
                dequeueMax(list);
            } else if (operation.equals("D -1")) {
                dequeueMin(list);
            }
        }

        if (list.isEmpty()) {
            return new int[] { 0, 0 };
        } else {
            return new int[] { list.getLast(), list.getFirst() };
        }
    }

    private void enqueue(LinkedList<Integer> list, int n) {
        list.add(n);
        Collections.sort(list);
    }

    private int dequeueMax(LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            return list.removeLast();
        }

        return Integer.MIN_VALUE;
    }

    private int dequeueMin(LinkedList<Integer> list) {
        if (!list.isEmpty()) {
            return list.removeFirst();
        }

        return Integer.MAX_VALUE;
    }
}
