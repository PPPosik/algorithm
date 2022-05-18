package Programmers.level3;

import java.util.*;
import java.util.Map.*;

public class Prob42579 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Music>> map = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (map.get(genres[i]) == null) {
                map.put(genres[i], new ArrayList<>());
                total.put(genres[i], 0);
            }

            map.get(genres[i]).add(new Music(i, plays[i]));
            total.put(genres[i], total.get(genres[i]) + plays[i]);
        }

        ArrayList<Entry<String, ArrayList<Music>>> list = new ArrayList<>(map.entrySet());
        ArrayList<Integer> answerList = new ArrayList<>();

        Collections.sort(list, (o1, o2) -> total.get(o2.getKey()) - total.get(o1.getKey()));

        for (Entry<String, ArrayList<Music>> entry : list) {
            Collections.sort(entry.getValue(), (o1, o2) -> {
                if (o1.playTime == o2.playTime) {
                    return o1.code - o2.code;
                } else {
                    return o2.playTime - o1.playTime;
                }
            });

            for (int i = 0; i < Math.min(2, entry.getValue().size()); i++) {
                answerList.add(entry.getValue().get(i).code);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    class Music {
        int code;
        int playTime;

        public Music(int code, int playTime) {
            this.code = code;
            this.playTime = playTime;
        }
    }
}
