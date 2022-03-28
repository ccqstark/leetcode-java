package 字符串.No76最小覆盖子串;

/**
 * 滑动窗口法
 */
public class Solution {
    public String minWindow(String s, String t) {
        // i为滑窗左边界，j为滑窗右边界
        // needCnt变量方便我们快速判断当前滑窗是否符合要求
        // start是答案字符串的起点下标，minLength是答案字符串的长度，也就是最小的长度
        int i = 0, j = 0, minLength = Integer.MAX_VALUE, start = 0, needCnt = 0;
        // 大写字母A的ASCII为65，小写z为122，最少需要58位才够用
        // need数据记录还需要的字母数量
        int[] need = new int[58];
        // 统计t字符串中的我们所需的字母以及数量
        for (int k = 0; k < t.length(); k++) {
            need[t.charAt(k) - 'A']++;
            needCnt++;
        }
        while (j < s.length()) {
            // 先移动右边界，直到包含了所有的必要字母，也就是needCnt等于0
            while (j < s.length() && needCnt > 0) {
                if (need[s.charAt(j) - 'A'] > 0) {
                    // 如果是必要字母，那么needCnt要减1
                    needCnt--;
                }
                // 遇到的每一个字母need数组都要减1，右边界右移
                need[s.charAt(j) - 'A']--;
                j++;
            }
            // 然后移动左边界，直到遇到了第一个必要字母
            while (i < j && need[s.charAt(i) - 'A'] < 0) {
                need[s.charAt(i) - 'A']++;
                i++;
            }
            // 这里必须要再判断下是否满足needCnt，因为上面循环的结束有可能是数组遍历完了
            if (needCnt == 0 && j - i < minLength) {
                // 遇到长度更小的要更新minLength和start
                // 滑窗（当前子串）的长度的计算是 j - i (这里之所以不用+1是因为j的落脚点其实是最后一个必要字母后一位)
                minLength = j - i;
                start = i;
            }

            // 完成一个滑窗的判断后，为了进入下一个滑窗，左边界需要收缩一位
            // i可能越界，这里需要多判断一次
            if (i < s.length()) need[s.charAt(i) - 'A']++;
            needCnt++;
            i++;
        }

        // 最后用起点和最小子串长度截取答案子串
        // 如果长度还是Integer.MAX_VALUE说不明找不到，返回""
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
