package 字符串.剑指Offer58II左旋字符串;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        // 翻转前n个字符
        reverseString(sb, 0, n - 1);
        // 翻转后n个字符
        reverseString(sb, n, s.length() - 1);
        // 翻转整个字符串
        reverseString(sb, 0, s.length() - 1);

        return sb.toString();
    }

    // 翻转指定区间的字符串
    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
