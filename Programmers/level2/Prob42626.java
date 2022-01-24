package Programmers.level2;

import java.util.Arrays;

public class Prob42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        MinHeap heap = new MinHeap(scoville.length);

        for (int n : scoville) {
            heap.add(n);
        }

        int minScoville = heap.remove();
        int secondMinScoville = heap.remove();
        while (minScoville < K) {
            if (minScoville < 0 || secondMinScoville < 0) {
                answer = -1;
                break;
            } else {
                int newScoville = minScoville + 2 * secondMinScoville;
                heap.add(newScoville);
                answer++;
            }

            minScoville = heap.remove();
            secondMinScoville = heap.remove();
        }

        return answer;
    }

    private class MinHeap {
        int lastNodeIdx = 0;
        int[] arr;

        MinHeap(int capacity) {
            this.arr = new int[capacity + 1];
            Arrays.fill(arr, -1);
        }

        public void add(int n) {
            arr[++lastNodeIdx] = n;

            int nowIdx = lastNodeIdx;
            int parentIdx = getParentIdx(nowIdx);
            while (parentIdx > 0 && arr[nowIdx] < arr[parentIdx]) {
                swap(nowIdx, parentIdx);
                nowIdx = parentIdx;
                parentIdx = getParentIdx(nowIdx);
            }

            System.out.print("add" + n + " : ");
            for (int aa : arr) {
                System.out.print(aa + " ");
            }
            System.out.println();
        }

        public int remove() {
            int parentIdx = 1;
            int leftChildIdx = getLeftChildIdx(parentIdx);
            int rightChildIdx = getRightChildIdx(parentIdx);
            int ret = arr[parentIdx];

            arr[parentIdx] = arr[lastNodeIdx];
            arr[lastNodeIdx--] = -1;

            while (true) {
                int changeIdx = -1;

                if (leftChildIdx > 0 && arr[leftChildIdx] != -1 && rightChildIdx > 0 && arr[rightChildIdx] != -1) {
                    changeIdx = arr[leftChildIdx] < arr[rightChildIdx] ? leftChildIdx : rightChildIdx;
                } else if (leftChildIdx > 0 && arr[leftChildIdx] != -1) {
                    changeIdx = leftChildIdx;
                } else if (rightChildIdx > 0 && arr[rightChildIdx] != -1) {
                    changeIdx = rightChildIdx;
                } else {
                    break;
                }

                if(arr[parentIdx] > arr[changeIdx]) {
                    swap(changeIdx, parentIdx);
                    parentIdx = changeIdx;
                    leftChildIdx = getLeftChildIdx(parentIdx);
                    rightChildIdx = getRightChildIdx(parentIdx);
                }
                else {
                    break;
                }
            }

            System.out.print("remove" + ret + " : ");
            for (int aa : arr) {
                System.out.print(aa + " ");
            }
            System.out.println();

            return ret;
        }

        public void swap(int idx1, int idx2) {
            int tmp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = tmp;
        }

        public int getParentIdx(int idx) {
            return idx / 2 > 0 ? idx / 2 : -1;
        }

        public int getLeftChildIdx(int idx) {
            return idx * 2 < arr.length ? idx * 2 : -1;
        }

        public int getRightChildIdx(int idx) {
            return idx * 2 + 1 < arr.length ? idx * 2 + 1 : -1;
        }
    }
}
