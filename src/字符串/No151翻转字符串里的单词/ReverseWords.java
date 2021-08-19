package 字符串.No151翻转字符串里的单词;

public class ReverseWords {
    public String reverseWords(String s) {

        // 去除空格
        StringBuilder sb = removeSpace(s);
        // 整体反转
        reverseString(sb, 0, sb.length() - 1);
        // 反转单词
        reverseEachWord(sb);

        return sb.toString();
    }

    // 去除空格
    private StringBuilder removeSpace(String s) {
        // 去除首尾空格
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        // 去除单词间多余空格
        while (start <= end) {
            if (s.charAt(start) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(start));
            }
            start++;
        }
        return sb;
    }

    // 反转指定区间的字符串
    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //反转各个单词
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') end++;
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
