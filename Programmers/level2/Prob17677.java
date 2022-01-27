package Programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Prob17677 {
    public int solution(String str1, String str2) {
        char[] charArr1 = str1.toLowerCase().toCharArray();
        char[] charArr2 = str2.toLowerCase().toCharArray();
        Set<String> union = new HashSet<String>();
        Set<String> intersection = new HashSet<String>();

        for (int i = 1; i < charArr1.length; i++) {
            if (isAlpha(charArr1[i - 1]) && isAlpha(charArr1[i])) {
                union.add(("" + charArr1[i - 1] + charArr1[i]));
            }
        }

        for (int i = 1; i < charArr2.length; i++) {
            if (isAlpha(charArr2[i - 1]) && isAlpha(charArr2[i])) {
                String tmp = ("" + charArr2[i - 1] + charArr2[i]);
                if (union.contains(tmp)) {
                    intersection.add(tmp);
                }

                union.add(tmp);
            }
        }

        int unionSize = 0;
        for (String s : union) {
            unionSize += Math.max(countSubstring(s, charArr1), countSubstring(s, charArr2));
            System.out.println("union : " + s + " " + unionSize);
        }

        int intersectionSize = 0;
        for (String s : intersection) {
            intersectionSize += Math.min(countSubstring(s, charArr1), countSubstring(s, charArr2));
            System.out.println("intersection : " + s + " " + intersectionSize);
        }

        double jaccard = unionSize == 0 ? 1 : (double) intersectionSize / unionSize;
        return (int) (jaccard * 65536);
    }

    private int countSubstring(String target, char[] s) {
        int ret = 0;

        for (int i = 1; i < s.length; i++) {
            if (target.equals("" + s[i - 1] + s[i])) {
                ret++;
            }
        }

        return ret;
    }

    private boolean isAlpha(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
