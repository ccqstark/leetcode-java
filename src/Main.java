import java.util.*;

public class Main {
    public static String minWindow(String s, String t) {
        int i = 0, j = 0, minLength = Integer.MAX_VALUE, start = 0, needCnt = 0;
        int[] need = new int[58];
        for (int k = 0; k < t.length(); k++) {
            need[t.charAt(k) - 'A']++;
            needCnt++;
        }
        while (j < s.length()) {
            while (j < s.length() && needCnt > 0) {
                if (need[s.charAt(j) - 'A'] > 0) {
                    needCnt--;
                }
                need[s.charAt(j) - 'A']--;
                j++;
            }
            while (i < j && need[s.charAt(i) - 'A'] < 0) {
                need[s.charAt(i) - 'A']++;
                i++;
            }
            if (needCnt == 0 && j - i < minLength) {
                minLength = j - i;
                start = i;
            }

            if (i < s.length()) need[s.charAt(i) - 'A']++;
            i++;
            needCnt++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abb", "abb"));
    }
}
