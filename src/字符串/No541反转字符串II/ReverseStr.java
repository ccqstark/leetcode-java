package 字符串.No541反转字符串II;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            // 交换的终点是起点往后k个和字符串长度中更小的那个，保证在剩下的字符小于k个时不会越界
            int end = Math.min(start + k - 1, s.length() - 1);
            // 经典异或交互写法
            while (start < end) {
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
