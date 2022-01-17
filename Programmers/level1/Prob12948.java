package Programmers.level1;

public class Prob12948 {
    public String solution(String phone_number) {
        StringBuilder secretPhone = new StringBuilder();

        for (int i = 0; i < phone_number.length() - 4; i++) {
            secretPhone.append('*');
        }

        for (int i = phone_number.length() - 4; i < phone_number.length(); i++) {
            secretPhone.append(phone_number.charAt(i));
        }

        return secretPhone.toString();
    }
}
