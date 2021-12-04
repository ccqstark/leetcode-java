package 贪心.No738单调递增的数字;

public class Solution {
    public int monotoneIncreasingDigits(int n) {

        char[] charArr = Integer.toString(n).toCharArray();

        // flag标志着开始为9的下标，从这里开始后面全是9，才能保证数字最大化
        int flag = charArr.length;
        for (int i = charArr.length - 1; i > 0; i--) {
            // 如果charArr[i] < charArr[i - 1]，违反递增，
            // 左边的数要自减1，右边的标为flag
            if (charArr[i] < charArr[i - 1]) {
                flag = i;
                charArr[i - 1]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) {
            // 遇到flag之后全是9
            if (i >= flag) {
                sb.append('9');
            } else {
                sb.append(charArr[i]);
            }
        }

        // 这里本来就已经可以把数字最前面的0去掉了
        return Integer.parseInt(sb.toString());
    }
}
