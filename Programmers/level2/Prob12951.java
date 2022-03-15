package Programmers.level2;

public class Prob12951 {
    public String solution(String s) {
        char[] arr = s.toLowerCase().toCharArray();

        if ('a' <= arr[0] && arr[0] <= 'z') {
            arr[0] = Character.toUpperCase(arr[0]);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == ' ' && 'a' <= arr[i] && arr[i] <= 'z') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }

        return new String(arr);
    }
}
