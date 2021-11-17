package 贪心.No455分发饼干;

import java.util.Arrays;

public class Solution {

    // 大饼干先给大胃口的
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int cookiesIndex = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (cookiesIndex < 0) {
                break;
            }

            if (s[cookiesIndex] >= g[i]) {
                num++;
                cookiesIndex--;
            }
        }

        return num;
    }

    // 小饼干先喂饱小胃口的
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int childIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (childIndex + 1 > g.length) {
                break;
            }

            if (s[i] >= g[childIndex]) {
                num++;
                childIndex++;
            }
        }

        return num;
    }

}
