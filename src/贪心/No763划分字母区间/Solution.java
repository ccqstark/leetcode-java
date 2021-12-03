package 贪心.No763划分字母区间;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>(); // 存储结果。即划分出的字符串长度集合
        int[] farthest = new int[26]; // 用于存储每个字符最远的下标
        int count = 0; // 当前分段字符串长度
        int nowFarthest = 0; // 第二次遍历中，当前遍历过的所有字符串中，最远下标的最大值

        // 第一次遍历，获得各字母的最远下标
        for (int i = 0; i < s.length(); i++) {
            farthest[s.charAt(i) - 'a'] = i;
        }

        // 第二次遍历
        for (int i = 0; i < s.length(); i++) {
            count++;
            int thisFarthest = farthest[s.charAt(i) - 'a']; // thisFarthest为当前遍历到的字母的实际最远下标
            if (thisFarthest > nowFarthest) { // 更新最大值
                nowFarthest = thisFarthest;
            }
            // 到达了当前字母的最远下标，同时此下标还是当前所遇过的所有字符中，最远下标的最大值
            if (i == thisFarthest && i == nowFarthest) {
                result.add(count);
                count = 0;
            }
        }

        return result;
    }
}
