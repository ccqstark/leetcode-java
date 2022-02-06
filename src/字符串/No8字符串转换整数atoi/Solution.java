package 字符串.No8字符串转换整数atoi;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int myAtoi(String s) {
        Automation automation = new Automation();
        int length = s.length();
        // 一位位字符给自动机进行处理
        for (int i = 0; i < length; i++) {
            automation.get(s.charAt(i));
        }
        // 符号乘结果绝对值，得到答案
        return (int) (automation.sign * automation.ans);
    }
}

/**
 * 自动机
 */
class Automation {
    public int sign = 1;  // 符号
    public long ans = 0;  // 转换结果
    private String state = "start"; // 自动机当前状态
    // 状态转换表
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        // 状态转换
        state = table.get(state)[get_col(c)];
        // 如果是"数字处理"状态
        if ("in_number".equals(state)) {
            // 把原来的数乘10再加上新的数（就是把新的位添加进答案）
            ans = ans * 10 + (c - '0');
            // 溢出判断
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            // 符号判断，1是正数，-1是负数
            sign = c == '+' ? 1 : -1;
        }
    }

    // 根据当前的字符来决定选择状态转换表的哪一列
    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}