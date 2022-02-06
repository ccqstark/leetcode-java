package 字符串.No3无重复字符的最长子串;

import java.util.HashSet;

/**
 * 解法：滑动窗口（用左右指针表示窗口左右边界，判断重复直接用hashset）
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 长度小于等于1的特殊处理
        if (s.length() <= 1) {
            return s.length();
        }
        HashSet<Character> set = new HashSet<Character>();
        int maxLength = 0;
        // 首位这里要添加一下，后面的因为在添加r的时候都添加了，所以不用额外手动添加l
        set.add(s.charAt(0));
        for (int l = 0, r = l + 1; l < s.length(); l++) {
            while (r < s.length()) {
                // 如果在set中已经存在则结束循环
                if (set.contains(s.charAt(r))) {
                    break;
                }
                // 添加到集合中并更新最大长度
                set.add(s.charAt(r));
                if ((r - l + 1) > maxLength) {
                    maxLength = r - l + 1;
                }
                // r指针继续向右，扩大滑动窗口并继续下一个循环
                r++;
            }
            // 因为l向右移动，所以要去除l所在字符
            set.remove(s.charAt(l));
        }
        return maxLength;
    }
}
