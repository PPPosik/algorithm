package Programmers.level1;

import java.util.HashMap;

public class Prob81301 {
    public int solution(String s) {
        return new NumberWithString(s).convertNumberString().numberStringToInt();
    }

    private class NumberWithString {
        private HashMap<String, String> map = new HashMap<>();
        private String numberWithString;

        public NumberWithString(String numberWithString) {
            this.numberWithString = numberWithString;
            map.put("zero", "0");
            map.put("one", "1");
            map.put("two", "2");
            map.put("three", "3");
            map.put("four", "4");
            map.put("five", "5");
            map.put("six", "6");
            map.put("seven", "7");
            map.put("eight", "8");
            map.put("nine", "9");
        }

        public NumberWithString convertNumberString() {
            NumberWithString ret = new NumberWithString(numberWithString);

            map.forEach((key, value) -> {
                ret.setString(ret.getString().replaceAll(key, value));
            });

            return ret;
        }

        public int numberStringToInt() {
            return Integer.parseInt(numberWithString);
        }

        public String getString() {
            return this.numberWithString;
        }

        public void setString(String numberWithString) {
            this.numberWithString = numberWithString;
        }
    }
}
