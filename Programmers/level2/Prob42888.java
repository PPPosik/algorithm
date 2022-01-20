package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Prob42888 {
    public String[] solution(String[] record) {
        HashMap<String, String> ids = new HashMap<String, String>();

        for (String str : record) {
            String[] splited = str.split(" ");

            if (splited[0].equals("Enter") || splited[0].equals("Change")) {
                ids.put(splited[1], splited[2]);
            }
        }

        ArrayList<String> tmp = new ArrayList<String>();
        for (String str : record) {
            String[] splited = str.split(" ");

            if (splited[0].equals("Enter")) {
                tmp.add(ids.get(splited[1]) + "님이 들어왔습니다.");
            } else if (splited[0].equals("Leave")) {
                tmp.add(ids.get(splited[1]) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[tmp.size()];
        Arrays.setAll(answer, i -> tmp.get(i));

        return answer;
    }
}
