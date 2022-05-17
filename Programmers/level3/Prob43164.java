package Programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Prob43164 {
    public String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<Ticket>> map = new HashMap<>();
        String[] answer = new String[tickets.length + 1];

        for (String[] strings : tickets) {
            if (map.get(strings[0]) == null) {
                map.put(strings[0], new ArrayList<>());
            }

            map.get(strings[0]).add(new Ticket(strings[0], strings[1], false));
        }

        for (Entry<String, ArrayList<Ticket>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), (o1, o2) -> o1.to.compareTo(o2.to));
        }

        dfs(map, "ICN", answer, 0);

        return answer;
    }

    private void dfs(HashMap<String, ArrayList<Ticket>> map, String node, String[] path, int idx) {
        path[idx] = node;

        if (map.get(node) != null) {
            for (Ticket next : map.get(node)) {
                if (idx + 1 < path.length && !next.used) {
                    next.used = true;
                    dfs(map, next.to, path, idx + 1);
                    next.used = false;

                    if (path[path.length - 1] != null) {
                        break;
                    }
                }
            }
        }
    }

    class Ticket {
        String from;
        String to;
        boolean used;

        public Ticket(String from, String to, boolean used) {
            this.from = from;
            this.to = to;
            this.used = used;
        }
    }
}
