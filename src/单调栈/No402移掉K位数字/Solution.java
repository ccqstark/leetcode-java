package 单调栈.No402移掉K位数字;

public class Solution {
    public String removeKdigits(String num, int k) {
        // 直接把sb当栈用就行
        StringBuilder sb = new StringBuilder();
        char[] chars = num.toCharArray();
        for (char c : chars) {
            // 当栈顶的数字大于当前数字时，要移除
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            // 数字前面的0要去掉
            if (sb.length() == 0 && c == '0') continue;
            sb.append(c);
        }

        // 原本是取前n-k个，不够取的话直接全部删掉，为空字符串的话就要返回0
        String ans = sb.substring(0, Math.max(sb.length() - k, 0)).toString();
        if (ans.length() == 0) return "0";
        return ans;
    }
}
