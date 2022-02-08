package 字符串.No43字符串相乘;

public class Solution {
    /**
     * 本题的话可以和加法一样用模拟法去做，每次相乘后得到的字符串数要相加就可以用之前"No415字符串相加"的方法来完成求和部分的运算
     * 这里的解法其实也大概是模拟乘法过程，但是用了数组对加法部分进行了优化
     */
    public String multiply(String num1, String num2) {
        // 只要其中一个乘数为0，那么结果就是0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // m和n分别是两个字符串数的长度，我们创建一个长度为(m+n)的数组
        // 因为长度为m和n的两个数相乘，得出的结果长度最大为m+n（最小为m+n-1）
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        // 来一个双重循环进行乘法部分
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                // 乘积先放在数组下标为i+j+1处（加上，进位下面再处理）
                arr[i + j + 1] += a * b;
            }
        }
        // 处理进位
        for (int i = m + n - 1; i > 0; i--) {
            arr[i - 1] += arr[i] / 10; // 先处理进位
            arr[i] = arr[i] % 10; // 再把对应位置取个位数
        }
        // 因为乘积结果长度可能为m+n或者m+n-1, 所以首位有可能是0，需要跳过
        int index = arr[0] == 0 ? 1 : 0;
        // 最后用StringBuilder拼接起来就可以了
        StringBuilder ans = new StringBuilder();
        for (; index < m + n; index++) {
            ans.append(arr[index]);
        }
        return ans.toString();
    }
}
