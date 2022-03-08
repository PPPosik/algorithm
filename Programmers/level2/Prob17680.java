package Programmers.level2;

public class Prob17680 {
    public int solution(int cacheSize, String[] cities) {
        String[] cache = new String[cacheSize];
        int[] leastUsed = new int[cacheSize];
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (int i = 0; i < cities.length; i++) {
            int targetIdx = findCache(cache, cities[i]);

            if (targetIdx != -1) {
                answer++;
            } else {
                targetIdx = updateCache(cache, leastUsed, cities[i]);
                answer += 5;
            }

            leastUsed[targetIdx] = i + 1;
        }

        return answer;
    }

    private int findCache(String[] cache, String target) {
        for (int i = 0; i < cache.length; i++) {
            if (target.toLowerCase().equals(cache[i])) {
                return i;
            }
        }

        return -1;
    }

    private int updateCache(String[] cache, int[] leastUsed, String target) {
        int idx = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < leastUsed.length; i++) {
            if (minValue > leastUsed[i]) {
                minValue = leastUsed[i];
                idx = i;
            }
        }

        cache[idx] = target.toLowerCase();

        return idx;
    }
}
