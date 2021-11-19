package 回溯.No93复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();
    int pointNum = 0;

    public List<String> restoreIpAddresses(String s) {
        // 大于12位的直接return，因为IP最多12位数字
        if (s.length() > 12) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        // 已经加了3个句点时
        if (pointNum == 3) {
            // 如果最后那一段数字有效，就可以加入结果集
            if (isValid(s.substring(startIndex))) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length() - 1; i++) {
            // startIndex就是新一段的开头，i就是当前要加句点的分割位置
            if (isValid(s.substring(startIndex, i + 1))) {
                // 构造的时候要从头开始，因为最后是要把s加入到结果集的，而且startIndex和i也是相对当前整串s而言的
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                // 注意这里要i+2，因为加了个句点了，句点在i+1的下标位置，下一段就要从i+2开始了
                backtracking(s, i + 2);
                // 回溯要减句点数量，同时在s中去掉句点
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }

    }

    // 判断这个数字是否有效
    public boolean isValid(String s) {
        // 不为0的数开头不能是0
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        // 注意这里要long类型，不然很可能会超int
        if (Long.parseLong(s) > 255) {
            return false;
        }
        return true;
    }

}
