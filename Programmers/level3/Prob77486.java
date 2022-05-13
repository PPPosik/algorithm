package Programmers.level3;

import java.util.HashMap;

public class Prob77486 {
    private final String BOSS = "-";

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, Integer> money = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            money.put(enroll[i], 0);
            parents.put(enroll[i], referral[i]);
        }
        money.put(BOSS, 0);

        for (int i = 0; i < seller.length; i++) {
            sell(parents, money, seller[i], amount[i] * 100);
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = money.get(enroll[i]);
        }

        return answer;
    }

    private void sell(HashMap<String, String> parents, HashMap<String, Integer> money, String seller, int price) {
        while (price > 0) {
            if (!seller.equals(BOSS)) {
                money.put(seller, money.get(seller) + price - (price / 10));
                seller = parents.get(seller);
                price /= 10;
            } else {
                money.put(seller, money.get(seller) + price);
                price = 0;
            }
        }
    }
}
