package Programmers.level2;

import java.util.HashMap;

public class Prob42577 {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> words = new HashMap<String, Boolean>();

        for (String phone : phone_book) {
            words.put(phone, true);
        }

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String word = phone.substring(0, i);

                if (words.get(word) != null) {
                    return false;
                }
            }
        }

        return true;
    }
}
