package Programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Prob17677 {
    public int solution(String str1, String str2) {
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        Set<String> union = new HashSet<String>();
        Set<String> intersection = new HashSet<String>();

        for (int i = 1; i < charArr1.length; i++) {
            if (isAlpha(charArr1[i - 1]) && isAlpha(charArr1[i])) {
                union.add(("" + charArr1[i - 1] + charArr1[i]).toLowerCase());
            }
        }

        for (int i = 1; i < charArr2.length; i++) {
            if (isAlpha(charArr2[i - 1]) && isAlpha(charArr2[i])) {
                String tmp = ("" + charArr2[i - 1] + charArr2[i]).toLowerCase();
                if (union.contains(tmp)) {
                    intersection.add(tmp);
                }

                union.add(tmp);
            }
        }

        for (String s : union) {
            System.out.println("union : " + s);
        }
        for (String s : intersection) {
            System.out.println("intersection : " + s);
        }

        double jaccard = union.size() == 0 ? 1 : (double) intersection.size() / union.size();
        return (int) (jaccard * 65536);
    }

    private boolean isAlpha(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
