package Programmers.level2;

import java.util.HashMap;
import java.util.Map.Entry;

public class Prob42578 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesTypeCnt = new HashMap<String, Integer>();

        for (String[] cloth : clothes) {
            Integer value = clothesTypeCnt.get(cloth[1]);
            clothesTypeCnt.put(cloth[1], value == null ? 1 : value + 1);
        }

        for (Entry<String, Integer> entry : clothesTypeCnt.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }
}
