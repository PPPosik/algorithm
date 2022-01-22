package Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prob1835 {
    public int solution(int n, String[] data) {
        final char[] member = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
        PhotoPosition photoPosition = new PhotoPosition(member, data);

        return photoPosition.calcPosition();
    }

    private class PhotoPosition {
        char[] member;
        Stack<Character> ready;
        boolean[] visited;
        String[] rules;

        public PhotoPosition(char[] member, String[] rules) {
            this.member = member;
            this.ready = new Stack<Character>();
            this.visited = new boolean[member.length];
            this.rules = rules;
        }

        private int calcPosition() {
            int ret = 0;

            for (int i = 0; i < member.length; i++) {
                clear();
                ret += dfs(i);
            }

            return ret;
        }

        private int dfs(int idx) {
            if (visited[idx]) {
                return 0;
            }
            visited[idx] = true;
            ready.push(member[idx]);

            if (ready.size() == member.length) {
                return 1;
            }

            int ret = 0;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && isPossible(i)) {
                    ret += dfs(i);
                    visited[i] = false;
                    ready.pop();
                }
            }

            return ret;
        }

        private boolean isPossible(int idx) {
            boolean ret = true;
            List<Character> virtualReady = new ArrayList(ready);
            virtualReady.add(member[idx]);

            for (String rule : rules) {
                char person1 = rule.charAt(0);
                char person2 = rule.charAt(2);
                char op = rule.charAt(3);
                int wishDist = Character.getNumericValue(rule.charAt(4));
                int readyIdx1 = virtualReady.indexOf(person1);
                int readyIdx2 = virtualReady.indexOf(person2);
                int realDist = Math.abs(readyIdx1 - readyIdx2) - 1;

                if (readyIdx1 == -1 || readyIdx2 == -1) {
                    continue;
                } else if (op == '=') {
                    if (wishDist == realDist) {
                        continue;
                    }
                } else if (op == '<') {
                    if (wishDist > realDist) {
                        continue;
                    }
                } else if (op == '>') {
                    if (wishDist < realDist) {
                        continue;
                    }
                }

                ret = false;
            }

            return ret;
        }

        private void clear() {
            this.ready = new Stack<Character>();
            Arrays.fill(visited, false);
        }
    }
}
