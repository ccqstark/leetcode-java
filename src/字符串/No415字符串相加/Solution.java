package 字符串.No415字符串相加;

/**
 * 模拟法，直接模拟我们小学加法竖式笔算的过程
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        int add = 0; // 表示是否进位
        // 注意一点：写算法题如果要重新构造一个字符串的话，能用StringBuilder就尽量用
        // 尽量不要直接用String，因为StringBuilder底层是直接操作char[]，而String是不可变的
        StringBuilder ans = new StringBuilder();
        // 只要其中一个数还没处理完或者还有进位（最高位进位情况）
        while (index1 >= 0 || index2 >= 0 || add != 0) {
            // 若index为负数就当0处理
            int a = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int b = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int c = a + b + add;
            ans.append(c % 10);
            add = c / 10;
            // 左移继续处理
            index1--;
            index2--;
        }
        // 最后记得翻转一下，顺序是反过来的
        ans.reverse();
        return ans.toString();
    }
}
